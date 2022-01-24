package com.cloudnote.vo;

import java.util.LinkedList;
import java.util.List;

public class ResultInfo<T> {

    private Integer code;

    private String msg;

    private Integer count;

    private List<T> info;

    public ResultInfo(){
        info = new LinkedList <>();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List <T> getInfo() {
        return info;
    }

    public void setInfo(List <T> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", info=" + info +
                '}';
    }
}
