import java.util.List;

public class Caperucita implements Elemento {
    @Override
    public void mover(String item, List<String> from, List<String> to) {
        move("C", from, to);

    }

    private void move(String item, List<String> from, List<String> to) {
        if (from.remove(item)) {
            to.add(item);
        }
    }
}
