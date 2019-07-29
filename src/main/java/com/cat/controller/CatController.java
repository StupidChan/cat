package com.cat.controller;

import com.cat.entity.Cat;
import com.cat.service.CatService;
import com.cat.util.EasyExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/excel")
public class CatController {
    @Resource
    private CatService catService;
    @Resource
    private Cat cat;

    List<Cat> catList=null;
    //导入excel
    @RequestMapping(value = "/import.do", method = RequestMethod.POST)
    @ResponseBody
    public String importExcel(@RequestParam(value = "uploadFile", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response)throws IOException {

        List<Cat> catList= EasyExcelUtil.getExcelContent(file.getInputStream(),Cat.class);
        for(int i=0;i<catList.size();i++){
            cat.setCatColor(catList.get(i).getCatColor());
            cat.setCatName(catList.get(i).getCatName());
            catService.insertCat(cat);
            System.out.println(cat.toString());
        }
        return "successfully";
    }

    /*
    @RequestMapping(value="a.html")
    public String getDatagreateYs(){
        return "/WEB-INF/views/modules/medicalPage/import3.jsp";
    }

   @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadExcel(HttpServletRequest request) {
        Map<String,Object> map =new HashMap<>();
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multiRequest.getFile("uploadFile");
            try {
                //excelUtil工具类
                List<String[]> res = ExcelUtil.readExcel(file);
                if (res != null && res.size() > 0) {
                    //存库或者其他处理逻辑
                    String result =importService.readExcelFile(file);
                    map.put("message", result);
                }
            } catch (IOException e) {

            }
        }

        return map;
    }*/

}
