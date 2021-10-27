package com.example.myapplication.moudel;

import org.litepal.crud.DataSupport;

/**
 * model基础类
 */
public class BaseModel extends DataSupport {
    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
