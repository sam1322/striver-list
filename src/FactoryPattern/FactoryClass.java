package FactoryPattern;

public class FactoryClass {
    public static OS getInstance(String str){
        if(str.equals("OPEN_SOURCE")){
            return new Android();
        }
        else if(str.equals("CLOSED_SOURCE")){
            return new IOS();
        }
        else{
            return new Windows();
        }
    }
}
