package com.vegetable.controller.admin;

import com.vegetable.common.Result;
import com.vegetable.entity.UsersEntity;
import com.vegetable.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : UsersController
 * @Description : 用户控制器
 * @Author : 袁田婷
 * @Date: 2019-12-28 12:10
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 添加用户
     * @param usersEntity 用户实体
     * @return 返回添加成功！
     */
    @PostMapping(value = "/addUser")
    public Result addUser(@RequestBody UsersEntity usersEntity){
        int user = usersService.addUser(usersEntity);
        if (user > 0){
            return Result.ok("添加成功！");
        }
       return Result.error("添加失败！");
    }

    /**
     * 根据条件查询用户
     * @param name 名字
     * @return 返回用户信息
     */
    @GetMapping(value = "/selectUser")
    public Result selectUser(@RequestParam(value = "name")String name){
        List<UsersEntity> userList = usersService.selectUSer(name);
        if (userList.size() > 0 && userList !=null){
            Map<String,Object> map = new HashMap<>();
            map.put("dataList",userList);
            return Result.ok(map);
        }
        return Result.error("查询失败!");
    }
}
