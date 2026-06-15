// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> res = new ArrayList<>();

        if(pairs.size() == 0)   return res;

        res.add(new ArrayList<>(pairs));    // initial state.

        for(int i = 1; i < pairs.size(); i++) {
            int j = i - 1;
            Pair val = pairs.get(i);

            while(j >= 0 && val.key < pairs.get(j).key) {
                pairs.set(j + 1, pairs.get(j));
                j--;
            }
            
            pairs.set(j + 1, val);

            res.add(new ArrayList<>(pairs));
        }

        return res;
    }
}
