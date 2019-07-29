package com.cat.dao;

import com.cat.entity.Cat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("CatDao")
public interface CatDao {
    public void insertCat(Cat cat);
}
