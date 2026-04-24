interface Engine {
    void start();
    void stop();
    void setSpeed(int speed);
    void increase();
    void decrease();
}

abstract class AbstractEngine implements Engine {
    int internalSpeed = 0;

    public void setSpeed(int speed) {
        this.internalSpeed = speed;
    }

    public void increase() {
        internalSpeed++;
    }

    public void decrease() {
        internalSpeed--;
    }
}

class GasolineEngine extends AbstractEngine {
    public void start() {}

    public void stop() {}
}

class ElectronicEngine extends AbstractEngine {
    public void start() {}

    public void stop() {}
}

class MixedHybridEngine implements Engine {
    GasolineEngine gasEngine = new GasolineEngine();
    ElectronicEngine electricEngine = new ElectronicEngine();

    Engine currentEngine;
    int currentSpeed = 0;

    public MixedHybridEngine() {
        currentEngine = electricEngine; 
    }

    public void start() {
        currentEngine.start();
    }

    public void stop() {
        currentEngine.stop();
    }

    public void setSpeed(int speed) {
        if (speed < 50) {
            if (currentEngine != electricEngine) {
                gasEngine.stop();
                electricEngine.start();
                currentEngine = electricEngine;
            }
        } else {
            if (currentEngine != gasEngine) {
                electricEngine.stop();
                gasEngine.start();
                currentEngine = gasEngine;
            }
        }

        currentSpeed = speed;
        currentEngine.setSpeed(speed);
    }

    public void increase() {
        currentEngine.increase();
    }

    public void decrease() {
        currentEngine.decrease();
    }
}

class Car {
    Engine engine;
    int speed = 0;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        speed = 0;
        engine.setSpeed(speed);
        engine.stop();
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

enum EngineType {
    GAS, ELECTRIC, HYBRID
}

class CarFactory {

    public static Car createCar(EngineType type) {
        Car car = new Car();
        installEngine(car, type);
        return car;
    }

    private static Engine createEngine(EngineType type) {
        switch (type) {
            case GAS:
                return new GasolineEngine();
            case ELECTRIC:
                return new ElectronicEngine();
            case HYBRID:
                return new MixedHybridEngine();
            default:
                throw new IllegalArgumentException("Invalid Engine Type");
        }
    }

    public static void installEngine(Car car, EngineType type) {
        car.setEngine(createEngine(type));
    }
}



