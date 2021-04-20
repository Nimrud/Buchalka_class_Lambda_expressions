package m05_challenge1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // CHALLENGE 1:
        // convert following code to lambda expression:
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts){
                    System.out.println(part);
                }
            }
        };

        // rozwiązanie moje:
        String myString = "Let split this up into an array";
        Runnable r = () -> System.out.println(Arrays.toString(myString.split(" ")));
        new Thread(r).start();

        // rozwiązanie Buchalki:
        Runnable runnable1 = () -> {
            String myString2 = "Let split this up into an array";
            String[] parts = myString2.split(" ");
            for (String part : parts){
                System.out.println(part);
            }
        };
    }
}
