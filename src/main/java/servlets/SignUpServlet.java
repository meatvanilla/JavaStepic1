package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import accs.AccountService;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    // Конструктор, принимающий AccountService
    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null && password != null && !login.isEmpty() && !password.isEmpty()) {
            // Сохранение аккаунта с помощью AccountService
            accountService.addAccount(login, password);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("Account created successfully");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Login and password are required");
        }
    }
}