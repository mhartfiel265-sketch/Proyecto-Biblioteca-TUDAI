package biblioteca;
/*

Entrada:
- Código, título, autor y año.

Proceso:
- Registrar los datos del libro.
- Controlar disponibilidad.
- Permitir prestar, devolver o dar de baja un libro.

Salida:
- Datos del libro.
- Estado del libro: Disponible, Prestado o Dado de baja.
*/

// La clase Libro representa un libro en la biblioteca, con atributos para almacenar su información y métodos para gestionar su estado.
public class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;
    private boolean activo;
// Constructor para inicializar los atributos del libro, estableciendo su estado inicial como disponible y activo.
    public Libro(int codigo, String titulo, String autor, int anio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = true;
        this.activo = true;
    }
// Métodos getter para acceder a los atributos del libro.
    public int getCodigo() {
        return codigo;
    }
// Método para obtener el título del libro.
    public String getTitulo() {
        return titulo;
    }
// Método para obtener el autor del libro.
    public String getAutor() {
        return autor;
    }
// Método para obtener el año de publicación del libro.
    public int getAnio() {
        return anio;
    }
// Métodos para verificar el estado del libro (disponible o activo).
    public boolean isDisponible() {
        return disponible;
    }
// Método para verificar si el libro está activo (no dado de baja).
    public boolean isActivo() {
        return activo;
    }
// Métodos setter para modificar los atributos del libro.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
// Método para establecer el autor del libro.
    public void setAutor(String autor) {
        this.autor = autor;
    }
// Método para establecer el año de publicación del libro.
    public void setAnio(int anio) {
        this.anio = anio;
    }
// Métodos para gestionar el estado del libro: prestar, devolver o dar de baja.
    public void prestar() {
        disponible = false;
    }
// Método para devolver el libro, cambiando su estado a disponible.
    public void devolver() {
        disponible = true;
    }
// Método para dar de baja el libro, marcándolo como inactivo.
    public void darDeBaja() {
        activo = false;
    }
// Método para obtener una representación en cadena del estado del libro, indicando si está disponible, prestado o dado de baja.
    public String getEstado() {
        if (!activo) {
            return "Dado de baja";
        }
        return disponible ? "Disponible" : "Prestado";
    }
// Método para mostrar los datos completos del libro, incluyendo su estado actual.
    public String mostrarLibro() {
        return "Código: " + codigo
                + " | Título: " + titulo
                + " | Autor: " + autor
                + " | Año: " + anio
                + " | Estado: " + getEstado();
    }
}