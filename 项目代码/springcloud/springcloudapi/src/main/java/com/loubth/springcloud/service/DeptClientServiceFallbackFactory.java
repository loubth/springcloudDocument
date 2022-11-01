package com.loubth.springcloud.service;

import com.loubth.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * DeptClientService()服务失败时通过create函数返回自定义的降级版的DeptClientService()
 *
 * 熔断和降级老师都写在公共模块springcloudapi子工程里确实容易让人误解，熔断是在服务提供者里用的，降级是在服务消费者里用的
 *
 * 熔断是对微服务中的一个方法配置回调函数，降级是对整个微服务配置回调函数
 * */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(long id) {
                return new Dept().setDeptno(id).setDname("id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭").setDb_source("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
