import java.util.PriorityQueue;
import java.util.Map.Entry;
import java.util.*;

class Pair {
	public static <T, U> Map.Entry<T, U> of(T first, U second) {
		return new AbstractMap.SimpleEntry<>(first, second);
	}
}

class MinHeap {

	public static void printType(Object o) {
		Class cls = o.getClass();
		System.out.println("Type: " + cls.getName());
	}

	public static void main(String[] args) {
		PriorityQueue<Entry> maxHeap = new PriorityQueue<Entry>(new Comparator<Entry>(){
			public int compare(Entry e1, Entry e2) {
				Integer first = (Integer)e1.getKey();
				Integer second = (Integer)e2.getKey();
				return second.compareTo(first);
			}
		});
		Entry<Integer, String> one = Pair.of(1, "Hello");
		Entry<Integer, String> two = Pair.of(2, "Jello");
		Entry<Integer, String> three = Pair.of(3, "llo");
		Entry<Integer, String> four = Pair.of(4, "Hlo");
		Entry<Integer, String> five = Pair.of(5, "Hoo");

System.out.println(one);
System.out.println("Key: " + one.getKey() + ", Value: " + one.getValue());
printType(one);
printType(one.getKey());
printType(one.getValue());
printType((Integer)one.getKey());
printType(Pair.of(10, "Hello"));

		maxHeap.offer(five);
		maxHeap.offer(four);
		maxHeap.offer(two);
		maxHeap.offer(three);
		maxHeap.offer(one);
		System.out.println(maxHeap);
		while(!maxHeap.isEmpty()) System.out.println(maxHeap.poll());
		System.out.println(maxHeap);
	}
}