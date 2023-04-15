package Java_Home_Work.First_Home_Work;

import java.util.Scanner;

public class Task_4 {
    // Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть
    // заменены знаком вопроса, например, 2? + ?5 = 69.
    // Требуется восстановить выражение до верного равенства. Предложить хотя бы
    // одно решение или сообщить, что его нет.

    public static void main(String[] args) {
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner scanner = new Scanner(System.in, encoding);
        System.out.println("Только 1 ? в числе!");
        System.out.print("Введите 1 число(примеры: 10, ?1, 1?, 1?1, ?11 и тд): ");
        String firstNum = scanner.nextLine();
        System.out.print("Введите 2 число(примеры: 10, ?1, 1?, 1?1, ?11 и тд): ");
        String secondNum = scanner.nextLine();
        System.out.printf("%s + %s равно: ", firstNum, secondNum);
        int res = scanner.nextInt();
        scanner.close();

        int num1Plus = plusValue(firstNum);    // нужны для определения по сколько добавлять к числу
        int num2Plus = plusValue(secondNum);   // единицы, десятки, сотни...

        firstNum = firstNum.replace("?", "0");
        secondNum = secondNum.replace("?", "0");

        int num1 = Integer.parseInt(firstNum);
        if (num1 < 10)
            num1 += 10;

        int num2 = Integer.parseInt(secondNum);
        if (num2 < 10)
            num2 += 10;

        boolean check = true;
        for (; num1 + num2 <= res; num1 += num1Plus) {
            for (int i = num2; i + num1 <= res; i += num2Plus) {
                if (num1 + i == res) {
                    System.out.printf("Возможный результат: %d + %d = %d\n", num1, i, res);
                    check = false;
                    return;
                }
            }
        }
        if (check)
            System.out.println("Результатов не нашлось!");
    }
    /**
     * определяет какую часть нужно сумировать ед., десятки, сотни...
     * @param value - число с ?
     * @return возвращает число
     */
    public static int plusValue(String value) {
        int res = 1;
        for (int i = value.length() - 1; i >= 0; i--) {
            if (value.charAt(i) == '?')
                return res;
            else
                res *= 10;
        }
        return res;
    }
}
