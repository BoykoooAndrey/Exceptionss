import java.util.Arrays;

/**
 * program
 */
public class program {

    public static void main(String[] args) {
        int[] arr1 = new int[] {2,3,4,5,6};
        int[] arr2 = new int[] {3,4,5,6,7};
        int[] result1 = Calc(arr1,arr2,'-');
        System.out.println(Arrays.toString(result1));

        int[] arr3 = new int[] {-2,-3,-4,-5,-7};
        int[] result2 = Calc(arr1,arr3,'/');
        System.out.println(Arrays.toString(result2));
    }

    public static int[] Calc(int[] arr1, int[] arr2, char action){
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Один из переданных аргументов - null");
        }else if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы не одинаковой длинны");
        }
        int[] result = new int[arr1.length];
        if (action == '-') {
            result = Difference(arr1,arr2);
        }
        else if (action == '/') {
            result = Division(arr1,arr2);
        }
        else{
            throw new RuntimeException("Невозможно выполнить данное действие");
        }

        return result;
    }

    public static int[] Difference(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Один из переданных аргументов - null");
        }else if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы не одинаковой длинны");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static int[] Division(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Один из переданных аргументов - null");
        }else if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы не одинаковой длинны");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Число под индексом " + i + " во втором массиве это 0. Деление на ноль не возможно");
            }
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }
}
