
package persistencia;

import libreria.entidades.Libro;


public class LibroDAO extends DAO<Libro> {
    
    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }
    
    
    public Libro buscarPorTituloDelLibro(String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l from Libro l WHERE l.titulo LIKE :titulo")
        .setParameter("titulo", titulo).getSingleResult();
        
        desconectar();
        return libro;
    }
    
    public Libro buscarPorIsbn(Long isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
        .setParameter("isbn", isbn).getSingleResult();
        
        desconectar();
        return libro;
    }

}
