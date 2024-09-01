package com.zack.service;

import com.zack.pojo.Emp;
import com.zack.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface EmpService {
    /**
     * 分页查询
     * @param page 第几页
     * @param pageSize 每页大小
     * @return 分页查询结果封装在PageBean中，包括总记录数和该页记录
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteById(Integer id);

    void add(Emp emp);

    Emp getById(Integer id);
}
