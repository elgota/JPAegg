
package persistencia;

import libreria.entidades.Autor;


public class AutorDAO extends DAO<Autor> {
    
    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }
    
    public Autor buscarPorNombreAutor(String nombre){
        
        try {
        conectar();
        Autor autor = (Autor) em.createQuery(
                "SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
        
        desconectar();
        return autor;   
        } catch (Exception e) {
            System.out.println("No se han encontrado autores con es nombre...");
            return null;
        }
        
    }
    
    public Autor buscarAutorPorId (Integer id) {
        
        try {
            conectar();
            Autor autor = (Autor) em.createQuery(
                    "SELECT a FROM Autor a WHERE a.id LIKE :id")
                    .setParameter("id", id)
                    .getSingleResult();
            
            desconectar();
            return autor;
        } catch (Exception e) {
            System.out.println("No se han encontrado autores con es nombre...");
            return null;
        }
    }
    
    public void modificarAutor (Autor autor) {
        
        try {
            if (autor == null) {
                throw new Exception("No se ha podido modificar el autor.");
            }
            super.editar(autor);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: "+e.toString());
        }
        
    }
}
