package Task1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final String[] words = {"слово", "дом", "солнце", "книга", "вода", "ветер", "огонь", "земля", "время", "человек", "рука", "город", "день", "ночь", "жизнь", "мир", "голова", "ребенок", "сила", "конец", "вид", "река", "час", "путь", "дверь", "нога", "работа", "слово", "место", "лицо", "друг", "стол", "окно", "палец", "ночь", "голос", "мать", "сон", "море", "сторона", "дом", "отец", "проблема", "час", "правда", "квартира", "комната", "минута", "улица", "язык", "задача", "тетрадь", "солдат", "смерть", "рынок", "цвет", "небо", "свет", "воздух", "ответ", "автор", "образ", "закон", "орган", "бой", "театр", "вечер", "картина", "музыка", "история", "фильм", "поле", "цель", "письмо", "вкус", "память", "линия", "гора", "герой", "режим", "ветер", "огонь", "судьба", "дерево", "хлеб", "ученик", "сентябрь", "сомнение", "встреча", "кофе", "платье", "снег", "повод", "поезд", "форма", "собака", "семья", "состав", "число", "связь", "статья", "группа", "журнал", "зима", "лето", "осень", "весна"};
    private String word;
    private boolean[] char_state;
    private int health;
    private ArrayList<Character> old_chars;
    boolean stop_flag = false;

    String[] man_states = {
            "-----RIP------ \n" +
            "      |---|    \n" +
            "      0   |    \n" +
            "     /|\\  |   \n" +
            "      |   |    \n" +
            "     / \\  |   \n" +
            "          |    \n" +
            "  -----------  \n",

            "      |---|    \n" +
            "      0   |    \n" +
            "     /|\\  |   \n" +
            "      |   |    \n" +
            "     / \\  |   \n" +
            "     ===  |    \n" +
            "  ---|-|-----  \n",

            "      |---|    \n" +
            "          |    \n" +
            "      0   |    \n" +
            "     /|\\  |   \n" +
            "      |   |    \n" +
            "     / \\  |   \n" +
            "  -----------  \n",

            "      |---|    \n" +
            "          |    \n" +
            "          |   \n" +
            "          |    \n" +
            "          |   \n" +
            "          |    \n" +
            "  -----------  \n",

            "          |    \n" +
            "          |    \n" +
            "          |   \n" +
            "          |    \n" +
            "          |   \n" +
            "          |    \n" +
            "  -----------  \n",

            "               \n" +
            "               \n" +
            "               \n" +
            "          |    \n" +
            "          |    \n" +
            "          |    \n" +
            "  -----------  \n",

            "               \n" +
            "               \n" +
            "               \n" +
            "               \n" +
            "               \n" +
            "               \n" +
            "  -----------  \n"
    };

    Random random = new Random();

    public Game() {
        word = words[random.nextInt(0,100)];
        char_state = new boolean[word.length()];
        health = 6;
        old_chars = new ArrayList<Character>();
        System.out.println("---Добро пожаловать в игру \"Виселица\"---");
        System.out.println(getGameState());
    }

    public String getChar_state() {
        String res = "";
        for (boolean el : char_state){
            if (el) {
                res += "1";
            } else {
                res += "0";
            }
        }
        return res;
    }

    public String getOld_chars() {
        String res = "";
        for (char el : old_chars){
            res += el;
        }
        return res;
    }

    public String getMan_states() {
        return man_states[health];
    }

    public String getWord() {
        return word;
    }

    public int getHealth() {
        return health;
    }

    public void restart() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Хотите перезапустить(Д/Н)?");
        String input = scan.nextLine().toUpperCase();

        if (input.toUpperCase().contains("Д") || input.toUpperCase().contains("Y")) {
            System.out.println("\n\nПЕРЕЗАПУСК...\n");
            word = words[random.nextInt(0,100)];
            char_state = new boolean[word.length()];
            health = 6;
            old_chars = new ArrayList<Character>();
            System.out.println(getGameState());
        } else if (input.toUpperCase().contains("Н") || input.toUpperCase().contains("N")) {
            System.out.println("Хорошего дня. До встречи!");
            stop_flag = true;
        }
    }

    public void try_letter(char letter) {
        if (old_chars.contains(letter)) {
            System.out.println("Эта буква уже была((");
            return;
        }
        old_chars.add(letter);

        if (word.contains(Character.toString(letter))){
            for (int i = 0; i < word.length(); i++) {
                if (letter == word.charAt(i)) {
                    char_state[i] = true;
                }
            }
        } else {
            health -= 1;
        }

        System.out.println(getGameState());
        checkGameState();
    }

    public String getKnown(){
        String res = "";
        for (int i = 0; i < word.length(); i++){
            if (char_state[i]){
                res += word.charAt(i);
            } else {
                res += "_";
            }
        }
        return res;
    }

    public String getGameState() {

        String border = "----------------------------------------";
        String res = "";
        res += border + "\n";
        res += "Уже использовали: " + getOld_chars() + "\n";
        res += border + "\n";
        res += getMan_states() + "\n";
        res += border + "\n";
        res += "Здоровье: " + getHealth() + "\n";
        res += "Слово: " + getKnown().toUpperCase() + "\n";
        res += border + "\n";

        return res;
    }

    public void checkGameState() {
        boolean has_false = false;
        for (boolean el : char_state) {
            if (!el) {
                has_false = true;
                break;
            }
        }
        if (!has_false) {

            System.out.println(
                    "   /-------\\   \n" +
                    "   |  | |  |  \n" +
                    "   | \\___/ |  \n" +
                    "   \\-------/ \n" +
                    "       " +
                    "       "
            );    //смайлик дописать

            System.out.println("Господа, это победа))");
            restart();
        } else if (health == 0) {
            System.out.println("Проигрыш:(");
            restart();
        }
    }
}
