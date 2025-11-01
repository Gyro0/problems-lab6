package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int c=random.nextInt(1000);
            arrayList.add(c);
            linkedList.add(c);
        }

        // 2️⃣ Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        // 3️⃣ Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        // 4️⃣ Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

    // ------------------------------------------------------------

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        // insert your code here
        for(int i=0;i<OPERATIONS;i++){
            int randomIndex=random.nextInt(list.size()+1);
            list.add(randomIndex,random.nextInt(1000));
            if(!list.isEmpty()){
            randomIndex=random.nextInt(list.size());
            list.remove(randomIndex);
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();
        Random random=new Random();
        // Insertions at beginning and end
        for (int i=0;i<OPERATIONS/2;i++) {
            // Insert at beginning (index 0)
            list.add(0,random.nextInt(1000));
            
            // Insert at end
            list.add(random.nextInt(1000));
        }
        

        // Deletions at beginning and end

        for (int i=0;i<OPERATIONS/2;i++) {
            // delete at beginning (index 0)
            if(!list.isEmpty()){
                list.remove(0);
            }
            // delete at end
            if(!list.isEmpty()){
                list.remove(list.size()-1);
            }
        }
        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        // sum of the all elements in the list
        for(int i=0;i<OPERATIONS;i++){
            int indxRnd=random.nextInt(list.size());
            sum+=list.get(indxRnd);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}

