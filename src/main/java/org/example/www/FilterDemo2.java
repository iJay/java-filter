package org.example.www;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 两者的路径匹配同为/*，为什么先执行FilterDemo2的doFilter方法，再执行FilterDemo的doFilter方法？
 * 配置方式的优先级是按照过滤器类名(字符串)的自然排序。 所以，这里的执行顺序如下：
 * before.EFilterDemo...
 * 1.FilterDemo...
 * 2.FilterDemo...
 * 3.hello jsp
 * 4.FilterDemo...
 * 5.FilterDemo...
 * after.EFilterDemo...
 */
@WebFilter(filterName = "FilterDemo2", urlPatterns = "/*")
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo2 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 放行前，对 request数据进行处理
        System.out.println("2.FilterDemo...");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
        // 2. 放行后，对Response 数据进行处理
        System.out.println("4.FilterDemo...");
    }

    @Override
    public void destroy() {

    }
}
