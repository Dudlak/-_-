package Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();
        Scanner scan = new Scanner(System.in);
        String input;
        int size;

        System.out.println("Команды: генерировать(+), старые пароли, очистить, настройки, выход ");


        while (true){
            System.out.print("Введите команду: ");
            input = scan.nextLine();
            switch (input){
                case "генерировать", "+":
                    System.out.print("Введите размер пароля(8-12): ");
                    size = scan.nextInt();
                    scan.nextLine(); //сброс
                    if (size >= 8 && size <= 12) {
                        generator.generate(size);
                        System.out.println("Новый пароль: " + generator.getPassword());
                    } else {
                        System.out.println("Пароль должен быть от 8 до 12 символов длиной!");
                        break;
                    }
                    break;

                case "старые пароли":
                    System.out.println("Старые пароли:\n\t" + generator.getOldPasswords());
                    break;

                case "очистить":
                    generator.clearOldPasswords();
                    System.out.println("Список паролей очищен.");
                    break;

                case "настройки":
                    boolean chars = true, up_chars = true, numbers = true, special = true;
                    System.out.println("Отвечайте Д/Н: \n\tХотите использовать:");

                    System.out.print("\tСтрочные буквы? ");
                    input = scan.nextLine().toUpperCase();
                    if (input.equals("Н") || input.equals("N")) {
                        chars = false;
                    } else if (!(input.equals("Д") || input.equals("Y"))) {
                        System.out.println("Неверный ввод(установленно \"Д\")");
                    }

                    System.out.print("\tЗаглавные буквы? ");
                    input = scan.nextLine().toUpperCase();
                    if (input.equals("Н") || input.equals("N")) {
                        up_chars = false;
                    } else if (!(input.equals("Д") || input.equals("Y"))) {
                        System.out.println("Неверный ввод(установленно \"Д\")");
                    }

                    System.out.print("\tЦифры? ");
                    input = scan.nextLine().toUpperCase();
                    if (input.equals("Н") || input.equals("N")) {
                        numbers = false;
                    } else if (!(input.equals("Д") || input.equals("Y"))) {
                        System.out.println("Неверный ввод(установленно \"Д\")");
                    }

                    System.out.print("\tСпециальные символы? ");
                    input = scan.nextLine().toUpperCase();
                    if (input.equals("Н") || input.equals("N")) {
                        special = false;
                    } else if (!(input.equals("Y") || input.equals("Д"))) {
                        System.out.println("Неверный ввод(установленно \"Д\")");
                    }

                    generator.setSettings(chars, up_chars, numbers, special);
                    System.out.println("Новые параметры установленны.");

                    break;

                case "выход":
                    System.out.println("Хорошего дня!");
                    return;
            }
        }

    }
}
