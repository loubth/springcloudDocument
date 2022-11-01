package com.loubth.springcloud.service;

import com.loubth.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//将指定服务映射成接口，value填application name
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
@Service    //注入spring容器中
public interface DeptClientService {

    /*方法和服务提供者的接口中的一致
     *
     * 请求路径和服务提供者（springcloud-provider-dept-8001，8002,8003）的controller的路径也得一致，不然报错！！！
     * */
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);

    //这里@pathcariable里面必须写上id要不然会出错
    @GetMapping("/dept/qbid/{id}")
    public Dept queryById(@PathVariable("id") long id);

    @GetMapping("/dept/qall")
    public List<Dept> queryAll();
}

