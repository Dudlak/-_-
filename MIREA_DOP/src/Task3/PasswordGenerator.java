package Task3;

import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator {
    Random random = new Random();
    private final String chars = "abcdefghijklmnopqrstuvwxyz";
    private final String numbers = "0123456789";
    private final String special_chars = "!?@#$%^&*~`";

    private String alf = "";
    private String password;
    private ArrayList<String> oldPasswords = new ArrayList<>();

    public PasswordGenerator() {
        alf = chars + chars.toUpperCase() + numbers + special_chars;
    }


    public PasswordGenerator(boolean chars, boolean up_chars, boolean numbers, boolean special){
        if (chars) {
            alf += this.chars;
        }
        if (up_chars) {
            alf += this.chars.toUpperCase();
        }
        if (numbers) {
            alf += this.numbers;
        }
        if (special) {
            alf += special_chars;
        }
    }

    public void setSettings(boolean chars, boolean up_chars, boolean numbers, boolean special) {
        alf = "";
        if (chars) {
            alf += this.chars;
        }
        if (up_chars) {
            alf += this.chars.toUpperCase();
        }
        if (numbers) {
            alf += this.numbers;
        }
        if (special) {
            alf += special_chars;
        }
    }

    public void generate(int size) {
        password = "";
        for (int i = 0; i < size; i++){
            password += alf.charAt(random.nextInt(alf.length()));
        }
        oldPasswords.add(password);
    }

    public String getPassword() {
        return password;
    }

    public String getOldPasswords() {
        return String.join("\n\t", oldPasswords);
    }

    public void clearOldPasswords() {
        oldPasswords.clear();
    }

}
