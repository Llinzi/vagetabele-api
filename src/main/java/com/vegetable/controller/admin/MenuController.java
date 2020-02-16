package com.vegetable.controller.admin;

import com.github.pagehelper.PageInfo;
import com.vegetable.common.Result;
import com.vegetable.entity.MenuEntity;
import com.vegetable.model.MenuModel;
import com.vegetable.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : MenuController
 * @Description : 菜谱控制器
 * @Author : 袁田婷
 * @Date: 2020-02-09 23:58
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 菜谱查询
     * @param menuEntity 查询条件，菜谱实体类
     * @return
     */
    @GetMapping(value = "/selectMenu")
    public Result selectMenu(MenuEntity menuEntity){
        try{
            PageInfo<MenuEntity> pageInfo = menuService.selectMenu(menuEntity);
            List<MenuEntity> list = pageInfo.getList();
            if (list.size() > 0 && list !=null){
                Map<String,Object> map = new HashMap<>();
                map.put("dataList",list);
                //总页数
                map.put("pages",pageInfo.getPages());
                //当前页
                map.put("pageNum",pageInfo.getPageNum());
                //总条数
                map.put("total",pageInfo.getTotal());
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到满足条件的菜谱");
    }

    @PostMapping(value = "/insertMenu")
    public Result insertMenu(@RequestBody MenuModel menuModel){
        try{
            int steps = menuService.insertSteps(menuModel.getStepsEntity());
            if (steps > 0){
                Integer stepId = menuModel.getStepsEntity().getStepId();
                System.out.println("步骤id为"+stepId);
                menuModel.getMenuEntity().setStepId(stepId);
                int menu = menuService.insertMenu(menuModel.getMenuEntity());
                Integer mId = menuModel.getMenuEntity().getMId();
                System.out.println("菜谱id为"+mId);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("添加失败!");
    }

}
