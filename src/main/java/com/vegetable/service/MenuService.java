package com.vegetable.service;

import com.github.pagehelper.PageInfo;
import com.vegetable.entity.MenuEntity;
import com.vegetable.entity.StepsEntity;

import java.util.List;

/**
* @ClassName : MenuService
* @Description : 菜谱事务层
* @Author : 袁田婷
* @Date: 2020-01-31 14:27
*/
public interface MenuService{

    /**
     * 菜谱查询
     * @param menuEntity 菜谱实体
     * @return 成功返回查询到的菜谱信息
     */
    PageInfo<MenuEntity> selectMenu(MenuEntity menuEntity);

    /**
     * 菜谱添加
     * @param menuEntity 菜谱实体
     * @return 成功返回一条数据
     */
    int insertMenu(MenuEntity menuEntity);

    /**
     * 删除菜谱
     * @param mId 菜谱id
     * @return 成功返回一条数据
     */
    int deleteMenu(Integer mId);

    /**
     * 修改菜谱
     * @param menuEntity 菜谱实体类
     * @return 成功返回一条数据
     */
    int updateMenu(MenuEntity menuEntity);

    /**
     * 菜谱步骤添加
     * @param stepsEntity 步骤实体类
     * @return 成功返回一条数据
     */
    int insertSteps(StepsEntity stepsEntity);

    /**
     * 菜谱步骤修改
     * @param stepsEntity
     * @return 成功返回一条数据
     */
    int updateSteps(StepsEntity stepsEntity);

    /**
     * 通过菜谱 id 查询步骤
     * @param mId
     * @return 成功返回菜谱步骤
     */
    StepsEntity selectStepsByMId(Integer mId);
}
