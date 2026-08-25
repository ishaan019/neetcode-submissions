// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        int N = pairs.size();

        // Quick Sort
        return quickSort(0, N - 1, pairs, N);
    }

    List<Pair> quickSort(int s, int e, List<Pair> pairs, int N) {
        if (e - s + 1 <= 1) {
            return pairs;
        }

        int left = s;
        Pair pivot = pairs.get(e);

        for (int i = s; i < e; i++) {
            if (pairs.get(i).key < pivot.key) {
                // swap it
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, temp);
                left += 1;
            }
        }

        Pair temp1 = pairs.get(left);
        pairs.set(left, pivot);
        pairs.set(e, temp1);

        quickSort(s, left - 1, pairs, N);
        quickSort(left + 1, e, pairs, N);

        return pairs;
    }
}
