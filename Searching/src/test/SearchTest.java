package test;

import algorithm.RabinKarpAlgorithm;
import algorithm.Search;

import java.util.Arrays;
import java.util.List;

public class SearchTest {

    public static void main(String[] args) {

        Search search = new RabinKarpAlgorithm();

        System.out.println("First Test case");
        //Real World Scenario
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                " It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged." +
                " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum";

        String pattern = "Ipsum";
        int count = search.count(text, pattern);

        if (4 != count) {
            System.out.println("Search Failed");
        }
        System.out.println("Total occurrences : " + count);

        List<Integer> occurrences = search.findOccurrences(text, pattern);
        List<Integer> actualOccurrences = Arrays.asList(6, 81, 452, 568);

        for (int i = 0; i < occurrences.size(); i++) {

            if (actualOccurrences.get(i).intValue() == occurrences.get(i).intValue()) {
                System.out.println("Occurrence at index : " + occurrences.get(i));
            } else {
                System.out.println("Search Failed");
            }
        }


        System.out.println("Second Test case");
        //Complex Test Case
        String text1 = "ABABDABACDABABCABAB";
        String pattern1 = "ABABCABAB";

        List<Integer> l = search.findOccurrences(text1, pattern1);
        if (10 == l.get(0)) {
            System.out.println("Occurrence at index : " + l.get(0));
        } else {
            System.out.println("Search Failed");
        }
    }
}
