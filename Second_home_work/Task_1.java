package Java_Home_Work.Second_home_work;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

// 1) Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” …
public class Task_1 {

    public static void main(String[] args) {
        String request = "select * from students where ";
        String data = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Soligorsk\", \"age\":\"null\"}";
        StringBuilder where = getRequest(data, request);
        System.out.println("Решение строками");
        System.out.printf("%s", where);

        System.out.println("\nРешение с json файлом    (я не понимаю почему тут Ivanov выводится последним, хотя должен быть первым)");
        System.out.println(getPersonData("./Java_Home_Work/Second_home_work/PersonDataForTask_1.json"));

    }

    public static StringBuilder getPersonData(String path) {
        JSONParser parser = new JSONParser();
        StringBuilder sb = new StringBuilder("select * from students where ");
        try {
            Object file = parser.parse(new FileReader(path));// распарсил файл в объект
            JSONObject jsonString = (JSONObject) file; // записал строку файла в переменную JSONObject

            int keysCount = jsonString.keySet().size() - 1; // количество ключей в строке json

            for (Object key : jsonString.keySet()) {  // перебираю ключи строки json
                if ((String) jsonString.get(key) != null) { // если значение ключа не нулл, то идёт запись в StringBuilder  
                    sb.append("\"" + key.toString() + "\"" + " = " + "\"" + (String) jsonString.get(key) + "\""); // запись в StringBuilder
                    if (keysCount-- == 1) // проверка, чтобы в конце не было " and "
                        return sb;
                    sb.append(" and ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static StringBuilder getRequest(String str, String request) {
        str = str.replaceAll("[{|}|,]", "").replace(":", " ");
        String[] checkNull = str.split(" ");
        int rangeCheckNull = checkNull.length;
        StringBuilder where = new StringBuilder(request);

        for (int i = 0; i < rangeCheckNull - 1; i++) {

            if (!checkNull[i + 1].contains("null")) {
                where.append(checkNull[i] + " = " + checkNull[i++ + 1] + " ");

            } else
                i++;
        }
        return where;
    }
}
