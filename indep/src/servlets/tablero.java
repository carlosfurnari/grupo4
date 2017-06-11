package servlets;

import charts.ChartData;
import charts.ChartTablero;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tablero
 */
@WebServlet("/tablero")
public class tablero extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ATTR_DATA_CHART = "chartData";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tablero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	    String total = "$40.000";
	    String ingresos = "$50.000";
	    String egresos = "$10.000";

	    request.setAttribute("total", total);
	    request.setAttribute("ingresos", ingresos);
	    request.setAttribute("egresos", egresos);
		setAttributeChartDataForTablero(request);
	    request.getRequestDispatcher("tablero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void setAttributeChartDataForTablero(HttpServletRequest request) {
		ChartData chartData = new ChartTablero();

		request.setAttribute(ATTR_DATA_CHART, chartData.getData());
	}

}