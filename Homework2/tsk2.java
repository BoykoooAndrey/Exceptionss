public class tsk2 {
    public static void main(String[] args) {
        try {
            int d = 0;
            int[] intArray = new int[8];
            double catchedRes1 = intArray.length / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
         }
           
    }
}
