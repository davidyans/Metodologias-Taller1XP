import java.util.*;
import java.util.stream.IntStream;

public class JuegoLobo {
    static boolean leftToRigth = true; // Posicion inicial del observador y el resto
    public static void main(String[] args) {
        List<String> leftSide = new ArrayList<>(Arrays.asList("O", "L", "C", "U")), rightSide = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Posiciones iniciales:");
        printState(leftSide, rightSide);
        while ((!isGameOver(rightSide)) && (!isDangerousState(leftSide)) && (!isDangerousState(rightSide))) {
            System.out.println("\nElige: (O)bservador (para moverte solo), (L)obo, (C)aperucita, (U)vas");
            String choice = scanner.nextLine().toUpperCase();
            if((choice.equals("O")) || (choice.equals("L")) || (choice.equals("C")) || (choice.equals("U"))){
                if ((leftToRigth && leftSide.contains(choice)) || (!leftToRigth && rightSide.contains(choice))) {
                    move(choice, leftToRigth ? leftSide : rightSide, leftToRigth ? rightSide : leftSide);
                    move("O", leftToRigth ? leftSide : rightSide, leftToRigth ? rightSide : leftSide);
                    printMoves(choice, leftToRigth ? leftSide : rightSide, leftToRigth ? rightSide : leftSide); leftToRigth = !leftToRigth;
                } else { 
                    System.out.println("Movimiento inválido! " + choice.toUpperCase() + " tiene que estar del mismo lado del Observador."); 
                    continue; 
                }
                if (!isGameOver(rightSide)) { 
                    System.out.println("\n****** ESTADO ACTUAL: ******"); 
                    printState(leftSide, rightSide); 
                    System.out.println("*****************************"); 
                }
                if ((isDangerousState(leftSide)) || (isDangerousState(rightSide))) { 
                    checkDangerousState(leftSide); 
                    checkDangerousState(rightSide); 
                }
            }else System.out.println("### ELIGE UNA OPCIÓN VÁLIDA!!! ###");  
        }
        if (isGameOver(rightSide)) System.out.println("\n¡¡¡GANASTE!!!\nHaz logrado cruzar el río con todos los elementos.");
        scanner.close();
    }

    private static void move(String item, List<String> from, List<String> to) {
        if (from.remove(item)) to.add(item);
    }
    
    private static void printMoves(String item, List<String> from, List<String> to) {
        IntStream.range(0, 10).forEach(i -> {
            try {
                System.out.print("\r" + generateWater(i) + "\\_O_" + (item.equals("O") ? "" : item) + "_/" + generateWater(9 - i));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    
    private static String generateWater(int length) {
        return ".".repeat(Math.max(0, length));
    }
    
    private static void printState(List<String> leftBank, List<String> rightBank) {
        System.out.println("Lado izquierdo: " + leftBank + "\nLado Derecho: " + rightBank);
    }
    
    private static boolean isGameOver(List<String> rightBank) {
        return rightBank.containsAll(Arrays.asList("O", "L", "C", "U"));
    }
    
    private static boolean isDangerousState(List<String> bank) {
        return (bank.contains("L") && bank.contains("C") || bank.contains("C") && bank.contains("U")) && !bank.contains("O");
    }

    private static void checkDangerousState(List<String> side) {
        if ((side.contains("L") && (side.contains("C")) && (!side.contains("O"))) 
            && (side.contains("C") && (side.contains("U")) && (!side.contains("O")))) {
            System.out.println("Haz dejado al Lobo solo con la Caperucita / Caperucita sola con las Uvas.\n¡¡¡PERDISTE!!!");
            return;
        }
        if ((side.contains("L")) && (side.contains("C")) && (!side.contains("O"))) {
            System.out.println("Haz dejado al Lobo solo con la Caperucita.\n¡¡¡PERDISTE!!!");
            return;
        }
        if ((side.contains("C")) && (side.contains("U")) && (!side.contains("O"))) 
        System.out.println("Haz dejado a la Caperucita sola con las Uvas.\n¡¡¡PERDISTE!!!");
    }
}