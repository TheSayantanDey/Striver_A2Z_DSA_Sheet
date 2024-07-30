package StringsMedium;

import java.util.*;
import java.util.Collections;

class Pair{
    char character;
    int count;
    Pair(char character,int count){
        this.character = character;
        this.count = count;
    }
}

public class SortCharactersByFrequency {
//    public static String frequencySort(String s) {
//        HashMap<Character,Integer> map = new HashMap<>();
//        StringBuilder ans = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if(map.containsKey(s.charAt(i))) {
//                int val = map.get(s.charAt(i));
//                map.put(s.charAt(i),val+1);
//            }else map.put(s.charAt(i),1);
//        }
//        List<Character> list = new ArrayList<>(map.keySet());
//        list.sort((ob1,ob2) -> map.get(ob2) - map.get(ob1));
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < map.get(list.get(i)); j++) {
//                ans.append(list.get(i));
//            }
//        }
//        return ans.toString();
//    }


    public static String frequencySort(String s) {
        //create a frequency array and store the counts of each character
        int[] freqArr = new int[123];
        for (int i = 0; i < s.length(); i++) {
            freqArr[(int)s.charAt(i)]++;
        }

        //Make a List of Pair class(Manually defined) consist of characters and counts
        LinkedList<Pair> list = new LinkedList<>();
        for (int i = 0; i <= 122; i++) {
            if(freqArr[i]!=0){
                Pair pair = new Pair((char)i,freqArr[i]);
                list.add(pair);
            }
        }

        //Sort the list in decreasing order of count
        Collections.sort(list,new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.count-a.count;
            }
        });

        //Build the new String
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Pair currentPair = list.get(i);
            for (int j = 0; j < currentPair.count; j++) {
                ans.append(currentPair.character);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
