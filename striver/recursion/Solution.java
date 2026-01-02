package striver.recursion;

class Solution {

    static void printName(int n, String name) {
        // Base case
        if (n == 0) return;

        // Work
        System.out.println(name);

        // Recursive call
        printName(n - 1, name);
    }

    public static void main(String[] args) {
        int n = 5;
        String name = "Shubham";

        printName(n, name);
    }
}
