package Java_Home_Work.First_Home_Work;
import java.util.Scanner;




public class Task_1 {

    // Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    public static void main(String[] args) {
        int value = yourNum("Введите целое число больше 0, но меньше 28", 1, 28);
        printAllTriangularNumber(value,true);
        triangularNumber(value,true); 
        multiplicationResult(value,true);
    }
    /**
     * Произведение чисел
     * @param num - до какого числа считать
     * @param info - показ. тексковый ответ
     */
    public static void multiplicationResult(int num, boolean info) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        if(info) System.out.printf("Произведение чисел от 1 до  %d будет %d\n", (int)num, (int)res);
    }
    /**
     * показ. все числа треугольного числа
     * @param num - до какого числа считать
     * @param info - показ. тексковый ответ
     */
    public static void printAllTriangularNumber(int num, boolean info) {
        int res = 0;
        if(info) System.out.printf("Ваши треугольные числа от 1 до %d\n", num);

        for (int i = 1; i <= num ; i++) {
                res += i;
            System.out.print(res + " ");   
        }
        System.out.println();
    }
    /**
     * показ. посл. число тр. числа
     * @param num - до какого числа считать
     * @param info - показ. тексковый ответ
     */
    public static void triangularNumber(float num, boolean info) {
        float res = num / 2 *(num + 1);
        if(info) System.out.printf("Сумма чисел от 1 до  %d будет %d\n", (int)num, (int)res);        
    }
    /**
     * проверяет попало ли число в заданный жиапозон
     * @param value - проверка числа
     * @param from - диапазон от
     * @param to - диапозон до
     * @return - возвращ. true or false
     */
    public static boolean conditionRangeFromTo(int value, int from, int to) {
        boolean res = value > from && value < to ? true : false;
        return res;
    }
    /**
     * запрос числа от пользователя с проверкой 
     * @param text - указания для пользователя
     * @param from - диапазон от
     * @param to - диапозон до
     * @return - возвращ. число
     */
    public static int yourNum(String text, int from, int to) {
        while(true){
            String encoding = System.getProperty("console.encoding", "cp866");
            Scanner iScanner = new Scanner(System.in, encoding);
            System.out.printf("%s: ", text);
            int num = iScanner.nextInt();          
            if(conditionRangeFromTo(num, from, to)){
                iScanner.close();
                return num;
            } 
            else{
                System.out.println("Вы ввели не то значение, попробуйте снова!");
                iScanner.close();
            } 
        }
    }
}
