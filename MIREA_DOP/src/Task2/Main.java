package Task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        double value;
        String tag;
        String[] tag_types = {"USD", "EUR", "GBP", "JPY", "RUB", "CNY"};

        System.out.println("Курс для расчёта");
        getCourse(1, "USD");

        while (true) {
            System.out.print("Доступные валюты: ");
            for (String el : tag_types){
                System.out.print(el + " ");
            }
            System.out.println();
            System.out.print("Введите количество и валюту из доступных(example: 1 USD): ");
            value = scan.nextDouble();
            tag = scan.nextLine().trim().toUpperCase();

            boolean hasTag = false;
            for (String el : tag_types) {
                if (tag.equals(el)){
                    hasTag = true;
                    break;
                }
            }
            if (hasTag) {
                getCourse(value, tag);
            } else {
                System.out.println("Неверное наименование валюты...");
            }

            System.out.println(
                    "|------------------|| Продолжить(Д/Н)? ||------------------|");
            input = scan.nextLine().toUpperCase();
            if (input.equals("Н") || input.equals("N")) {
                System.out.println("Хорошего дня!");
                break;
            } else if (input.equals("Д") || input.equals("Y")) {

            } else {
                System.out.println("Введено некорректное значение. Программа перезапущена.");
            }
        }

    }

    public static void getCourse(double start_value, String start_tag) {
        String border = "============================================================";
        int len = Double.toString(start_value).length() + start_tag.length() + 1;
        String space = " ".repeat(len);
        Map<String, Double> course = new HashMap<>();

        course.put("USD", 1.0);
        course.put("EUR", 0.92);
        course.put("GBP", 0.79);
        course.put("JPY", 148.5);
        course.put("RUB", 91.8);
        course.put("CNY", 7.25);

        double USD_value = (start_value/course.getOrDefault(start_tag, 1.0));

        System.out.println(border);
        System.out.print(start_value + " " + start_tag + " | ");
        for (Map.Entry<String, Double> entry : course.entrySet()){
            if (!entry.getKey().equals(start_tag)) {
                System.out.println(entry.getValue() * USD_value + " " + entry.getKey());
                System.out.print(space + " | ");
            }

        }
        System.out.println("\n" + border);
    }


}