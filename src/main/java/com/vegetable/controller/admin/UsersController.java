package com.vegetable.controller.admin;

import com.github.pagehelper.PageInfo;
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
     * @param usersEntity 用户实体
     * @return 返回用户信息
     */
    @GetMapping(value = "/selectUser")
    public Result selectUser(UsersEntity usersEntity) {
        try {
            //查询满足条件的分页信息
            PageInfo<UsersEntity> pageInfo = usersService.selectUser(usersEntity);
            if(pageInfo == null){
                return Result.error("没有查询到相关信息");
            }
            //从分页信息中获得用户信息
            List<UsersEntity> list = pageInfo.getList();
            //判断是否找到满足条件的信息
            if (list.size() > 0 && list != null){
                Map<String, Object> map = new HashMap<>();
                //总页数
                map.put("pages",pageInfo.getPages());
                //总条数
                map.put("total",pageInfo.getTotal());
                //当前页
                map.put("pageNum",pageInfo.getPageNum());
                map.put("dataList",list);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.ok("没有查询到满足条件的用户信息！");
    }

    /**
     * 根据 id 修改用户信息
     * @param usersEntity 用户实体
     * @return
     */
    @PostMapping(value = "/updateUser")
    public Result updateUser(@RequestBody UsersEntity usersEntity){
        try {
            int user = usersService.updateUser(usersEntity);
            if (user > 0){
                return Result.ok("修改成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("修改失败!");
    }

    /**
     * 根据 id 删除用户信息
     * @param id 用户编号
     * @return
     */
    @PostMapping(value = "/deleteUser")
    public Result deleteUser(@RequestParam(value = "id") Integer id){
        try {
            int user = usersService.deleteUser(id);
            if (user > 0){
                return Result.ok("删除成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("删除失败!");
    }

    /**
     * 根据 id 查询用户信息
     * @param userId 用户 id
     * @return 成功返回用户信息
     */
    @GetMapping(value = "/selectByPrimaryKey")
    public Result selectByPrimaryKey(@RequestParam(value = "userId") Integer userId){
        try {
            UsersEntity usersEntity = usersService.selectByPrimaryKey(userId);
            if (usersEntity !=null){
                Map<String,Object> map = new HashMap<>();
                map.put("userData",usersEntity);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到该用户!");
    }
}
