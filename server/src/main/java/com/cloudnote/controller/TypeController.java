package com.cloudnote.controller;


import com.cloudnote.pojo.Type;
import com.cloudnote.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "云记类型模块")
@RequestMapping("/type")
public class TypeController {

    @Resource
    private TypeService typeService;

    @ApiOperation(value = "查询所有类型")
    @PostMapping("/types")
    public List<Type> types(){
        return typeService.types();
    }
}
