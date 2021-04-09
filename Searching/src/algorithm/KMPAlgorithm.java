package algorithm;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm implements Search {

    @Override
    public List<Integer> findOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        if (n < m) {
            return occurrences;
        }

        int[] lps = new int[m]; //Compute Longest prefix suffix array;
        preProcessLPS(pattern, lps);

        int i = 0;
        int j = 0;

        while(i<n){

            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else if(j>0){
                j = lps[j-1];
            }else{
                i++;
            }

            if(j==m){
                occurrences.add(i-j);
                j = lps[j-1];
            }
        }

        return occurrences;
    }


    private void preProcessLPS(String pattern, int[] lps) {

        int m = pattern.length();
        int i = 1;
        int j = 0;

        lps[0] = 0;

        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else if(j>0){
                j = lps[j-1];
            }else{
                i++;
            }
        }

    }
}
