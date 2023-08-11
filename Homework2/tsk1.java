import java.util.Scanner;

/**
 * tsk1
 */
public class tsk1 {

    public static void main(String[] args) {
        
        Float val = RequestFloat();
        if (val != null) {
            System.out.println(val);
        }else{
            System.out.println("Введено не правильное згначение");
        }
    }

    public static Float RequestFloat(){
        try {
            Float val = Float.valueOf(Request());
            return val;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не дробное число, попробуйте пожалуйста еще раз");
            try {
                Float val = Float.valueOf(Request());
                return val;
            } catch (NumberFormatException er) {
                System.out.println("Спасибо, но больше не нужно");
                return null;
            }
        }
        
    }
    public static String Request(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите дробное число: ");
        String inputVal = sc.nextLine();
        if (inputVal.isEmpty()) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
        return inputVal;

        
    }

}