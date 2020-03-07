package com.vegetable.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.vegetable.common.RedisUtils;
import com.vegetable.common.Result;
import com.vegetable.common.SubMailUtils;
import com.vegetable.entity.UsersEntity;
import com.vegetable.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName : userLogin
 * @Description : 用户登录控制器
 * @Author : 袁田婷
 * @Date: 2020-02-28 00:39
 */
@RestController
@RequestMapping(value = "/userLogin")
public class userLoginController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 用户登录
     * @param userPhone 用户手机号
     * @param userPwd 用户密码
     * @return
     */
    @GetMapping(value = "/login")
    public Result login(@RequestParam(value = "userPhone") String userPhone,
                        @RequestParam(value = "userPwd") String userPwd){
        try {
            UsersEntity usersPhone = usersService.selectPhone(userPhone);
            UsersEntity usersEntity = usersService.userLogin(userPhone, userPwd);
            if(usersPhone == null){
                return Result.error("该用户不存在,请注册!");
            }else if (userPhone !=null && usersEntity == null){
                return Result.error("密码错误");
            }else if (usersEntity != null){
                Map<String,Object> map = new HashMap<>();
                map.put("user",usersEntity);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }


    /**
     * 发送短信验证码
     * @param phone 电话
     * @param type  验证码类型（reg:注册; reset:重置）
     * @return
     */
    @GetMapping(value = "/sendMsg")
    public Result sendMsg(@RequestParam(value = "phone") String phone,
                          @RequestParam(value = "type") String type){
        if (phone == "" && phone == null){
            return Result.error("请输入电话号码");
        }
        String code =String.valueOf(new Random().nextInt(899999) + 100000);
        JSONObject vars = new JSONObject();
        vars.put("code",code);
        vars.put("time","5分钟");
        String project = "";
        switch (type){
            case "reg":
                project = "Sy7hQ3";
                break;
            case "reset":
                project = "HqFvM";
                break;
        }
        try {
            boolean message = SubMailUtils.sendMessage(phone, project, vars);
            if (message){
                //把验证码存入redis缓存，并设置过期时间
                redisUtils.set(phone , code , 5);
                return Result.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("发送验证码失败！");
    }

    /**
     * 查询手机号是否被注册
     * @param userPhone 手机号码
     * @return 被注册返回 {"valid",false}  没有被注册返回 {"valid",true}
     */
    @GetMapping(value = "/selectPhone")
    public JSONObject selectPhone(String userPhone){
        JSONObject result = new JSONObject();
        UsersEntity usersEntity = usersService.selectPhone(userPhone);
        if (usersEntity != null){
            result.put("valid",false);
            return result;
        }
        result.put("valid",true);
        return result;
    }

    /**
     * 查询手机号是否存在
     * @param userPhone 手机号码
     * @return 被注册返回 {"valid",true}  没有被注册返回 {"valid",false}
     */
    @GetMapping(value = "/selectPhone1")
    public JSONObject selectPhone1(String userPhone){
        JSONObject result = new JSONObject();
        UsersEntity usersEntity = usersService.selectPhone(userPhone);
        if (usersEntity != null){
            result.put("valid",true);
            return result;
        }
        result.put("valid",false);
        return result;
    }

    /**
     * 验证验证码是否正确
     * @param code 验证码
     * @return 正确返回 {"valid",true}  错误返回 {"valid",false}
     */
    @GetMapping(value = "/validationCode")
    public JSONObject validationCode(String phone , String code){
        JSONObject result = new JSONObject();
        //获取缓存中的验证码
        Object reCode = redisUtils.get(phone);
        if (reCode !=null){
            if (reCode.toString().equals(code)){
                result.put("valid",true);
                return result;
            }
        }else {
            System.out.println("验证码失效");
            result.put("valid",false);
            return result;
        }
        result.put("valid",false);
        return result;
    }

    /**
     * 根据手机号修改密码
     * @param userPhone 手机号
     * @param pwd 密码
     * @return
     */
    @PostMapping(value = "/updatePwd")
    public Result updatePwd(@RequestParam String userPhone ,
                            @RequestParam String pwd){
        try{
            int i = usersService.updatePwd(userPhone,pwd);
            if (i > 0 ){
                return Result.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }

}
