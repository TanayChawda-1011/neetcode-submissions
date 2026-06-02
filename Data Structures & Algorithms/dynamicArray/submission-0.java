class DynamicArray {
    private int capacity = 0;
    private int[] arr;
    private int length = 0;

    public DynamicArray(int capacity) {
        if(capacity > 0) {
            this.capacity = capacity;
            this.length = 0;
            arr = new int[this.capacity];
        }
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        if(i < this.capacity && i >= 0)
            arr[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        if(length >= 1) {
            length--;
        }
        return arr[this.length];
    }

    private void resize() {
        this.capacity *= 2;
        int[] newArr = new int[capacity];

        for(int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
