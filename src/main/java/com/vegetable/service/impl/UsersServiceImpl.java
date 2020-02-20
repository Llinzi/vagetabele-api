package com.vegetable.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<UsersEntity> selectUser(UsersEntity usersEntity) {
        //设置分页信息
        PageHelper.startPage(usersEntity.getCurrentPage(),usersEntity.getPageSize());
        //查询满足条件的用户信息
        List<UsersEntity> list = usersMapper.selectUser(usersEntity);
        //返回分页信息
        return new PageInfo<>(list);
    }

    @Override
    public int updateUser(UsersEntity usersEntity) {
        return usersMapper.updateByPrimaryKeySelective(usersEntity);
    }

    @Override
    public int deleteUser(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UsersEntity selectByPrimaryKey(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

}
