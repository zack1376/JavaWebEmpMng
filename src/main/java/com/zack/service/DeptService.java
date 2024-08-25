package com.zack.service;

import com.zack.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {

    List<Dept> list();
}
