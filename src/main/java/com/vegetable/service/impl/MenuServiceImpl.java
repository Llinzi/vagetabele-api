package com.vegetable.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vegetable.entity.CollectionEntity;
import com.vegetable.entity.DiscussEntity;
import com.vegetable.entity.MenuEntity;
import com.vegetable.entity.StepsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.vegetable.mapper.MenuMapper;
import com.vegetable.service.MenuService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
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
        menuEntity.setCreateTime(new Date());
        menuEntity.setLikeNum(0);
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
    @Transactional(rollbackFor = Exception.class)
    public int insertSteps(StepsEntity stepsEntity) {
        try {
            return menuMapper.insertSteps(stepsEntity);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 0;
    }

    @Override
    public int updateSteps(StepsEntity stepsEntity) {
        return menuMapper.updateSteps(stepsEntity);
    }

    @Override
    public StepsEntity selectStepsByMId(Integer mId) {
        return menuMapper.selectStepsByMId(mId);
    }

    @Override
    public int updateMenuNum(Integer mId ,Integer type) {
        return menuMapper.updateMenuNum(mId,type);
    }

    @Override
    public int insertCollection(CollectionEntity collectionEntity) {
        collectionEntity.setCreateTime(new Date());
        return menuMapper.insertCollection(collectionEntity);
    }

    @Override
    public CollectionEntity selectCollection(Integer userId, Integer mId) {
        return menuMapper.selectCollection(userId,mId);
    }

    @Override
    public PageInfo<DiscussEntity> selectDiscussEntity(DiscussEntity discussEntity) {
        PageHelper.startPage(discussEntity.getCurrentPage(),discussEntity.getPageSize());
        List<DiscussEntity> list = menuMapper.selectDiscuss(discussEntity.getMenuId());
        return new PageInfo<>(list);
    }

    @Override
    public int insertDiscuss(DiscussEntity discussEntity) {
        discussEntity.setDiscussTime(new Date());
        return menuMapper.insertDiscuss(discussEntity);
    }

    @Override
    public List<MenuEntity> selectLikenum() {
        return menuMapper.selectLikenum();
    }

    @Override
    public PageInfo<MenuEntity> selectCollectionByUserId(MenuEntity menuEntity) {
        PageHelper.startPage(menuEntity.getCurrentPage(),menuEntity.getPageSize());
        List<MenuEntity> list = menuMapper.selectCollectionByUserId(menuEntity.getUserId());
        return new PageInfo<>(list);
    }

    @Override
    public int deleteCollection(Integer collectionId) {
        return menuMapper.deleteCollection(collectionId);
    }

}
