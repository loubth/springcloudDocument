package com.loubth.springcloud.mapper;

import com.loubth.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//让接口被spring托管，表示当前接口是dao层的东西
@Repository
public interface DeptMapper {
    boolean addDept(Dept dept);

    Dept queryById(long id);

    List<Dept> queryAll();
}