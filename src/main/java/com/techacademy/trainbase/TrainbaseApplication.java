package com.techacademy.trainbase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class TrainbaseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TrainbaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Find the second Highest Number
        List<Integer> arrList = List.of(10,20,30,40);
        Integer secondHighestNumber = arrList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println("secondHighestNumber is:" + secondHighestNumber);

        //Find the Longest String
        List<String> stringList = List.of("java", "stream", "api");
        String longestString = stringList.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Longest String is:" + longestString);

        //Top three frequent elements
        List<Integer> frequentElemensList = List.of(1,2,3,4,2,1,1,2,3,5,4,4);
        Map<Integer, Long> frequencyMap = frequentElemensList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> topThreeFrequentElements = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
        System.out.println("topThreeFrequentElements is:" + topThreeFrequentElements);

    }
}
