public class Main {
    public static void main(String[] args) {
        CustomArrayList<Car> transport = new CustomArrayList<>(); // динамич.массив для хранения транспорта; вторая <> означает, что <Car>
        // подсказка "Raw use of parameterized class 'DynamicArray'" означает, что DynamicArray<Object> transport
        transport.add(new Car());
        transport.add(new Car());
        transport.add(new Car());
        // transport.add(new Plane()); // ошибка на этапе компеляции
        for (int i = 0; i < 4; i++) {
            ((Car)transport.get(i)).drive();
        }
    }
}

class Car{
    void drive(){
        System.out.println("Driving car");
    }
}

class Plane{
    void fly(){
        System.out.println("Getting off in the plane");
    }
}