package com.vegetable.mapper;

import com.vegetable.entity.MenuEntity;
import com.vegetable.entity.StepsEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : MenuMapper
* @Description : 菜谱持久化层
* @Author : 袁田婷
* @Date: 2020-01-31 14:27
*/
public interface MenuMapper extends Mapper<MenuEntity> {

    /**
     * 菜谱查询
     * @param menuEntity 菜谱实体
     * @return
     */
    List<MenuEntity> selectMenu(MenuEntity menuEntity);

    /**
     * 菜谱步骤添加
     * @param stepsEntity
     * @return
     */
    int insertSteps(StepsEntity stepsEntity);
}