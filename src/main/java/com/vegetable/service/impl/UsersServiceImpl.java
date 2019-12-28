package com.vegetable.service.impl;

import com.vegetable.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.vegetable.mapper.UsersMapper;
import com.vegetable.service.UsersService;

import java.util.List;

/**
* @ClassName : UsersServiceImpl
* @Description : 用户 service 实现类
* @Author : 袁田婷
* @Date: 2019-12-24 10:50
*/
@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int addUser(UsersEntity usersEntity) {
        return usersMapper.insertSelective(usersEntity);
    }

    @Override
    public List<UsersEntity> selectUSer(String name) {
        return usersMapper.selectUSer(name);
    }
}
