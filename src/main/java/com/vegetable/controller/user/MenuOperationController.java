package com.vegetable.controller.user;

import com.github.pagehelper.PageInfo;
import com.vegetable.common.Result;
import com.vegetable.entity.CollectionEntity;
import com.vegetable.entity.DiscussEntity;
import com.vegetable.entity.MenuEntity;
import com.vegetable.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : MenuOperationController
 * @Description : 菜谱操作控制器
 * @Author : 袁田婷
 * @Date: 2020-03-10 14:50
 */
@RestController
@RequestMapping(value = "/menuOperation")
public class MenuOperationController {

    @Autowired
    private MenuService menuService;

    /**
     *点赞、收藏、评论
     * @param mId 菜谱 id
     * @param type 类型 （收藏：1 ;点赞：2；评论：3）
     * @return
     */
    @PostMapping(value = "/updateMenuNum")
    public Result updateMenuNum(@RequestParam Integer mId,@RequestParam Integer type){
        try {
            int menuNum = menuService.updateMenuNum(mId, type);
            if (menuNum > 0){
                return Result.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    };

    /**
     * 添加收藏功能
     * @param collectionEntity 收藏实体
     * @return
     */
    @PostMapping(value = "/insertCollection")
    public Result insertCollection(CollectionEntity collectionEntity){
        try {
            int i = menuService.insertCollection(collectionEntity);
            if (i > 0){
                return Result.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }

    /**
     * 通过用户 id 和 菜谱 id 查询用户是否收藏过该菜谱
     * @param userId
     * @param mId
     * @return
     */
    @GetMapping(value = "/selectCollection")
    public Result selectCollection(Integer userId ,Integer mId){
        try {
            CollectionEntity collectionEntity = menuService.selectCollection(userId, mId);
            if (collectionEntity != null){
                return Result.error("该菜谱已经收藏过了哦!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.ok();
    }

    /**
     * 查询评论
     * @param discussEntity 评论实体
     * @return
     */
    @GetMapping(value = "/selectDiscuss")
    public Result selectDiscuss(DiscussEntity discussEntity){
        try{
            PageInfo<DiscussEntity> pageInfo = menuService.selectDiscussEntity(discussEntity);
            List<DiscussEntity> list = pageInfo.getList();
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
        return Result.error("该菜谱还没有评论哦!");
    }

    /**
     * 添加评论
     * @param discussEntity
     * @return
     */
    @PostMapping(value = "/insertDiscuss")
    public Result insertDiscuss(DiscussEntity discussEntity){
        try {
            int i = menuService.insertDiscuss(discussEntity);
            if (i > 0){
                return Result.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }

    /**
     * 查询菜谱点赞前 3
     * @return
     */
    @GetMapping(value = "/selectLikeum")
    public Result selectLikeum(){
        try {
            List<MenuEntity> list = menuService.selectLikenum();
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("LikeumList",list);
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }

    /**
     *查询用户收藏的菜谱
     * @menuEntity 菜谱实体
     * @return
     */
    @GetMapping(value = "/selectCollectionByUserId")
    public Result selectCollectionByUserId(MenuEntity menuEntity){
        try{
            PageInfo<MenuEntity> pageInfo = menuService.selectCollectionByUserId(menuEntity);
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
        return Result.error("您还没有收藏任何菜谱哦!");
    }

    /**
     * 删除收藏菜谱
     * @param collectionId 收藏 id
     * @return
     */
    @PostMapping(value = "/deleteCollection")
    public Result deleteCollection(Integer collectionId){
        try{
            int i = menuService.deleteCollection(collectionId);
            if ( i > 0){
                return Result.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error();
    }
}
