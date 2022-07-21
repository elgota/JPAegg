
package servicios;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import persistencia.LibroDAO;


public class LibroServicio {

    private final LibroDAO DAO;

    public LibroServicio() {
        this.DAO = new LibroDAO();
    }
    
    public Libro crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial ){
        
        Libro libro = new Libro();
        
        try {
            
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(Boolean.TRUE);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            DAO.guardar(libro);
            return libro;
            
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error...");
            System.out.println(e.toString());
            return null;
        }
        
        
    }
    
    public Libro buscarPorTitulo (String titulo) {
        
        try {
            
            Libro libro = DAO.buscarPorTituloDelLibro(titulo);
            System.out.println("El autor del libro es "+libro.getAutor().getNombre()+", de la Editorial "+libro.getEditorial().getNombre()+", ISBN "+libro.getIsbn());
            return libro;
            
        } catch (Exception e) {
            System.out.println("El título ingresado no es válido...");
            return null;
        }
        
    }
    
    public Libro buscarPorIsbn (Long isbn) {
        
        try {
            
            Libro libro = DAO.buscarPorIsbn(isbn);
            System.out.println("El título del libro es "+libro.getTitulo()+", de "+libro.getAutor().getNombre());
            return libro;
        } catch (Exception e) {
            System.out.println("El ISBN ingresado no es válido...");
            return null;
        }
        
    }
    
}
