package com.vegetable.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
* @ClassName : Menu
* @Description : 菜谱实体类
* @Author : 袁田婷
* @Date: 2020-01-31 14:27
*/
@Data
@Table(name = "menu")
public class MenuEntity implements Serializable {
    /**
     * 菜谱id
     */
    @Id
    @Column(name = "m_id")
    @GeneratedValue(generator = "JDBC")
    private Integer mId;

    /**
     * 菜谱名称
     */
    @Column(name = "m_name")
    private String mName;

    /**
     * 发表用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 发表用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 烹饪步骤id
     */
    @Column(name = "step_id")
    private Integer stepId;

    /**
     * 所需食材
     */
    @Column(name = "food_material")
    private String foodMaterial;

    /**
     * 难度等级（1：易，2：一般，3：难）
     */
    @Column(name = "`level`")
    private Integer level;

    /**
     * 烹饪所需大概时间
     */
    @Column(name = "`time`")
    private String time;

    /**
     * 菜品图片
     */
    @Column(name = "image")
    private String image;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 收藏数量
     */
    @Column(name = "collection_num")
    private Integer collectionNum;

    /**
     * 点赞数量
     */
    @Column(name = "like_num")
    private Integer likeNum;

    /**
     * 评论数量
     */
    @Column(name = "discuss_num")
    private Integer discussNum;

    /**
     * 当前页
     */
    private Integer  currentPage;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    private static final long serialVersionUID = 1L;
}