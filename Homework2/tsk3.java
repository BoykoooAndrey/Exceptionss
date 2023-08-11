
public class tsk3 {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            if (b == 0) {
                throw new ArithmeticException("division by zero");
            }
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = new int[] { 1, 2, 9};

        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        } 
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}
