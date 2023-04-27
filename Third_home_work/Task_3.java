package Java_Home_Work.Third_home_work;

import java.util.ArrayList;
// import java.util.Collections;
import java.util.Random;

public class Task_3 {
    // Задан целочисленный список ArrayList. Найти минимальное, максимальное и
    // среднее из этого списка.

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        addNumsForList(nums);
        System.out.println(nums);
        showMaxMinAverageValue(nums);
        // можно без циклов, но тут не всегда среднее значение правильно)
        // Collections.sort(nums);      
        // System.out.println(
        //     "min = " + nums.get(0) +
        //     ", max = " + nums.get(nums.size() - 1) + 
        //     ", average = " + ( nums.get(0) + nums.get(nums.size() - 1) ) / 2
        // );
    }

    public static void showMaxMinAverageValue(ArrayList<Integer> nums) {
        int max = nums.get(0);
        int min = nums.get(0);
        // int min = Collections.min(nums);
        // int max = Collections.max(nums);
        for (Integer num : nums) {
            if(max < num) max = num;
            if(min > num) min = num;
        }
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);

        int average = (max + min) / 2;
        if(nums.contains(average))
        System.out.println("Average = " + average);
        else{
            int average1 = average + 1;
            int average2 = average - 1;

            while (true) {
                if(nums.contains(average1)){
                    System.out.println("Average = " + average1);
                    break;
                }
                else average1++;

                if(nums.contains(average2)){
                    System.out.println("Average = " + average2);
                    break;
                }
                else average2--;
            
            }
            
        }
    }
    public static void addNumsForList(ArrayList<Integer> list) {
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(rnd.nextInt(0, 30));
        }
    }
}
