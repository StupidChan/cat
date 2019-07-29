package com.cat.entity;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import org.springframework.stereotype.Component;

@Component("Cat")
public class Cat extends BaseRowModel {

    @ExcelProperty(value = "颜色",index = 0)
    private String catColor;

    @ExcelProperty(value = "名字",index = 1)
    private String catName;

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catColor='" + catColor + '\'' +
                ", catName='" + catName + '\'' +
                '}';
    }
}
