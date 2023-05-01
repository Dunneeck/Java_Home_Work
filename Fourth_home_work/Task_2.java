package Java_Home_Work.Fourth_home_work;



import java.util.LinkedList;






public class Task_2 {
    // 2. Реализуйте очередь с помощью LinkedList со следующими методами:
    // • enqueue() — помещает элемент в конец очереди,
    // • dequeue() — возвращает первый элемент из очереди и удаляет его,
    // • first() — возвращает первый элемент из очереди, не удаляя.

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        // чуствую я что тут не правильно сделал дз. Лазил по сайтам, смотрел код методов с помощью f12 и нифига не понял как самому расписать эти методы...
        // если бы с массивами работал, enqueue() - создал массив на размер больше(на 1), перезаписал весь массив и в конец нужный элем.
        // dequeue() - на размер меньше, 0 элем не перезаписывал, а тупо в другую перем. 
        // first() - копировал 0 в перем.

        System.out.println(list);
        enqueue(list, "666");
        System.out.println(list);
        
        String el = dequeue(list);
        System.out.println(el);
        System.out.println(list);
        
        String el2 = first(list);
        System.out.println(el2);
        
        
    }
    

    public static void enqueue(LinkedList<String> list, String el) {
        // list.addLast(el);
        list.add(list.size(), el);
    }
    public static String dequeue( LinkedList<String> list) {
        // System.out.println(list.pollFirst());
        String el = list.get(0);
        list.remove(0);
        return el;
    }
    public static String first(LinkedList<String> list) {
        String el = list.get(0);
        return el;
    }
    
}

