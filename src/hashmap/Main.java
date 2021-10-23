package hashmap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myMap = new MyHashMap<>();
           System.out.println(myMap.isEmpty());
        myMap.put(1, "Hi");
        myMap.put(2, "Hello");
        myMap.put(9, "Good morning");
        myMap.put(12, "Good afternoon");
        myMap.put(24, "Good night");
            System.out.println(myMap.containsKey(789));
            System.out.println(myMap.get(12));
        myMap.remove(1);
            System.out.println(myMap.size());
            System.out.println(myMap.isEmpty());
             System.out.print("MyMap is: ");
        myMap.display();
    }
}