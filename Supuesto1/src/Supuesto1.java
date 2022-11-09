/**
 * Carlos Corbalan Andreu 
 * 9/11/2022
 * Simple programa de ordenador que muestra texto en pantalla
 */

import java.util.Scanner;

public class Supuesto1 {
    public static void main(String args[]) {     
        //
        //Creamos un nuevo scanner de teclado
        Scanner teclado = new Scanner(System.in);
        int num;    //Creamos una nueva variable tipo int
        
        //Asignamos el valor 1 a la variable num
        num = 1;
        System.out.println("Hola, Soy un modesto ");
        System.out.print("programa de ordenador...\n");
        System.out.println("Mi número de orden es el " + num + " por ser el primero.");
        //Recibimos dos numeros enteros 
        System.out.println("Escribe dos números...\n");
        int dato1 = teclado.nextInt();
        int dato2 = teclado.nextInt();
        //Imprimimos los numeros que recibimos
        System.out.println("Dato1: " + dato1);
        System.out.println("Dato2: " + dato2);
        // Crea una variable donde se guardara el mensaje basado en la diferencia entre los dos numeros pasados
        String mensaje = "";
        if (dato1 == dato2) {
            mensaje = "Ninguno de los dos es mayor... ";
        }
        // Comprueba si el primer numero es mayor del segundo, si es asi guarda el mensaje
        if (dato1 > dato2) {
            mensaje = "El mayor es: " + dato1;
        }
        // Comprueba si el primer numero es menor del segundo, si es asi guarda el mensaje
        if (dato2 > dato1) {
            mensaje = "El mayor es: " + dato2;
        }
        //Imprimimos el mensaje que obtenemos en los condicionales anteriores
        System.out.println(mensaje);
    }
}