package week1;
import java.util.*;
import java.util.stream.Collectors;

public class Hashbrown{
    private static void processMap(AbstractMap<String, String> map){
        // When you print out the hashMap, you see that the key value pairs don't print in the same order as the order
        // that we added them in. They print in order of key's hash value, from lowest to highest.
        // Printing out the linkedHashMap shows that the key value pairs are printed in the same order as we added them
        System.out.print("PredatorPreyHashMap before adding: ");
        System.out.println(map);

        map.put("assassin snail", "ramshorn snail");
        map.put("cat", "mouse");
        map.put("hawk", "fish");
        System.out.print("PredatorPreyHashMap after adding: ");
        System.out.println(map);

        map.remove("cat");
        map.remove("assassin snail");
        System.out.print("PredatorPreyHashMap after removing: ");
        System.out.println(map);
    }

    private static void hashMapping(){
        System.out.println("STARTING HASH MAP...");
        processMap(new HashMap<>());
    }

    private static void linkedHashMapping() {
        System.out.println("STARTING LINKED HASH MAP...");
        processMap(new LinkedHashMap<>());
    }

    public static void main(String[] args) {
        hashMapping();
        System.out.print("\n");
        linkedHashMapping();
        System.out.print("\n");

        System.out.print("BEFORE LOWERCASING VIA STREAM: ");
        String toLowercase = "HELLO, WHAT CASE AM I IN?";
        System.out.println(toLowercase);
        List<String> lowercased = Arrays.stream(toLowercase.split(""))
                                        .map(String::toLowerCase)
                                        .collect(Collectors.toList());
        System.out.print("AFTER LOWERCASING VIA STREAM: ");
        lowercased.forEach(System.out::print);
        System.out.print("\n");
    }
}