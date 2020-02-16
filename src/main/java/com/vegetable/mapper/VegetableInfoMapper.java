package com.vegetable.mapper;

import com.vegetable.entity.VegetableInfoEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : VegetableInfoMapper
* @Description : 蔬菜信息持久化层
* @Author : 袁田婷
* @Date: 2020-01-09 10:55
*/
public interface VegetableInfoMapper extends Mapper<VegetableInfoEntity> {

    /**
     * 根据条件查询满足条件的蔬菜信息
     * @param vegetableInfoEntity 蔬菜信息实体
     * @return 成功返回满足条件的蔬菜
     */
    List<VegetableInfoEntity> selectVegetable(VegetableInfoEntity vegetableInfoEntity);
}