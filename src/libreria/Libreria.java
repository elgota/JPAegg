
package libreria;

import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import servicios.AutorServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;

public class Libreria {

    public static void main(String[] args) {
        
        Scanner lee = new Scanner(System.in).useDelimiter("\n");
      
        AutorServicio autorServicio = new AutorServicio();
        LibroServicio libroServicio = new LibroServicio();
        EditorialServicio editorialServicio = new EditorialServicio();
        
        //Carga de autores
        
        try {
            Autor a1 = autorServicio.crearAutor(1, "Ernesto Sábato", false);
            Autor a2 = autorServicio.crearAutor(2, "Julio Cortázar", true);
            Autor a3 = autorServicio.crearAutor(3, "Borges Jose Luis", true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
        //Carga de editoriales
        
        try {
            Editorial e1 = editorialServicio.crearEditorial(1, "Planeta", true);
            Editorial e2 = editorialServicio.crearEditorial(2, "Sudamericana", true);
            Editorial e3 = editorialServicio.crearEditorial(3, "Siglo", true);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
            
        //Carga de libros
        
        try {
            Libro l1 = libroServicio.crearLibro(9789878317090L, "Sobre héroes y tumbas", 2019, 20, null, null, true, autorServicio.buscarPorNombreAutor("Ernesto Sábato"), editorialServicio.buscarPorNombreEditorial("Planeta"));
            Libro l2 = libroServicio.crearLibro(9789877382570L, "Rayuela", 2016, 20, null, null, true, autorServicio.buscarPorNombreAutor("Julio Cortázar"), editorialServicio.buscarPorNombreEditorial("Planeta"));
            Libro l3 = libroServicio.crearLibro(9789500755764L, "El Aleph", 2016, 20, null, null, true, autorServicio.buscarPorNombreAutor("Borges Jose Luis"), editorialServicio.buscarPorNombreEditorial("Siglo"));
            
         
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
        // Busqueda de libro por título
        
//        System.out.println("Ingresa el título del libro a buscar... ");
//        libroServicio.buscarPorTitulo(lee.next());
        
        // Busqueda de libro por ISBN
        
        System.out.println("Ingresa el isbn del libro a buscar... ");
        libroServicio.buscarPorIsbn(lee.nextLong());
        
        // Dar Alta de un autor
        
//        System.out.println("Ingresá el Id del Autor para darlo de ALTA: ");
//        autorServicio.darAltaAutor(lee.nextInt());
        
        // Dar Baja a un autor
       
//        System.out.println("Ingresá el Id del Autor para darlo de BAJA: ");
//        autorServicio.darBajaAutor(lee.nextInt());
    }
    
        
        
        
}
