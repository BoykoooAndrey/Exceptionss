package ExceptionsDateOfBirth;

public class BadYearInDateException extends NumberFormatException{
    private static String msg = "Введено неверное значение года рождения(меньше 1900 или больше 2022)";
    public BadYearInDateException() {
        super(msg);
    }

}
