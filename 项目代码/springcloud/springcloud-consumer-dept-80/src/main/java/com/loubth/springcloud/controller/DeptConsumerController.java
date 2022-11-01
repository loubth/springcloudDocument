package com.loubth.springcloud.controller;

import com.loubth.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    /*理解：
     * 消费者不应该有service层，因此需要调用远程服务。前面就说过Springcloud基于Http的Rest风格来进行通信的
     * RestTemplate就是spring提供的一种便捷访问远程http服务的对象
     * */
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("consumer/dept/getDeptById/{id}")
    public Dept getDeptById(@PathVariable("id") long id) {
        /*
         * 通过restTemplate访问远程服务端提供的服务
         *
         * getForObject()表示用get方法从远程服务器拿回一个对象
         * 参数类型一般为：
         * 1. 要访问的URL
         * 2. 实体（携带的参数们）：类型可以为Map。如果携带参数为int等基本数据类型时可以不用额外的实体而像本例直接把参数用restful风格融入url（通俗来说就是拼接字符串）
         * 3. Class<T>responseType 需要的返回值的类型
         *
         * restful不像rpc那要要求reference引用，restful直接通过http的url去请求，http-restful通过restTemplate实现
         * 客户端和服务无关，没有service层，完全解耦
         * */
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/qbid/" + id, Dept.class);
    }

    @RequestMapping("consumer/dept/getDeptAll")
    public List<Dept> getDeptAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/qall", List.class);
    }

    @RequestMapping("consumer/dept/addDept")
    public boolean addDept(Dept dept) {
        /*
         * restTemplate.postForObject(URI url, @Nullable Object request, Class<T> responseType)参数解析:
         * 1. 请求远程服务需要的url
         * 2. 以post方式提交请求时需要携带的（对象）参数
         * 3. 控制器函数addDept()返回类型，需要和远程服务的返回值一致
         * */
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add/", dept, Boolean.class);
    }


}