package com.zack.mapper;

import com.zack.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //获取总记录数
    @Select("select count(*) from emp")
    Long count();

//    //获取分页查询返回列表
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    List<Emp> list(Integer start, Integer pageSize);

    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    @Delete("delete from emp where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into emp (id, username, password, name, gender, image, job, entry_date, dept_id, create_time, update_time) " +
            "values (#{id}, #{username}, #{password}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);
    
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);
}
