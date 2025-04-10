package vista;

import java.util.Scanner;


public class ArticuloFunc {

    static Scanner teclado = new Scanner(System.in);

    public String introducirCodigo() throws Exception{
        String codigo = "";
        System.out.println("Introduzca el codigo\n");
        codigo = teclado.nextLine();
        System.out.print("\n");
        if(codigo.equals("")){
            throw new Exception("Dato no introducido");
        }
        return codigo;
    }

    public int introducirTiempoPreparacion(){
        int tiempoPreparacion;
        System.out.println("Introduzca el timepo de preparación en minutos\n");
        tiempoPreparacion = teclado.nextInt();
        System.out.print("\n");
        return tiempoPreparacion;
    }

    public float introducirGastosEnvio(){
        float gastosEnvio;
        System.out.println("Introduzca los gastos de envio\n");
        gastosEnvio = teclado.nextFloat();
        System.out.print("\n");
        return gastosEnvio;
    }

    public float introducirPrecioVenta(){
        float precioVenta;
        System.out.println("Introduzca el precio de venta\n");
        precioVenta = teclado.nextFloat();
        System.out.print("\n");
        return precioVenta;
    }

    public String introducirDescripcion() throws Exception{
        String descripcion = "";
        System.out.println("Introduzca una descripción\n");
        teclado.nextLine();
        descripcion = teclado.nextLine();
        if(descripcion.equals("")){
            throw new Exception("Dato no introducido");
        }
        System.out.print("\n");
        return descripcion;
    }

    public void printArticulos(int count, String s){
        System.out.println(count + ". " + s);
    }

    public void handleInputMismatch(){
        System.out.print("\n");
        System.out.println("Tipo de dato erroneo");
        System.out.print("\n");
        teclado.nextLine();
        return;
    }

    public void handleException(Exception e){
        System.out.println(e.getMessage());
        System.out.print("\n");
        return;
    }
}
