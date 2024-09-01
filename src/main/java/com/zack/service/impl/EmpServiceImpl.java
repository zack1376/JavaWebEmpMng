package com.zack.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zack.mapper.EmpMapper;
import com.zack.pojo.Emp;
import com.zack.pojo.PageBean;
import com.zack.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    /**
     * 分页查询
     * @param page 第几页
     * @param pageSize 每页大小
     * @return 分页查询结果封装在PageBean中，包括总记录数和该页记录
     */
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list(name, gender, begin, end);

        Page<Emp> p = (Page<Emp>) empList;

        return new PageBean(p.getTotal(), p.getResult());
    }

    /**
     * 按id删除员工
     * @param id 员工id
     */
    @Override
    public void deleteById(Integer id) {
        empMapper.deleteById(id);
    }

    //新增员工
    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }
}
