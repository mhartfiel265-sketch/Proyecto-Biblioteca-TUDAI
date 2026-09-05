package biblioteca;
/*
Entrada:
- Nombre, apellido y DNI.

Proceso:
- Almacenar datos comunes de una persona.
- Permitir que otras clases hereden esos datos.

Salida:
- Datos personales mediante el método mostrarDatos().
*/

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String dni;
// Constructor para inicializar los atributos de la persona.
    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
// Métodos getter y setter para acceder y modificar los atributos de la persona.
    public String getNombre() {
        return nombre;
    }
// Método para obtener el apellido de la persona.
    public String getApellido() {
        return apellido;
    }
// Método para obtener el DNI de la persona.
    public String getDni() {
        return dni;
    }
// Métodos setter para modificar los atributos de la persona.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
// Método para establecer el apellido de la persona.
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
// Método para establecer el DNI de la persona.
    public void setDni(String dni) {
        this.dni = dni;
    }
// Método abstracto que debe ser implementado por las clases que hereden de Persona para mostrar los datos personales.
    public abstract String mostrarDatos();
}