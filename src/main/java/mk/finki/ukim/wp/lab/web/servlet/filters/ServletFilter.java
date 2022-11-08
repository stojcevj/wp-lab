package mk.finki.ukim.wp.lab.web.servlet.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class ServletFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String balloonColor = (String) httpServletRequest.getSession().getAttribute("balloonColor");
        String path = httpServletRequest.getServletPath();

        /*if(balloonColor == null && !path.equals("") && !path.equals("/orders") && !path.equals("/balloons") && !path.equals("/balloons/delete")){
            httpServletResponse.sendRedirect("");
        }else{*/
            filterChain.doFilter(servletRequest, servletResponse);
      //  }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
