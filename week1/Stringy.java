package week1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stringy{
    private static String reverso(String str){
        // Split string into array, convert to list, reverse list, then return a joined string created from list
        List<String> input = Arrays.asList(str.split(" "));
        Collections.reverse(input);
        return String.join(" ", input);
    }

    private static boolean containSameChars(String str1, String str2){
        // Convert string to all lowercase, then convert to IntStream w/ chars(), then sum it all up.
        // Converted to lowercase so that uppercase characters don't affect total ascii value
        return str1.toLowerCase().chars().sum() == str2.toLowerCase().chars().sum();
    }
    
    public static void main(String[] args){
        System.out.println("Testing Reverso: ");
        System.out.println(reverso("This is an assignment"));
        System.out.println(reverso("whatifIhadnospaces"));

        System.out.println("\n");

        System.out.println("Testing ContainSameChars (should be true false true): ");
        System.out.println(containSameChars("below", "elbow"));
        System.out.println(containSameChars("belo", "elbow"));
        System.out.println(containSameChars("LOVELY day in sunnyvale", "sunnyvale in day lovely"));
    }
}