
package servicios;

import libreria.entidades.Autor;
import persistencia.AutorDAO;


public class AutorServicio {

    private final AutorDAO DAO;
    
    public AutorServicio() {
        this.DAO = new AutorDAO();
    }
    
    public Autor crearAutor(Integer id, String nombre, Boolean alta) {
        
        Autor autor = new Autor();
        
        try {
            
            autor.setId(id);
            autor.setNombre(nombre);
            autor.setAlta(alta);
            
            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
            
        }
        
    }
    
    public Autor buscarPorNombreAutor(String nombre){
        
        try {
            Autor autor = DAO.buscarPorNombreAutor(nombre);
            System.out.println("Se encontró el autor: "+autor.getNombre());
            
            return autor;
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: "+e.toString());
            System.out.println("No se devolvió ninguna entrada para esta editorial. ");
            return null;
        }
        
    }
    
    public Autor darAltaAutor(Integer id) {
        try {
            
            Autor autor = DAO.buscarAutorPorId(id);
            System.out.println("El Autor es: "+autor.getNombre());
            
                if (autor.getAlta() == true) {
                    System.out.println("El autor ya está dado de alta...");
                
                }else {
                    autor.setAlta(Boolean.TRUE);
                    DAO.modificarAutor(autor);
                    System.out.println("Se ha dado de ALTA el autor "+autor.getNombre());
            }
            
            return autor;
        } catch (Exception e) {
            System.out.println("No se ha logrado dar de alta el autor...");
            e.printStackTrace();
            return null;
        }
    }
    
        public Autor darBajaAutor(Integer id) {
        try {
            
            Autor autor = DAO.buscarAutorPorId(id);
            System.out.println("El Autor es: "+autor.getNombre());
            
                if (autor.getAlta() == false) {
                    System.out.println("El autor ya está dado de baja...");
                
                }else {
                    autor.setAlta(Boolean.FALSE);
                    DAO.modificarAutor(autor);
                    System.out.println("Se ha dado de BAJA el autor "+autor.getNombre());
            }
            
            return autor;
        } catch (Exception e) {
            System.out.println("No se ha logrado dar de alta el autor...");
            e.printStackTrace();
            return null;
        }
    }
}
