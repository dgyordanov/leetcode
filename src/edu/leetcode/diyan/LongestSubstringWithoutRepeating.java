package edu.leetcode.diyan;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Given a string s, find the length of the longest substring without repeating characters.
public class LongestSubstringWithoutRepeating {

    private Set<Set<Integer>> activeWords = new HashSet<>();
    private int result = 0;

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        s.chars().forEach(c -> {
            Iterator<Set<Integer>> activeWordsIterator = activeWords.iterator();
            while (activeWordsIterator.hasNext()) {
                Set<Integer> activeWord = activeWordsIterator.next();
                if (activeWord.contains(c)) {
                    // terminate all words in active words in case they contain the char
                    if (result < activeWord.size()) {
                        // this is the longest word so far
                        result = activeWord.size();
                    }
                    activeWordsIterator.remove();
                } else {
                    // the current char can be appended to activeWord
                    activeWord.add(c);
                }
            }

            // start a new word from this char on
            activeWords.add(new HashSet<Integer>(List.of(c)));
        });

        for (Set<Integer> activeWord: activeWords) {
            if (activeWord.size() > result) {
                result = activeWord.size();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        solution = new LongestSubstringWithoutRepeating();
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        solution = new LongestSubstringWithoutRepeating();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        solution = new LongestSubstringWithoutRepeating();
        System.out.println(solution.lengthOfLongestSubstring(" "));
        solution = new LongestSubstringWithoutRepeating();
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

}
