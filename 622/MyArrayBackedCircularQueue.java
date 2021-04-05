class MyArrayBackedCircularQueue {
    
    final int[] queue;
    int rear;
    int front;
    int size;
    
    public MyArrayBackedCircularQueue(int k) {
        queue = new int[k];
        rear = -1;
        front = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear+1) % queue.length; 
        queue[rear] = value;
        if (front == -1) {
            front = 0;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front+1) % queue.length; 
        size--;
        if (size == 0) {
            rear = -1;
            front = -1;
        }
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */