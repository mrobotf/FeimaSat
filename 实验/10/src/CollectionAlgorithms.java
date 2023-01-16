import java.util.*;
import java.util.stream.Collectors;

public class CollectionAlgorithms {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            list.add((int)(Math.random()*100));
        }
        Collections.sort(list);
        System.out.println("Sorted Array: " + list);
        int testNumber = 10;
        int index = Collections.binarySearch(list, testNumber); // 二分查找，必须先排序再找
        if((index) >= 0) {
            System.out.println("Number " + testNumber + " found at index: " + index);
        } else {
            System.out.println("Number " + testNumber + " not found");
        }
        System.out.println("Max number: " + Collections.max(list));
        System.out.println("Min number: " + Collections.min(list));
        System.out.println("Frequency of " + testNumber + ": " + Collections.frequency(list, testNumber));
        Set<Integer> sortedList = new HashSet<>();
        sortedList.addAll(list);
        System.out.println("Number of distinct elements: " + sortedList.size());
        list.clear();   // remove all items from this list
        list.addAll(sortedList);
        Collections.shuffle(list);      // 打乱集合中的顺序
        List<Integer> topTenList = list.subList(0,10);
        Collections.sort(topTenList);
        System.out.println("Top 10: " + topTenList);
    }
}

// Set 用于存储不重复的元素，是一个接口，需要实现
