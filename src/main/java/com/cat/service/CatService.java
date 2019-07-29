package com.cat.service;

import com.cat.dao.CatDao;
import com.cat.entity.Cat;
import com.cat.util.EasyExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service("CatService")
public class CatService {
    @Resource
    private CatDao catDao;

    public void insertCat(Cat cat){
       catDao.insertCat(cat);
    }
}
