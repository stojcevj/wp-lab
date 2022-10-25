package mk.finki.ukim.wp.lab.web.servlet;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="confirmation-servlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String balloonColor = (String)req.getSession().getAttribute("balloonColor");
        if(balloonColor == null){
            resp.sendRedirect("");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        if(clientName == null || clientAddress == null || clientAddress.isEmpty() || clientName.isEmpty()){
            resp.sendRedirect("BalloonOrder.do");
        }else {
            WebContext context = new WebContext(req, resp, req.getServletContext());
            context.setVariable("clientName", clientName);
            context.setVariable("clientAddress", clientAddress);
            context.setVariable("balloonColor", req.getSession().getAttribute("balloonColor"));
            context.setVariable("balloonSize", req.getSession().getAttribute("balloonSize"));
            context.setVariable("ipAddress", req.getRemoteHost());
            context.setVariable("browser", req.getHeader("User-Agent"));
            springTemplateEngine.process("confirmationInfo", context, resp.getWriter());
        }
    }
}
