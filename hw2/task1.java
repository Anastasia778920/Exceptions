package hw2;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        setNumber();

    }

    public static void setNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число: ");
        String numb = scanner.nextLine();
        try {
            float number = Float.parseFloat(numb);
            System.out.println("Вы ввели: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не дробное число!");
            setNumber();
        }
        scanner.close();

    }
}
