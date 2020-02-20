package com.vegetable.model;

import com.vegetable.entity.MenuEntity;
import com.vegetable.entity.StepsEntity;
import lombok.Data;

/**
 * @ClassName : MenuModel
 * @Description : 菜谱对象
 * @Author : 袁田婷
 * @Date: 2020-02-13 12:37
 */
@Data
public class MenuModel {
    private MenuEntity menuEntity;
    private StepsEntity stepsEntity;


}
