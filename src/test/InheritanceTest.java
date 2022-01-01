package test;

public class InheritanceTest {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.doSome(1);
        Parent pc1 = new Child1();
        pc1.doSome(2);
        Parent pc2 = new Child2();
        pc2.doSome(3);

        String s1 = "abc";
        String s2 = "daadabcdeed";
        System.out.println(s1.compareTo(s2));
        for (int i = 0; i < 10; i++) {
            i += 1;
            System.out.println("Helloworld" + i);
        }
        System.out.println("strawberry".substring(2, 5));
        System.out.println("Comparing apples and bananas" + "apple".compareTo("banana"));
    }
}

class Parent {
    Parent() {

    }

    Parent(String s) {
        this();
    }

    void doSome(int number) {
        System.out.println("test.Parent " + number);
    }
}

class Child1 extends Parent {
    Child1() {
    }

    Child1(String s) {
        super(s);
    }

    void doSome(Number number) {
        System.out.println("test.Parent test.Child1 " + number);
    }

    void doChild1() {
        System.out.println("Only test.Child1");
    }
}

class Child2 extends Parent {
    void doSome(Number integer) {
        System.out.println("test.Parent test.Child2 " + integer);
    }

    void doChild2() {
        System.out.println("Only test.Child2");
    }
}
