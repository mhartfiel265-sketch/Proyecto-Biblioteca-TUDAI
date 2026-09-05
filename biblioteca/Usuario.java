package biblioteca;
/*


Entrada:
- Nombre, apellido, DNI, legajo y tipo de usuario.

Proceso:
- Crear un usuario de biblioteca.
- Guardar su estado: Activo o Suspendido.
- Permitir activar o suspender al usuario.

Salida:
- Datos completos del usuario.
- Estado del usuario.
*/

// La clase Usuario hereda de la clase Persona, lo que permite reutilizar los atributos y métodos comunes a todas las personas.
public class Usuario extends Persona {
    private String legajo;
    private String tipoUsuario;
    private String estado;
// Constructor para inicializar los atributos del usuario, incluyendo los heredados de Persona.
    public Usuario(String nombre, String apellido, String dni, String legajo, String tipoUsuario) {
        super(nombre, apellido, dni);
        this.legajo = legajo;
        this.tipoUsuario = tipoUsuario;
        this.estado = "Activo";
    }
// Métodos getter y setter para acceder y modificar los atributos específicos del usuario.
    public String getLegajo() {
        return legajo;
    }
// Método para obtener el tipo de usuario (por ejemplo, Estudiante, Profesor, etc.).
    public String getTipoUsuario() {
        return tipoUsuario;
    }
// Método para obtener el estado actual del usuario (Activo o Suspendido).
    public String getEstado() {
        return estado;
    }
// Métodos setter para modificar los atributos del usuario.
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
// Método para establecer el tipo de usuario.
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
// Método para establecer el estado del usuario (Activo o Suspendido).
    public void suspender() {
        this.estado = "Suspendido";
    }
// Método para activar al usuario, cambiando su estado a Activo.
    public void activar() {
        this.estado = "Activo";
    }
// Implementación del método mostrarDatos() heredado de Persona para mostrar toda la información del usuario.
    @Override
    public String mostrarDatos() {
        return "Usuario: " + getNombre() + " " + getApellido()
                + " | DNI: " + getDni()
                + " | Legajo: " + legajo
                + " | Tipo: " + tipoUsuario
                + " | Estado: " + estado;
    }
}