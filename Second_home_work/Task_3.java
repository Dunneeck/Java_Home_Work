package Java_Home_Work.Second_home_work;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;



// 3) ** (Для преподавателя: если не успели выполнить задание 7, 
// дать наводку из этого задания) Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.


public class Task_3 {
    public static void main(String[] args) {

        studentGrades("./Java_Home_Work/Second_home_work/personDataForTask_3.json");
    }

    public static void studentGrades(String path) {
        StringBuilder sb = new StringBuilder();
        JSONParser parser = new JSONParser();

        try {
            Object arr = parser.parse(new FileReader(path));

            JSONArray jsonArray = (JSONArray) arr;
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;
                String surname =  (String)jsonObject.get("surname");
                String grades = (String) jsonObject.get("grades");
                String lesson = (String) jsonObject.get("lesson");
                sb.append("Студент " + surname + " получил " + grades + " по предмету " + lesson + ".\n");
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
