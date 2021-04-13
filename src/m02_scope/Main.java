package m02_scope;

public class Main {
    public static void main(String[] args) {

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.makeLowerCase();
        System.out.println(s);

        System.out.println("===");
        printValue();
    }

    public final static String doStringStuff(UpperLowerConcat uc, String s1, String s2){
        return uc.switchAndConcat(s1, s2);
    }

    public static void printValue(){
        int number = 25;

        Runnable r = () -> {
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Number = " + number);
        };
        new Thread(r).start();
    }
}

interface UpperLowerConcat {
    public String switchAndConcat(String s1, String s2);
}

class AnotherClass {
    public String makeLowerCase(){
        UpperLowerConcat ulc = (s1, s2) -> {
            System.out.println("Lambda expression's class: " + getClass().getSimpleName());
            String result = s1.toLowerCase() + s2.toLowerCase();
            return result;
        };
        // wyrażenia lambda są traktowane jak nested blocks {...}
        // wszystkie zmienne spoza {...} muszą być zadeklarowane jako final
        // lub ich wartość nie może się zmieniać (czyli bez inkrementacji itp.)

        System.out.println("Another class name: " + getClass().getSimpleName());
        return Main.doStringStuff(ulc, "String1", "String2");
//        System.out.println("Another class name: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperLowerConcat() {
//            @Override
//            public String switchAndConcat(String s1, String s2) {
//                //System.out.println("Anonymous class name: " + getClass().getSimpleName());
//                return s1.toLowerCase() + s2.toLowerCase();
//            }
//        }, "String1", "String2");
    }
}
