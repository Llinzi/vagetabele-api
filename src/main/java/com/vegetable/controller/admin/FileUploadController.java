package com.vegetable.controller.admin;

import com.vegetable.common.Result;
import com.vegetable.common.UploadUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : FileUploadController
 * @Description : 文件上传和删除控制器
 * @Author : 袁田婷
 * @Date: 2019-12-24 12:10
 */
@RestController
@RequestMapping(value = "/upload")
public class FileUploadController {

    /**
     * 用户头像图片路径
     */
    private String userPath = "E:/workspaces/images/users/";

    /**
     * 蔬菜图片路径
     */
    private String vegetablePath = "E:/workspaces/images/vegetable/";

    /**
     * 用户头像上传
     *
     * @param file
     * @return 上传的文件
     */
    @RequestMapping(value="/userUpload")
    public Result userUpload(@RequestParam("userHead") MultipartFile file) {
        try {
            Map<String, Object> map = this.uploadFile(userPath, file);
            if(map!=null && map.size() > 0) {
                return Result.ok(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.error("上传头像失败！");
    }

    /**
     * 蔬菜图片上传
     * @param file 上传的文件
     * @return
     */
    @RequestMapping(value="/vegetableUpload")
    public Result goodsUpload(@RequestParam("vegetablePhoto") MultipartFile file) {
        try {
            Map<String, Object> map = this.uploadFile(vegetablePath, file);
            if(map!=null && map.size() > 0) {
                return Result.ok(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.error("上传图片失败！");
    }


    /**
     * 删除用户头像
     * @param userHead 上传的用户头像
     * @return
     */
    @RequestMapping(value="/deleteUserHead")
    public Result deleteUserHPhoto(@RequestParam("userHead") String userHead) {
        try {
            //从URL中获得商品图片的名字
            int indexOf = userHead.lastIndexOf("/");
            if(indexOf!=-1) {
                String fileName = userHead.substring(indexOf + 1);
                File file = new File(this.userPath + fileName);
                file.delete();
                return Result.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error();
    }

    /**
     * 删除蔬菜图片
     * @param vegetablePhoto 上传的蔬菜图片
     * @return
     */
    @RequestMapping(value="/deleteVegetablePhoto")
    public Result deleteGoodsPhoto(@RequestParam("vegetablePhoto") String vegetablePhoto) {
        try {
            //从URL中获得商品图片的名字
            int indexOf = vegetablePhoto.lastIndexOf("/");
            if(indexOf!=-1) {
                String fileName = vegetablePhoto.substring(indexOf + 1);
                File file = new File(this.vegetablePath + fileName);
                file.delete();
                return Result.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error();
    }

    /**
     * 上传文件
     *
     * @param path 上传文件的路径
     * @param file 上传的文件
     * @return 成功返回java.util.Map类型的实例，否则返回null
     * @throws IOException
     */
    private Result uploadFile(String path, MultipartFile file) throws IOException {
        // 获得新的文件名
        String fileName = UploadUtils.getFileName();
        // 根据上传文件的文件名获得文件的扩展名
        String extendedName = UploadUtils.getExtendedName(file.getOriginalFilename());

        //上传文件
        //1.将文件装换为字节类型的数组
        byte[] bytes = file.getBytes();
        //2.创建File类的对象，并设置文件名上传路径及文件名
        File saveFile = new File(path + fileName + extendedName);
        //3.上传文件
        FileCopyUtils.copy(bytes, saveFile);

        //当文件上传成功时，将文件新的文件名以扩展名传递回视图层
        Map<String,Object> map = new HashMap<>();
        map.put("fileName",fileName);
        map.put("extendedName", extendedName);
        return Result.ok(map);

    }

}
