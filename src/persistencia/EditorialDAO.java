
package persistencia;

import libreria.entidades.Editorial;


public class EditorialDAO extends DAO<Editorial> {
    
    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }
    
    public Editorial buscarPorNombreEditorial (String nombre) {
        conectar();
        
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
        .setParameter("nombre", nombre).getSingleResult();
         
        desconectar(); 
        return editorial;
       
        
        
    }

}
