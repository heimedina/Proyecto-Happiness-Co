package happinessandco;

import java.util.Scanner;

/**
 *
 * @author heidi
 */
public class HappinessAndCo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salir=false;
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n*********************");
            System.out.println("|       MENÚ       |");
            System.out.println("*********************");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Añadir evento");
            System.out.println("4. Eliminar evento");
            System.out.println("5. Añadir galería");
            System.out.println("6. Eliminar galería");
            System.out.println("7. Añadir favorito");
            System.out.println("8. Eliminar favorito");
            System.out.println("9. Salir");
            System.out.print("\n Elige una opción: ");
            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 9) {
                System.out.println("Opción inválida!\n");
                continue;
            }
            switch (opcion) {
                case 1 -> {
                    System.out.println("*Añadir usuario*");
                }
                case 2 -> {
                    System.out.println("*Eliminar usuario*");
                    System.out.println("¿Cuánto deseas depositar? ");
                    double deposito = sc.nextDouble();
                    if (deposito <= 0) { // No permite depósitos negativos
                        System.out.println("El monto debe ser mayor que 0");
                    } else {
                        
                    }
                }

                case 3 -> {
                    System.out.println("*Añadir evento*");
                    System.out.println("¿Cuánto deseas retirar? ");
                    double retiro = sc.nextDouble();
                    
                }
                case 4 -> {
                    System.out.println("*Eliminar evento*");
                }
                case 5 -> {
                    System.out.println("*Añadir galería*");
                }
                case 6 -> {
                    System.out.println("*Eliminar galería*");
                }
                case 7 -> {
                    System.out.println("*Añadir favorito*");
                }
                case 8 -> {
                    System.out.println("*Eliminar favorito*");
                }
                case 9 -> {
                    System.out.println("*Gracias por usar nuestro sistema*");
                }
                
                default ->
                    System.out.println("Opción inválida!");

            }

        } while (opcion != 9);
    }

}
