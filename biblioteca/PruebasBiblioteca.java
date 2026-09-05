package biblioteca;
/*
Entrada:
- Datos fijos cargados directamente en el código.

Proceso:
- Probar alta de libros.
- Probar alta de usuarios.
- Probar préstamo.
- Probar devolución.
- Probar búsqueda binaria.

Salida:
- Resultado de cada prueba: Correcta o Incorrecta.
*/

// La clase PruebasBiblioteca contiene el método main para realizar pruebas unitarias simples de las funcionalidades de la biblioteca, utilizando datos fijos cargados directamente en el código para facilitar las pruebas y demostraciones.
public class PruebasBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
// Se cargan datos fijos en la biblioteca para realizar las pruebas.
        Libro libro1 = new Libro(1, "El Principito", "Antoine de Saint-Exupéry", 1943);
        Usuario usuario1 = new Usuario("Ana", "Gómez", "11111111", "U001", "Estudiante");
// Se muestra un encabezado para las pruebas unitarias simples.
        System.out.println("---- PRUEBAS UNITARIAS SIMPLES ----");
// Se realizan las pruebas de alta de libro, alta de usuario, préstamo, devolución y búsqueda binaria, mostrando el resultado de cada prueba como Correcta o Incorrecta según corresponda.
        boolean prueba1 = biblioteca.agregarLibro(libro1);
        System.out.println("Prueba alta libro: " + (prueba1 ? "Correcta" : "Incorrecta"));
// Se prueba el alta de usuario, verificando si el usuario se agregó correctamente a la biblioteca.
        boolean prueba2 = biblioteca.agregarUsuario(usuario1);
        System.out.println("Prueba alta usuario: " + (prueba2 ? "Correcta" : "Incorrecta"));
// Se prueba el registro de un préstamo, verificando si el préstamo se registró correctamente en la biblioteca y si el estado del libro cambió a prestado.
        boolean prueba3 = biblioteca.registrarPrestamo(1, "11111111", "13/06/2026", "20/06/2026");
        System.out.println("Prueba préstamo: " + (prueba3 ? "Correcta" : "Incorrecta"));
// Se prueba el estado del libro después de realizar el préstamo, verificando si el libro se marcó como no disponible.
        boolean prueba4 = !libro1.isDisponible();
        System.out.println("Prueba estado libro prestado: " + (prueba4 ? "Correcta" : "Incorrecta"));
// Se prueba el registro de una devolución, verificando si la devolución se registró correctamente en la biblioteca y si el estado del libro cambió a disponible.
        boolean prueba5 = biblioteca.registrarDevolucion(1);
        System.out.println("Prueba devolución: " + (prueba5 ? "Correcta" : "Incorrecta"));
// Se prueba el estado del libro después de realizar la devolución, verificando si el libro se marcó como disponible nuevamente.
        boolean prueba6 = libro1.isDisponible();
        System.out.println("Prueba estado libro devuelto: " + (prueba6 ? "Correcta" : "Incorrecta"));
// Se prueba la búsqueda binaria por título, verificando si se encuentra el libro buscado en la biblioteca.
        Libro buscado = biblioteca.busquedaBinariaPorTitulo("El Principito");
        System.out.println("Prueba búsqueda binaria: " + (buscado != null ? "Correcta" : "Incorrecta"));
    }
}