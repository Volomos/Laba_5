    import java.util.*;

public class Test1 {
    public static void findElementTime(int element, Collection<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        long start = System.nanoTime();
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
            if (elem == element) break;
        }
        long end = System.nanoTime();
        System.out.println("Time of searching for element " + element + " took: " + ((end - start)) + "ns");
    }
    public static void deleteElementTime(int element,  Collection<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        long start = System.nanoTime();
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
            if (elem == element) {
                list.remove(elem);
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("Time of deleting element " + element + " took: " + ((end - start)) + "ns");
    }
    public static void timeOfAllOperations(int length, Collection<Integer> list){
        long start = System.nanoTime();
        for (int i = 0; i < length; i = i + 1) list.add(i);
        long end = System.nanoTime();
        System.out.println("Adding of "+ length +" elements took: " + ((end - start)) + "ns");
        findElementTime(1,list);
        findElementTime(length/2,list);
        findElementTime(length-1,list);
        deleteElementTime(1,list);
        deleteElementTime((length-1)/2,list);
        deleteElementTime(length-3,list);
    }


    public static void main(String[] args) {
        int length = 10000;

        System.out.println("\nLinked list testing:");
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        timeOfAllOperations(length, linkedList);

        System.out.println("\nArray list testing:");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        timeOfAllOperations(length, arrayList);

        System.out.println("\nTree set testing:");
        Set<Integer> treeSet = new TreeSet<Integer>();
        timeOfAllOperations(length, treeSet);

        System.out.println("\nHash set testing:");
        Set<Integer> hashSet = new HashSet<Integer>();
        timeOfAllOperations(length, hashSet);
        System.out.println("\n\nTask2\n");
        Test2 test2 = new Test2();
        test2.MainForTest2();
    }
}
