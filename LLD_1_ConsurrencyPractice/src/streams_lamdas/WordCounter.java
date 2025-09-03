package streams_lamdas;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

//Count Unique Words
//Problem Statement
//Given a list of strings representing sentences, write a Java method called countWords that performs the following operations using Java streams:
//
//Filter out sentences that don't contain the word "Java".
//
//Map each filtered sentences to a list of unique words (remove duplicates).
//
//Flatten the list of unique words into a single stream of words. Hint: Use flatMap(Arrays::stream) Method
//
//Count the total number of remaining words.
//
//Return the count of remaining words.
//
//Instructions
//Implement the countWords method inside the WordCounter class
//You need to use Java Streams for doing the operation.

public class WordCounter {
    public static long countWords(List<String> sentences) {

          long ans = sentences.stream()
             // Filter sentences containing "Java"
             .filter(sentence -> sentence.contains("Java"))
             // Map each sentence to a set of unique words
             .map(sentence -> new HashSet<>(Arrays.asList(sentence.split("\\s+"))))
             // Flatten the sets of words into one stream of words
             .flatMap(wordsSet -> wordsSet.stream())
             // Count the total number of words
             .count();


        return ans;
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Python is a programming language.",
                "JavaScript is used for web development.",
                "Ruby is known for its simplicity."
        );

        long wordCount = WordCounter.countWords(sentences);
        System.out.println(wordCount);
    }
}