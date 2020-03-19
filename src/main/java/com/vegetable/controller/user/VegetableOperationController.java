package com.vegetable.controller.user;

import com.vegetable.common.Result;
import com.vegetable.entity.VegetableInfoEntity;
import com.vegetable.service.VegetableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : VegetableOperationController
 * @Description : 蔬菜操作控制器
 * @Author : 袁田婷
 * @Date: 2020-03-14 21:42
 */
@RestController
@RequestMapping(value = "/vegetableOperation")
public class VegetableOperationController {

    @Autowired
    private VegetableInfoService vegetableInfoService;

    /**
     *随机推荐同类蔬菜
     * @param typeId
     * @return
     */
    @GetMapping(value = "/selectByTypeId")
    public Result selectByTypeId(@RequestParam Integer typeId){
        try{
            List<VegetableInfoEntity> list = vegetableInfoService.selectByTypeId(typeId);
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("TypeList",list);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到相关信息");
    }

    /**
     * 随机查询 12 条数据
     * @return
     */
    @GetMapping(value = "/selectRand")
    public Result selectRand(){
        try{
            List<VegetableInfoEntity> list = vegetableInfoService.selectRand();
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("randList",list);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }

}
