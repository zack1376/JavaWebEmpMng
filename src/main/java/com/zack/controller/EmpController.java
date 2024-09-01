package com.zack.controller;

import com.zack.pojo.Emp;
import com.zack.pojo.PageBean;
import com.zack.pojo.Result;
import com.zack.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询员工数据
     * @return 要求的一页员工数据封装结果
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询，参数：{}，{}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    //删除员工
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable Integer ids) {
        log.info("删除员工，序号：{}", ids);
        empService.deleteById(ids);
        return Result.success();
    }

    //新增员工
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("新增员工，{}", emp.toString());
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("查询员工，{}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
}
