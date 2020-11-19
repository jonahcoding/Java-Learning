package DynamicArray;

public class DynamicArrayTest {

    public static void main(String[] args) throws IllegalAccessException {

        DynamicArray<Integer> arrayNoArgument = new DynamicArray<Integer>();
        System.out.println(arrayNoArgument.toString());

        DynamicArray<Integer> array = new DynamicArray<Integer>(4);
        System.out.println(array.toString());

        array.add(0,0);
        array.add(1,1);
        System.out.println(array.toString());

        array.add(2,2);
        System.out.println(array.toString());

        array.addFirst(-1);
        array.addLast(3);
        System.out.println(array.toString());

        System.out.println("索引为2的元素是：" + array.get(2));
        System.out.println("数组首元素是：" + array.getFirst());
        System.out.println("数组尾元素是：" + array.getLast());

        System.out.println("数组是否存在元素'1'：" + array.isContains(1));
        System.out.println("数组中'3'的索引是（-1表示元素不在数组中）：" + array.indexOf(4));

        array.removeElement(2);

        array.removeFirst();
        array.removeLast();
        System.out.println(array.toString());

        array.remove(1);

        System.out.println(array.toString());

    }
}
