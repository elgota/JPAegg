
package servicios;

import libreria.entidades.Editorial;
import persistencia.EditorialDAO;


public class EditorialServicio {
    
    private final EditorialDAO DAO;
    
    public EditorialServicio() {
        this.DAO = new EditorialDAO();
    }
    
    public Editorial crearEditorial(Integer id, String nombre, Boolean alta){
        
        Editorial editorial = new Editorial();
        
        try {
            
            editorial.setId(id);
            editorial.setNombre(nombre);
            editorial.setAlta(alta);
            
            DAO.guardar(editorial);
            return editorial;
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Editorial buscarPorNombreEditorial(String nombre) {
        
        try {
            
            Editorial editorial = DAO.buscarPorNombreEditorial(nombre);
            System.out.println("Se encontró Editorial: "+editorial.getNombre());
            
            return editorial;
            
        } catch (Exception e) {
            throw e;
        }
        
    }

}
