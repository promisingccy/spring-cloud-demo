package com.ccy.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AccessLogFilter
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 11:43
 * @Version 1.0
 **/
/**
 * 此过滤器在 整个请求发送response 之前执行
 * */
@Slf4j  //日志注解
@Component
public class AccessLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 过滤器执行顺序
     * 越小 优先级越高
     * */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        //获取起始时间
        RequestContext ctx = RequestContext.getCurrentContext();
        Long startTime = (Long) ctx.get("startTime");
        //获取请求信息
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        //计算执行时长
        long duration = System.currentTimeMillis() - startTime;
        log.info("uri:{}, duration:{}", uri, duration/100);
        return null;
    }
}
