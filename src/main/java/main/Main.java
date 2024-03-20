package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import accs.AccountService;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        AccountService accountService = new AccountService();

        // Создание экземпляров сервлетов с передачей экземпляра AccountService в конструктор
        SignUpServlet signUpServlet = new SignUpServlet(accountService);
        SignInServlet signInServlet = new SignInServlet(accountService);

        // Создание ServletHolder для каждого сервлета
        ServletHolder signUpServletHolder = new ServletHolder(signUpServlet);
        ServletHolder signInServletHolder = new ServletHolder(signInServlet);

        // Добавление сервлетов с маппингами с использованием метода addServletWithMapping()
        handler.addServletWithMapping(signUpServletHolder, "/signup");
        handler.addServletWithMapping(signInServletHolder, "/signin");

        server.start();
        System.out.println("Server started");
        server.join();
    }

}