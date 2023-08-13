package ExceptionsNumberPhone;
public class BadFirstSecondSymbolInNumberException extends RuntimeException{
    private static String msg = "Введеный номер не соответсвет Росcийскому формату номера телефона";
    public BadFirstSecondSymbolInNumberException() {
        super(msg);
    }
}