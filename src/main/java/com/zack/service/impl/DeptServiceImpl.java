package com.zack.service.impl;

import com.zack.mapper.DeptMapper;
import com.zack.pojo.Dept;
import com.zack.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询部门基本信息
     * @return 全部部门表
     */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    /**
     * 删除部门
     * @param id 待删除的部门id
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * 添加部门
     * @param dept 待添加的部门信息
     */
    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return 查询到的部门
     */
    @Override
    public Dept getById(Integer id) {
        return deptMapper.selectById(id);
    }

    /**
     * 更新部门
     * @param dept 存储了待更新的信息
     */
    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
