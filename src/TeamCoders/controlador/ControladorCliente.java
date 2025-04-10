package controlador;

import vista.ClienteFunc;

import java.util.ArrayList;

import modelo.*;

public class ControladorCliente {


    private ClienteFunc menuCliente = new ClienteFunc();

    public void agregarCliente() throws Exception{
        String nombre = "";
        String domicilio = "";
        String nif = "";
        String email = "";
        String opcion = "";
        boolean opcionPosible = false;

        while(!opcionPosible){
            opcion = menuCliente.tipoCliente();
            if(!opcion.equals("")){
                opcionPosible = true;
            }
        }

        nombre = menuCliente.introducirNombre();
        domicilio = menuCliente.introducirDomicilio();
        nif = menuCliente.introducirNIF();
        email = menuCliente.introducirEmail();

        if(opcion.equals("1")){
            Cliente newCliente = new ClienteEstandar(nombre, domicilio, nif, email);
            Datos.agregarCliente(newCliente);
        }else{
            int cuotaAnual;
            
           cuotaAnual = menuCliente.introducirCuotaAnual();

            Cliente newCliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
            Datos.agregarCliente(newCliente);
        }

    }

    public void mostrarCliente(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes = Datos.getClientes();
        int count = 1;
        for (Cliente c : clientes){
            menuCliente.printClientes(count, c.getNombre());
            count ++;
        }
    }

    public void mostrarClienteEstandar(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes = Datos.getClientes();
        int count = 1;
        for (Cliente c : clientes){
            if(c instanceof ClienteEstandar){
                menuCliente.printClientes(count, c.getNombre());
                count ++;
            }
        }
    }

    public void mostrarClientePremium(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes = Datos.getClientes();
        int count = 1;
        for (Cliente c : clientes){
            if(!(c instanceof ClienteEstandar)){
                menuCliente.printClientes(count, c.getNombre());
                count ++;
            }
        }
    }

}
