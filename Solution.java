import java.util.Arrays;

/**
 * Created by KayLee on 07/11/2018.
 */
public class Solution {

    static int getMaxYear(Person[] people){
        int minYear = Integer.MAX_VALUE;
        int maxYear = 0;

        for(Person p: people){
            minYear = Math.min(minYear, p.birth);
            maxYear = Math.max(maxYear, p.death);
        }

        if(maxYear - minYear + 1 <= 0)
            return minYear;

        // create difference array for different people
        int[] differenceArray = new int[maxYear - minYear + 1];

        //populate difference array to note population changes
        for(int i = 0; i < people.length; i++){
            differenceArray[people[i].birth - minYear]++;
            differenceArray[people[i].death - minYear]--;
        }

        // create prefix sum as a tool to identify the maximum
        int[] prefixSum = new int[differenceArray.length];
        prefixSum[0] = differenceArray[0];
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + differenceArray[i];
        }

        System.out.println(Arrays.toString(differenceArray) + " \n " + Arrays.toString(prefixSum));

        // get max in prefix sum and corresponding index
        Position max = new Position(0, 0);
        for(int i = 0; i < prefixSum.length; i++){

            if(prefixSum[i] > max.value){
                max.index = i;
                max.value = prefixSum[i];
            }
        }

        System.out.println("Position: " + max);

        // get corresponding year for max index
        return minYear + max.index;
    }

    public static void main(String[] args) {
        Person[] people = {
                new Person(1930, 1931),
                new Person(1940, 1950),
                new Person(1958, 2010),
                new Person(1931, 2000)
        };

        System.out.println("A year with the maximum people alive is: " + getMaxYear(people));

    }
}
