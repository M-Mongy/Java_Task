public class CarFactory {
    public static Car createCar(EngineType type) {
        Car car = new Car();
        installEngine(car, type);
        return car;
    }

    private static Engine createEngine(EngineType type) {
        return switch (type) {
            case GAS -> new GasEngine();
            case ELECTRIC -> new ElectronicEngine();
            case HYBRID -> new MixedHybridEngine();
            default -> throw new IllegalArgumentException("Invalid Engine Type");
        };
    }

    public static void installEngine(Car car, EngineType type) {
        car.setEngine(createEngine(type));
    }
}