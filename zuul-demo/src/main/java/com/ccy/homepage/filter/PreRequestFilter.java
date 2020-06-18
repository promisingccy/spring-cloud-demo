package com.ccy.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @ClassName PreRequestFilter
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 11:32
 * @Version 1.0
 **/

/**
 * 此过滤器在 整个请求开始之前 执行
 * 实现功能：在过滤器中存储客户端发起请求的时间戳
 * Component注解 表明该类会作为组件类，并告知Spring要为这个类创建bean
 * */
@Component
public class PreRequestFilter extends ZuulFilter {

    /**
     * 过滤器类型
     * 简略先后顺序 PRE_TYPE -> ROUTE_TYPE|ERROR_TYPE -> POST_TYPE
     * */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器执行顺序
     * 越小 优先级越高
     * */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 根据条件 是否启用当前过滤器
     * */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //请求上下文 RequestContext 用于在过滤器之间传递消息
        RequestContext ctx = RequestContext.getCurrentContext();
        //存储起始时间
        ctx.set("startTime", System.currentTimeMillis());
        return null;
    }
}
