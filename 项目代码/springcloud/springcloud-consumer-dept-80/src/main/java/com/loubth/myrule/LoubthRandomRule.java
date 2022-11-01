package com.loubth.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/*
 * 自定义为：每个服务访问五次后换下一个服务
 *
 * */
public class LoubthRandomRule extends AbstractLoadBalancerRule {
    public LoubthRandomRule() {
    }

    //当前节点已被调用的次数
    private int count = 0;
    //当前是哪个节点在提供服务
    private int currentIndex = 0;

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                //获得还活着的服务
                List<Server> upList = lb.getReachableServers();
                //获得全部的服务
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }
                /*======================================自定义访问算法===start=======================================*/
//                //获得区间随机数
//                int index = this.chooseRandomInt(serverCount);
//                //从活着的服务列表中随机获取一个服务
//                server = (Server)upList.get(index);
                if (this.count < 5) {
                    server = upList.get(this.currentIndex);
                    this.count++;
                } else {
                    this.count = 0;
                    this.currentIndex++;
                    if (this.currentIndex >= upList.size()) {
                        this.currentIndex = 0;
                    }
                }
                /*======================================自定义访问算法===end=======================================*/

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }


    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}