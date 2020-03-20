package com.vegetable.service;

import com.github.pagehelper.PageInfo;
import com.vegetable.entity.CollectionEntity;
import com.vegetable.entity.DiscussEntity;
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

    /**
     * 收藏、点赞、评论数量加一
     * @param mId 菜谱id
     * @param type 收藏：1 ;点赞：2；评论：3
     * @return
     */
    int updateMenuNum(Integer mId, Integer type);

    /**
     * 添加收藏信息
     * @param collectionEntity 收藏实体
     * @return
     */
    int insertCollection(CollectionEntity collectionEntity);

    /**
     * 通过用户 id 和 菜谱 id 查询用户是否收藏过该菜谱
     * @param userId 用户 id
     * @param mId 菜谱 id
     * @return
     */
    CollectionEntity selectCollection(Integer userId ,Integer mId);

    /**
     * 根据菜谱 id 查询菜谱
     * @param discussEntity 评论实体
     * @return
     */
    PageInfo<DiscussEntity> selectDiscussEntity(DiscussEntity discussEntity);

    /**
     * 添加评论
     * @param discussEntity 评论实体
     * @return
     */
    int insertDiscuss(DiscussEntity discussEntity);

    /**
     * 查询点赞最多的 3 个菜谱
     * @return
     */
    List<MenuEntity> selectLikenum();

    /**
     * 查询用户收藏的菜谱
     * @menuEntity 菜谱实体
     * @return
     */
    PageInfo<MenuEntity> selectCollectionByUserId(MenuEntity menuEntity);

    /**
     * 删除收藏菜谱
     * @param collectionId 收藏 id
     * @return
     */
    int deleteCollection(Integer collectionId);
}
