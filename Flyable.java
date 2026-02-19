interface Flyable {
    void takeOff();
    void land();
    double maxAltitude();

    default String status() {
        return "FLY MODE";
    }
}

interface Drivable {
    void startEngine();
    void stopEngine();
    double maxSpeed();

    default String status() {
        return "DRIVE MODE";
    }
}

interface ThermalSensor {
    double readTemperatureC();
    boolean detectHuman(double thresholdC);
}

interface Communicable {
    void send(String message);
    String getDeviceId();
}