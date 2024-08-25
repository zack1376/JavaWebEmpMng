package com.zack.controller;

import com.zack.pojo.Dept;
import com.zack.pojo.Result;
import com.zack.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class RequestController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
        log.info("list");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
}
