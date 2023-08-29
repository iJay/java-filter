package org.example.www;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * filter执行流程： 执行放行前逻辑 ------ 放行 ------ 访问资源 ------ 执行放行后逻辑
 */

/**
 * 这里的拦截类似于servlet路径匹配，按照优先级先后倒叙排列
 * 如果是/，则拦截所有请求
 * 如果是/*，则拦截所有请求
 * 如果是*.do，则拦截所有以.do结尾的请求
 * 如果是/abc/*，则拦截/abc/下的所有请求
 * 如果是/abc/def，则拦截/abc/def请求
 */
@WebFilter(filterName = "FilterDemo", urlPatterns = "/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 放行前，对 request数据进行处理
        System.out.println("1.FilterDemo...");
        // 放行后才可以访问到index.jsp的页面内容
        filterChain.doFilter(servletRequest,servletResponse);
        // 2. 放行后，对Response 数据进行处理
        System.out.println("5.FilterDemo...");
    }

    @Override
    public void destroy() {

    }
}
