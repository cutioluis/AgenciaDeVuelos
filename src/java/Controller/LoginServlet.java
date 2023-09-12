
package Controller;

import DAO.UsuarioDAO;
import DTO.Usuario;
import java.io.IOException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {
    
    private UsuarioDAO userDAO;
    
    
    
    public void init (){
        //CADA VEZ QUE INSTANCIO AL SERVLET SE VA A GENER UNA INSTANCIA DE USUARIO 
        userDAO = new UsuarioDAO();
        
        
    }
   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action.equals ("Login")){
            //LLAMAR A LA CONSULTA DE BASE DE DATOS 
            validateLogin(request, response);
            
            
        }
        
        
        
    }
    
    protected void validateLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //ESTO PERMITE CAPTURAR LOS DATOS INGRESADOS EN LOS TEXTBOX DEL LOGIN
        try {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        //INSTANCIAR UN USAURAIO PARA CAPTURAR EL RESULTADO DE LA BASE DE DATOS
       
        Usuario usuario = new Usuario();
        
            //LLAMAR FUNCION DE CONSULTA A LA BASE DE DATOS 
            usuario = userDAO.obtenerUsuariosXLogin(username, password);
            //SI EXISTE UN USUARIO TE DIRECCIONA A LA PAGINA PRINCIPAL 
            if(usuario != null){
                response.sendRedirect("Principal.jsp");
                
                
            }
        } catch (NamingException ex) {
            
            System.out.println("Error al obtener el usuario" + ex.getMessage());
        }
    }
    
    
    
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
