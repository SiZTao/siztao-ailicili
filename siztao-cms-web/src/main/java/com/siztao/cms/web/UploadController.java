package com.siztao.cms.web;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-13 14:40
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-13 14:40
 * @email: 982637685@qq.com
 * @version:
 **/

@Controller
public class UploadController {

    @RequestMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public JSONObject upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
        String originalFilename = file.getOriginalFilename();
        String faultStr = "{\"result\":\"error\"}";
        JSONObject faultJson = JSONObject.parseObject(faultStr);
        // 文件名使用当前时间
        String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        // 获取上传图片的扩展名(jpg/png/...)
        String extension = FilenameUtils.getExtension(originalFilename);
        // 图片上传的相对路径
        String uploadPath = "/upload/" + name + "." + extension;
        // 图片上传的绝对路径
        String url = request.getSession().getServletContext().getRealPath("") + uploadPath;
        // 图片相对路径（因为页面在web-inf下，所以需要加上项目名称）
        String basePath = request.getContextPath() + uploadPath;
        File dir = new File(url);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 上传图片
        try {
            file.transferTo(new File(url));
        } catch (IOException e) {
            return faultJson;
        }
        // 将相对路径写回（json格式）
        JSONObject jsonObject = new JSONObject();
        // 将图片上传到本地
        jsonObject.put("path", basePath);
        if (file.getOriginalFilename() != null) {
            return jsonObject;
        } else {
            return faultJson;
        }
    }

}