
package TeamCoders.modelo;

public class Pedido {
    private String codigo;
    private String dniCliente;
    private String codigoArticulo;
    private int cantidad;

    public Pedido(String codigo, String dniCliente, String codigoArticulo, int cantidad) {
        this.codigo = codigo;
        this.dniCliente = dniCliente;
        this.codigoArticulo = codigoArticulo;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", dniCliente='" + dniCliente + '\'' +
                ", codigoArticulo='" + codigoArticulo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
