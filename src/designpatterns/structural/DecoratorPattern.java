package designpatterns.structural;

interface Building{
    void create();
}

class Apartment implements Building{

    @Override
    public void create() {
        System.out.println("Apartment");
    }
}

abstract class BuildingDecorator implements Building{
    protected Building building;

    BuildingDecorator(Building building){
        this.building = building;
    }

    @Override
    public void create() {
        this.building.create();
    }
}

class Gallery extends BuildingDecorator{

    Gallery(Building building) {
        super(building);
    }

    @Override
    public void create() {
        super.create();
        System.out.println("Creating Gallery");
    }
}

class Terrace extends BuildingDecorator{

    Terrace(Building building) {
        super(building);
    }

    @Override
    public void create() {
        super.create();
        System.out.println("Creating Terrace");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Building building = new Gallery(new Terrace(new Apartment()));
        building.create();
    }
}
