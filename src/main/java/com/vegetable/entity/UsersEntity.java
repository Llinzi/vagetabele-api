package com.vegetable.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
* @ClassName : Users
* @Description : 用户实体类
* @Author : 袁田婷
* @Date: 2019-12-24 10:50
*/

/**
 * @Data注解 添加set 和 get 等方法
 * @Table 对应数据库的表名
 * @Id 表示主键
 * @Column 对应数据库的字段
 * @GeneratedValue 表示主键自增长
 */
@Data
@Table(name = "users")
public class UsersEntity implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Integer userId;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户性别(0为男,1为女)
     */
    @Column(name = "user_sex")
    private Integer userSex;

    /**
     * 用户年龄
     */
    @Column(name = "user_age")
    private Integer userAge;

    /**
     * 用户手机号
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户账号
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 用户密码
     */
    @Column(name = "user_pwd")
    private String userPwd;

    /**
     * 用户头像
     */
    @Column(name = "user_head")
    private String userHead;

    /**
     * 电子邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 用户状态(0为禁用，1为启用)
     */
    @Column(name = "user_state")
    private Integer userState;

    /**
     * 用户 权限(0为管理员，1为普通用户)
     */
    @Column(name = "user_permissions")
    private Integer userPermissions;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currentPage;

    private static final long serialVersionUID = 1L;
}