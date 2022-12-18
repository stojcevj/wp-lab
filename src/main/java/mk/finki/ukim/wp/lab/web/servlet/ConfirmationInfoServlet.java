package mk.finki.ukim.wp.lab.web.servlet;

import mk.finki.ukim.wp.lab.model.User;
import mk.finki.ukim.wp.lab.service.implementation.OrderServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@WebServlet(name="confirmation-servlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final OrderServiceImpl orderService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, OrderServiceImpl orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> usr = (Optional<User>)req.getSession().getAttribute("user");
        String clientName = usr.map(User::getName).orElse(null);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("clientName", clientName);

        orderService.placeOrder((String)req.getSession().getAttribute("balloonColor"),
                                (String)req.getSession().getAttribute("balloonSize"), LocalDateTime.parse(req.getParameter("dateCreated")));
        springTemplateEngine.process("confirmationInfo", context, resp.getWriter());

    }
}
