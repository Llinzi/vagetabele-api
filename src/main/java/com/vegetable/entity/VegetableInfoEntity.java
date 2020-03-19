package com.vegetable.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
* @ClassName : VegetableInfo
* @Description : 蔬菜信息实体类
* @Author : 袁田婷
* @Date: 2020-01-09 10:55
*/
@Data
@Table(name = "vegetable_info")
public class VegetableInfoEntity implements Serializable {
    /**
     * 蔬菜编号
     */
    @Id
    @Column(name = "v_id")
    @GeneratedValue(generator = "JDBC")
    private Integer vId;

    /**
     * 蔬菜名称
     */
    @Column(name = "v_name")
    private String vName;

    /**
     * 蔬菜别称
     */
    @Column(name = "v_nickName")
    private String vNickname;

    /**
     * 食用方式
     */
    @Column(name = "eat_way")
    private String eatWay;

    /**
     * 营养成分
     */
    @Column(name = "nutrients")
    private String nutrients;

    /**
     * 主要价值
     */
    @Column(name = "main_value")
    private String mainValue;

    /**
     * 植物学史
     */
    @Column(name = "plant_history")
    private String plantHistory;

    /**
     * 形态特征
     */
    @Column(name = "`characteristics`")
    private String characteristics;

    /**
     * 分布范围
     */
    @Column(name = "distribution")
    private String distribution;

    /**
     * 主要品种
     */
    @Column(name = "varieties")
    private String varieties;

    /**
     * 种植方式
     */
    @Column(name = "planting_way")
    private String plantingWay;

    /**
     * 生长环境
     */
    @Column(name = "growing_environment")
    private String growingEnvironment;

    /**
     * 生长时间
     */
    @Column(name = "growing_time")
    private String growingTime;

    /**
     * 一级类别
     */
    @Column(name = "type_id")
    private Integer typeId;

    /**
     * 图片
     */
    @Column(name = "image")
    private String image;

    /**
     * 类别名称
     */
    private String typeName;

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