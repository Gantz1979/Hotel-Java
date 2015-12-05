package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import dao.Fabrica;
import interfaces.ClienteDAO;
import services.ClienteService;

/**
 * Servlet implementation class ClienteControlador
 */
@WebServlet("/cliente")
public class ClienteControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteService service =new ClienteService();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operacion= request.getParameter("metodo");
				
		if (operacion.equals("registra"))
			registra(request,response);
		
		if(operacion.equals("consulta"))
			consultaxnombre(request, response);
		
		if(operacion.equals("actualiza"))
			actualizar(request, response);
		if(operacion.equals("elimina"))
			eliminar(request, response);
		}
	
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int Codigo;
		 
		   Codigo = Integer.parseInt(request.getParameter("btnElimar"));
		   	     Cliente bean= new Cliente();
	        bean.setCodigoCliente(Codigo);
	       
	    
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String   tipoDocumento;
			 String   numero;
			 String   nombreCliente  ;
		     String	 apelllidoPaterno; 
	         String	 apellidoMaterno ;
		     String   dni;
			 String	 telefono;
			 String   direccion;
		    
		     String   email;
		
			 
			 
			   
		    	
		    	nombreCliente= request.getParameter("txtnombre");
		    	apelllidoPaterno= request.getParameter("txtapellidopa");
		    	apellidoMaterno= request.getParameter("txtapellidoma");
		    	dni=request.getParameter("dni");
		    	direccion= request.getParameter("txtdireccion");
		    	telefono= request.getParameter("txttelefono");
		    	email= request.getParameter("txtemail");
		    	
			 
		        Cliente bean= new Cliente();
		        bean.setNombreCliente(nombreCliente);
		        bean.setApelllidoPaterno(apelllidoPaterno);
		        bean.setApellidoMaterno(apellidoMaterno);
		        bean.setNumeroDocumento(dni);
		        bean.setDireccion(direccion);
		        bean.setTelefono(telefono);
		        bean.setEmail(email);
		     
		        
		      service.registrar(bean);    
		  	  request.getRequestDispatcher("FrmMantenerCliente.jsp").forward(request, response);
		
	}

	protected void consultaxnombre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String nombre = request.getParameter("consult");
		Fabrica subFabrica = Fabrica.obtenerTipo(Fabrica.MYSQL);
		 ClienteDAO dao=subFabrica.getCliente();
		List<Cliente> data = null;
	
		try {
			data = dao.listarXnombre(nombre);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("clientes", data);
									   
		request.getRequestDispatcher("/BuscarCliente.jsp").forward(request, response);
	}



	
	

	protected void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		// TODO Auto-generated method stub
		
	     String   tipoDocumento;
		 String   numeroDocumento;
		 String   nombreCliente  ;
	     String	 apelllidoPaterno; 
         String	 apellidoMaterno ;
	     String   profesion;
	     String	 sexo;
		 String   direccion;
		 String	 telefono;
	     String   celular;
	     String   email;
		 String	 fecha;
		 
		 
		    tipoDocumento = request.getParameter("cbotipo");
	    	numeroDocumento = request.getParameter("txtnumero");
	    	nombreCliente= request.getParameter("txtnombre");
	    	apelllidoPaterno= request.getParameter("txtapellidopa");
	    	apellidoMaterno= request.getParameter("txtapellidoma");
	    	profesion= request.getParameter("txtprofesion");
	    	sexo= request.getParameter("cbosexo");
	    	direccion= request.getParameter("txtdireccion");
	    	celular= request.getParameter("txtcelular");
	    	telefono= request.getParameter("txttelefono");
	    	email= request.getParameter("txtemail");
	    	fecha= request.getParameter("txtfecha");
		 
	        Cliente bean= new Cliente();
	        bean.setTipoDocumento(tipoDocumento);
	        bean.setNumeroDocumento(numeroDocumento);
	        bean.setNombreCliente(nombreCliente); 
	        bean.setApelllidoPaterno(apelllidoPaterno);
	        bean.setApellidoMaterno(apellidoMaterno);
	        bean.setProfesion(profesion); 
	        bean.setSexo(sexo);
	        bean.setDireccion(direccion);
	        bean.setCelular(celular);
	        bean.setTelefono(telefono);
	        bean.setEmail(email);
	        bean.setFecha(fecha);
	    service.registrar(bean);    
	  request.getRequestDispatcher("FrmMantenerCliente.jsp").forward(request, response);
		
	}
	

}
