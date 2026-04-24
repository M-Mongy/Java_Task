public class Car {
    Engine engine;
    int speed = 0;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        if (speed == 0) {
            engine.stop();
        } else {
            System.out.println("Car must be at 0 speed before stopping.");
        }
    }

    public void accelerate() {
        if (speed < 200) {
            speed += 20;
            engine.setSpeed(speed);
        }
    }

    public void brake() {
        if (speed > 0) {
            speed -= 20;
            engine.setSpeed(speed);
        }
    }
}