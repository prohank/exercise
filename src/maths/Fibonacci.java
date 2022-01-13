package maths;

public class Fibonacci {

    int doFibo(int limit) {
        if (limit == 0) return 1;
        return limit * doFibo(--limit);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.doFibo(4));
    }
}
