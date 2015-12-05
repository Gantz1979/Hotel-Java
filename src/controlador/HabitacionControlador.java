package controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Habitacion;
import services.HabitacionService;

/**
 * Servlet implementation class HabitacionControlador
 */
@WebServlet("/habitacion")
public class HabitacionControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	HabitacionService servicio = new HabitacionService();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String metodo = request.getParameter("metodo");
		
		
		
		
				if(metodo.equals("registrar")){
					registrar(request, response);
				}
				else if(metodo.equals("listar")){
					listar(request,response);}
				else if(metodo.equals("porTipoCate")){
					
					buscarTipo_Categoria(request, response);
				}
		
		
				
	}
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  
		
		request.setAttribute("data", servicio.listar());
		request.getRequestDispatcher("/MantenimientoHabitacion.jsp").forward(request, response);
	}
    

	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	 String 	categoriaHabitacion = request.getParameter("cboCategoria");
    	 String 	tipoHabitacion = request.getParameter("cboTipo");
    	// String     nombreHabitacion = request.getParameter("txtNombre");
    	 String 	numeroPiso     =  request.getParameter("txtPiso");
    	 String 	precioPorNoche = request.getParameter("txtPrecio");
    	 String 	estadoHabitacion  = request.getParameter("cboEstado");
    	 
    	int catHabi=Integer.parseInt(categoriaHabitacion.trim());
    	int tipoHab=Integer.parseInt(tipoHabitacion.trim());
    	int num =Integer.parseInt(numeroPiso.trim());
    	double precio=Double.parseDouble(precioPorNoche.trim());
    	int est=Integer.parseInt(estadoHabitacion.trim());
    	
 
       Habitacion bean= new Habitacion();
       bean.setCategoriaHabitacion(catHabi);
       bean.setTipoHabitacion(tipoHab);
    //   bean.setNombreHabitacion(nombreHabitacion); 
       bean.setNumeroPiso(num);
       bean.setPrecioPorNoche(precio);
       bean.setEstadoHabitacion(est); 
       servicio.registrar(bean);
       request.getRequestDispatcher("/MantenimientoHabitacion.jsp").forward(request, response);
       
	}
    
    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 int    numeroHabitacion;	
	 int 	categoriaHabitacion ;
  	 int 	tipoHabitacion;
  	 String nombreHabitacion;
  	 int 	numeroPiso  ;
  	 double	precioPorNoche ;
  	 int 	estadoHabitacion ;
  	numeroHabitacion= Integer.parseInt(request.getParameter("txtCodigo"));
  	categoriaHabitacion = Integer.parseInt(request.getParameter("cboCategoria"));
  	tipoHabitacion = Integer.parseInt(request.getParameter("cboTipo"));
  	nombreHabitacion = request.getParameter("txtNombre");
  	numeroPiso = Integer.parseInt(request.getParameter("txtPiso"));
  	precioPorNoche = Double.parseDouble(request.getParameter("txtPrecio"));
  	estadoHabitacion = Integer.parseInt(request.getParameter("cboEstado"));
  	
    
     Habitacion bean= new Habitacion();
     bean.setNumeroHabitacion(numeroHabitacion);
     bean.setCategoriaHabitacion(categoriaHabitacion);
     bean.setTipoHabitacion(tipoHabitacion);
     bean.setNombreHabitacion(nombreHabitacion); 
     bean.setNumeroPiso(numeroPiso);
     bean.setPrecioPorNoche(precioPorNoche);
     bean.setEstadoHabitacion(estadoHabitacion); 
     
	   
	   
	 
	   
	}
   protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   int numeroHabitacion;
	   int estado;
	   numeroHabitacion = Integer.parseInt(request.getParameter("txtCodigo"));
	   estado= Integer.parseInt(request.getParameter("cboEstado"));
	   	     Habitacion bean= new Habitacion();
        bean.setNumeroHabitacion(numeroHabitacion);
        bean.setEstadoHabitacion(estado);
    
	     
	}
	
   
   protected void buscarHabitacionPorTipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String tipo =request.getParameter("tipo");
	   
	   int codigoTipo =Integer.parseInt(tipo);
	   
	   request.setAttribute("datosPorTipo", servicio.buscarPorTipo(codigoTipo));
	   
	   request.getRequestDispatcher("BuscarHabitacion.jsp").forward(request, response);
	   
	   
	   
   }
   
	
   protected void buscarHabitacionPorCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String cat=request.getParameter("cate");
	   
	   int cate =Integer.parseInt(cat);
	   request.setAttribute("habitacion", servicio.buscarPorCategoria(cate));
	   request.getRequestDispatcher("/BuscarHabitacion.jsp").forward(request, response);
	   
	   
   }
	
	
   protected void buscarTipo_Categoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String tipo =request.getParameter("tipo");
   String cat =request.getParameter("categoria");

	   int codigoTipo =Integer.parseInt(tipo);
	   int codigocate =Integer.parseInt(cat);
	   	  
	   
	   request.setAttribute("datosTipoCategoria", servicio.buscarPorCat_Hab(codigoTipo, codigocate));
	   
	   request.getRequestDispatcher("/BuscarHabitacion.jsp").forward(request, response);
	   
	
   }
	
}
