package algo;

public class MyCircularDeque {
    //data.
    final int[] array;
    //index position.
    int front = 0;
    int rear = 0;
    int currSize = 0;
    int maxSize = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array = new int[k];
        maxSize = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + maxSize) % maxSize;
        array[front] = value;
        currSize++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % maxSize;
        currSize++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % maxSize;
        currSize--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + maxSize) % maxSize;
        currSize--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(rear - 1 + maxSize) % maxSize];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return rear == front && currSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return rear == front && maxSize == currSize;
    }
}

