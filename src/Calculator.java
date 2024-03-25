import java.io.IOException;
import java.util.*;

public class Calculator {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String vvod = in.nextLine();
        System.out.println(calc(vvod));}

    public static String calc (String vvod) throws IOException {
        String result1 = null;
        String[] a = vvod.split(" ");
        int dlinaMassiva = a.length;
        if (dlinaMassiva!=3){
            throw new IOException("Ошибка ввода");
        }
        String a0 = a[0], a1 = a[1], a2 = a[2];
        char simvol1 = a0.charAt(0);
        char simvol2 = a2.charAt(0);
        if (Arrays.asList(roman).contains(a0)&&Arrays.asList(roman).contains(a2)||Arrays.asList(arab).contains(a0)&&Arrays.asList(arab).contains(a2)){
            if (Character.isDigit(simvol1)&&Arrays.asList(roman).contains(a2)||Character.isDigit(simvol2)&&Arrays.asList(roman).contains(a0)) {
                throw new IOException("Ошибка ввода");
            }
            if (Character.isDigit(simvol1)&&Character.isDigit(simvol2)) {
                int chislo1 = Integer.parseInt(a0), chislo2 = Integer.parseInt(a2);
                if (chislo1 <= 0 || chislo1 > 10 || chislo2 <= 0 || chislo2 > 10) {
                    throw new IOException("Число вне диапазона от 1 до 10");
                }
                int result = raschet(chislo1, chislo2, a1);
                result1 = Integer.toString(result);
            } else if (Arrays.asList(roman).contains(a0)&&Arrays.asList(roman).contains(a2)){
                int chislo1 = Arrays.asList(roman).indexOf(a0);
                int chislo2 = Arrays.asList(roman).indexOf(a2);
                if (chislo1 <= 0 || chislo1 > 10 || chislo2 <= 0 || chislo2 > 10) {
                    throw new IOException("Число вне диапазона от I до X");
                }
                int result = raschet(chislo1, chislo2, a1);
                if (result<1) {
                    throw new IOException("В римской системе нет отрицательных чисел");
                }
                result1 = roman[result];
            }
        }else {throw new IOException("Ошика ввода");}
        return result1;
    }
    static String[] roman = new String []{
            "0", "I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    static String[] arab = new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };
    public static int raschet (int chislo1, int chislo2, String a1) throws IOException {
        int result = 0;
        switch (a1) {
            case "+":
                result = chislo1 + chislo2;
                break;
            case "-":
                result = chislo1 - chislo2;
                break;
            case "*":
                result = chislo1 * chislo2;
                break;
            case "/":
                result = chislo1 / chislo2;
                break;
            default:
                throw new IOException("Неверный знак операции");
        }
        return result;
    }
}

