package algorithm;

import java.util.List;

public interface Search {

    default int count(String text, String pattern){
        return findOccurrences(text,pattern).size();
    };

    List<Integer> findOccurrences(String text, String pattern);

}
