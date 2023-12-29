import java.util.*;
import java.util.stream.IntStream;

public class Juego {

    private boolean leftToRight = true;
    private List<String> leftSide;
    private List<String> rightSide;
    private Scanner scanner;

    public Juego() {
        leftSide = new ArrayList<>(Arrays.asList("O", "L", "C", "U"));
        rightSide = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        System.out.println("Posiciones iniciales:");
        printState();
        while (!isGameOver() && !isDangerousState(leftSide) && !isDangerousState(rightSide)) {
            System.out.println("\nElige: (O)bservador (para moverte solo), (L)obo, (C)aperucita, (U)vas");
            String choice = scanner.nextLine().toUpperCase();
            moverElemento(choice);
            printState();
            checkDangerousState(leftSide);
            checkDangerousState(rightSide);
        }
        if (isGameOver()) {
            System.out.println("\n¡¡¡GANASTE!!!\nHaz logrado cruzar el río con todos los elementos.");
        }
        scanner.close();
    }

    private void moverElemento(String item) {
        ElementoFactory factory = new ElementoFactory();
        Elemento elemento = factory.createElemento(item);
        if (elemento != null) {
            if ((leftToRight && leftSide.contains(item)) || (!leftToRight && rightSide.contains(item))) {
                elemento.mover(item, leftSide, rightSide);
                elemento.mover("O", leftSide, rightSide);
                printMoves(item);
                leftToRight = !leftToRight;
            } else {
                System.out.println("Movimiento inválido! " + item.toUpperCase() + " tiene que estar del mismo lado del Observador.");
            }
        } else {
            System.out.println("### ELIGE UNA OPCIÓN VÁLIDA!!! ###");
        }
    }



    private void printMoves(String item) {
        IntStream.range(0, 10).forEach(i -> {
            try {
                System.out.print("\r" + generateWater(i) + "\\_O_" + (item.equals("O") ? "" : item) + "_/" + generateWater(9 - i));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private String generateWater(int length) {
        return ".".repeat(Math.max(0, length));
    }

    private void printState() {
        System.out.println("Lado izquierdo: " + leftSide + "\nLado Derecho: " + rightSide);
    }

    private boolean isGameOver() {
        return rightSide.containsAll(Arrays.asList("O", "L", "C", "U"));
    }

    private boolean isDangerousState(List<String> bank) {
        return (bank.contains("L") && bank.contains("C") || bank.contains("C") && bank.contains("U")) && !bank.contains("O");
    }

    private void checkDangerousState(List<String> side) {
        if ((side.contains("L") && side.contains("C") && !side.contains("O")) && (side.contains("C") && side.contains("U") && !side.contains("O"))) {
            System.out.println("Haz dejado al Lobo solo con la Caperucita / Caperucita sola con las Uvas.\n¡¡¡PERDISTE!!!");
            System.exit(0);
        }
        if (side.contains("L") && side.contains("C") && !side.contains("O")) {
            System.out.println("Haz dejado al Lobo solo con la Caperucita.\n¡¡¡PERDISTE!!!");
            System.exit(0);
        }
        if (side.contains("C") && side.contains("U") && !side.contains("O")) {
            System.out.println("Haz dejado a la Caperucita sola con las Uvas.\n¡¡¡PERDISTE!!!");
            System.exit(0);
        }
    }
}
