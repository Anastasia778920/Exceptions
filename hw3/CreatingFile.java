package hw3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreatingFile {
    public static void creatingFile(String text, Object userData) {
        boolean indicatorFile = false;
        String str = "";
        if (Files.exists(Path.of(userData + ".txt"))) {
            str = readFile(userData);
            if (!str.contains(text)) {
                indicatorFile = true;
                writerFile(userData, text, indicatorFile);
                System.out.println("Данные успешно добавлены");
            } else {
                System.out.println("Данные существуют");
            }
        } else {
            writerFile(userData, text, indicatorFile);
            System.out.println("Файл " + userData + ".txt успешно создан");
        }
    }

    public static String readFile(Object userData) {
        try (FileReader reader = new FileReader(userData + ".txt")) {
            int c;
            StringBuilder str = new StringBuilder();
            while ((c = reader.read()) != -1) {
                str.append((char) c);
            }
            return str.toString();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла " + e);
        }
    }

    public static void writerFile(Object userData, String text, boolean indicator) {
        try (FileWriter writer = new FileWriter(userData + ".txt", indicator)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла" + e);
        }
    }
}
