package Java_Home_Work.First_Home_Work;

import java.util.Scanner;


public class Task_3 {

    // Реализовать простой калькулятор
    public static void main(String[] args) {
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner scanner = new Scanner(System.in, encoding);
        System.out.print("Введите 1 число: ");
        float firstNum = scanner.nextFloat();
        System.out.print("Введите 2 число: ");
        float secondNum = scanner.nextFloat();
        System.out.print("Выберите действие ( / * - + ): ");
        String action = scanner.next();
        scanner.close();
        switch (action) {
            case "/":
                if (secondNum == 0)
                    System.out.println("На ноль делить нельзя!");
                else {
                    float res = firstNum / secondNum;
                    beautyShow(firstNum, secondNum, res, action);
                }
                break;
            case "*":
                float res2 = firstNum * secondNum;
                beautyShow(firstNum, secondNum, res2, action);
                break;
            case "-":
                float res3 = firstNum - secondNum;
                beautyShow(firstNum, secondNum, res3, action);
                break;
            case "+":
                float res4 = firstNum + secondNum;
                beautyShow(firstNum, secondNum, res4, action);
                break;
            default:
                System.out.println("Вы ввели что-то не правильное действие!");
                break;}
        
    }

    public static void beautyShow(float firstNum, float secondNum, float res, String action) {
        if (firstNum == (int) firstNum && secondNum == (int) secondNum && res == (int) res)
            System.out.printf("%d %s %d = %d", (int) firstNum, action, (int) secondNum, (int) res);

        else if (firstNum == (int) firstNum && secondNum != (int) secondNum)
            System.out.printf("%d %s %f = %.3f", (int) firstNum, action, secondNum, res);

        else if (firstNum != (int) firstNum && secondNum == (int) secondNum)
            System.out.printf("%f %s %d = %.3f", firstNum, action, (int) secondNum, res);

        else if (firstNum != (int) firstNum && secondNum != (int) secondNum)
            System.out.printf("%f %s %f = %.3f", firstNum, action, secondNum, res);

        else
            System.out.printf("%d %s %d = %.3f", (int) firstNum, action, (int) secondNum, res);
    }
}
