package com.zack.controller;

import com.zack.pojo.Dept;
import com.zack.pojo.Result;
import com.zack.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 部门列表数据查询
     * @return 全部部门表
     */
    @GetMapping
    public Result listDept(){
        log.info("listDept");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据部门id删除部门
     * @param id 部门id
     * @return 返回成功信息
     */
    @DeleteMapping("/{id}")
    public Result deleteDeptById(@PathVariable Integer id){
        log.info("deleteDept:{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 添加部门
     * @param dept 需要添加的部门信息
     * @return 成功信息
     */
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        log.info("addDept:{}", dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return 查询到的部门
     */
    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id){
        log.info("getDeptById:{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        log.info("updateDept:{}", dept);
        deptService.updateDept(dept);
        return Result.success();
    }
}
