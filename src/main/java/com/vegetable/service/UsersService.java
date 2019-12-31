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

}
