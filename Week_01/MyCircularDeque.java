public class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    private int[] data;
    private int head; // head pointer
    private int tail; // tail pointer
    private int size; // current size of the deque
    private int capacity; // desinated capacity of the deque
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        data = new int[k];
        head = 0;
        tail = 0;
        size = 0;
        capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        head = (head + capacity - 1) % capacity;
        data[head] = value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[tail] = value;
        tail = (tail + 1 + capacity) % capacity;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1)% capacity;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return data[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return data[(tail-1+capacity)%capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (tail == head) && (size == 0);
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail == head) && (size == capacity);
    }
}