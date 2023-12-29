public class ElementoFactory {
    public Elemento createElemento(String tipo) {
        switch (tipo) {
            case "O":
                return new Observador();
            case "L":
                return new Lobo();
            case "C":
                return new Caperucita();
            case "U":
                return new Uvas();
            default:
                return null;
        }
    }
}
