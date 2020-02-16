package com.vegetable.controller.admin;

import com.github.pagehelper.PageInfo;
import com.vegetable.common.Result;
import com.vegetable.entity.VegetableInfoEntity;
import com.vegetable.service.VegetableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : vegetableInfoController
 * @Description : 蔬菜信息控制器
 * @Author : 袁田婷
 * @Date: 2020-01-09 13:15
 */
@RestController
@RequestMapping(value = "/vegetableInfo")
public class VegetableInfoController {

    @Autowired
    private VegetableInfoService vegetableInfoService;

    /**
     * 添加蔬菜信息
     * @param vegetableInfoEntity 蔬菜实体类
     * @return 成功返回大于 0
     */
    @PostMapping(value = "/insertVegetable")
    public Result insertVegetable(@RequestBody VegetableInfoEntity vegetableInfoEntity){
        try {
            int vegetable = vegetableInfoService.insertVegetable(vegetableInfoEntity);
            if (vegetable > 0){
                return Result.ok("添加蔬菜信息成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("添加蔬菜信息失败！");
    }

    /**
     * 根据 id 删除蔬菜信息
     * @param id 蔬菜 id
     * @return 成功返回大于 0
     */
    @PostMapping(value = "/deleteVegetable")
    public Result deleteVegetable(@RequestParam(value = "id") Integer id){
        try {
            int vegetable = vegetableInfoService.deleteVegetable(id);
            if(vegetable > 0){
                return Result.ok("删除蔬菜信息成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("删除蔬菜信息失败！");
    }

    /**
     * 根据 id 修改蔬菜信息
     * @param vegetableInfoEntity 蔬菜实体
     * @return 成功返回大于 0
     */
    @PostMapping(value = "/updateVegetable")
    public Result updateVegetable(@RequestBody VegetableInfoEntity vegetableInfoEntity){
        try{
            int vegetable = vegetableInfoService.updateVegetable(vegetableInfoEntity);
            if (vegetable > 0){
                return Result.ok("修改蔬菜信息成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("修改蔬菜信息失败！");
    }

    @GetMapping(value = "/selectVegetable")
    public Result selectVegetable(VegetableInfoEntity vegetableInfoEntity){
        try{
            //查询分页信息
            PageInfo<VegetableInfoEntity> pageInfo = vegetableInfoService.selectVegetable(vegetableInfoEntity);
            //从分页信息中查询满足条件的用户信息
            List<VegetableInfoEntity> list = pageInfo.getList();
            if (list.size() > 0 && list !=null){
                Map<String,Object> map = new HashMap<>();
                map.put("dataList",list);
                //当前页
                map.put("pageNum",pageInfo.getPageNum());
                //总页数
                map.put("pages",pageInfo.getPages());
                //总条数
                map.put("total",pageInfo.getTotal());
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到满足条件的蔬菜信息");
    }

}
