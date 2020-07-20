// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         //use hash map counting the element frequency in the array
//         Map<Integer, Integer> map = new HashMap();
//         for (int num:nums) {
//             if (map.containsKey(num)) {
//                 map.put(num, map.get(num)+1);
//             } else {
//                 map.put(num,1);
//             }
//         }
//         //use minheap keep the top k frequency elements
//         PriorityQueue<Integer> pq = new PriorityQueue<> (new Comparator<Integer>(){
//             @Override
//             public int compare(Integer a, Integer b) {
//                 return map.get(a) - map.get(b);
//             }
//         });

//         for (int key : map.keySet()) {
//             if(pq.size() < k) {
//                 pq.add(key);
//             } else if (map.get(key) > map.get(pq.peek())) {
//                 pq.remove();
//                 pq.add(key);
//             }
//         }
//         int[] res = new int[k];
//         for(int i = k-1; i >=0 ; i--) {
//             res[i] = pq.remove();
//         }
//         return res;

//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer>[] list = new List[nums.length+1];
        for (int key:map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }
        for(int i = list.length - 1;i >= 0&& count < k;i--) {
            if (list[i] == null) continue;
            for (int j = 0; j < list[i].size(); j++){
                res[count] = list[i].get(j);
                count++;
            }
            
        }
        return res;
        
    }
}