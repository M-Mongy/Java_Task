public abstract class AbstractEngine implements Engine {
    int internalSpeed = 0;

    @Override
    public void setSpeed(int speed) {
        this.internalSpeed = speed;
    }

    @Override
    public void increase() {
        internalSpeed++;
    }

    @Override
    public void decrease() {
        internalSpeed--;
    }
}