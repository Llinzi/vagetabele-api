package com.vegetable.service;

import com.github.pagehelper.PageInfo;
import com.vegetable.entity.VegetableInfoEntity;

/**
* @ClassName : VegetableInfoService
* @Description : 蔬菜信息事务层接口
* @Author : 袁田婷
* @Date: 2020-01-09 10:55
*/
public interface VegetableInfoService{

    /**
     * 添加蔬菜信息
     * @param vegetableInfoEntity 蔬菜实体
     * @return 成功返回大于 0 的信息
     */
    int insertVegetable(VegetableInfoEntity vegetableInfoEntity);

    /**
     * 根据 id 删除蔬菜信息
     * @param id 蔬菜 id
     * @return 成功返回大于 0 的信息
     */
    int deleteVegetable(Integer id);

    /**
     * 根据 id 修改相应的蔬菜信息
     * @param vegetableInfoEntity 蔬菜信息
     * @return 成功返回大于 0 的信息
     */
    int updateVegetable(VegetableInfoEntity vegetableInfoEntity);

    /**
     * 根据前台传递的参数，查询满足条件的蔬菜信息
     * @param vegetableInfoEntity 蔬菜信息实体
     * @return 成功返回满足条件的分页信息
     */
    PageInfo<VegetableInfoEntity> selectVegetable(VegetableInfoEntity vegetableInfoEntity);

}
