package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm implements Search {

    @Override
    public List<Integer> findOccurrences(String text, String pattern) {

        List<Integer> occurrences = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        if (n < m) {
            return occurrences;
        }

        int q = 101;  //Prime Number
        int d = 256;  //Range of characters
        int h = 1;    // d^(m-1)

        //Calculate h = d^(m-1)
        for (int i = 1; i < m; i++) {
            h = (h * d) % q;
        }

        int t = 0;  //hash value of text
        int p = 0;  //hash value of pattern

        for (int i = 0; i < m; i++) {
            t = (t * d + text.charAt(i)) % q;
            p = (p * d + pattern.charAt(i)) % q;
        }

        for (int i = 0; i < n - m; i++) {

            if (t == p) {
                if (compare(text, pattern, i)) {
                    occurrences.add(i);
                }
            }

            t = (t - text.charAt(i) * h); //Removing first element from hash value
            t = (t * d + text.charAt(i + m)) % q; //Adding the next value in hash

            if (t < 0) {
                t = t + q;
            }

        }

        //Checking for the last value;
        if (t == p) {
            if (compare(text, pattern, n - m)) {
                occurrences.add(n-m);
            }
        }

        return occurrences;
    }

    private boolean compare(String text, String pattern, int start) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != text.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }

}
