package hw3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MessageHandler {

    private static Object[] userData;

    public static void arrayEnteredData(String[] arr) {
        int count = 0;
        if (userData.length != 6) {
            System.out.println("Вы ввели больше или меньше данных чем требуется, введите строку заново");
            count++;
        } else {
            if (!((String) userData[0]).matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Неверно введена фамилия, введите строку заново");
                count++;
            }
            if (!((String) userData[1]).matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Неверно введено имя, введите строку заново");
                count++;
            }
            if (!((String) userData[2]).matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Неверно введена отчество, введите строку заново");
                count++;
            }
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            try {
                df.parse((String) userData[3]);
            } catch (ParseException e) {
                System.out.println("Неверный формат даты, введите строку заново");
                count++;
            }
            try {
                Long.parseLong((String) userData[4]);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат телефона, введите строку заново");
                count++;
            }
            if (!((String) userData[5]).equalsIgnoreCase("f") && !userData[5].equalsIgnoreCase("m")) {
                System.out.println("Неверно введен пол, введите строку заново");
                count++;
            }
        }
        if (count == 0) {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < userData.length; i++) {
                if (i == userData.length - 1) {
                    text.append(userData[i]);
                } else {
                    text.append(userData[i]).append(" ");
                }
            }
            CreatingFile.creatingFile(text.toString(), userData[0]);
        }

    }

}
