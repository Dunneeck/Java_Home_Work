package Java_Home_Work.Second_home_work;


import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;

// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Task_2{
    public static void main(String[] args) {
        int[] arr = getArray(15, -100, 100);
        System.out.println("Массив до изменения\n"+Arrays.toString(arr));
        int[] newArr = bubbleSort(arr);
        System.out.println("Массив после изменения\n" + Arrays.toString(newArr));

    }

    public static int[] bubbleSort(int[] arr) {
        
        Logger logger = Logger.getLogger(Task_2.class.getName());
        try {
            FileHandler fh = new FileHandler("./Java_Home_Work/Second_home_work/log_for_Task_2.txt");
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
                logger.info(Arrays.toString(arr));
            }
        }


        return arr;
    }
    public static int[] getArray(int range, int from, int to) {
        int[] arr = new int[range];
        Random rnd = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(from,to);
        }

        return arr;
    }
}