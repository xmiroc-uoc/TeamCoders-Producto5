package vista;

import java.util.Scanner;

public class ClienteFunc {
    
    static Scanner teclado = new Scanner(System.in);

    public String tipoCliente(){
        String opcion = "";
        System.out.println("Que tipo de cliente quiere agregar:\r\n" + //
                            "1. Cliente Estándar\r\n" + //
                            "2. Cliente Premium");
            
        System.out.print("\n");
        opcion = teclado.nextLine();
        System.out.print("\n");

        if(opcion.equals("1") || opcion.equals("2")){
            return opcion;
        }else{
            System.out.println("Escoja entre las opciones disponibles.\\n");
            return "";
        }
    }

    public String introducirNombre() throws Exception{
        String nombre = "";
        System.out.println("Introduzca el nombre\n");
        nombre = teclado.nextLine();
        if(nombre.equals("")){
            throw new Exception("Dato no introducido");
        }
        System.out.print("\n");
        return nombre;
    }

    public String introducirDomicilio() throws Exception{
        String domicilio = "";
        System.out.println("Introduzca el domicilio\n");
        domicilio = teclado.nextLine();
        if(domicilio.equals("")){
            throw new Exception("Dato no introducido");
        }
        System.out.print("\n");
        return domicilio;
    }

    public String introducirNIF() throws Exception{
        String nif = "";
        System.out.println("Introduzca el NIF\n");
        nif = teclado.nextLine();
        if(nif.equals("")){
            throw new Exception("Dato no introducido");
        }
        System.out.print("\n");
        return nif;
    }

    public String introducirEmail() throws Exception{
        String email = "";
        System.out.println("Introduzca el mail\n");
        email = teclado.nextLine();
        if(email.equals("")){
            throw new Exception("Dato no introducido");
        }
        System.out.print("\n");
        return email;
    }

    public int introducirCuotaAnual(){
        int cuotaAnual;
        System.out.println("Introduzca la cuota anual\n");
        cuotaAnual = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\n");
        return cuotaAnual;
    }

    public void printClientes(int count, String s){
        System.out.println(count + ". " + s);
    }

}
