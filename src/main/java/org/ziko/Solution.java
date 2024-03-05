class Solution {
 public List<Integer> twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            int indice = Arrays.binarySearch(numbers, i+1, numbers.length, diff);
            if(indice>=0 && i!=indice) {
                return new ArrayList<>(List.of(numbers[i], numbers[indice]));
            }
        }
        return new ArrayList<>();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        for (int val : nums) {
            List<Integer> twoSums = twoSum(nums, val *-1);
            if (!twoSums.isEmpty()) {
                twoSums.add(val);
                if(!solution.contains(twoSums)) {
                    solution.add(twoSums);
                }
            }
        }
       List<List<Integer>> solutionReturned = new ArrayList<>();
        
        for(List<Integer> list : solution) {
            list = list.stream().sorted().toList();
            solutionReturned.add(list);
        }
        return solutionReturned.stream().distinct().toList();
    }
}