
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Selvin Aguilar
 */
public class Control {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea=new Scanner(System.in);
        
        while(true){
              
        System.out.println("--------MENU--------");
        System.out.println("1- CIFRADO.");
        System.out.println("2- FILTRAR.");
        System.out.println("3- CODIGO ENIGMA.");
        System.out.println("4- SALIR.");
        System.out.println("---------------------");
        System.out.print("INGRESA NUMERO DEL MENU: ");
        int menu=lea.nextInt();
        
        if(menu == 1){
            
            lea.nextLine(); // Limpiar el teclado antes de leer la frase

            System.out.println("--------CIFRADO--------");
            System.out.print("Escribe la frase que quieres cifrar: ");
            String frase = lea.nextLine();

            System.out.print("Cuántos lugares quieres mover cada letra?: ");
            int desplazamiento = lea.nextInt();

            String resultado = ""; // Aquí vamos a guardar la frase cifrada

            int i = 0; // Esto es para contar en qué letra estamos
            while(i < frase.length()){ // Mientras no lleguemos al final de la frase
                char c = frase.charAt(i); // Tomamos la letra en la posición i

                // Si la letra está entre A y Z (mayúsculas)
                if(c >= 'A' && c <= 'Z'){
                    char letra_cifrada = (char)(c + desplazamiento); // Movemos la letra

                    // Si pasamos de la Z, volvemos a empezar desde la A
                    if(letra_cifrada > 'Z'){
                        letra_cifrada = (char)(letra_cifrada - 26);
                    }
                    resultado = resultado + letra_cifrada; // Añadimos la letra cifrada al resultado

                // Si la letra está entre a y z (minúsculas)
                } else if(c >= 'a' && c <= 'z'){
                    char letraCifrada = (char)(c + desplazamiento); // Movemos la letra

                    // Si pasamos de la z, volvemos a empezar desde la a
                    if(letraCifrada > 'z'){
                        letraCifrada = (char)(letraCifrada - 26);
                    }
                    resultado = resultado + letraCifrada; // Añadimos la letra cifrada al resultado

                } else {
                    // Si no es letra, solo la dejamos igual (espacios, números, símbolos)
                    resultado = resultado + c;
                }

                i = i + 1; // Pasamos a la siguiente letra
            }

            System.out.println("Tu frase cifrada es: " + resultado);

        }else if(menu == 2){
            System.out.println("");
            System.out.println("--------FILTRAR--------");

            lea.nextLine(); // limpiar el buffer

            System.out.print("Ingresar frase: ");
            String frase = lea.nextLine();

            System.out.print("Ingresar longitud mínima de la palabra: ");
            int long_min = lea.nextInt();
            lea.nextLine(); // limpiar el buffer

            System.out.println("Palabra(s) mayor o igual a la longitud de " + long_min + ":");

            int contador = 0;
            String palabra = "";

            while(contador <= frase.length()){
                if(contador == frase.length() || frase.charAt(contador) == ' '){
                
                if(palabra.length() >= long_min){
                System.out.println(palabra);
                 }
                    palabra = ""; // Reinicio de la palabra
                } else {
                    palabra += frase.charAt(contador);
                }
                    contador++;
                }
            }else if(menu == 3){
                int submenu = 0;
                String encriptado = "";

                // Usamos while para el submenu
                while (submenu != 3) {
                    System.out.println("--------CODIGO ENIGMA--------");
                    System.out.println("1. Encriptar texto");
                    System.out.println("2. Desencriptar texto");
                    System.out.println("3. Regresar");
                    System.out.print("Elija una opcion: ");
                    submenu = lea.nextInt();
                    lea.nextLine();

                    if (submenu == 1) {
                        System.out.print("Ingrese un texto: ");
                        String texto_original = lea.nextLine();

                        String cadena_pares = "";
                        String cadena_impares = "";

                        System.out.print("Posiciones pares: ");
                        for (int i = 0; i < texto_original.length(); i++) {
                            if (i % 2 == 0) {
                                System.out.print("'" + texto_original.charAt(i) + "' ");
                                cadena_pares += texto_original.charAt(i);
                            }
                        }

                        System.out.println();
                        System.out.print("Posiciones impares: ");
                        for (int i = 0; i < texto_original.length(); i++) {
                            if (i % 2 != 0) {
                                System.out.print("'" + texto_original.charAt(i) + "' ");
                                cadena_impares += texto_original.charAt(i);
                            }
                        }

                        encriptado = cadena_pares + cadena_impares;
                        System.out.println();
                        System.out.println("Texto encriptado: " + encriptado);

                    } else if (submenu == 2) {
                        if (encriptado.isEmpty()) {
                            System.out.println("No hay texto encriptado.");
                        } else {
                            int mitad = (encriptado.length() + 1) / 2;
                            String pares = encriptado.substring(0, mitad);
                            String impares = encriptado.substring(mitad);
                            String desencriptar = "";

                            for (int i = 0; i < encriptado.length(); i++) {
                                if (i % 2 == 0 && i / 2 < pares.length()) {
                                    desencriptar += pares.charAt(i / 2);
                                } else if (i % 2 != 0 && i / 2 < impares.length()) {
                                    desencriptar += impares.charAt(i / 2);
                                }
                            }

                            System.out.println("Texto desencriptado: " + desencriptar);
                        }

                    } else if (submenu == 3) {
                        // volvemos al menú principal
                    } else {
                        System.out.println("Opcion invalida");
                    }
                }

            } else if (menu == 4) {
                // Opción para salir del programa
                System.out.println("Saliendo del programa");
                break;
            } else {
                // Si elige algo que no está en el menú
                System.out.println("Opcion no valida");
            }
                    
                }
            }
            }
        

