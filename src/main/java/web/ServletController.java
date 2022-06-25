package web;

import data.ClientDaoJDBC;
import domain.Client;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "insert":
                    this.insertClient(req, res);
                    break;
                case "edit":
                    this.editClient(req,res);
                    break;
                case "delete":
                    this.deleteClient(req, res);
                    break;
                default:
                    this.defaultAction(req, res);
            }
        } else {
            this.defaultAction(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "insert":
                    this.insertClient(req, res);
                    break;
                case "edit":
                    this.updateClient(req,res);
                    break;
                default:
                    this.defaultAction(req, res);
            }
        } else {
            this.defaultAction(req, res);
        }
    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Client> clients = new ClientDaoJDBC().list();
        System.out.println("clientes = " + clients);
        HttpSession session = req.getSession();
        session.setAttribute("clients", clients);
        session.setAttribute("totalClients", clients.size());
        session.setAttribute("totalBalance", calcBalance(clients));
        //req.getRequestDispatcher("clients.jsp").forward(req, res);
        res.sendRedirect("clients.jsp");
    }

    private void insertClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //Values of form
        double balance = 0;
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String balanceString = req.getParameter("balance");
        if (balanceString != null && !"".equals(balanceString)) {
            balance = Double.parseDouble(balanceString);
        }

        // New object
        Client client = new Client(firstName, lastName, email, phone, balance);

        //Insert database
        int records = new ClientDaoJDBC().insert(client);
        System.out.println("records = " + records);

        this.defaultAction(req, res);
    }
    
    private void updateClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int idClient = Integer.parseInt(req.getParameter("idClient"));
        double balance = 0;
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String balanceString = req.getParameter("balance");
        if (balanceString != null && !"".equals(balanceString)) {
            balance = Double.parseDouble(balanceString);
        }

        // New object
        Client client = new Client(idClient, firstName, lastName, email, phone, balance);

        //Insert database
        int records = new ClientDaoJDBC().update(client);
        System.out.println("records = " + records);

        this.defaultAction(req, res);
    }
    
    private void editClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idClient = Integer.parseInt(req.getParameter("idClient"));
        System.out.println("idClient = " + idClient);
        Client client = new ClientDaoJDBC().find(new Client(idClient));
        System.out.println("client = " + client);
        req.setAttribute("client", client);
        String jspEdit = "/WEB-INF/pages/client/editClient.jsp";
        req.getRequestDispatcher(jspEdit).forward(req, res);
    }
    
    private void deleteClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int idClient = Integer.parseInt(req.getParameter("idClient"));
        // New object
        Client client = new Client(idClient);

        //Insert database
        int records = new ClientDaoJDBC().delete(client);
        System.out.println("records = " + records);

        this.defaultAction(req, res);
    }

    private double calcBalance(List<Client> clients) {
        double total = 0;
        for (Client client : clients) {
            total += client.getBalance();
        }
        return total;
    }
}
