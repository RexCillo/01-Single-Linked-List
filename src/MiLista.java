import java.util.Iterator;

public class MiLista implements ListInterface {
    ListNode cabeza;

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        if (this.cabeza == null) {
            return 0;
        }
        ListNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
            contador = contador + 1;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (this.cabeza == null) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        return iterador.dato;
    }

    @Override
    public Object get(ListNode node) {
        if (node == null || this.cabeza == null) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador == node) {
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public Object search(Object object) {
        if (object == null || this.cabeza == null) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (object.equals(iterador.dato)) {
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        ListNode nuevoNode = new ListNode(object);
        if (this.cabeza == null) {
            this.cabeza = nuevoNode;
            return true;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        iterador.siguiente = nuevoNode;
        return true;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        ListNode nuevoNode = new ListNode(object);
        nuevoNode.siguiente = node.siguiente;
        node.siguiente = nuevoNode;
        return true;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        if (ob == null || this.cabeza == null) {
            return false;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato != null && iterador.dato.equals(ob)) {
                ListNode nuevoNode = new ListNode(object);
                nuevoNode.siguiente = iterador.siguiente;
                iterador.siguiente = nuevoNode;
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if (this.cabeza == null) {
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        } else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(ListNode node) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        if (this.cabeza == node) {
            this.cabeza = this.cabeza.siguiente;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null && iterador.siguiente != null) {
            if (iterador.siguiente == node) {
                iterador.siguiente = node.siguiente;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        if (this.cabeza == null) {
            return false;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (object == null) {
                if (iterador.dato == null) {
                    return true;
                }
            } else if (object.equals(iterador.dato)) {
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int size = getSize();
        Object[] arreglo = new Object[size];
        ListNode iterador = this.cabeza;
        int lugar = 0;
        while (iterador != null) {
            arreglo[lugar] = iterador.dato;
            lugar++;
            iterador = iterador.siguiente;
        }
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        int size = getSize();
        if (object == null || object.length < size) {
            object = new Object[size];
        }
        ListNode iterador = this.cabeza;
        int indice = 0;
        while (iterador != null) {
            object[indice] = iterador.dato;
            indice++;
            iterador = iterador.siguiente;
        }
        if (object.length > size) {
            object[size] = null;
        }
        return object;
    }

    @Override
    public Object getBeforeTo() {
        return null;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        if (this.cabeza == null || node == null || this.cabeza == node) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null && iterador.siguiente != node) {
            iterador = iterador.siguiente;
        }
        if (iterador != null) {
            return iterador.dato;
        }
        return null;
    }

    @Override
    public Object getNextTo() {
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        if (node == null || node.siguiente == node) {
            return null;
        }
        return node.siguiente.dato;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        MiLista subLista = new MiLista();
        if (this.cabeza == null || from == null || to == null) {
            return subLista;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null && iterador != from) {
            iterador = iterador.siguiente;
        }
        if (iterador == null) {
            return subLista;
        }
        while (iterador != null) {
            subLista.add(iterador.dato);
            if (iterador == to) {
                break;
            }
            iterador = iterador.siguiente;
        }
        return subLista;
    }

    @Override
    public MiLista sortList() {
        if (this.cabeza == null || this.cabeza.siguiente == null) {
            return this;
        }

        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            ListNode actual = this.cabeza;

            while (actual.siguiente != null) {
                String valorActual = actual.dato != null ? actual.dato.toString() : "";
                String valorSiguiente = actual.siguiente.dato != null ? actual.siguiente.dato.toString() : "";

                if (valorActual.compareTo(valorSiguiente) > 0) {
                    Object temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    huboIntercambio = true;
                }
                actual = actual.siguiente; // Avanzamos al siguiente nodo
            }
        } while (huboIntercambio);
        return this;
    }

    @Override
    public String toString() {
        if (this.cabeza == null) {
            return "[]";
        }

        String resultado = "[";
        ListNode iterador = this.cabeza;

        while (iterador != null) {
            resultado += iterador.dato;

            // Agregamos una coma y espacio si existe un nodo siguiente
            if (iterador.siguiente != null) {
                resultado += ", ";
            }

            iterador = iterador.siguiente;
        }

        resultado += "]";
        return resultado;
    }
}