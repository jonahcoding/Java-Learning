package DynamicArray;

public class DynamicArray<E> {
    private E[] data;
    private int capacity = 16;
    private int size = 0;

    //无参构造
    public DynamicArray(){
        data = (E[])new Object[capacity];
    }
    //有参构造（参数为数组初始化容量）
    public DynamicArray(int initCapacity){
        this.capacity = initCapacity;
        data = (E[])new Object[capacity];
    }
    //获取数组大小
    public int getSize(){
        return size;
    }
    //获取数组容量
    public int getCapacity(){
        return capacity;
    }
    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //动态扩（缩）容
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
    }
    //按索引添加元素
    public void add(int index, E e) throws IllegalAccessException {
        if (index < 0 || index > size){
            throw new IllegalAccessException("添加数据失败，索引越界！" + " 当前有效索引为：0 ~ " + getSize());
        }

        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;

        if (size >= capacity*3/4){
            resize(capacity*2);
        }
    }
    //添加首元素
    public void addFirst(E e) throws IllegalAccessException {
        add(0, e);
    }
    //添加尾元素
    public void addLast(E e) throws IllegalAccessException {
        add(size, e);
    }
    //按索引移除元素
    public void remove(int index) throws IllegalAccessException {
        if (index < 0 || index >= size){
            throw new IllegalAccessException("删除数据失败，索引越界！" + " 当前有效索引为：0 ~ " + getSize());
        }
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if (size <= capacity*1/4){
            resize(capacity/2);
        }
    }
    //移除首元素
    public void removeFirst() throws IllegalAccessException {

        remove(0);
    }
    //移除尾元素
    public void removeLast() throws IllegalAccessException {
        remove(size-1);
    }
    //移除指定元素
    public void removeElement(E e) throws IllegalAccessException {
        int index = indexOf(e);
        System.out.println(index);
        if (index != -1){
            remove(index);
        }
    }
    //按索引获取元素
    public E get(int index) throws IllegalAccessException {
        if (index < 0 || index >= size){
            throw new IllegalAccessException("获取数据失败，索引越界！" + " 当前有效索引为：0 ~ " + getSize());
        }
        return data[index];
    }
    //获取首元素
    public E getFirst() throws IllegalAccessException {
        return get(0);
    }
    //获取尾元素
    public E getLast() throws IllegalAccessException {
        return get(size-1);
    }
    //按索引设值
    public void set(int index, E e) throws IllegalAccessException {
        if (index < 0 || index >= size){
            throw new IllegalAccessException("设置数据失败，索引越界！" + " 当前有效索引为：0 ~ " + getSize());
        }
        data[index] = e;
    }
    //判断是否包含某个元素
    public boolean isContains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //获取指定元素的索引
    public int indexOf(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //重写toString方法
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d, capacity = %d\n", size, capacity));
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size-1){
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
