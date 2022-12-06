package mk.finki.ukim.wp.lab.web.servlet.filters;

import mk.finki.ukim.wp.lab.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

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

        Optional<User> user = (Optional<User>) httpServletRequest.getSession().getAttribute("user");
        String path = httpServletRequest.getServletPath();

        if(user == null && !path.equals("/auth") && !path.equals("/auth/register")){
            httpServletResponse.sendRedirect("/auth");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
