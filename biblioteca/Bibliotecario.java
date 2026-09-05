package biblioteca;
/*

Entrada:
- Nombre, apellido, DNI y usuario del sistema.

Proceso:
- Crear un bibliotecario como responsable de la gestión.

Salida:
- Datos del bibliotecario.
*/

// La clase Bibliotecario hereda de la clase Persona, lo que permite reutilizar los atributos y métodos comunes a todas las personas.
public class Bibliotecario extends Persona {
    private String usuarioSistema;
// Constructor para inicializar los atributos del bibliotecario, incluyendo los heredados de Persona.
    public Bibliotecario(String nombre, String apellido, String dni, String usuarioSistema) {
        super(nombre, apellido, dni);
        this.usuarioSistema = usuarioSistema;
    }
// Métodos getter y setter para acceder y modificar el atributo específico del bibliotecario.
    public String getUsuarioSistema() {
        return usuarioSistema;
    }
// Método para establecer el usuario del sistema para el bibliotecario.
    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }
// Implementación del método mostrarDatos() heredado de Persona para mostrar toda la información del bibliotecario.
    @Override
    public String mostrarDatos() {
        return "Bibliotecario: " + getNombre() + " " + getApellido()
                + " | DNI: " + getDni()
                + " | Usuario sistema: " + usuarioSistema;
    }
}