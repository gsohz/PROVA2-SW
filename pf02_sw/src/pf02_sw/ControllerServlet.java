package pf02_sw;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
	
	public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        dao = new DAO(jdbcURL, jdbcUsername, jdbcPassword);
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
            case "/newSalesman":
            	showNewFormSalesman(request, response);
                break;
            case "/insertSalesman":
            	insertSalesman(request, response);
                break;
            case "/newCustomer":
            	showNewFormCustomer(request, response);
                break;
            case "/insertCustomer":
            	insertCustomer(request, response);
                break;
            case "/newOrders":
            	showNewFormOrders(request, response);
                break;
            case "/insertOrders":
            	insertOrders(request, response);
                break;
            case "/credits":
                showCredits(request, response);
                break;
            case "/list":
            	list(request, response);
                break;
            default:
            	list(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void list(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Salesman> listSalesman = dao.listAllSalesman();
        List<Customer> listCustomer = dao.listAllCustomer();
        List<Orders> listOrders = dao.listAllOrders();

        request.setAttribute("listSalesman", listSalesman);
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listOrders", listOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("List.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewFormSalesman(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
        dispatcher.forward(request, response);
    }
 

    private void insertSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        float comission = Float.parseFloat(request.getParameter("comission"));
 
        Salesman newSalesman = new Salesman(name, city, comission);
        dao.insertSalesman(newSalesman);
        response.sendRedirect("list");
    }

    private void showNewFormCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
        dispatcher.forward(request, response);
    }
 

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        float grade = Float.parseFloat(request.getParameter("grade"));
 
        Customer newCustomer = new Customer(name, city, grade);
        dao.insertCustomer(newCustomer);
        response.sendRedirect("list");
    }
    
    private void showNewFormOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersForm.jsp");
        dispatcher.forward(request, response);
    }
 

    private void insertOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	float purch_amt =  Float.parseFloat(request.getParameter("purch_amt"));
    	String dateString = request.getParameter("ord_date");
    	Date ord_date = new Date();
    	try {
    		if(dateString != null) {
    			ord_date= new SimpleDateFormat("yyyy-MM-dd").parse(dateString);    		
    		}
    	} catch(ParseException e) {
    		
    	}
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
       
        
        Orders newOrders = new Orders(purch_amt, ord_date, customer_id, salesman_id);
        dao.insertOrders(newOrders);
        response.sendRedirect("list");
    }
    
    private void showCredits(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Credits.jsp");
        dispatcher.forward(request, response);
    }
}
