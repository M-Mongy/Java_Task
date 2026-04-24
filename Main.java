public class Main {
    public static void main(String[] args) {
        Car myHybrid = CarFactory.createCar(EngineType.HYBRID);
        
        myHybrid.start();
        myHybrid.accelerate();
        myHybrid.accelerate();
        myHybrid.accelerate();
        
        myHybrid.brake();
        myHybrid.brake();
        myHybrid.brake(); 
        myHybrid.stop();
    }
}