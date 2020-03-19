package com.vegetable.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DiscussEntity {
    /**
     * 评论id
     */
    private Integer discussId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 评论用户名称
     */
    private String userName;

    /**
     * 评论用户头像
     */
    private String userHead;

    /**
     * 菜谱id
     */
    private Integer menuId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date discussTime;

    /**
     * 当前页
     */
    private Integer  currentPage;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

}

