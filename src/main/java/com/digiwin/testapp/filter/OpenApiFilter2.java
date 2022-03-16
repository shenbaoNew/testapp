package com.digiwin.testapp.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * FileName:OpenApiFilter2
 * Author: shenbao
 * Date: 2022/3/16 22:10
 * Description:
 */
public class OpenApiFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("open api 2");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
