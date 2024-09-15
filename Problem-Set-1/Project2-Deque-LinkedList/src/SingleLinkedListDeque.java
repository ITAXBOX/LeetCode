import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.NoSuchElementException;

public class SingleLinkedListDeque<E> {
    private Node<E> head;
    private int size;
    private final int capacity;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    public SingleLinkedListDeque() {
        head = null;
        size = 0;
        capacity = Integer.MAX_VALUE;
    }

    public SingleLinkedListDeque(int capacity) {
        head = null;
        size = 0;
        this.capacity = capacity;
    }

    public SingleLinkedListDeque(Collection<E> c) {
        capacity = Integer.MAX_VALUE;
        addAll(c);
    }

    private Node<E> getRear() {
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public int getSize() {
        return size;
    }

    public boolean offer(E e) {
        if (size == capacity) {
            return false;
        }
        if (head == null) {
            head = new Node<>(e);
        } else {
            Node<E> temp = getRear();
            temp.next = new Node<>(e);
        }
        size++;
        return true;
    }

    public boolean offerFirst(E e) {
        if (size == capacity) {
            return false;
        }
        if (head == null) {
            head = new Node<>(e);
        } else {
            head = new Node<>(e, head);
        }
        size++;
        return true;
    }

    public boolean offerLast(E e) {
        return offer(e);
    }

    public E poll() {
        if (head == null) {
            return null;
        }
        E temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public E pollFirst() {
        return poll();
    }

    public E pollLast() {
        if (head == null) {
            return null;
        }
        if (size == 1) {
            E data = head.data;
            head = null;
            size--;
            return data;
        }
        Node<E> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        E data = temp.next.data;
        temp.next = null;
        size--;
        return data;
    }

    public E peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (head == null) {
            return null;
        }
        return getRear().data;
    }

    public void add(E data) {
        if (size == capacity) {
            throw new IllegalStateException("the Deque is full");
        }
        offer(data);
    }

    public void addAll(Collection<E> c) {
        for (E e : c) {
            add(e);
        }
    }

    public void addFirst(E e) {
        if (size == capacity) {
            throw new IllegalStateException("the Deque is full");
        }
        offerFirst(e);
    }

    public void addLast(E e) {
        if (size == capacity) {
            throw new IllegalStateException("the Deque is full");
        }
        offerLast(e);
    }

    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException("the Deque is empty");
        }
        return poll();
    }

    public E removeFirst() {
        return remove();
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("the Deque is empty");
        }
        return pollLast();
    }

    public E element() {
        if (size == 0) {
            throw new NoSuchElementException("the Deque is empty");
        }
        return peek();
    }

    public E getFirst() {
        return element();
    }

    public E getLast() {
        if (size == 0) {
            throw new NoSuchElementException("the Deque is empty");
        }
        return peekLast();
    }

    public void push(E e) {
        if (size == capacity) {
            throw new IllegalStateException("the Deque is full");
        }
        offerFirst(e);
    }

    public E pop() {
        return remove();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int remainingCapacity() {
        if (capacity == Integer.MAX_VALUE) {
            throw new IllegalStateException("the deque is not capacity-restricted");
        }
        return capacity - size;
    }

    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }
        Node<E> temp = head;
        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return true;
        }
        while (temp.next != null) {
            if (temp.next.data.equals(o)) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    public boolean removeLastOccurrence(Object o) {
        if (size == 0) {
            return false;
        }
        Node<E> temp = new Node<>(head.data, head);
        Node<E> remove = null;
        while (temp.next!= null) {
            if (temp.next.data.equals(o)) {
                remove = temp.next;
            }
            temp = temp.next;
        }
        if (remove != null) {
            removeNode(remove);
            return true;
        }
        return false;

    }

    private void removeNode(Node<E> remove) {
        if (remove == head) {
            remove();
        }
        Node<E> temp = head;
        while (temp.next != null) {
            if (temp.next == remove) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    public boolean removeAll(Collection<E> c) {
        if (size == 0) {
            return false;
        }
        int i = 0;
        for (E e : c) {
            if (remove(e)) {
                i++;
            }
        }
        if (i == 0)
            return false;
        return true;
    }

    public boolean retainAll(Collection<E> c) {
        if (size == 0) {
            return false;
        }
        int i = 0;
        Node<E> temp = head;
        while (temp != null) {
            if (!c.contains(temp.data)) {
                removeNode(temp);
            }
            temp = temp.next;
            i++;
        }
        if (i == 0)
            return false;
        return true;
    }

    boolean contains(Object o) {
        if (size == 0) {
            return false;
        }
        Node<E> temp = head;
        if (head.data.equals(o)) {
            return true;
        }
        while (temp.next != null) {
            if (temp.next.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean containsAll(Collection<E> c) {
        for (E e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        Node<E> temp = head;
        while (temp != null) {
            array[i] = temp.data;
            temp = temp.next;
            i++;
        }
        return array;
    }

    public void clear() {
        head = null;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Deque)) {
            return false;
        }
        Deque<E> deque = (Deque<E>) o;
        if (size != deque.size()) {
            return false;
        }
        Deque<E> dummy = new ArrayDeque<>(deque);
        Node<E> temp = head;
        while (temp != null) {
            if (temp.data != dummy.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    // Recursive
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        toString(head, sb);
        sb.append("]");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.data);
        toString(node.next, sb);
    }
}
