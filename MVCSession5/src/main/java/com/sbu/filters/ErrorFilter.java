package com.sbu.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tara on 6/17/2017.
 */
public class ErrorFilter extends HttpServlet implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(filterConfig == null)
            return;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String requestedURL = request.getRequestURL().toString();
        int role = (int) session.getAttribute("role");

        if(requestedURL.contains("/student") & role!=1){
            response.sendRedirect("/error");
        }

        else if(requestedURL.contains("/prof") & role!=2){
            response.sendRedirect("/error");
        }

        else if(requestedURL.contains("/manager") & role!=3){
            response.sendRedirect("/error");
        }

        filterChain.doFilter(request, response);

    }


    @Override
    public void destroy(){
        this.filterConfig=null;
    }
}
