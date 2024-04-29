
interface Vehicle {

    // all are the abstract methods.
    void changeGear(int a);
    void speedUp(int a);
    void applyBrakes(int a);

    default void display(){
        System.out.println("HEELLO");
    }
}

class Bicycle implements  Vehicle{
    int speed ;
    int gear ;
    @Override
    public void changeGear(int newGear){
        System.out.println("changing gear");
        gear = newGear;
    }

    @Override
    public void speedUp(int increment){
        System.out.println("incrementing speed");
        speed =  speed + increment;
    }
    @Override
    public void applyBrakes(int decrement){

        speed = speed - decrement;
    }

    public void printStates() {
        System.out.println("speed: " + speed
                + " gear: " + gear);
    }


}

public class Abstractions {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2);
        bicycle.speedUp(3);
        bicycle.applyBrakes(1);

        System.out.println("Bicycle present state :");
        bicycle.printStates();
        bicycle.display();
    }
}
