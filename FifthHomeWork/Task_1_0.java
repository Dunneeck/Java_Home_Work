package Java_Home_Work.FifthHomeWork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Task_1_0 {
    // 1) Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    // человек может иметь несколько телефонов.


    public static Scanner scan = new Scanner(System.in, encoding());

    public static String encoding() {
        String encoding = System.getProperty("console.encoding", "cp866");
        return encoding;
    }

    public static void main(String[] args) {
        HashMap<String, LinkedList<Integer>> phoneBook = new HashMap<>();

        while (true) {
            System.out.println("end - чтобы прекратить");
            System.out.println("Введите имя: ");
            String name = scan.next();
            if(name.equals("end")) break;
            addData(phoneBook, name);
        }
        System.out.println(phoneBook);
    }

    public static void addData(HashMap<String, LinkedList<Integer>> phoneBook, String name) {
        if (phoneBook.containsKey(name.toLowerCase())) {
            LinkedList<Integer> allPhoneNumber = phoneBook.get(name);
            allPhoneNumber.add(addPhoneNumber(name));
        } else {
            phoneBook.put(name, new LinkedList<Integer>());
            LinkedList<Integer> allPhoneNumber = phoneBook.get(name);
            allPhoneNumber.add(addPhoneNumber(name));
        }
    }
    public static Integer addPhoneNumber(String name) {
        System.out.println("Введите номер для " + name);
            int phone = scan.nextInt();
        return phone;
    }
}
