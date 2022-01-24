package com.cloudnote.service.impl;

import com.cloudnote.dao.TypeDao;
import com.cloudnote.pojo.Type;
import com.cloudnote.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeDao typeDao;

    @Override
    public List <Type> types() {
        return typeDao.types();
    }
}
