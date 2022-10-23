package data.structures;

import java.util.LinkedList;

public class ArvoreDeBuscaBinariaImpl<T extends Comparable<T>> implements ArvoreDeBuscaBinaria<T> {

    private T data;
    private ArvoreDeBuscaBinariaImpl<T> dir;
    private ArvoreDeBuscaBinariaImpl<T> esq;

    public ArvoreDeBuscaBinariaImpl(T data) {
        this.data = data;
    }

    @Override
    public void insert(T data) {
        insert(this, data);
    }

    private void insert(ArvoreDeBuscaBinariaImpl<T> arvore, T data) {
        if (data.compareTo(arvore.data) > 0) {
            if (arvore.dir == null) {
                arvore.dir = new ArvoreDeBuscaBinariaImpl<>(data);
            } else {
                insert(arvore.dir, data);
            }
        } else {
            if (arvore.esq == null) {
                arvore.esq = new ArvoreDeBuscaBinariaImpl<T>(data);
            } else {
                insert(arvore.esq, data);
            }
        }
    }

    @Override
    public boolean exists(T dada) {
        return false;
    }

    @Override
    public ArvoreDeBuscaBinaria<T> retrieve(T data) {
        return null;
    }

    @Override
    public void preOrder() {
        preOrder(this);
    }

    private void preOrder(ArvoreDeBuscaBinariaImpl<T> arvore) {
        if (arvore != null) {
            System.out.println(arvore.data);
            preOrder(arvore.esq);
            preOrder(arvore.dir);
        }
    }

    @Override
    public void inOrder() {
        inOrder(this);
    }

    private void inOrder(ArvoreDeBuscaBinariaImpl<T> arvore) {
        if (arvore != null) {
            preOrder(arvore.esq);
            System.out.println(arvore.data);
            preOrder(arvore.dir);
        }
    }

    @Override
    public void posOrder() {
        posOrder(this);
    }

    private void posOrder(ArvoreDeBuscaBinariaImpl<T> arvore) {
        if (arvore != null) {
            posOrder(arvore.esq);
            posOrder(arvore.dir);
            System.out.println(arvore.data);
        }
    }

    @Override
    public void bfs() {
        LinkedList<ArvoreDeBuscaBinariaImpl<T>> fila = new LinkedList<>();

        fila.addFirst(this);

        while (!fila.isEmpty()) {
            var no = fila.getFirst();

            // Adicionar filhos
            if (no.esq != null)
                fila.addLast(no.esq);

            if (no.dir != null)
                fila.addLast(no.dir);

            // Consumir
            System.out.println(no.data);

            fila.removeFirst();
        }
    }
}
