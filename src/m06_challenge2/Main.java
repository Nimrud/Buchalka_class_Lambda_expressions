package m06_challenge2;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    // CHALLENGE 2a:
    // write the following method as a lambda expression
    // don't worry about assigning it to anything
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < source.length(); i++){
            if (i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    // rozwiązanie:
    Function<String, String> lambdaFunction = (String source) -> {
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < source.length(); i++){
            if (i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    };

    // CHALLENGE 2b:
    // right now, the function does not do anything
    // write the code that will execute the funcion with an argument "0123456789"

    public static void main(String[] args) {

        //System.out.println(everySecondChar("Jabłko Adama"));

        // rozwiązanie (challenge 2b):
        String s2 = "0123456789";

        Function<String, String> lambdaFunction = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if (i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println("challenge 2b: " + lambdaFunction.apply(s2));

        // challenge 2c:
        String s3 = "1234567890";
        System.out.println("challenge 2c: " + everySecondCharacter(lambdaFunction, s3));


        // CHALLENGE 2d:
        // write a lambda expression that maps to the java.util.Supplier interface
        // this lambda should return the string "I love Java!"
        // assign it to a variable called iLoveJava
        String s = "I love Java!";
        Supplier<String> iLoveJava = () -> s;

        // CHALLENGE 2e:
        // use this supplier to assign the string "I love Java!" to a variable called supplierResult
        // print the variable to the console
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }

    // CHALLENGE 2c:
    // instead of executing this function directly, suppose we want to pass it to a method
    // write a method called everySecondCharacter
    // it should accept the function as a parameter and executes it with the argument '1234567890'
    // it should return the result of the function
    // bonus point: don't hard-code the argument string within the method
    public static String everySecondCharacter(Function f, String s){
        return f.apply(s).toString();
    };



}
