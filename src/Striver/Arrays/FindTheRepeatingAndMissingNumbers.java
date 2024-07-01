package Striver.Arrays;

public class FindTheRepeatingAndMissingNumbers {
    public static int[] findMissingRepeatingNumbersBySum(int[] a) {
        long n = a.length; // size of the array
        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long) a[i] * (long) a[i];
        }

        //S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = {(int) x, (int) y};
        return ans;
    }

    public static int[] findMissingRepeatingNumbersByXOR(int[] a) {
        int n = a.length;
        int S = 0, Sn = 0;
        for (int i = 0; i < n; i++) {
            S ^= a[i];
            Sn ^= (i + 1);
        }

        int xor = S ^ Sn;
        int setBit = 1;
        while ((xor & 1) == 0) {
            setBit <<= 1;
            xor >>= 1;
        }
        System.out.println("setbit = " + setBit);
//        int setBit = xor & ~(xor - 1);
        int x = 0, y = 0;
        for (int i = 0; i < n; ++i) {
            if ((setBit & a[i]) != 0) {
                x = x ^a[i];
            } else {
                y = y ^ a[i];
            }

            int j = i + 1;
            if ((setBit & j) != 0) {
                x = x ^j;
            } else {
                y = y ^ j;
            }
        }
        System.out.println("x = " + x + " y = " + y);
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                flag = 1;
                break;
            }
        }
        int[] ans;
        if (flag == 1) {
            ans = new int[]{x, y};
        } else {
            ans = new int[]{y, x};
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] a = {4, 3, 6, 2, 1, 1};
        int[] ans = findMissingRepeatingNumbersBySum(a);
        System.out.println("Missing Number: " + ans[0] + " Repeating Number: " + ans[1]);
        ans = findMissingRepeatingNumbersByXOR(a);
        System.out.println("Missing Number: " + ans[0] + " Repeating Number: " + ans[1]);
    }
}
