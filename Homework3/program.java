import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ExceptionsDateOfBirth.BadDayInDateException;
import ExceptionsDateOfBirth.BadMonthInDateException;
import ExceptionsDateOfBirth.BadSymbolInDateException;
import ExceptionsDateOfBirth.BadYearInDateException;
import ExceptionsNumberPhone.BadFirstSecondSymbolInNumberException;
import ExceptionsNumberPhone.BadLengthNumberException;

/**
 * program
 */
public class program {

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите данные пользователя");
            Map<String, String> dictionary = createDict();
            String filename = dictionary.get("FIO").split(" ")[0];
            try {
                FileWriter writer = new FileWriter(filename + ".txt", true);
                writer.write("<" + dictionary.get("FIO") + ">");
                writer.write("<" + dictionary.get("Number") + ">");
                writer.write("<" + dictionary.get("Date") + ">");
                writer.write("<" + dictionary.get("Gender") + ">");
                writer.write("\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String continued = Request("Добавить еще одного пользователя?(yes/no))").toLowerCase();
            if (continued.equals("no") ) {
                break;
            }        
        }
    }


    public static Map<String, String> createDict(){
        Map<String, String> dictionary = new HashMap<String, String>();
        while (dictionary.size() < 4) {
            String data = "";
            try {
                data = Request("Введите ФИО(через пробел), дату рождения в формате DD:MM:YYYY, номер телефона, без знаков и пробелов, пол f или m. Значения вводятся по отдельности: ");
                if (isGender(data)) {
                    dictionary.put("Gender", data);
                } else if (isFIO(data)) {
                    dictionary.put("FIO", data);
                } else if (isNumber(data)) {
                    dictionary.put("Number", data);
                } else if (isDateOfBirth(data)) {
                    dictionary.put("Date", data);
                }else{
                System.out.println("не удалось распознать значение");
            }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }

        }
        return dictionary;
    }

    public static String Request(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.printf(msg);
        String inputVal = sc.nextLine();
        if (inputVal.isEmpty()) {
            throw new RuntimeException("Строка пустая");
        }
        return inputVal;
    }

    private static boolean isGender(String inputDate) {
        if (inputDate.equals("f")  || inputDate.equals("m") ) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isFIO(String inputDate) {
        if (inputDate.split(" ").length == new String[2].length
                || inputDate.split(" ").length == new String[3].length) {
            return true;
        }
        return false;
    }

    private static boolean isDateOfBirth(String inputDate) {
        String[] arr = inputDate.split(":");
        if (arr.length != 3) {
            return false;
        }
        int day = 0;
        int month = 0;
        int year = 0;

        try {
            day = Integer.parseInt(arr[0]);
            month = Integer.parseInt(arr[1]);
            year = Integer.parseInt(arr[2]);
        } catch (NumberFormatException e) {
            new BadSymbolInDateException().printStackTrace();
            return false;
        }
        try {
            if (day < 0 || day > 31) {
                throw new BadDayInDateException();
            }
            if (month < 0 || month > 12) {
                throw new BadMonthInDateException();
            }
            if (year < 1900 || year > 2022) {
                throw new BadYearInDateException();
            }

        } catch (BadDayInDateException e) {
            e.printStackTrace();
            return false;
        } catch (BadMonthInDateException e) {
            e.printStackTrace();
            return false;
        } catch (BadYearInDateException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private static boolean isNumber(String inputDate) {
        try {
            long number = Long.parseLong(inputDate);
            if (inputDate.length() != 11) {
                throw new BadLengthNumberException();
            } else if (inputDate.charAt(0) != '7' || inputDate.charAt(1) != '9') {
                throw new BadFirstSecondSymbolInNumberException();
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (BadLengthNumberException e) {
            e.printStackTrace();
            return false;
        } catch (BadFirstSecondSymbolInNumberException e) {
            e.printStackTrace();
            return false;
        }
    }

}
