package mk.finki.ukim.wp.lab.web.servlet;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="select-balloon-servlet", urlPatterns = "/selectBalloon")
public class SelectBalloonServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String balloonColor = (String)req.getSession().getAttribute("balloonColor");
        WebContext context = new WebContext(req,resp,req.getServletContext());
        springTemplateEngine.process("selectBalloonSize", context, resp.getWriter());
    }
}
