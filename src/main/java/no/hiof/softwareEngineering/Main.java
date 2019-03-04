package no.hiof.softwareEngineering;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = IntStream.range(1, 101).toArray();
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("test");
    }
}
