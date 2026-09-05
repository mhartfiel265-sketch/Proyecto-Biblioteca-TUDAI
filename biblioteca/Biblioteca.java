package biblioteca;
/*

.

Entrada:
- Objetos Libro, Usuario y Prestamo.
- Criterios de búsqueda: código, título o DNI.

Proceso:
- Gestionar arrays de libros, usuarios y préstamos.
- Realizar altas, bajas y modificaciones.
- Buscar libros y usuarios.
- Ordenar libros por título.
- Aplicar búsqueda binaria.
- Registrar préstamos y devoluciones.
- Calcular porcentaje de libros prestados.

Salida:
- Listados generales.
- Resultado de búsquedas.
- Informe personalizado.
- Cantidad de libros, usuarios y préstamos.
- Porcentaje de libros prestados.
*/

// La clase Biblioteca es la clase principal que gestiona los libros, usuarios y préstamos de la biblioteca, proporcionando métodos para realizar diversas operaciones sobre estos objetos.
public class Biblioteca {
    private Libro[] libros;
    private Usuario[] usuarios;
    private Prestamo[] prestamos;
// Atributos para llevar un conteo de la cantidad de libros, usuarios y préstamos registrados en la biblioteca.
    private int cantidadLibros;
    private int cantidadUsuarios;
    private int cantidadPrestamos;
// Constructor para inicializar los arrays y los contadores de la biblioteca.
    public Biblioteca() {
        libros = new Libro[100];
        usuarios = new Usuario[100];
        prestamos = new Prestamo[100];
// Inicialización de los contadores a cero.
        cantidadLibros = 0;
        cantidadUsuarios = 0;
        cantidadPrestamos = 0;
    }
// Métodos para agregar libros, usuarios y préstamos a la biblioteca, verificando que no se exceda la capacidad de los arrays.
    public boolean agregarLibro(Libro libro) {
        if (cantidadLibros < libros.length) {
            libros[cantidadLibros] = libro;
            cantidadLibros++;
            return true;
        }
        return false;
    }
// Método para agregar un usuario a la biblioteca, verificando que no se exceda la capacidad del array de usuarios.
    public boolean agregarUsuario(Usuario usuario) {
        if (cantidadUsuarios < usuarios.length) {
            usuarios[cantidadUsuarios] = usuario;
            cantidadUsuarios++;
            return true;
        }
        return false;
    }
// Método para contar la cantidad de libros registrados en la biblioteca.   
    public int contarLibros() {
        return cantidadLibros;
    }
// Método para contar la cantidad de usuarios registrados en la biblioteca.
    public int contarUsuarios() {
        return cantidadUsuarios;
    }
// Método para contar la cantidad de préstamos registrados en la biblioteca.
    public int contarPrestamos() {
        return cantidadPrestamos;
    }
// Métodos para listar los libros, usuarios y préstamos registrados en la biblioteca, mostrando su información completa.
    public void listarLibros() {
        if (cantidadLibros == 0) {
            System.out.println("No hay libros cargados.");
            return;
        }
// Iteración sobre el array de libros para mostrar la información de cada libro registrado.
        for (int i = 0; i < cantidadLibros; i++) {
            System.out.println(libros[i].mostrarLibro());
        }
    }
// Método para listar los usuarios registrados en la biblioteca, mostrando su información completa.
    public void listarUsuarios() {
        if (cantidadUsuarios == 0) {
            System.out.println("No hay usuarios cargados.");
            return;
        }
// Iteración sobre el array de usuarios para mostrar la información de cada usuario registrado.
        for (int i = 0; i < cantidadUsuarios; i++) {
            System.out.println(usuarios[i].mostrarDatos());
        }
    }
// Método para listar los préstamos registrados en la biblioteca, mostrando su información completa.
    public Libro buscarLibroPorCodigo(int codigo) {
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getCodigo() == codigo) {
                return libros[i];
            }
        }
        return null;
    }
// Método para buscar un usuario por su DNI, iterando sobre el array de usuarios y comparando el DNI con el proporcionado como parámetro.
    public Usuario buscarUsuarioPorDni(String dni) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i].getDni().equals(dni)) {
                return usuarios[i];
            }
        }
        return null;
    }
// Método para buscar libros por su título, iterando sobre el array de libros y comparando el título con el proporcionado como parámetro, mostrando los resultados encontrados.
    public void buscarLibroPorTitulo(String titulo) {
        boolean encontrado = false;
// Iteración sobre el array de libros para comparar el título de cada libro con el título proporcionado, mostrando la información de los libros que coincidan.
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(libros[i].mostrarLibro());
                encontrado = true;
            }
        }
// Si no se encuentra ningún libro con el título proporcionado, se muestra un mensaje indicando que no se encontraron resultados.
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }
// Método para modificar la información de un libro, buscando el libro por su código y actualizando sus atributos si se encuentra.
    public boolean modificarLibro(int codigo, String nuevoTitulo, String nuevoAutor, int nuevoAnio) {
        Libro libro = buscarLibroPorCodigo(codigo);
// Si se encuentra el libro, se actualizan sus atributos con los nuevos valores proporcionados y se devuelve true. Si no se encuentra el libro, se devuelve false.
        if (libro != null) {
            libro.setTitulo(nuevoTitulo);
            libro.setAutor(nuevoAutor);
            libro.setAnio(nuevoAnio);
            return true;
        }
// Si no se encuentra el libro, se devuelve false.
        return false;
    }
// Método para dar de baja un libro, buscando el libro por su código y cambiando su estado a inactivo si se encuentra.
    public boolean darDeBajaLibro(int codigo) {
        Libro libro = buscarLibroPorCodigo(codigo);
// Si se encuentra el libro, se cambia su estado a inactivo y se devuelve true. Si no se encuentra el libro, se devuelve false.
        if (libro != null) {
            libro.darDeBaja();
            return true;
        }
// Si no se encuentra el libro, se devuelve false.
        return false;
    }
// Método para registrar un préstamo, buscando el libro por su código y el usuario por su DNI, verificando que el libro esté disponible y activo, y creando un nuevo préstamo si se cumplen las condiciones.
    public boolean registrarPrestamo(int codigoLibro, String dniUsuario, String fechaPrestamo, String fechaDevolucion) {
        Libro libro = buscarLibroPorCodigo(codigoLibro);
        Usuario usuario = buscarUsuarioPorDni(dniUsuario);
// Si se encuentra el libro y el usuario, y el libro está disponible y activo, se crea un nuevo préstamo y se devuelve true. Si no se cumplen las condiciones, se devuelve false.
        if (libro != null && usuario != null && libro.isDisponible() && libro.isActivo()) {
            if (cantidadPrestamos < prestamos.length) {
                int codigoPrestamo = cantidadPrestamos + 1;
                prestamos[cantidadPrestamos] = new Prestamo(codigoPrestamo, libro, usuario, fechaPrestamo, fechaDevolucion);
                cantidadPrestamos++;
                return true;
            }
        }
// Si no se cumplen las condiciones para registrar el préstamo, se devuelve false.
        return false;
    }
// Método para registrar la devolución de un libro, buscando el préstamo por su código y cambiando su estado a devuelto si se encuentra y no ha sido devuelto previamente.
    public boolean registrarDevolucion(int codigoPrestamo) {
        for (int i = 0; i < cantidadPrestamos; i++) {
            if (prestamos[i].getCodigoPrestamo() == codigoPrestamo && !prestamos[i].isDevuelto()) {
                prestamos[i].devolverLibro();
                return true;
            }
        }
// Si no se encuentra el préstamo o ya ha sido devuelto, se devuelve false.
        return false;
    }
// Método para listar los préstamos registrados en la biblioteca, mostrando su información completa, incluyendo el estado actual de cada préstamo.
    public void listarPrestamos() {
        if (cantidadPrestamos == 0) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
// Iteración sobre el array de préstamos para mostrar la información de cada préstamo registrado, incluyendo su estado (Pendiente o Devuelto).
        for (int i = 0; i < cantidadPrestamos; i++) {
            System.out.println(prestamos[i].mostrarPrestamo());
        }
    }
// Método para ordenar los libros por título utilizando el algoritmo de ordenamiento burbuja, comparando los títulos de los libros y reordenándolos en el array.
    public void ordenarLibrosPorTitulo() {
        for (int i = 0; i < cantidadLibros - 1; i++) {
            for (int j = 0; j < cantidadLibros - 1 - i; j++) {
                if (libros[j].getTitulo().compareToIgnoreCase(libros[j + 1].getTitulo()) > 0) {
                    Libro aux = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = aux;
                }
            }
        }
    }
// Método para realizar una búsqueda binaria de un libro por su título, asumiendo que el array de libros está ordenado por título, y devolviendo el libro encontrado o null si no se encuentra.
    public Libro busquedaBinariaPorTitulo(String titulo) {
        ordenarLibrosPorTitulo();

        int inicio = 0;
        int fin = cantidadLibros - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = libros[medio].getTitulo().compareToIgnoreCase(titulo);
// Si la comparación es igual a cero, se ha encontrado el libro y se devuelve. Si la comparación es menor que cero, se busca en la mitad superior del array. Si la comparación es mayor que cero, se busca en la mitad inferior del array.
            if (comparacion == 0) {
                return libros[medio];
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
// Si no se encuentra el libro, se devuelve null.
        return null;
    }
// Método para generar un informe personalizado que muestre los libros disponibles ordenados por título, verificando el estado de cada libro y mostrando solo aquellos que estén disponibles y activos.
    public void informeLibrosDisponiblesOrdenados() {
        ordenarLibrosPorTitulo();
// Se muestra un encabezado para el informe personalizado.
        System.out.println("\n--- INFORME PERSONALIZADO: LIBROS DISPONIBLES ORDENADOS POR TÍTULO ---");
// Iteración sobre el array de libros para mostrar solo aquellos que estén disponibles y activos, utilizando un flag para verificar si se encontraron libros disponibles.
        boolean hayDisponibles = false;
// Si no se encuentra ningún libro disponible, se muestra un mensaje indicando que no hay libros disponibles.
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].isDisponible() && libros[i].isActivo()) {
                System.out.println(libros[i].mostrarLibro());
                hayDisponibles = true;
            }
        }
// Si no se encontraron libros disponibles, se muestra un mensaje indicando que no hay libros disponibles.
        if (!hayDisponibles) {
            System.out.println("No hay libros disponibles.");
        }
    }
// Método para calcular el porcentaje de libros prestados, contando la cantidad de libros prestados y dividiéndola por la cantidad total de libros registrados en la biblioteca, devolviendo el resultado como un porcentaje.
    public double porcentajeLibrosPrestados() {
        if (cantidadLibros == 0) {
            return 0;
        }
// Se cuenta la cantidad de libros prestados iterando sobre el array de libros y verificando su estado de disponibilidad.
        int prestados = 0;

        for (int i = 0; i < cantidadLibros; i++) {
            if (!libros[i].isDisponible()) {
                prestados++;
            }
        }
// Se calcula el porcentaje de libros prestados dividiendo la cantidad de libros prestados por la cantidad total de libros y multiplicando por 100 para obtener el resultado en porcentaje.
        return (prestados * 100.0) / cantidadLibros;
    }
// Método para cargar datos fijos en la biblioteca, agregando algunos libros, usuarios y un préstamo de ejemplo para facilitar las pruebas y demostraciones de las funcionalidades de la biblioteca.
    public void cargarDatosFijos() {
        agregarLibro(new Libro(1, "El Principito", "Antoine de Saint-Exupéry", 1943));
        agregarLibro(new Libro(2, "Cien años de soledad", "Gabriel García Márquez", 1967));
        agregarLibro(new Libro(3, "Rayuela", "Julio Cortázar", 1963));
        agregarLibro(new Libro(4, "Martín Fierro", "José Hernández", 1872));
// Se agregan algunos usuarios de ejemplo a la biblioteca.
        agregarUsuario(new Usuario("Ana", "Gómez", "11111111", "U001", "Estudiante"));
        agregarUsuario(new Usuario("Carlos", "Pérez", "22222222", "U002", "Docente"));
// Se registra un préstamo de ejemplo, relacionando un libro con un usuario y estableciendo las fechas de préstamo y devolución.
        registrarPrestamo(1, "11111111", "13/06/2026", "20/06/2026");
    }
}