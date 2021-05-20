package date.iterator.tools.sort;

public class ShellSort<T extends Comparable<T>> {
    private int[] stepSequence = null;
    private final T[] input;

    public ShellSort(T[] input) {
        stepSequence = sedgewick(20);
        this.input = input;
    }

    public void initSequence(SequenceType type, int sequenceLength) {
        switch (type){
            case sedgewick:
            default:
                stepSequence = sedgewick(sequenceLength);
                break;
            case prime:
                stepSequence = prime(sequenceLength);
                break;
            case ps:
                stepSequence = ps(sequenceLength);
                break;
        }
    }

    public void sort() {

    }

    /*
    * The length of the output sequence will be the length of the input sequence
     */
    public static int[] sedgewick(final int length) {
        int[] result = new int[length];
        for (int i = 0; 2*i < length; i++) {
            // 4 * 2²ⁱ + 3 * 2ⁱ + 1
            // result[i] = (int)(4 * Math.pow(4, i) - 3 * Math.pow(2, i) + 1);
            // 9×4ⁱ-9×2ⁱ+1    4ⁱ-3×2ⁱ+1
            result[2*i] = (int)(9 * Math.pow(4, i) - 9 * Math.pow(2, i) + 1);
            if (2*i+1 < length) {
                result[2 * i + 1] = (int) (Math.pow(4, i + 2) - 3 * Math.pow(2, i + 2) + 1);
            }
        }
        return result;
    }

    // Hibbard
    public static int[] ps(final int length) {
        //2ᵏ - 1
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int)(Math.pow(2, i+1) - 1);
        }
        return result;
    }

    public static int[] prime(final int length){
        int[] result = new int[length];
        result[0] = 1;
        result[1] = 2;
        if (length < 3) {
            return result;
        }
        result[2] = 3;
        int i = 2;
        int current = 5;
        while (i < length - 1){
            boolean exactly = false;
            int sub = 20;
            if (current > sub) {
                // when the current value is greater than a certain number, only the number less than its square root is tested
                sub = (int) Math.floor(Math.sqrt(current));
            }
            for (int j = 1; j < i; j++) {
                if (sub < result[j]) {
                    break;
                }
                if (divideExactly(current, result[j])) {
                    exactly = true;
                    break;
                }
            }

            if (!exactly) {
                result[++i] = current;
            }
            current += 2;
        }
        return result;
    }

    private static boolean divideExactly(int dividend, int divisor) {
        return dividend % divisor == 0;
    }
}

enum SequenceType {
    sedgewick,
    ps,
    prime
}
