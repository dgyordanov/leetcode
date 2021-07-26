package edu.leetcode.diyan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        List<List<String>> result = solution.findLadders(
                "hot",
                "dog",
                Arrays.asList("hot", "dog", "dot")
        );
        System.out.println(result);
    }

    private List<List<String>> allSolutions = new LinkedList<>();
    private List<String> currentSolution = new LinkedList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        currentSolution.add(beginWord);
        findNextWords(beginWord, endWord, wordList);
        return allSolutions;
    }

    private void findNextWords(String currentWord, String endWord, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (currentSolutionNotTooLong()
                    && !currentSolution.contains(wordList.get(i))
                    && differSingleLetter(currentWord, wordList.get(i))) {
                currentSolution.add(wordList.get(i));
                if (endWord.equals(wordList.get(i))) {
                    appendSolution(new ArrayList<>(currentSolution));
                } else {
                    findNextWords(wordList.get(i), endWord, wordList);
                }
                currentSolution.remove(currentSolution.size() - 1);
            }
        }
    }

    private boolean currentSolutionNotTooLong() {
        if (allSolutions.isEmpty()) {
            return true;
        }
        return getCurrentSolutionsSize() > currentSolution.size();
    }

    private void appendSolution(ArrayList<String> solution) {
        if (allSolutions.isEmpty()) {
            allSolutions.add(solution);
        } else if (getCurrentSolutionsSize() == solution.size()) {
            allSolutions.add(solution);
        } else if (getCurrentSolutionsSize() > solution.size()) {
            allSolutions.clear();
            allSolutions.add(solution);
        }
    }

    private int getCurrentSolutionsSize() {
        if (allSolutions.isEmpty()) {
            return 0;
        } else {
            return allSolutions.get(0).size();
        }
    }

    private boolean differSingleLetter(String firstWord, String secondWord) {
        int differentLetters = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i))
                differentLetters++;
        }
        return differentLetters == 1;
    }
}
