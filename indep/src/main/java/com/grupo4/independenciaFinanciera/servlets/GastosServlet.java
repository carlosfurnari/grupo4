package com.grupo4.independenciaFinanciera.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indepfin.talledp.model.Categoria;
import com.indepfin.talledp.model.Gasto;

@WebServlet("/GastosServlet")
public class GastosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public GastosServlet() {
		super();
	}

    //private StudentDAO dao;
    public static final String LIST_GASTOS = "show-gastos.jsp";
    public static final String INSERT_OR_EDIT = "carga-gastos.jsp";
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );
 
        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LIST_GASTOS;
            String gastoId = request.getParameter("gastoId") ;
            //dao.deleteStudent(studentId);
            System.out.println("DELETE GASTO" + gastoId);
            request.setAttribute("gastos", getMockedGastos() );
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERT_OR_EDIT;
            System.out.println("EDIT gasto");
            int gastoId = Integer.parseInt( request.getParameter("gastoId") );
            //Student student = dao.getStudentById(studentId);
            request.setAttribute("gasto", null);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = LIST_GASTOS;
            request.setAttribute("gastos", getMockedGastos() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
 
    private List<Gasto> getMockedGastos() {
		Gasto gasto1 = new Gasto();
		gasto1.setDescripcion("desc1");
		gasto1.setCategoria(Categoria.ALIMENTOS);
		gasto1.setMonto("200");
		
		Gasto gasto2 = new Gasto();
		gasto2.setDescripcion("desc2");
		gasto2.setCategoria(Categoria.INDUMENTARIA);
		gasto2.setMonto("500");
    	List<Gasto> result = new ArrayList<Gasto>();
		result.add(gasto1);
		result.add(gasto2);
		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gasto gasto = new Gasto();
        gasto.setDescripcion(request.getParameter( "desc" ) );
        gasto.setMonto( request.getParameter( "monto" ) );
        gasto.setCategoria( Categoria.valueOf(request.getParameter( "Cat" )) );
        String gastoId = request.getParameter("gastoId");
 
        if( gastoId == null || gastoId.isEmpty() )
            //dao.addStudent(student);
        	System.out.println("Add to database");
        else {
            gasto.setId( gastoId );
            //dao.updateStudent(student);
            System.out.println("update in database");
        }
        RequestDispatcher view = request.getRequestDispatcher( LIST_GASTOS );
        request.setAttribute("gastos", null);
        view.forward(request, response);
    }
}
