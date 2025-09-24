package Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scan = new Scanner(System.in);
        String alf = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        //добавить проверку на русские буквы
        while (!game.stop_flag){
            System.out.print("Введите букву: ");
            String value = scan.nextLine().toLowerCase();

            //выводит ответ по ключевому слову "админ" для проверки работы
            if (value.equals("админ")){
                System.out.println(game.getWord());
                System.out.print("Введите букву: ");
                value = scan.nextLine().toLowerCase();
            }
            if (value.length() == 1 && alf.contains(value)){
                game.try_letter(value.charAt(0));
            } else {
                System.out.println("Введите одну русскую букву...");
            }

        }

    }
}
