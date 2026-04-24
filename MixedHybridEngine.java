public class MixedHybridEngine implements Engine {
    GasEngine gasEngine = new GasEngine();
    ElectronicEngine electricEngine = new ElectronicEngine();
    Engine currentEngine;
    int currentSpeed = 0;

    public MixedHybridEngine() {
        currentEngine = electricEngine; 
    }

    @Override
    public void start() {
        currentEngine.start();
    }

    @Override
    public void stop() {
        currentEngine.stop();
    }

    @Override
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

    @Override
    public void increase() {
        currentEngine.increase();
    }

    @Override
    public void decrease() {
        currentEngine.decrease();
    }
}