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
public class ManagerFilter extends HttpServlet implements Filter{

    FilterConfig filterConfig=null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (filterConfig==null)
            return;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        int role = (int) session.getAttribute("role");

        if(role!=3)
            response.sendRedirect("error.jsp");
    }

    @Override
    public void destroy(){
        this.filterConfig=null;
    }
}
