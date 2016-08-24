package cn.zw.entity;

import java.io.Serializable;

/**
 * Created by Administrator
 * on 2016/8/3
 * 9:43.
 */
public class BaseEntity  implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
