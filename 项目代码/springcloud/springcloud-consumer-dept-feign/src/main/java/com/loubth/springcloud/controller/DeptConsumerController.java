package com.loubth.springcloud.controller;

import com.loubth.springcloud.pojo.Dept;
import com.loubth.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;


    @RequestMapping("consumer/dept/getDeptById/{id}")
    public Dept getDeptById(@PathVariable("id") long id) {
        return this.deptClientService.queryById(id);
    }

    @RequestMapping("consumer/dept/getDeptAll")
    public List<Dept> getDeptAll() {
        return this.deptClientService.queryAll();
    }

    @RequestMapping("consumer/dept/addDept")
    public boolean addDept(Dept dept) {
        return this.deptClientService.addDept(dept);
    }


}