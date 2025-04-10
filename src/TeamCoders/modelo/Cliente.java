
package TeamCoders.modelo;

public class Cliente {
    private String nombre;
    private String dni;
    private String tipo; // Estandar o Premium

    public Cliente(String nombre, String dni, String tipo) {
        this.nombre = nombre;
        this.dni = dni;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
