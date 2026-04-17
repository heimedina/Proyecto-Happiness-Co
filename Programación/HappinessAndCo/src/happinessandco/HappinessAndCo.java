package happinessandco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author heidi
 */
public class HappinessAndCo {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Usuario> usuarios = new HashMap<>();
    static HashMap<Integer, Evento> eventos = new HashMap<>();
    static ArrayList<Favorito> favoritos = new ArrayList<>();

    static int contadorEventos = 0;
    static int contadorGalerias = 0;

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n*********************");
            System.out.println("|       MENÚ        |");
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
            sc.nextLine(); //Limpia el buffer 

            if (opcion < 1 || opcion > 9) {
                System.out.println("Opción inválida!\n");
                continue;
            }
            switch (opcion) {
                case 1 -> {
                    añadirUsuario();
                }
                case 2 -> {
                    eliminarUsuario();
                }

                case 3 -> {
                    anadirEvento();
                }
                case 4 -> {
                    eliminarEvento();
                }
                case 5 -> {
                    anadirGaleria();
                }
                case 6 -> {
                    eliminarGaleria();
                }
                case 7 -> {
                    añadirFavorito();
                }
                case 8 -> {
                    eliminarFavorito();
                }
                case 9 -> {
                    System.out.println("*Gracias por usar nuestro sistema*");
                }

                default ->
                    System.out.println("Opción inválida!");

            }

        } while (opcion != 9);
    }

    private static void añadirUsuario() {
        System.out.println("\n************************");
        System.out.println("|    Añadir usuario    |");
        System.out.println("************************");

        System.out.print("Introduce el email: ");
        String email = sc.nextLine();

        if (usuarios.containsKey(email)) {
            System.out.println("¡El usuario ya existe!");
            return;
        }

        System.out.print("Introduce el Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el Password: ");
        String password = sc.nextLine();

        usuarios.put(email, new Usuario(nombre, email, password));
        System.out.println("¡Usuario creado correctamente!");

    }

    private static void eliminarUsuario() {
        System.out.println("\n*************************");
        System.out.println("|    Eliminar usuario    |");
        System.out.println("*************************");

        System.out.print("Introduce el email del usuario que deseas eliminar: ");
        String email = sc.nextLine();

        if (usuarios.remove(email) == null) {
            System.out.println("¡El usuario no existe!");
        } else {
            System.out.println("¡Usuario eliminado correctamente!");
        }

    }

    private static void anadirEvento() {
        System.out.println("\n***********************");
        System.out.println("|    Añadir evento    |");
        System.out.println("***********************");
        contadorEventos++;

        // Definir el formato esperado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = null;

        while (fecha == null) {
            System.out.print("Introduce la Fecha del evento \n*asegurate que sea en formato dd/MM/yyyy*: ");
            // Fecha en formato String "16/01/2026"
            String fechaTexto = sc.nextLine();

            try {
                // Convertir String a LocalDate
                fecha = LocalDate.parse(fechaTexto, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido, intenta de nuevo!");
            }
        }

        System.out.print("Introduce el Titulo del evento: ");
        String titulo = sc.nextLine();

        System.out.print("Introduce la Ubicación: ");
        String ubicacion = sc.nextLine();

        System.out.print("Indica una descripción: ");
        String descripcion = sc.nextLine();

        eventos.put(contadorEventos, new Evento(String.valueOf(contadorEventos), fecha, titulo, ubicacion, descripcion));
        System.out.println("¡Evento creado correctamente!");
    }

    private static void eliminarEvento() {
        System.out.println("\n************************");
        System.out.println("|    Eliminar evento    |");
        System.out.println("************************");

        //Mostrar eventos
        if (eventos.isEmpty()) {
            System.out.println("¡No hay eventos disponibles!");
            return;
        }
        eventos.values().forEach(System.out::println); //Imprime los eventos
        System.out.print("Introduce el ID del evento que deseas eliminar: ");
        int id = sc.nextInt();

        if (eventos.remove(id) == null) {
            System.out.println("¡El evento no existe!");
        } else {
            System.out.println("¡Evento eliminado correctamente!");
        }

    }

    private static void anadirGaleria() {
        System.out.println("\n************************");
        System.out.println("|    Añadir galería    |");
        System.out.println("************************");

        eventos.values().forEach(System.out::println);

        System.out.print("Introduce el Id del evento: ");
        int id = sc.nextInt();
        sc.nextLine();

        Evento e = eventos.get(id);

        if (e == null) {
            System.out.println("¡Error, El evento no existe");
            return;
        }

        contadorGalerias++;

        System.out.print("Introduce el titulo de la galeria: ");
        String titulo = sc.nextLine();

        e.getColeccionGaleria().add(new Galeria(String.valueOf(contadorGalerias), titulo, String.valueOf(id)));
        System.out.println("¡Galeria creada correctamente!");
    }

    private static void eliminarGaleria() {
        System.out.println("\n**************************");
        System.out.println("|    Eliminar galería    |");
        System.out.println("**************************");

        //Mostrar eventos
        if (eventos.isEmpty()) {
            System.out.println("¡No hay eventos disponibles!");
            return;
        }
        System.out.println("\nLista de eventos:");
        eventos.values().forEach(System.out::println);

        System.out.print("Introduce el Id del evento: ");
        int idEvento = sc.nextInt();
        sc.nextLine();

        Evento evento = eventos.get(idEvento);

        if (evento == null) {
            System.out.println("El evento no existe");
            return;
        }

        if (evento.getColeccionGaleria().isEmpty()) {
            System.out.println("¡Este evento no tiene galerías!");
        }

        System.out.println("\nGalerías del evento:");
        evento.getColeccionGaleria().forEach(System.out::println);

        System.out.print("Introduce el Id de la galería a eliminar: ");
        int idGaleria = sc.nextInt();
        sc.nextLine();

        //Buscar y eliminar
        boolean eliminada = evento.getColeccionGaleria().removeIf(g -> g.getId().equals(String.valueOf(idGaleria)));

        if (!eliminada) {
            System.out.println("¡La galería no existe!");
        } else {
            System.out.println("¡Galería eliminada correctamente!");
        }

    }

    private static void añadirFavorito() {
        System.out.println("\n*************************");
        System.out.println("|    Añadir favorito    |");
        System.out.println("*************************");

        //Mostrar eventos y usuarios
        if (eventos.isEmpty()) {
            System.out.println("¡No hay eventos disponibles!");
            return;
        } else if (usuarios.isEmpty()) {
            System.out.println("¡No hay usuarios registrados!");
            return;
        }

        System.out.println("\nLista de eventos:");
        eventos.values().forEach(System.out::println);
        System.out.println("\nLista de usuarios:");
        usuarios.values().forEach(System.out::println);

        System.out.print("\nIntroduce el Id del evento: ");
        int idEvento = sc.nextInt();
        sc.nextLine();

        System.out.print("Email usuario: ");
        String email = sc.nextLine();

        if (!eventos.containsKey(idEvento) || !usuarios.containsKey(email)) {
            System.out.println("¡Error en los datos!");
            return;
        }

        favoritos.add(new Favorito(email, String.valueOf(idEvento)));
        System.out.println("Favorito creado correctamente");
    }

    private static void eliminarFavorito() {
        System.out.println("\n***************************");
        System.out.println("|    Eliminar favorito    |");
        System.out.println("***************************");

        //Mostrar favoritos
        if (favoritos.isEmpty()) {
            System.out.println("¡No hay favoritos disponibles!");
            return;
        }

        System.out.println("\nLista de favoritos:");
        favoritos.forEach(System.out::println);

        System.out.print("Introduce el Id del evento: ");
        int idEvento = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el correo del usuario: ");
        String email = sc.nextLine();

        boolean eliminado = favoritos.removeIf((var f)
                -> f.getIdEvento().equals(String.valueOf(idEvento)) && f.getCorreoUsuario().equals(email)
        );

        if (!eliminado) {
            System.out.println("¡El favorito no existe!");
        } else {
            System.out.println("¡Favorito eliminado correctamente!");
        }
    }

}
