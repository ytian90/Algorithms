package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements
 * @author yutian
 * @since May 7, 2016
 */
public class TopKFrequentElements {
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(key);
		}
		List<Integer> result = new ArrayList<>();
		for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
			if (bucket[i] != null) {
				result.addAll(bucket[i]);
			}
		}
        return result;
    }

	public static void main(String[] args) {
		TopKFrequentElements t = new TopKFrequentElements();
		System.out.println(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
		System.out.println(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4}, 2));
		System.out.println(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4}, 3));

	}

}
