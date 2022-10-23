package data.structures;

public class FilaImpl<T> implements Fila<T> {

    private final T[] elements;
    private int front;
    private int rear;

    public FilaImpl(int size) {
        if (size <= 0) throw new RuntimeException("Tamanho inválido: " + size);
        this.elements = (T[]) new Object[size];
        this.front = -1; // Início
        this.rear = -1; // Fim
    }

    @Override
    public void enqueue(T data) {
        if (isFull()) throw new RuntimeException("Fila cheia");

        if (isEmpty()) {
            elements[++front] = data;
            rear++;
        } else {
            if (rear + 1 == size()) {
                rear = 0;
                elements[rear] = data;
            } else {
                elements[++rear] = data;
            }
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Fila vazia");

        System.out.println("front " + front);
        System.out.println("rear " + rear);

        if (front + 1 < size()) {
            T data = elements[front];
            elements[front++] = null;
            System.out.println("if dequeue " + front + " " + rear);
            return data;
        } else {
            front = 0;
            System.out.println("else dequeue");
            elements[size() - 1] = null;
            return elements[size() - 1];
        }
    }

    @Override
    public T front() {
        if (!isEmpty()) {
            return elements[front];
        }
        return null;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        int control = 0;
        for(T element : elements) {
            System.out.println("elemento " + element);
            if (element == null) control++;
        }

        if (control == size()) {
            front = -1;
            rear = -1;
        }

        return (front == -1) && (rear == -1);
    }

    @Override
    public boolean isFull() {
        return (front + 1) == size();
    }
}
