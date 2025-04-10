package controlador;

import vista.ArticuloFunc;

import java.util.ArrayList;
import java.util.InputMismatchException;

import modelo.*;

public class ControladorArticulo {
    
    private ArticuloFunc menuArticulo = new ArticuloFunc();
    public void agregarArticulo(){
        String codigo = "";
        int tiempoPreparacion;
        float gastosEnvio;
        float precioVenta;
        String descripcion = "";

        try{
            codigo = menuArticulo.introducirCodigo();
        }
        catch (InputMismatchException ime){
            menuArticulo.handleInputMismatch();
            return;
        }
        catch (Exception e){
            menuArticulo.handleException(e);
            return;
        }

       
        tiempoPreparacion = menuArticulo.introducirTiempoPreparacion();
        gastosEnvio = menuArticulo.introducirGastosEnvio();
        precioVenta = menuArticulo.introducirPrecioVenta();
        
        try{
            descripcion = menuArticulo.introducirDescripcion();
        }
        catch (InputMismatchException ime){
            menuArticulo.handleInputMismatch();
            return;
        }
        catch (Exception e){
            menuArticulo.handleException(e);
            return;
        }
        
        
        Articulo newArticulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
        
        Datos.agregarArticulo(newArticulo);
    }
    public void mostrarArticulo(){
        ArrayList<Articulo> articulos = new ArrayList<>();
        articulos = Datos.getArticulos();
        int count = 1;
        for (Articulo a : articulos){
            menuArticulo.printArticulos(count, a.getDescripcion());
            count ++;
        }
    }
}
