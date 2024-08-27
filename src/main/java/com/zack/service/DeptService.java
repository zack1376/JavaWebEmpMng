package com.zack.service;

import com.zack.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {

    List<Dept> list();

    void deleteById(Integer id);

    void addDept(Dept dept);

    Dept getById(Integer id);

    void updateDept(Dept dept);
}
