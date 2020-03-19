package com.vegetable.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vegetable.entity.TypeEntity;
import com.vegetable.entity.VegetableInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vegetable.mapper.VegetableInfoMapper;
import com.vegetable.service.VegetableInfoService;

import java.util.List;

/**
* @ClassName : VegetableInfoServiceImpl
* @Description : 蔬菜信息事务层实现类
* @Author : 袁田婷
* @Date: 2020-01-09 10:55
*/
@Service
public class VegetableInfoServiceImpl implements VegetableInfoService{

    @Autowired
    private VegetableInfoMapper vegetableInfoMapper;

    @Override
    public int insertVegetable(VegetableInfoEntity vegetableInfoEntity) {
        return vegetableInfoMapper.insertSelective(vegetableInfoEntity);
    }

    @Override
    public int deleteVegetable(Integer id) {
        return vegetableInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateVegetable(VegetableInfoEntity vegetableInfoEntity) {
        return vegetableInfoMapper.updateByPrimaryKeySelective(vegetableInfoEntity);
    }

    @Override
    public PageInfo<VegetableInfoEntity> selectVegetable(VegetableInfoEntity vegetableInfoEntity) {
        //设置分页信息(当前页。每页显示条数)
        PageHelper.startPage(vegetableInfoEntity.getCurrentPage(),vegetableInfoEntity.getPageSize());
        //查询满足条件的信息
        List<VegetableInfoEntity> list = vegetableInfoMapper.selectVegetable(vegetableInfoEntity);
        //返回分页信息
        return new PageInfo<>(list);
    }

    @Override
    public List<TypeEntity> selectType() {
        return vegetableInfoMapper.selectType();
    }

    @Override
    public List<VegetableInfoEntity> selectByTypeId(Integer typeId) {
        return vegetableInfoMapper.selectByTypeId(typeId);
    }

    @Override
    public List<VegetableInfoEntity> selectRand() {
        return vegetableInfoMapper.selectRand();
    }
}
