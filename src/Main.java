public class Main {
    public static void main(String[] args) {
        MiLista miLista = new MiLista();
        // Escenario 1: Insertar "Hola" en la lista vacía
        System.out.println("--- Escenario 1: Lista vacía ---");
        miLista.add("Hola");
        System.out.println("Cabeza actual: " + miLista.getHead()); // Imprime: Hola

        // Escenario 2: Preparamos la lista con "Buenos" y "Días"
        miLista.add("Buenos");
        miLista.add("Días");

        System.out.println("--- Lista inicial ---");
        imprimirLista(miLista);

        // Añadimos el nodo "Hola" al final de esa lista existente
        System.out.println("\n--- Añadiendo 'Hola' ---");
        miLista.add("Hola");

        System.out.println("--- Lista resultante ---");
        imprimirLista(miLista);
    }

    // Método auxiliar sencillo para ver la lista en consola
    private static void imprimirLista(MiLista lista) {
        ListNode iterador = lista.cabeza;
        while (iterador != null) {
            System.out.println("- " + iterador.dato); // O iterador.data / valor
            iterador = iterador.siguiente;
        }
    }
}