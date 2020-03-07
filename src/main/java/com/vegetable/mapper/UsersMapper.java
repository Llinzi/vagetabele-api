package com.vegetable.mapper;

import com.vegetable.entity.UsersEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : UsersMapper
* @Description : 用户 mapper 接口
* @Author : 袁田婷
* @Date: 2019-12-24 10:50
*/

/**
 * 实现了 TK-MyBatis 对单表操作更简单了，不用在 xml 里写 sql
 * 但复杂的 sql 还是得在 xml 里手写
 */
public interface UsersMapper extends Mapper<UsersEntity> {

    //查询满足条件的用户信息
    List<UsersEntity> selectUser(UsersEntity usersEntity);

    /**
     * 用户登录
     * @param userPhone 用户手机号
     * @param userPwd 用户密码
     * @return 成功发回用户信息
     */
    UsersEntity userLogin(String userPhone,String userPwd);

    /**
     * 查询此号码是否存在
     * @param userPhone 用户号码
     * @return
     */
    UsersEntity selectPhone(String userPhone);

    /**
     * 根据手机号修改用户密码
     * @param userPhone 手机号
     * @param pwd 密码
     * @return
     */
    int updatePwd(String userPhone,String pwd);

}