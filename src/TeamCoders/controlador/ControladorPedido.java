package controlador;

import vista.PedidoFunc;

import java.util.*;

import modelo.*;

public class ControladorPedido {


    private PedidoFunc menuPedido = new PedidoFunc();

    private ControladorCliente controladorCliente = new ControladorCliente();

    public void agregarPedido(){
        int numPedido;
        int unidades;
        Cliente clienteSeleccionado = null;
        Articulo articuloSeleccionado;
        

        numPedido = menuPedido.introducirNumPedido();
        unidades = menuPedido.introducirUnidades();
       
        String opcion = "";
        boolean opcionPosible = false;

        while(!opcionPosible){
            opcion = menuPedido.existenteOAgreagar();
            if(!opcion.equals("")){
                opcionPosible = true;
            }
        }

        if(opcion.equals("2")){
            try{
                controladorCliente.agregarCliente();
                clienteSeleccionado = Datos.getClientes().get((Datos.getClientes().size())-1);
            }
            catch (InputMismatchException ime){
                menuPedido.handleInputMismatch();
                return;
            }
            catch (Exception e){
                menuPedido.handleException(e);
                return;
            }
            
        }else{
            int opcionCliente = 0;
            while(opcionPosible){
                int clientesSize = Datos.getClientes().size();
                opcionCliente = menuPedido.seleccionarCliente(clientesSize);
                if(opcionCliente > 0){
                    opcionPosible = false;
                }
            }
            clienteSeleccionado = Datos.getClientes().get(opcionCliente - 1);
        }

        int opcionArticulo = 0;
        boolean opcionArtPosible = false;

        while(!opcionArtPosible){
            int articulosSize = Datos.getArticulos().size();
            opcionArticulo = menuPedido.seleccionarArticulo(articulosSize);
            if(opcionArticulo > 0){
                opcionArtPosible = true;
            }
        }
        articuloSeleccionado = Datos.getArticulos().get(opcionArticulo - 1);

        Date fecha = new Date();
        Pedido newPedido = new Pedido(numPedido, unidades, fecha, clienteSeleccionado, articuloSeleccionado);
        Datos.agregarPedido(newPedido);
    }

    public void eliminarPedido(){
        int opcionPedido = 0;
        int count = 1;
        boolean opcionPedPosible = false;

        while (!opcionPedPosible) {
            int pedidosSize = Datos.getPedidos().size();
            menuPedido.seleccion();
            for (Pedido p : Datos.getPedidos()){
                menuPedido.printPedidos(count, p.getNumeroPedido());
                count ++;
            }
            opcionPedido = menuPedido.seleccionarPedido(pedidosSize);
            if(opcionPedido!=0){
                opcionPedPosible = true;
                boolean eliminarPosible = Datos.getPedidos().get(opcionPedido-1).cancelable();
                if(eliminarPosible){
                    Datos.eliminarPedido(Datos.getPedidos().get(opcionPedido - 1));
                }else{
                    menuPedido.pedidoNoCancelable();
                }
            }
        }
    }

    public void mostrarPedidosPendientes(){
        int count = 1;
        Calendar calendar = Calendar.getInstance();
        Date actualidad = new Date();
        for (Pedido p : Datos.getPedidos()){
            calendar.setTime(p.getFechaPedido());
            calendar.add(Calendar.MINUTE, p.getArticulo().getTiempoPreparacion());
            if(!calendar.getTime().before(actualidad)){
                menuPedido.printPedidos(count, p.getNumeroPedido());
                count++;
            }
        }
    }

    public void mostrarPedidosEnviados(){
        int count = 1;
        Calendar calendar = Calendar.getInstance();
        Date actualidad = new Date();
        for (Pedido p : Datos.getPedidos()){
            calendar.setTime(p.getFechaPedido());
            calendar.add(Calendar.MINUTE, p.getArticulo().getTiempoPreparacion());
            if(calendar.getTime().before(actualidad)){
                menuPedido.printPedidos(count, p.getNumeroPedido());
                count++;
            }
        }
    }

}
