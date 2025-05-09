
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Selvin Aguilar
 */
public class EstructuraControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea=new Scanner(System.in);
        
        int contador_palabra_al_reves = 0;
        int contador_numero_perfecto = 0;
        int contador_primos = 0;
        int contador_votaciones = 0;
        
        
        
        while(true){
              
        System.out.println("--------MENU--------");
        System.out.println("1- PALABRA AL REVES.");
        System.out.println("2- NUMERO PERFECTO.");
        System.out.println("3- PRIMOS.");
        System.out.println("4- VOTACIONES.");
        System.out.println("5- SALIR.");
        System.out.println("---------------------");
        System.out.print("INGRESA NUMERO DEL MENU: ");
        int menu=lea.nextInt();
        
        if(menu==1){
            System.out.println("--------PALABRA AL REVES--------");
            System.out.print("Ingrese la cantidad de palabras: ");
                int cantidad = lea.nextInt();
                lea.nextLine();

                String palabraMasLarga = "";
                int longitudMaxima = 0;

                System.out.println("\nPalabras al reves:");
                for (int i = 0; i < cantidad; i++) {
                    System.out.print("Ingrese la palabra #" + (i + 1) + ": ");
                    String palabra = lea.nextLine().toLowerCase();

                    // Imprimir palabra al revés
                    for (int j = palabra.length() - 1; j >= 0; j--) {
                        System.out.print(palabra.charAt(j));
                    }
                    System.out.println();

                    // Verificar si es la más larga
                    if (palabra.length() > longitudMaxima) {
                        longitudMaxima = palabra.length();
                        palabraMasLarga = palabra;
                    }
                }

                // Verificar si palabraMasLarga es palíndromo
                int i = 0;
                int j = palabraMasLarga.length() - 1;
                String resultadoPalindromo = "SI";

                while (i < j) {
                    if (palabraMasLarga.charAt(i) != palabraMasLarga.charAt(j)) {
                        resultadoPalindromo = "NO";
                        break;
                    }
                    i++;
                    j--;
                }

                System.out.println("La palabra mas larga es " + palabraMasLarga + " con " + longitudMaxima + " letras y "+ resultadoPalindromo+"es palindromo." );
                System.out.println();
                
            } else if (menu == 2) {
                    
                    int numero;
                    int divisores = 0;

                    System.out.println("--------NUMERO PERFECTO--------");
                    System.out.print("Ingrese un numero: ");
                    numero = lea.nextInt();
                    
                    for (int i = 1; i <= numero / 2; i++) {
                        if (numero % i == 0) {
                            divisores += i;
                        }
                    }

                    if (divisores == numero) {
                        System.out.println("El numero " + numero + " es perfecto");
                    } else {
                        System.out.println(numero + ", No es un numero perfecto");
                    }
                    contador_numero_perfecto++;
                    
            } else if(menu==3) {
                System.out.println("Primos");
                    Random random = new Random();
                    int numeroAleatorio = random.nextInt(1000);
                    
                    boolean esPrimo = true;

                    for (int i = 2; i <= Math.sqrt(numeroAleatorio); i++) {
                        if (numeroAleatorio % i == 0) {
                            esPrimo = false;
                            break;
                        }
                    }
                    if (esPrimo && numeroAleatorio > 1) {
                        System.out.println("El numero: " + numeroAleatorio + " es primo");
                    } else {
                        System.out.println("El numero: " + numeroAleatorio + " no es primo");
                    }
                    contador_primos++;
                    
            }else if(menu==4){
                    
                    int votantes;
                    int votos_azules = 0;
                    int votos_rojos = 0;
                    int votos_negros = 0;
                    int votos_amarillos = 0;
                    int votos_nulos = 0;

                    System.out.println("--------VOTACIONES--------");
                    System.out.print("Ingresar la cantidad de votantes del pais: ");
                    votantes = lea.nextInt();

                    for (int i = 0; i < votantes; i++) {
                        System.out.print("Ingrese su voto (AZUL, AMARILLO, NEGRO, ROJO): ");
                        String voto = lea.nextLine().toUpperCase();

                        switch (voto) {
                            case "AZUL":
                                votos_azules++;
                                break; // Terminar caso
                            case "ROJO":
                                votos_rojos++;
                                break;
                            case "NEGRO":
                                votos_negros++;
                                break;
                            case "AMARILLO":
                                votos_amarillos++;
                                break;
                            default:
                                votos_nulos++;
                                break;
                        }
                    }

                    int total_votos = votantes;
                    int votos_validos = total_votos - votos_nulos;

                    if (votos_validos >= 0.6 * total_votos) {
                        String ganador;
                        if (votos_azules > votos_rojos && votos_azules > votos_negros && votos_azules > votos_amarillos) {
                            ganador = "AZUL";
                        } else if (votos_rojos > votos_azules && votos_rojos > votos_negros && votos_rojos > votos_amarillos) {
                            ganador = "ROJO";
                        } else if (votos_negros > votos_azules && votos_negros > votos_rojos && votos_negros > votos_amarillos) {
                            ganador = "NEGRO";
                        } else {
                            ganador = "AMARILLO";
                        }
                        System.out.println("La planilla ganadora es: " + ganador);
                    } else {
                        System.out.println("VOTACION FALLIDA");
                    }
                    contador_votaciones++; 

            } else if(menu==5){
                System.out.println("Cantidad de veces ingresada a Palabra Al Reves: "+contador_palabra_al_reves);
                System.out.println("Cantidad de veces ingresada a Numero Perfecto: "+contador_numero_perfecto);
                System.out.println("Cantidad de veces ingresada a Primos: "+contador_primos);
                System.out.println("Cantidad de veces ingresada a Votaciones: "+contador_votaciones);
                
                break;
            } else if(menu!=1 && menu!=2 && menu!=3 && menu!=4 && menu!=5){
                System.out.println("Ingresa un numero valido del menu");
                System.out.println("");
            }
        
            }
        
        }
    }
    

