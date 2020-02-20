package com.vegetable.service;

import com.github.pagehelper.PageInfo;
import com.vegetable.entity.UsersEntity;

import java.util.List;

/**
* @ClassName : UsersService
* @Description : 用户 service 接口
* @Author : 袁田婷
* @Date: 2019-12-24 10:50
*/
public interface UsersService{

    /**
     * 添加用户信息
     * @param usersEntity 用户实体
     * @return 成功返回一条数据
     */
    int addUser(UsersEntity usersEntity);

    /**
     * 查询满足条件的用户信息
     * @param usersEntity 用户实体
     * @return 返回满足条件的用户
     */
    PageInfo<UsersEntity> selectUser(UsersEntity usersEntity);

    /**
     * 根据 id 修改用户信息
     * @param usersEntity 用户实体
     * @return 成功返回一条数据
     */
    int updateUser(UsersEntity usersEntity);

    /**
     * 根据 id 删除用户信息
     * @param id 用户编号
     * @return 成功返回一条数据
     */
    int deleteUser(Integer id);

    /**
     * 通过 id 查询用户信息
     * @param id 用户 id
     * @return 成功返回用户信息
     */
    UsersEntity selectByPrimaryKey(Integer id);
}
