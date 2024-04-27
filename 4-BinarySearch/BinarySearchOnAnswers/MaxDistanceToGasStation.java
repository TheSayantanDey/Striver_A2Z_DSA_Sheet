package BinarySearchOnAnswers;

import java.util.*;

class Pair{
    double first;
    int second;

    Pair(double first, int second){
        this.first = first;
        this.second = second;
    }
}
public class MaxDistanceToGasStation {
    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
    public static double MinimiseMaxDistance(int []arr, int k){

//        //Brute force
//        int [] section = new int[arr.length-1];
//        for (int i = 1; i <= k; i++) {
//            double maxDist = Integer.MIN_VALUE;
//            int maxInd = -1;
//            for (int j = 0; j < arr.length-1; j++) {
//                double dist = (double) (arr[j + 1] - arr[j]) /(section[j]+1);
//                if(dist>maxDist){
//                    maxDist = dist;
//                    maxInd = j;
//                }
//            }
//            section[maxInd]++;
//        }
//        double minMaxDist = Integer.MIN_VALUE;
//        for (int i = 0; i < arr.length-1; i++) {
//            double dist = (double) (arr[i + 1] - arr[i]) /(section[i]+1);
//            minMaxDist = Math.max(minMaxDist,dist);
//        }
//        return minMaxDist;

//        //Better Approach (using priority queue)
//
//        int [] section = new int[arr.length-1]; //Array to store number of gas station in each section
//
//        //Priority queue to get the max distance in log(n) time
//        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Double.compare(b.first,a.first));
//
//        // insert the first n-1 elements into pq
//        // with respective distance values:
//        for (int i = 0; i < arr.length-1; i++) {
//            Pair p = new Pair((arr[i+1]-arr[i]), i);
//            pq.add(p);
//        }
//
//        for (int i = 1; i <= k; i++) {
//            Pair topPair = pq.poll();
//            int index = topPair.second;
//
//            // insert the current gas station:
//            section[index]++;
//
//            //After pushing the new gasStation, redetermine the distance and push it back to the pq
//            double totalDiff = arr[index + 1] - arr[index];
//            double newDist = totalDiff / (double) (section[index] + 1);
//            pq.add(new Pair(newDist, index));
//        }
//
//        //Return the current max distance
//        return pq.poll().first;


//        //Optimal using BinarySearch

        int n = arr.length; // size of the array
        double low = 0;
        double high = 0;

        //Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }

        //Apply Binary search:
        double diff = 1e-6 ;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1,9,15,19};
        int k = 5;
        System.out.println(MinimiseMaxDistance(arr,k));
        System.out.println(Math.pow(10,-6));
    }
}
