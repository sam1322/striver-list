import java.util.Scanner;

class Employee {
    int id;
    String name;

    Employee() {
        id = 45;
        name = "Sam";
    }

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void PrintDetails() {
        System.out.printf("id = %d , name = %s\n", id, name);
    }
}

abstract class Base {
    abstract void Print();

    final void fun() {
        System.out.println("No fun is available what to do");
    }
}

class Derived extends Base {
    @Override
    void Print() {
        System.out.println("Hello , Need help ");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number 1");
//        int a = sc.nextInt();
//        System.out.println("Enter number 2");
//        int b = sc.nextInt();
//        System.out.printf("a = %d , b = %d\n", a, b);
//        final int myNum = 15;
////        myNum = 20;
//        System.out.println("myNum : " + myNum + a + b);


//        Employee emp = new Employee();
        Employee emp = new Employee(1, "Hey");
//        emp.id= 1;
//        emp.name="Sriram";
        emp.PrintDetails();

        Base b = new Derived();
        b.Print();
        b.fun();
    }
}