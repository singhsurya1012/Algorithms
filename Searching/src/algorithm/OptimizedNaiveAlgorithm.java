package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Works only if pattern does not contain duplicate character
 */
public class OptimizedNaiveAlgorithm implements Search {

    @Override
    public List<Integer> findOccurrences(String text, String pattern) {

        List<Integer> occurrences = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        if (n < m) {
            return occurrences;
        }

        int i = 0;

        while (i <= n - m) {

            int j;
            for (j=0; j < m; j++) {

                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                occurrences.add(i);
                i= i+m;
            } else if (j > 0) {
                i = i + j;
            } else {
                i++;
            }

        }
        return occurrences;
    }
}
