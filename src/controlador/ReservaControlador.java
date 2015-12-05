package controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DetalleReserva;
import beans.Empleado;
import beans.Habitacion;

import beans.Reserva;
import services.HabitacionService;
import services.ReservaService;

/**
 * Servlet implementation class ReservaControlador
 */
@WebServlet("/reserva")
public class ReservaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
ReservaService service= new ReservaService();
HabitacionService servicio= new HabitacionService();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String metodo=request.getParameter("metodo");
		if(metodo.equals("verHabitacion"))
		verHabitacion(request, response);
		else if (metodo.equals("verCliente"))
			CargaCliente(request, response);
		else if(metodo.equals("ingresa"))
		ingresa(request, response);
		else if(metodo.equals("elimina"))
		eliminar(request, response);
		else if(metodo.equals("registra"))
		registra(request, response);
		}
	
	protected void CargaCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String producto[]=new String[5];
		producto[0]=codigo;
	
		HttpSession session = request.getSession();
		session.setAttribute("datoCliente", producto);
		request.getRequestDispatcher("/FrmReserva.jsp").
		forward(request, response);
	}

	protected void verHabitacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigo = request.getParameter("codigo");
		String categoria = request.getParameter("categoria");
		String tipo = request.getParameter("tipo");
		String piso = request.getParameter("numero");
		String precio = request.getParameter("precio");
	
	
		String producto[]=new String[5];
		producto[0]=codigo;
		producto[1]=categoria;
		producto[2]=tipo;
		producto[3]=piso;
		producto[4]=precio;
		
		HttpSession session = request.getSession();
		session.setAttribute("datoHabitacion", producto);
		request.getRequestDispatcher("/FrmReserva.jsp").
		forward(request, response);
	
	}
	protected void ingresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String codigoHab =request.getParameter("txtNumeroHabitacion");
		String precio =request.getParameter("txtPrecio");
		String piso =request.getParameter("txtNumeroPiso");
		String huesped =request.getParameter("txtHuesped");
	    int habitacion =Integer.parseInt(codigoHab);
	    double precioHab = Double.parseDouble(precio);
	    int numpiso=Integer.parseInt(piso);
	  
	       
	     ArrayList<Habitacion> reserva ;
	
	     HttpSession session=request.getSession();
	     if(session.getAttribute("reserva") == null){
		reserva = new ArrayList<Habitacion>();
	}else{
		reserva = (ArrayList<Habitacion>)session.getAttribute("reserva");
	}
	
	Habitacion hab = new Habitacion();
	hab.setNumeroHabitacion(habitacion);
	hab.setPrecioPorNoche(precioHab);
	hab.setNumeroPiso(numpiso);
	
	
	boolean noExiste= true;
	
	for (int i = 0; i < reserva.size(); i++) {
		if(reserva.get(i).getNumeroHabitacion() ==habitacion ){
			reserva.set(i, hab);
			noExiste = false;
			break;
		}
	}
	
	//Si no existe se agrega
	if(noExiste){
		reserva.add(hab);
	}
	
	//la lista se agrega a sesion
	session.setAttribute("reserva", reserva);
	
	request.getRequestDispatcher("/FrmReserva.jsp").forward(request, response);
	
	
	

			
	
	
		
		
		
		
	}
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		HttpSession session =request.getSession();
		ArrayList<Habitacion> reserva=(ArrayList<Habitacion>)session.getAttribute("reserva");
		
		String cliente[]=(String[])session.getAttribute("datoCliente");
		int codCliente=Integer.parseInt(cliente[0]);
		
		Empleado codemple=(Empleado)session.getAttribute("datos");
		String fecha1=request.getParameter("FECHA");
		Reserva res =new Reserva();
		res.setCodigoEmpleado(1);
		res.setCodigoCliente(codCliente);
		
		
		ArrayList<DetalleReserva> deta= new ArrayList<DetalleReserva>();
		
		for(Habitacion x : reserva){
			
			DetalleReserva d= new DetalleReserva(0, x.getNumeroHabitacion(), x.getPrecioPorNoche());
			
			deta.add(d);
		
		}

		service.registraReserva(res, deta);
		session.removeAttribute("reserva");
		session.removeAttribute("datoHabitacion");
		session.removeAttribute("datoProducto");
		
		request.getRequestDispatcher("/FrmReserva").forward(request, response);
		
		
		
		
		
		
		
		
		
	}

	
	
	
	}

