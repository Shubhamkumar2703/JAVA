import java.util.*;

public class solution {
    
    // Function to reverse a number
    public static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }

    public static int SpecialGadget(int Max_x, int Max_y, int W) {
        int[] rev = new int[Math.max(Max_x, Max_y) + 1];
        for (int i = 1; i < rev.length; i++) {
            rev[i] = reverse(i);
        }

        for (int D = 2; D <= Max_x + Max_y; D++) {
            int count = 0;
            int x_min = Math.max(1, D - Max_y);
            int x_max = Math.min(Max_x, D - 1);
            for (int x = x_min; x <= x_max; x++) {
                int y = D - x;
                if (y >= 1 && y <= Max_y) {
                    if ((long)x * y == (long)rev[x] * rev[y]) {
                        count++;
                        if (count >= W) return D; // Early exit
                    }
                }
            }
        }

        return -1; // Not enough special gadgets found
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Max_x = Integer.parseInt(scan.nextLine().trim());
        int Max_y = Integer.parseInt(scan.nextLine().trim());
        int W = Integer.parseInt(scan.nextLine().trim());

        int result = SpecialGadget(Max_x, Max_y, W);
        System.out.println(result);
    }
}