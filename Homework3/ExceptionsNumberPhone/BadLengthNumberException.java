package ExceptionsNumberPhone;
public class BadLengthNumberException extends RuntimeException{
    private static String msg = "Длина введенных данных не соответсвет Росcийскому формату номера";
    public BadLengthNumberException() {
        super(msg);
    }
}
