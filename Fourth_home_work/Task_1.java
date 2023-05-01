package Java_Home_Work.Fourth_home_work;

import java.util.Collections;
import java.util.LinkedList;

public class Task_1 {
    // 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        System.out.println("Было");
        System.out.println(list);
        
        Collections.reverse(list);
        System.out.println("Стало");
        System.out.println(list);
        
        LinkedList<String> newList = mySort(list);
        System.out.println("Новый список");
        System.out.println(newList);
        System.out.println("старый остался преждним");
        System.out.println(list);

    }

    public static LinkedList<String> mySort(LinkedList<String> list) {
        LinkedList<String> newList = new LinkedList<>();
        int lastEl = list.size() - 1;
        for (int i = lastEl; i >= 0; i--) {
            newList.add(list.get(i)) ;

        }
        return newList;
    }
}
