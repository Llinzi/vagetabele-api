package com.vegetable.mapper;

import com.vegetable.entity.CollectionEntity;
import com.vegetable.entity.DiscussEntity;
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
     * 根据菜谱 id 查询评论
     * @param menuId 菜谱 id
     * @return
     */
    List<DiscussEntity> selectDiscuss(Integer menuId);

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
     * @param userId
     * @return
     */
    List<MenuEntity> selectCollectionByUserId(Integer userId);

    /**
     * 删除收藏菜谱
     * @param collectionId 收藏 id
     * @return
     */
    int deleteCollection(Integer collectionId);

}