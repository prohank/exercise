public class ClassInitializationTest {

    public static void main(String[] args) throws InterruptedException {

        //accessing static field of Parent through child, should only initialize Parent
        System.out.println(Child.familyName);
    }
}

class P {
    //compile time constant, accessing this will not trigger class initialization
    //protected static final String familyName = "Lawson";

    protected static final String familyName = "Lawson";

    static { System.out.println("static block of Super class is initialized"); }
    {System.out.println("non static blocks in super class is initialized");}
}

class Child extends P {
    static { System.out.println("static block of Sub class is initialized in Java "); }
    {System.out.println("non static blocks in sub class is initialized");}
}
