package com.vegetable.controller.admin;

import com.github.pagehelper.PageInfo;
import com.vegetable.common.Result;
import com.vegetable.entity.MenuEntity;
import com.vegetable.entity.StepsEntity;
import com.vegetable.model.MenuModel;
import com.vegetable.service.MenuService;
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

    /**
     * 菜谱添加
     * @param menuModel 菜谱添加对象
     * @return
     */
    @PostMapping(value = "/insertMenu")
    public Result insertMenu(@RequestBody MenuModel menuModel){
        try{
            int steps = menuService.insertSteps(menuModel.getStepsEntity());
            if (steps > 0){
                //得到步骤表的自增长id
                Integer stepId = menuModel.getStepsEntity().getStepId();
                //设置菜谱表的步骤id，然后添加菜谱
                menuModel.getMenuEntity().setStepId(stepId);
                int menu = menuService.insertMenu(menuModel.getMenuEntity());
                //获取菜谱表的自增长id，然后修改步骤表的菜谱id
                Integer mId = menuModel.getMenuEntity().getMId();
                menuModel.getStepsEntity().setmId(mId);
                menuModel.getStepsEntity().setStepId(stepId);
                int updateSteps = menuService.updateSteps(menuModel.getStepsEntity());
                return Result.ok("菜谱添加成功，请耐心等待管理员审核！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("添加失败!");
    }

    /**
     * 通过菜谱 id 查询步骤
     * @param mId 菜谱 id
     * @return
     */
    @GetMapping(value = "/selectStepsByMId")
    public Result selectStepsByMId(@RequestParam(value = "mId") Integer mId){
        try {
            StepsEntity stepsEntity = menuService.selectStepsByMId(mId);
            if (stepsEntity != null){
                Map<String,Object> map = new HashMap<>();
                map.put("stepsData",stepsEntity);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到改菜谱步骤!");
    }

    /**
     * 修改菜谱
     * @param menuEntity
     * @return
     */
    @PostMapping(value = "/updateMenu")
    public Result updateMenu(@RequestBody MenuEntity menuEntity){
        try {
            int i = menuService.updateMenu(menuEntity);
            if (i > 0){
                return Result.ok("修改成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("修改失败");
    }

}
