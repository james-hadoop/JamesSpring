package com.james.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james.spring.dao.mapper.master.LeyaoWebMapper;
import com.james.spring.dao.mapper.slave.LeyaoWeb2Mapper;
import com.james.spring.entity.LeyaoWeb;
import com.james.spring.entity.LeyaoWeb2;

@RestController
public class MultiDatasourceController {
    @Autowired
    LeyaoWebMapper leyaoWebMapper;

    @Autowired
    LeyaoWeb2Mapper leyaoWeb2Mapper;

    @RequestMapping("/leyaoWeb")
    public List<LeyaoWeb> leyaoWeb() {
        List<LeyaoWeb> leyaoWebList = leyaoWebMapper.getAll();
        return leyaoWebList;
    }

    @RequestMapping("/leyaoWeb2")
    public List<LeyaoWeb2> leyaoWeb2() {
        List<LeyaoWeb2> leyaoWeb2List = leyaoWeb2Mapper.getAll();
        return leyaoWeb2List;
    }
}
