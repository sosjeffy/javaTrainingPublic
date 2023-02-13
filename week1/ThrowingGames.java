package week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

// Default scope, so this exception can only be seen by this package (and class, LostGameException)
class LostGameException extends Exception{
    // Custom exception should extend Exception you should write a constructor
    public LostGameException(String message){
        super(message);
    }
}

public class ThrowingGames {
    // This exception should be caught somewhere or the program will crash
    private static void imaThrow(String msg) throws LostGameException{
        throw new LostGameException(msg);
    }

    private static void startGame() {
        System.out.println("Enter integers ONLY...or 'x' to quit");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        do{
            try{
                line = reader.readLine();
                Integer i = Integer.parseInt(line);
            }
            catch(NumberFormatException e){
                // Sadly, parseInt() throws this when you try to parse non-integer values
                System.out.println("You didn't enter an integer!!");
            }
            catch (IOException e){
                // This exception can occur from BufferedReader.readLine() when buffer is closed
                System.out.println("Something happened.");
            }
        } while (!Objects.equals(line, "x")); // null safety suggestion from IntelliJ
        System.out.println("Goodbye 🥳");
    }

    public static void main(String[] args) throws IOException {
        try{
            imaThrow("Oh no!");
        }
        catch(Exception e){
            System.out.println("Caught exception...");
            System.out.println(e.getMessage());
        }
        startGame();
    }
}
