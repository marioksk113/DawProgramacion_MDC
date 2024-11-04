import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Mostrar instrucciones
        System.out.println("Bienvenido al juego de Piedra, Papel o Tijera!");
        System.out.println("Instrucciones:");
        System.out.println("Escribe 'P' para Piedra, 'L' para Papel, 'T' para Tijeras.");
        System.out.println("Escribe 'S' para salir del juego.");

        Scanner scanner = new Scanner(System.in);
        String jugadaUsuario;
        
        while (true) {
            System.out.print("¿Cuál es tu jugada? (P/L/T/S): ");
            jugadaUsuario = scanner.nextLine().toUpperCase();

            if (jugadaUsuario.equals("S")) {
                System.out.println("Gracias por jugar. ¡Hasta luego!");
                break;
            }

            if (!jugadaUsuario.equals("P") && !jugadaUsuario.equals("L") && !jugadaUsuario.equals("T")) {
                System.out.println("Jugada no válida. Intenta de nuevo.");
                continue;
            }

            String[] opciones = {"P", "L", "T"};
            Random rand = new Random();
            String jugadaPC = opciones[rand.nextInt(opciones.length)];
            System.out.println("La jugada del ordenador es: " + jugadaPC);

            String resultado;
            if (jugadaUsuario.equals(jugadaPC)) {
                resultado = "¡Es un empate!";
            } else if ((jugadaUsuario.equals("P") && jugadaPC.equals("T")) ||
                       (jugadaUsuario.equals("L") && jugadaPC.equals("P")) ||
                       (jugadaUsuario.equals("T") && jugadaPC.equals("L"))) {
                resultado = "¡Ganaste!";
            } else {
                resultado = "Perdiste!";
            }

            System.out.println(resultado);
        }
    }
}


