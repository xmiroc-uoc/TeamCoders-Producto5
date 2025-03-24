package TeamCoders.modelo;

public class ClientePremium extends Cliente {

    private int cuotaAnual;
    private static final float DESCUENTO_ENVIO = 0.2f;

    public ClientePremium(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
        super(nombre, domicilio, nif, email);
        this.cuotaAnual = cuotaAnual;
    }

    public int getCuotaAnual() {
        return cuotaAnual;
    }
    
    public void setCuotaAnual(int cuotaAnual) {
        this.cuotaAnual = cuotaAnual;
    }

    @Override
    public float descuentoEnvio() {
        return DESCUENTO_ENVIO;
    }

}