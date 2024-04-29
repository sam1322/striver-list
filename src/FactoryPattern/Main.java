package FactoryPattern;

public class Main {
    public static void main(String[] args) {
        //    FactoryClass fc =  new FactoryClass();
        OS obj = FactoryClass.getInstance("OPEN_SOURCE");
        obj.spec();
    }
}
