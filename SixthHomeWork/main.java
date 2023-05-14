package Java_Home_Work.SixthHomeWork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    // Подумать над структурой класса Ноутбук для магазина техники — выделить поля и
    // методы. Реализовать в Java.
    // Создать множество ноутбуков.
    // Написать метод, который будет запрашивать у пользователя критерий (или
    // критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
    // Критерии фильтрации можно хранить в Map. Например:
    // “Введите цифру, соответствующую необходимому критерию:
    // 1 - ОЗУ
    // 2 - Объём ЖД
    // 3 - Операционная система
    // 4 - Цвет …
    // Далее нужно запросить минимальные и максимальные значения для указанных
    // критериев — сохранить параметры фильтрации можно также в Map.
    // Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
    // условиям.
    // Доп задание
    // Отсортировать ноутбуки получившегося множества. На выбор:
    // По возрастанию имени ноутбука в алфавитном порядке
    // По цене по убыванию
    public static void main(String[] args) {

        // System.out.println(notebooks);
        System.out.println("Все ноутбуки");
        for (Notebook n : notebooks) {
            n.printNotebookes(n);
        }
        getResult(getCriterias());

    }

    /**
     * Получаем нужные критерии в linkedlist
     * @return все критерии
     */
    public static LinkedList<Integer> getCriterias() {
        LinkedList<Integer> criterias = new LinkedList<>();
        int choise = getInt("Выберите критерий для показа:\n1 - ОЗУ\n2 - Объём ЖД\n3 - Операционная система\n4 - Цвет");
        criterias.add(choise);
        int i = 0;
        while (i < 3) {
            choise = getInt(
                    "Нужны дополнительные критерии?\n1 - ОЗУ\n2 - Объём ЖД\n3 - Операционная система\n4 - Цвет\n5 - Нет");
            if (choise == 5)
                i = 3;
            criterias.add(choise);
        }
        return criterias;
    }

    /**
     * сортирует и выводит ноуты которые надо надо по критериям
     * @param criterias сортировка по критериям
     */
    public static void getResult(LinkedList<Integer> criterias) {
        int min, max;
        for (int i = 0; i < criterias.size(); i++) {
            switch (criterias.get(i)) {
                case 1:
                    min = getInt("Введите мин диапазон ОЗУ от 4 до 32:");
                    max = getInt("Введите мах диапазон ОЗУ от 4 до 32:");
                    showNotebooks = getRamCriterias(min, max);
                     showResult();
                    break;
                case 2:
                    min = getInt("Введите мин диапазон памяти от 100 до 2000:");
                    max = getInt("Введите мах диапазон памяти от 100 до 2000:");
                    showNotebooks = getMemoriesCriterias(min, max);
                     showResult();
                    break;
                case 3:
                    System.out.println("Выберите систему: Windows, Linux");
                    String oS = scan.next();
                    showNotebooks = getOSCriteries(oS);
                      showResult();
                    break;
                case 4:
                    System.out.println("Выберите цвет: White, Black, grey");
                    String color = scan.next();
                    showNotebooks = getColorCriteries(color);
                      showResult();
                    break;

                default:
                    break;
            }
        }
    }

    /**
     * @param min  сортировка по мин значениям ОЗУ
     * @param max  сортировка по мах значениям ОЗУ
     * @return    отсортированные ноуты
     */
    public static HashSet<Notebook> getRamCriterias(int min, int max) {
        HashSet<Notebook> newNoteBooks = new HashSet<>();
        if (showNotebooks.isEmpty()) {
            for (Notebook notebook : notebooks) {
                if (notebook.ram >= min && notebook.ram <= max)
                    showNotebooks.add(notebook);
            }
            return showNotebooks;
        } else {
            for (Notebook notebook : notebooks) {
                if (notebook.ram >= min && notebook.ram <= max)
                    newNoteBooks.add(notebook);
            }
            return newNoteBooks;
        }
    }

    /**
     * @param min сортировка по мин значениям ПАМЯТИ
     * @param max сортировка по мах значениям ПАМЯТИ
     * @return    отсортированные ноуты
     */
    public static HashSet<Notebook> getMemoriesCriterias(int min, int max) {
        HashSet<Notebook> newNoteBooks = new HashSet<>();
        if (showNotebooks.isEmpty()) {
            for (Notebook notebook : notebooks) {
                if (notebook.memory >= min && notebook.memory <= max)
                    showNotebooks.add(notebook);
            }
            return showNotebooks;
        } else {
            for (Notebook notebook : notebooks) {
                if (notebook.memory >= min && notebook.memory <= max)
                    newNoteBooks.add(notebook);
            }
            return newNoteBooks;
        }
    }

    /**
     * @param osString добавляет ноут с только такой системой
     * @return  отсортированные ноуты
     */
    public static HashSet<Notebook> getOSCriteries(String osString) {
        HashSet<Notebook> newNoteBooks = new HashSet<>();
        if (showNotebooks.isEmpty()) {
            for (Notebook notebook : notebooks) {
                if (notebook.os.equals(osString))
                    showNotebooks.add(notebook);
            }
            return showNotebooks;
        } else {
            for (Notebook notebook : showNotebooks) {
                if (notebook.os.equals(osString))
                    newNoteBooks.add(notebook);
            }
            return newNoteBooks;
        }
    }

    /**
     * @param color добавляет ноут с только таким цветом
     * @return отсортированные ноуты
     */
    public static HashSet<Notebook> getColorCriteries(String color) {
        HashSet<Notebook> newNoteBooks = new HashSet<>();
        if (showNotebooks.isEmpty()) {
            for (Notebook notebook : notebooks) {
                if (notebook.color.equals(color))
                    newNoteBooks.add(notebook);
            }
            return showNotebooks;
        } else {
            for (Notebook notebook : showNotebooks) {
                if (notebook.color.equals(color))
                    newNoteBooks.add(notebook);
            }
            return newNoteBooks;
        }
    }

    /**
     * показывает рузультат отсортированных ноутов
     */
    public static void showResult() {
        for (Notebook n : showNotebooks) {
            n.printNotebookes(n);
        }
    }

    /**
     * @return создаёт множество ноутбуков
     */
    public static HashSet<Notebook> setsNotebook() {
        Notebook n1 = new Notebook("n1", 4, 100, "Windows", "White");
        Notebook n2 = new Notebook("n2", 4, 100, "Linux", "Black");
        Notebook n3 = new Notebook("n3", 4, 100, "Windows", "Black");
        Notebook n4 = new Notebook("n4", 8, 200, "Linux", "White");
        Notebook n5 = new Notebook("n5", 8, 200, "Linux", "Grey");
        Notebook n6 = new Notebook("n6", 16, 500, "Windows", "Grey");
        Notebook n7 = new Notebook("n7", 16, 500, "Windows", "White");
        Notebook n8 = new Notebook("n8", 16, 500, "Linux", "Grey");
        Notebook n9 = new Notebook("n9", 32, 1000, "Windows", "Black");
        Notebook n10 = new Notebook("n10", 32, 2000, "Windows", "White");
        HashSet<Notebook> notebooks = new HashSet<>(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10));
        return notebooks;
    }

    /**
     * показывает ноуты отсортированных п окритериям
     */
    public static HashSet<Notebook> showNotebooks = new HashSet<>();
    /**
     * все ноутбуки что есть
     */
    public static HashSet<Notebook> notebooks = setsNotebook();

    public static String encoding = System.getProperty("console.encoding", "cp866");
    public static Scanner scan = new Scanner(System.in, encoding);

    public static int getInt(String text) {
        System.out.println(text);
        return scan.nextInt();
    }
}
