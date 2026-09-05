package biblioteca;
/*
Entrada:
- Opciones seleccionadas por el usuario desde el menú.
- Datos ingresados por teclado.

Proceso:
- Mostrar menú principal.
- Capturar opciones.
- Llamar a los métodos de la clase Biblioteca.
- Controlar errores mediante try-catch.

Salida:
- Mensajes por pantalla.
- Confirmación de operaciones.
- Listados e informes.
*/ 
import java.util.InputMismatchException;
import java.util.Scanner;
// Clase principal que contiene el método main para ejecutar el programa.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
// Cargar datos fijos para pruebas.
        biblioteca.cargarDatosFijos();

        int opcion = 0;
// Bucle principal del programa que muestra el menú y captura las opciones del usuario.
        do {
            try {
                System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
                System.out.println("1. Alta de libro");
                System.out.println("2. Listar libros");
                System.out.println("3. Alta de usuario");
                System.out.println("4. Listar usuarios");
                System.out.println("5. Modificar libro");
                System.out.println("6. Baja de libro");
                System.out.println("7. Buscar libro por título");
                System.out.println("8. Registrar préstamo");
                System.out.println("9. Registrar devolución");
                System.out.println("10. Listar préstamos");
                System.out.println("11. Ordenar libros por título");
                System.out.println("12. Búsqueda binaria por título");
                System.out.println("13. Informe personalizado");
                System.out.println("14. Porcentaje de libros prestados");
                System.out.println("15. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = sc.nextInt();
                sc.nextLine();
// Estructura switch para manejar las diferentes opciones del menú.
                switch (opcion) {
                    case 1:
                        System.out.print("Código: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Autor: ");
                        String autor = sc.nextLine();

                        System.out.print("Año: ");
                        int anio = sc.nextInt();
                        sc.nextLine();

                        Libro libro = new Libro(codigo, titulo, autor, anio);

                        if (biblioteca.agregarLibro(libro)) {
                            System.out.println("Libro cargado correctamente.");
                        } else {
                            System.out.println("No hay espacio para cargar más libros.");
                        }
                        break;
// Opción para listar los libros disponibles en la biblioteca.
                    case 2:
                        biblioteca.listarLibros();
                        break;
// Opción para dar de alta un nuevo usuario en la biblioteca.
                    case 3:
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();

                        System.out.print("DNI: ");
                        String dni = sc.nextLine();

                        System.out.print("Legajo: ");
                        String legajo = sc.nextLine();

                        System.out.print("Tipo de usuario: ");
                        String tipo = sc.nextLine();

                        Usuario usuario = new Usuario(nombre, apellido, dni, legajo, tipo);

                        if (biblioteca.agregarUsuario(usuario)) {
                            System.out.println("Usuario cargado correctamente.");
                        } else {
                            System.out.println("No hay espacio para cargar más usuarios.");
                        }
                        break;
// Opción para listar los usuarios registrados en la biblioteca.
                    case 4:
                        biblioteca.listarUsuarios();
                        break;
// Opción para modificar los datos de un libro existente en la biblioteca.
                    case 5:
                        System.out.print("Código del libro a modificar: ");
                        int codModificar = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nuevo título: ");
                        String nuevoTitulo = sc.nextLine();

                        System.out.print("Nuevo autor: ");
                        String nuevoAutor = sc.nextLine();

                        System.out.print("Nuevo año: ");
                        int nuevoAnio = sc.nextInt();
                        sc.nextLine();

                        if (biblioteca.modificarLibro(codModificar, nuevoTitulo, nuevoAutor, nuevoAnio)) {
                            System.out.println("Libro modificado correctamente.");
                        } else {
                            System.out.println("No se encontró el libro.");
                        }
                        break;
// Opción para dar de baja un libro de la biblioteca.
                    case 6:
                        System.out.print("Código del libro a dar de baja: ");
                        int codBaja = sc.nextInt();
                        sc.nextLine();

                        if (biblioteca.darDeBajaLibro(codBaja)) {
                            System.out.println("Libro dado de baja correctamente.");
                        } else {
                            System.out.println("No se encontró el libro.");
                        }
                        break;
// Opción para buscar un libro por su título en la biblioteca.
                    case 7:
                        System.out.print("Ingrese el título a buscar: ");
                        String tituloBuscar = sc.nextLine();
                        biblioteca.buscarLibroPorTitulo(tituloBuscar);
                        break;
// Opción para registrar un préstamo de un libro a un usuario.
                    case 8:
                        System.out.print("Código del libro: ");
                        int codLibroPrestamo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("DNI del usuario: ");
                        String dniPrestamo = sc.nextLine();

                        System.out.print("Fecha de préstamo: ");
                        String fechaPrestamo = sc.nextLine();

                        System.out.print("Fecha de devolución: ");
                        String fechaDevolucion = sc.nextLine();

                        if (biblioteca.registrarPrestamo(codLibroPrestamo, dniPrestamo, fechaPrestamo, fechaDevolucion)) {
                            System.out.println("Préstamo registrado correctamente.");
                        } else {
                            System.out.println("No se pudo registrar el préstamo.");
                        }
                        break;
// Opción para registrar la devolución de un libro prestado.
                    case 9:
                        System.out.print("Código del préstamo: ");
                        int codPrestamo = sc.nextInt();
                        sc.nextLine();

                        if (biblioteca.registrarDevolucion(codPrestamo)) {
                            System.out.println("Devolución registrada correctamente.");
                        } else {
                            System.out.println("No se encontró el préstamo o ya fue devuelto.");
                        }
                        break;
// Opción para listar todos los préstamos registrados en la biblioteca.
                    case 10:
                        biblioteca.listarPrestamos();
                        break;
// Opción para ordenar los libros por título y mostrar el listado ordenado.
                    case 11:
                        biblioteca.ordenarLibrosPorTitulo();
                        System.out.println("Libros ordenados por título.");
                        biblioteca.listarLibros();
                        break;
// Opción para realizar una búsqueda binaria por título de libro en la biblioteca.
                    case 12:
                        System.out.print("Título para búsqueda binaria: ");
                        String tituloBinario = sc.nextLine();

                        Libro encontrado = biblioteca.busquedaBinariaPorTitulo(tituloBinario);

                        if (encontrado != null) {
                            System.out.println("Libro encontrado:");
                            System.out.println(encontrado.mostrarLibro());
                        } else {
                            System.out.println("No se encontró el libro.");
                        }
                        break;
// Opción para mostrar un informe personalizado de los libros disponibles ordenados por título.
                    case 13:
                        biblioteca.informeLibrosDisponiblesOrdenados();
                        break;
// Opción para calcular y mostrar el porcentaje de libros prestados en la biblioteca.
                    case 14:
                        System.out.println("Porcentaje de libros prestados: "
                                + biblioteca.porcentajeLibrosPrestados() + "%");
                        break;
// Opción para salir del sistema.
                    case 15:
                        System.out.println("Saliendo del sistema...");
                        break;
// Opción por defecto para manejar entradas no válidas.
                    default:
                        System.out.println("Opción incorrecta.");
                }
// Manejo de excepciones para controlar errores de entrada y otros errores inesperados.
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
// El bucle se repetirá hasta que el usuario seleccione la opción de salir (15).
        } while (opcion != 15);
// Cerrar el scanner al finalizar el programa para liberar recursos.
        sc.close();
    }
}