
/*
 * Gabriel Ferreira de Souza
 * Guilherme Ferreira Santos
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;
    private SalesmanDAO salesmanDAO;
    private OrdersDAO ordersDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        customerDAO = new CustomerDAO(jdbcURL, jdbcUsername, jdbcPassword);
        salesmanDAO = new SalesmanDAO(jdbcURL, jdbcUsername, jdbcPassword);
        ordersDAO = new OrdersDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new-customer":
                showNewCustomerForm(request, response);
                break;
            case "/insert-customer":
                insertCustomer(request, response);
                break;
            case "/delete-customer":
                deleteCustomer(request, response);
                break;
            case "/edit-customer":
                showEditCustomerForm(request, response);
                break;
            case "/update-customer":
                updateCustomer(request, response);
                break;
            case "/list-customer":
                listCustomer(request, response);
                break;
            case "/new-salesman":
                showNewSalesmanForm(request, response);
                break;
            case "/insert-salesman":
                insertSalesman(request, response);
                break;
            case "/delete-salesman":
                //deleteBook(request, response);
                break;
            case "/edit-salesman":
                //showEditForm(request, response);
                break;
            case "/update-salesman":
                //updateBook(request, response);
                break;
            case "/new-orders":
                //showNewForm(request, response);
                break;
            case "/insert-orders":
                //insertBook(request, response);
                break;
            case "/delete-orders":
                //deleteBook(request, response);
                break;
            case "/edit-orders":
                //showEditForm(request, response);
                break;
            case "/update-orders":
                //updateBook(request, response);
                break;
            default:
                listOrders(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listOrders(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List<Orders> listOrders = ordersDAO.listAllOrders();
        request.setAttribute("listOrders", listOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewCustomerForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id_customer = Integer.parseInt(request.getParameter("id_customer"));
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int grade = Integer.parseInt(request.getParameter("grade"));
        int id_salesman = Integer.parseInt(request.getParameter("id_salesman"));
 
        Customer newCustomer = new Customer(id_customer, name, city, grade, id_salesman);
        customerDAO.insertCustomer(newCustomer);
        response.sendRedirect("list-customer");
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerDAO.getCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id_customer = Integer.parseInt(request.getParameter("id_customer"));
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int grade = Integer.parseInt(request.getParameter("grade"));
        int id_salesman = Integer.parseInt(request.getParameter("id_salesman"));
 
        Customer customer = new Customer(id_customer, name, city, grade, id_salesman);
        customerDAO.updateCustomer(customer);
        response.sendRedirect("list-customer");
    }
 
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Customer customer = new Customer(id);
        customerDAO.deleteCustomer(customer);
        response.sendRedirect("list-customer");
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerDAO.listAllCustomers();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewSalesmanForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id_salesman = Integer.parseInt(request.getParameter("id_salesman"));
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        float comission = Float.parseFloat(request.getParameter("grade"));
 
        Salesman newSalesman = new Salesman(id_salesman, name, city, comission);
        salesmanDAO.insertSalesman(newSalesman);
        response.sendRedirect("list-customer");
    }

}
