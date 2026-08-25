// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        int N = pairs.size();

        return mergeSortHelper(0, N - 1, pairs);
    }

    List<Pair> mergeSortHelper(int s, int e, List<Pair> pairs) {
        if(e - s + 1 <= 1) {
            return pairs;
        }

        int m = (s + e) / 2;

        mergeSortHelper(s, m, pairs);
        mergeSortHelper(m + 1, e, pairs);

        merge(s, m, e, pairs);

        return pairs;
    }

    void merge(int s, int m, int e, List<Pair> pairs) {
        List<Pair> L = new ArrayList<>(pairs.subList(s, m + 1));
        List<Pair> R = new ArrayList<>(pairs.subList(m + 1, e + 1));

        int i = 0;//index for L
        int j = 0;//index for R
        int k = s;// index for pairs

        //Merge two sorted arrays into original arr
        while(i < L.size() && j < R.size()) {
            if(L.get(i).key <= R.get(j).key) {
                pairs.set(k, L.get(i));
                i++;
            } else {
                pairs.set(k, R.get(j));
                j++;
            }
            k++;
        }

        //if one of the half left
        while(i < L.size()) {
            pairs.set(k, L.get(i));
            i++;
            k++;
        }

         while(j < R.size()) {
            pairs.set(k, R.get(j));
            j++;
            k++;
        }
    }
}
