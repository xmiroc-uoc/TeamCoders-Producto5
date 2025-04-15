package modelo;

/**
 * Cliente Premium con descuento fijo en el envío y cuota anual.
 */
public class ClientePremium extends Cliente {

    private int cuotaAnual;

    /**
     * Constructor para cliente premium.
     * @param nombre Nombre del cliente.
     * @param domicilio Dirección del cliente.
     * @param nif Número de identificación fiscal.
     * @param email Correo electrónico del cliente.
     * @param cuotaAnual Cuota anual en euros.
     */
    public ClientePremium(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
        super(nombre, domicilio, nif, email);
        this.cuotaAnual = cuotaAnual;
    }

    /**
     * Obtiene la cuota anual del cliente premium.
     * @return cuota anual en euros.
     */
    public int getCuotaAnual() { return cuotaAnual; }

    /**
     * Establece la cuota anual del cliente premium.
     * @param cuotaAnual nueva cuota anual.
     */
    public void setCuotaAnual(int cuotaAnual) { this.cuotaAnual = cuotaAnual; }

    /**
     * Devuelve un descuento fijo del 20% en los gastos de envío.
     * @return 0.20 como descuento.
     */
    @Override
    public float descuentoEnvio() {
        return 0.20f;
    }

    /**
     * Devuelve una representación textual del cliente premium.
     * @return String con los datos del cliente premium.
     */
    @Override
    public String toString() {
        return "ClientePremium: " + super.toString() + " [cuotaAnual=" + cuotaAnual + "]";
    }
}

