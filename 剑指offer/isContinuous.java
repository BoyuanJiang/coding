import java.util.Arrays;

public class isContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int zeros = 0;
        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0)
                zeros++;
            if (numbers[i] != 0 && numbers[i] == numbers[i + 1])
                return false;
            if (numbers[i] != 0 && numbers[i + 1] - numbers[i] != 1)
                count += numbers[i + 1] - numbers[i] - 1;
        }
        if (zeros == 4)
            return true;
        else if (count != zeros)
            return false;
        else return true;
    }

    public static void main(String[] args) {
        int[] array = {1, 0,0,0,0};
        isContinuous sol = new isContinuous();
        System.out.println(sol.isContinuous(array));
    }
}
