package controlador;

import modelo.*;
import vista.*;

public class Tienda {
   
    private Datos datos = new Datos();
    private MenuGeneral menu = new MenuGeneral();

    public void navegarTienda(){
        menu.printMenuGeneral();
    }


}
