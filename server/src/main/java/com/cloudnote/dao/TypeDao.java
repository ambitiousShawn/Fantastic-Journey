package com.cloudnote.dao;

import com.cloudnote.pojo.Type;

import java.util.List;

public interface TypeDao {

    //显示有哪些类型
    List<Type> types();
}
