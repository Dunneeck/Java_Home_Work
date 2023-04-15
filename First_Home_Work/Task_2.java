package Java_Home_Work.First_Home_Work;

public class Task_2 {

    // Вывести все простые числа от 1 до 1000
    public static void main(String[] args) {
        int value =  Task_1.yourNum("Введите число от 1 до 1000", 1, 1000);
        simpleNumbers(value);
    }

    public static void simpleNumbers(int num) {
        for (int i = 2; i <= num; i++) {
            boolean check = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0)  {
                    check = false;
                    j = i;
                }
            }
            if(check) System.out.print(i + " ");
        }
    }
}
