package ExceptionsDateOfBirth;

public class BadDayInDateException extends BadSymbolInDateException{
    private static String msg = "Введено неверное значение дня рождения(меньше нуля или больше 30)";
    public BadDayInDateException() {
        super(msg);
    }
}
