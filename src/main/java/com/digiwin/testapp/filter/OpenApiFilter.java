package com.digiwin.testapp.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * FileName:OpenApiFilter
 * Author: shenbao
 * Date: 2022/3/15 11:24
 * Description:
 */
@WebFilter(filterName = "openApiFilter", urlPatterns = "/eai")
@Order(900001)
@Component
public class OpenApiFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //System.out.println("open api");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
