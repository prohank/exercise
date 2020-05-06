package designpatterns.structural;

abstract class Vehicle{
    protected Workshop w1;
    protected Workshop w2;
    protected Workshop w3;

    Vehicle(Workshop w1, Workshop w2){
        this.w1 = w1;
        this.w2 = w2;
    }

    Vehicle(Workshop w1, Workshop w2, Workshop w3){
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
    }

    abstract void manufacture();
}

class Car extends Vehicle{

    Car(Workshop w1, Workshop w2, Workshop w3) {
        super(w1, w2, w3);
    }

    @Override
    void manufacture() {
        System.out.println("Manufacturing of a designpatterns.structural.Car involves:");
        this.w1.work();
        this.w2.work();
        this.w3.work();
    }
}

class Bike extends Vehicle{

    Bike(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    @Override
    void manufacture() {
        System.out.println("Manufacturing of a designpatterns.structural.Bike involves");
        this.w1.work();
        this.w2.work();
    }
}

interface Workshop{
    void work();
}

class Produce implements Workshop{
    @Override
    public void work(){
        System.out.println("Producing");
    }
}

class Assemble implements Workshop{
    @Override
    public void work(){
        System.out.println("Assembling");
    }
}

class Paint implements Workshop{

    @Override
    public void work() {
        System.out.println("Painting");
    }
}
public class BridgePattern {
    public static void main(String[] args) {
        Vehicle v1 = new Car(new Produce(), new Assemble(), new Paint());
        Vehicle v2 = new Bike(new Produce(), new Assemble());
        v1.manufacture();
        v2.manufacture();
    }
}
