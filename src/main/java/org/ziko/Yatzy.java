package org.ziko;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {

    public static int chance(int... numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int sumByTarget(int target, int... numbers) {
        return Arrays.stream(numbers).filter(value -> value == target).sum();
    }

    public int fours() {
        return Arrays.stream(dice).filter(value -> value == 4).sum();
    }

    public int fives() {
        return Arrays.stream(dice).filter(value -> value == 5).sum();
    }

    public int sixes() {
        return Arrays.stream(dice).filter(value -> value == 6).sum();
    }

    public static int score_pair(int... nums) {
        List<Integer> listNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return filterByFrequency(listNums, 2).get(0) * 2;

    }

    public static int two_pair(int... nums) {
        List<Integer> listNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return filterByFrequency(listNums, 2).stream().reduce(0, Integer::sum) * 2;
    }

    public static int four_of_a_kind(int... nums) {
        List<Integer> listNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return filterByFrequency(listNums, 4).stream().reduce(0, Integer::sum) * 4;
    }

    public static int three_of_a_kind(int... nums) {
        List<Integer> listNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return filterByFrequency(listNums, 3).stream().reduce(0, Integer::sum) * 3;
    }

    public static int smallStraight(int... nums) {
        List<Integer> listNums = Arrays.stream(nums).boxed().distinct().sorted().collect(Collectors.toList());

        for (int i = 0; i < listNums.size() - 1; i++) {
            if (listNums.get(i + 1) - listNums.get(i) != 1) {
                return 0;
            }
        }
        return 15;
    }

    // 1,2,3,4,5,6

    public static int largeStraight(int... nums) {
        List<Integer> listNums = Arrays.stream(nums).boxed().distinct().sorted().collect(Collectors.toList());

        for (int i = 0; i < listNums.size() - 1; i++) {
            if (listNums.get(i + 1) - listNums.get(i) != 1) {
                return 0;
            }
        }
        return 20;
    }

    public static int fullHouse(int... nums) {
        return three_of_a_kind(nums) != 0 && two_pair(nums) != 0 ? 18 : 0;
    }

    public static int yatzy(int... dice) {
        List<Integer> listNums = Arrays.stream(dice).boxed().collect(Collectors.toList());

        return listNums.stream().filter(value -> Collections.frequency(listNums, value) == 5).count() == 5 ? 50 : 0;

    }

    public static List<Integer> filterByFrequency(List<Integer> list, int frequency) {
        return list.stream().filter(value -> Collections.frequency(list, value) >= frequency)
                .sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
    }

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int _5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }
}



