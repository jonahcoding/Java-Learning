### ArrayList

#### 概述

- ArrayList继承于AbstractList，实现了List接口，是顺序容器（元素存储顺序与放入顺序相同），允许存入null，底层由数组实现。
- 该容器容量不足时，自动扩容（底层是Object动态数组，可容纳任意类型）。
- 为追求效率未实现同步（Synchronized），默认不支持多线程并发访问，其余同Vector。

#### 底层数据结构

```java
transient Object[] elementData;//Object（动态）数组，transient修饰不需要序列化的属性（或对象）
private int size; // 大小
```

#### ArrayList的继承关系

```java'
java.lang.Object
   ↳     java.util.AbstractCollection<E>
         ↳     java.util.AbstractList<E>
               ↳     java.util.ArrayList<E>

public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {}
```

#### ArrayList与Collection关系

![](Java容器.assets/272343457973489.jpg)

#### 源码分析

1. 使用动态数组保存数据，使用默认构造时，其默认容量为10。
2. 通过ensureCapacity()扩容（内部调用grow方法）：新容量=原始容量+原始容量>>1。（Oracle JDK1.8）
3. ArrayList实现了java.io.Serializable，写入到输出流时，先读取容量，再依次读取每一个元素；当读出输入流时，先读取容量，再依次读取每一个元素。

#### fail-fast机制

expectedModCount初始值默认等于modCount，expectedModCount在整个迭代过程中除了赋予初始值modCount外，并未再发生改变。当ArrayList进行add，remove，clear等涉及到修改集合中的元素个数的操作时，modCount将发生改变(modCount ++)，所以当另一个线程（并发修改）或者同一个线程遍历过程中，调用相关方法使集合的元素个数发生改变，就会使modCount发生变化，在checkForComodification方法中抛出ConcurrentModificationException异常。 然而在使用迭代器遍历时可以通过迭代器的删除方法进行删除：迭代器执行remove操作时，重新赋值expectedModCount=modCount。

### LinkedList

#### 概述

- LinkedList同时实现了List接口与Deque接口，故既是顺序容器，又是队列。关于栈和队列，首选ArrayDeque，其性能优于LinkedList。
- 底层通过双向链表实现（双向链表的每个节点用内部类Node表示，LinkedList通过first和last引用分别指向链表的第一个和最后一个元素，链表为空时皆指向null）
- 为追求效率未实现同步（Synchronized），多线程并发访问时可使用Collections.synchronizedList()方法进行包装。

#### 底层数据结构

```java
transient int size = 0;
transient Node<E> first;
transient Node<E> last;
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
```

### HashMap

底层实现：数组+链表。（JDK1.7与JDK1.8中略有不同）

#### 底层结构（JDK1.7）

**成员变量**

1. 初始化桶大小，底层为数组，故该值为数组默认大小（1<<4，16）。
2. 桶最大值（1<<30）。
3. 默认负载因子（0.75f）。
4. map存放数量的大小。
5. 桶大小（构造时显式指定）。
6. 负载因子（构造时显式指定）。

Map在使用中数据数量达到了16*0.75=12后需要进行扩容，涉及rehash（重新哈希）、复制数据，十分消耗性能。HashMap通过内部类Entry保存数据。

**Entry**

```java
static class Entry<K,V> implements Map.Entry<K,V>{
    final K key;//键
    V value;//值
    Entry<K,V> next;//用于实现链表结构
    int hash;//当前key的hashcode
}
```

**put()**

```java
public V put(K key, V value) {
    if (table == EMPTY_TABLE) {
        inflateTable(threshold); //判断数组是否需要初始化
    }
    if (key == null)
        return putForNullKey(value); //判断key是否为空
    int hash = hash(key); //计算hashcode
    int i = indexFor(hash, table.length); //计算桶
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) { 
            //遍历判断链表中的key和hashcode是否相等，等就替换
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;
        }
    }
    modCount++;
    addEntry(hash, key, value, i); //没有就添加新的呗
    return null;
}
```

1. 判断当前数组是否需要初始化。
2. 如key为空，put空值。
3. 根据key计算hashcode。
4. 根据hashcode定位index的桶。
5. 如桶是链表，遍历判断hashcode、key是否与传入的相等，如相等则覆盖并返回原来的值。
6. 如桶为空，说明当前位置无数据，新增Entry对象存入即可。
7. 调用addEntry写入Entry时判断是否需要扩容，如需要：2倍扩容，当前key重新hash并定位。



1.7版本的缺点：























































