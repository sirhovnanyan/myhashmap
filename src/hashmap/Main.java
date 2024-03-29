package hashmap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myMap = new MyHashMap<>();
        System.out.println(myMap.isEmpty());
        myMap.put(1, "Hi");
        myMap.put(2, "Hello");
        myMap.put(9, "Good morning");
        myMap.put(12, "Good afternoon");
        myMap.put(20, "Good evening");
        myMap.put(24, "Good night");
        System.out.println(myMap.containsKey(789));
        System.out.println(myMap.get(12));
        myMap.remove(1);
        System.out.println(myMap.size());
        System.out.println(myMap.isEmpty());
        System.out.println("Is the value 'Hello' present? " + myMap.containsValue("Hello"));
        System.out.print("MyMap is: ");
        myMap.display();

        myMap.entryList();
        System.out.println("\nIterating my HashMap with iterator: ");
        MyMap.Iterator<Integer, String> itr = myMap.iterator();
        while (itr.hasNext()) {
            MyMap.MyEntry<Integer, String> entry = itr.next();
            System.out.print(entry.getKey() + " => " + entry.getValue() + " , ");
        }
    }
}