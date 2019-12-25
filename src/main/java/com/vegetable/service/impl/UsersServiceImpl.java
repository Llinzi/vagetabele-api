package com.vegetable.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.vegetable.mapper.UsersMapper;
import com.vegetable.service.UsersService;
/**
* @ClassName : UsersServiceImpl
* @Description : 用户 service 实现类
* @Author : 袁田婷
* @Date: 2019-12-24 10:50
*/
@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

}
