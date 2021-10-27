package com.example.myapplication.manager;

import com.example.myapplication.moudel.YoufengModel;

import org.litepal.crud.DataSupport;

import java.util.List;

public class YoufengManage {
    private static final int SUCCESS = 0;

    private YoufengManage() {

    }

    public static YoufengManage getInstance() {
        return YoufengManagerHoulder.YOUFENG;
    }

    private static class YoufengManagerHoulder {
        public static final YoufengManage YOUFENG = new YoufengManage();
    }

    /**
     * 添加数据
     *
     * @param model 数据对象
     * @return 返回值
     */
    public int addData(YoufengModel model) {
        model.save();
        return SUCCESS;
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<YoufengModel> InquireAllData() {
        List<YoufengModel> data = DataSupport.findAll(YoufengModel.class);
        return data;
    }

    /**
     * 更新数据
     *
     * @param model 要更新的数据
     * @param id    标志位id
     * @return
     */
    public int upData(YoufengModel model, int id) {
        model.update(id);
        return SUCCESS;
    }

    /**
     * 删除
     *
     * @param model 删除对象
     * @return
     */
    public int delete(YoufengModel model) {
        model.delete();
        return SUCCESS;
    }
}
