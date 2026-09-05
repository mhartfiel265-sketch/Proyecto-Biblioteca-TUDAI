package biblioteca;
/*
Entrada:
- Código de préstamo.
- Libro.
- Usuario.
- Fecha de préstamo.
- Fecha de devolución.

Proceso:
- Relacionar un libro con un usuario.
- Cambiar el estado del libro a Prestado.
- Registrar devolución.

Salida:
- Datos del préstamo.
- Estado: Pendiente o Devuelto.
*/
// La clase Prestamo representa un préstamo de un libro a un usuario, con atributos para almacenar la información del préstamo y métodos para gestionar su estado.
public class Prestamo {
    private int codigoPrestamo;
    private Libro libro;
    private Usuario usuario;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean devuelto;
// Constructor para inicializar los atributos del préstamo, estableciendo su estado inicial como pendiente (no devuelto) y cambiando el estado del libro a prestado.
    public Prestamo(int codigoPrestamo, Libro libro, Usuario usuario, String fechaPrestamo, String fechaDevolucion) {
        this.codigoPrestamo = codigoPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
        this.libro.prestar();
    }
// Métodos getter para acceder a los atributos del préstamo.
    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }
// Método para verificar si el préstamo ha sido devuelto o no.
    public boolean isDevuelto() {
        return devuelto;
    }
// Método para obtener el libro asociado al préstamo.
    public Libro getLibro() {
        return libro;
    }
// Método para obtener el usuario asociado al préstamo.
    public Usuario getUsuario() {
        return usuario;
    }
// Método para obtener la fecha de préstamo.    
    public void devolverLibro() {
        this.devuelto = true;
        this.libro.devolver();
    }
// Método para obtener la fecha de devolución.
    public String getEstado() {
        return devuelto ? "Devuelto" : "Pendiente";
    }
// Método para mostrar los datos completos del préstamo, incluyendo el estado actual del mismo.
    public String mostrarPrestamo() {
        return "Préstamo Nº: " + codigoPrestamo
                + " | Libro: " + libro.getTitulo()
                + " | Usuario: " + usuario.getNombre() + " " + usuario.getApellido()
                + " | Desde: " + fechaPrestamo
                + " | Hasta: " + fechaDevolucion
                + " | Estado: " + getEstado();
    }
}