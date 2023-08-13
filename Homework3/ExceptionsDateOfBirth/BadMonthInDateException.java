package ExceptionsDateOfBirth;

public class BadMonthInDateException extends BadSymbolInDateException{
    private static String msg = "Введено неверное значение месяца рождения(меньше нуля или больше 12)";
    public BadMonthInDateException() {
        super(msg);
    }
}
