package data.structures;

public class PilhaImpl<T> implements Pilha<T>{

    // Usa vetor de Objetos pois a classe é generica (T)
    private final T[] elements;
    private int pos; // Posição na pilha onde vai armazenar

    public PilhaImpl(int size) {
        if (size <= 0) throw new RuntimeException("Tamanho inválido: " + size);
        this.elements = (T[]) new Object[size];
        this.pos = -1;
    }

    @Override
    public void push(T data) {
        if (!isFull()) {
            elements[++pos] = data;
        } else {
            throw new RuntimeException("Pilha cheia");
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return elements[pos--];
        } else {
            throw new RuntimeException("Pilha vazia");
        }
    }

    @Override
    public T top() {
        if (!isEmpty()) {
            return elements[pos];
        }
        return null;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return pos < 0;
    }

    @Override
    public boolean isFull() {
        return (pos + 1) == size();
    }
}
