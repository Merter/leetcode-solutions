class MyLinkedListBackedCircularQueue {
    
    private static class QueueNode {
        int val;
        QueueNode next;
    }

    final int capacity;
    int size;
    QueueNode rear;
    
    public MyLinkedListBackedCircularQueue(int k) {
        capacity = k;
        size = 0;
        rear = null;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        final QueueNode enQueueNode = new QueueNode();
        enQueueNode.val = value;
        if (isEmpty()) {
            rear = enQueueNode;
            rear.next = rear;
        } else {
            final QueueNode temp = rear.next;
            rear.next = enQueueNode;
            enQueueNode.next = temp;
            rear = enQueueNode;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            rear = null;
        } else {
            final QueueNode temp = rear.next;
            rear.next = temp.next;
            temp.next = null;
        }
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : rear.next.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : rear.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
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
 