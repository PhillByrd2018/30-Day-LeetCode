package Challenger;

//So in short f[i] = f[i/2] + i%2; very wonderful solution
public class CountingBits {

    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}