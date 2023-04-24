package Java_Home_Work.Second_home_work;

import java.util.Scanner;
import java.util.logging.*;

// 4) К калькулятору из предыдущего дз добавить логирование.
public class Task_4 {

    public static void main(String[] args) {
        calculator(true);
    }

    public static void calculator(boolean startCalculator) {
        Logger logger = Logger.getLogger(Task_4.class.getName());
        try {
            FileHandler fh = new FileHandler("./Java_Home_Work/Second_home_work/log_for_Task_4.txt");
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (startCalculator) {
            System.out.print("Введите 1 число: ");
            float firstNum = scan.nextFloat();

            System.out.print("Выберите действие ( / * - + ): ");
            String action = scan.next();

            System.out.print("Введите 2 число: ");
            float secondNum = scan.nextFloat();

            float res = 0;
            switch (action) {
                case "/":
                    if (secondNum == 0)
                        System.out.println("На ноль делить нельзя!");
                    else {
                        res = firstNum / secondNum;
                    }
                    break;
                case "*":
                    res = firstNum * secondNum;
                    break;
                case "-":
                    res = firstNum - secondNum;
                    break;
                case "+":
                    res = firstNum + secondNum;
                    break;
                default:
                    System.out.println("Вы ввели  не правильное действие!");
                    break;
            }
            logger.info(beautyShowNum(firstNum) + " " + action + " " + beautyShowNum(secondNum) + " = " + beautyShowNum(res));
            System.out.println(beautyShowNum(firstNum) + " " + action + " " + beautyShowNum(secondNum) + " = " + beautyShowNum(res));

            System.out.println("Закончить работу калькулятора?\n Нажмите \"1\" чтобы закончить, \"любая цифра\" чтобы продолжить. ");
            int job = scan.nextInt();
            if (job == 1) {
                startCalculator = false;
            }
            else{
                System.out.println("Хорошо, продолжаем");
            }
                
        }
    }

    public static String beautyShowNum(float d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

    public static String encoding() {
        String encoding = System.getProperty("console.encoding", "cp866");
        return encoding;
    }

    public static Scanner scan = new Scanner(System.in, encoding());

}
