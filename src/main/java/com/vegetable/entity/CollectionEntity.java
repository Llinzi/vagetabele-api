package com.vegetable.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CollectionEntity implements Serializable {
    /**
     * 收藏id
     */
    private Integer collectionId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 菜谱id
     */
    private Integer menuId;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

}

