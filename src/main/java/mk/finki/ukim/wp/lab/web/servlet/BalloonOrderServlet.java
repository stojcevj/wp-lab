package mk.finki.ukim.wp.lab.web.servlet;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="balloon-order", urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String balloonSize = req.getParameter("size");
        req.getSession().setAttribute("balloonSize", balloonSize);
        WebContext context = new WebContext(req,resp,req.getServletContext());
        springTemplateEngine.process("deliveryInfo", context, resp.getWriter());
    }
}
