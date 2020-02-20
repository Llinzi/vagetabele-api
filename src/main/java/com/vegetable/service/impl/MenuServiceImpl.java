package com.vegetable.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vegetable.entity.MenuEntity;
import com.vegetable.entity.StepsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.vegetable.mapper.MenuMapper;
import com.vegetable.service.MenuService;

import java.util.List;

/**
* @ClassName : MenuServiceImpl
* @Description : 菜谱事务层实现类
* @Author : 袁田婷
* @Date: 2020-01-31 14:27
*/
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public PageInfo<MenuEntity> selectMenu(MenuEntity menuEntity) {
        PageHelper.startPage(menuEntity.getCurrentPage(),menuEntity.getPageSize());
        List<MenuEntity> list = menuMapper.selectMenu(menuEntity);
        return new PageInfo<>(list);
    }

    @Override
    public int insertMenu(MenuEntity menuEntity) {
        return menuMapper.insertSelective(menuEntity);
    }

    @Override
    public int deleteMenu(Integer mId) {
        return menuMapper.deleteByPrimaryKey(mId);
    }

    @Override
    public int updateMenu(MenuEntity menuEntity) {
        return menuMapper.updateByPrimaryKeySelective(menuEntity);
    }

    @Override
    public int insertSteps(StepsEntity stepsEntity) {
        return menuMapper.insertSteps(stepsEntity);
    }

    @Override
    public int updateSteps(StepsEntity stepsEntity) {
        return menuMapper.updateSteps(stepsEntity);
    }

    @Override
    public StepsEntity selectStepsByMId(Integer mId) {
        return menuMapper.selectStepsByMId(mId);
    }
}
