package designpatterns.creational;

interface Shape{
    void draw();
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class ShapeFactory {
    static Shape getShape(String shapeName){
        if(shapeName.equalsIgnoreCase("Square")){
            return new Square();
        } else if(shapeName.equalsIgnoreCase("Circle")){
            return new Circle();
        } else return null;
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        Shape s1 = ShapeFactory.getShape("Square");
        Shape s2 = ShapeFactory.getShape("Circle");
        s1.draw();
        s2.draw();

    }
}
