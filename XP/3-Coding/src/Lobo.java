import java.util.List;

public class Lobo implements Elemento {
    @Override
    public void mover(String item, List<String> from, List<String> to) {
        move("L", from, to);
    }

    private void move(String item, List<String> from, List<String> to) {
        if (from.remove(item)) {
            to.add(item);
        }
    }
}
