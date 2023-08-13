package ExceptionsDateOfBirth;
public class BadSymbolInDateException extends NumberFormatException {
    private static String msg = "Введен неверный символ в дате рождения";
    public BadSymbolInDateException() {
        super(msg);
    }
    protected BadSymbolInDateException(String msg2) {
        super(msg2);
    }
}
