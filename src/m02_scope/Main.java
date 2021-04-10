package m02_scope;

public class Main {
    public static void main(String[] args) {

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.makeLowerCase();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperLowerConcat uc, String s1, String s2){
        return uc.switchAndConcat(s1, s2);
    }
}

interface UpperLowerConcat {
    public String switchAndConcat(String s1, String s2);
}

class AnotherClass {
    public String makeLowerCase(){
        return Main.doStringStuff(new UpperLowerConcat() {
            @Override
            public String switchAndConcat(String s1, String s2) {
                return s1.toLowerCase() + s2.toLowerCase();
            }
        }, "String1", "String2");
    }
}
