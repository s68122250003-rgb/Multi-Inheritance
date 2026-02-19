class RescueRobot implements Flyable, Drivable, ThermalSensor, Communicable {

    private String deviceId;

    // Composition
    private Battery battery;
    private GPSTracker gps;
    private ThermalCamera thermal;

    public RescueRobot(String deviceId) {
        this.deviceId = deviceId;
        this.battery = new Battery(100);
        this.gps = new GPSTracker();
        this.thermal = new ThermalCamera();
    }


    @Override
    public void takeOff() {
        battery.drain(5);
        System.out.println("Taking off... Battery=" + battery.getLevel() + "%");
    }

    @Override
    public void land() {
        battery.drain(3);
        System.out.println("Landing... Battery=" + battery.getLevel() + "%");
    }

    @Override
    public double maxAltitude() {
        battery.drain(1);
        return 120.0;
    }

    @Override
    public void startEngine() {
        battery.drain(2);
        System.out.println("Engine started. Battery=" + battery.getLevel() + "%");
    }

    @Override
    public void stopEngine() {
        battery.drain(1);
        System.out.println("Engine stopped. Battery=" + battery.getLevel() + "%");
    }

    @Override
    public double maxSpeed() {
        battery.drain(1.5);
        return 60.0;
    }


    @Override
    public double readTemperatureC() {
        battery.drain(1);
        double temp = thermal.readTemperatureC();
        System.out.println("Temp=" + temp + " C Battery=" + battery.getLevel() + "%");
        return temp;
    }

    @Override
    public boolean detectHuman(double thresholdC) {
        battery.drain(2);
        boolean found = thermal.detectHuman(thresholdC);
        System.out.println("Human detected? " + found + " Battery=" + battery.getLevel() + "%");
        return found;
    }


    @Override
    public void send(String message) {
        battery.drain(1);
        System.out.println("Sending: ID=" + deviceId +
                ", POS=" + gps.currentPosition() +
                ", MSG=" + message +
                ", Battery=" + battery.getLevel() + "%");
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    public void updatePosition(double lat, double lon) {
        gps.updatePosition(lat, lon);
    }


    @Override
    public String status() {
        return "ROBOT: " + Flyable.super.status() + " + " + Drivable.super.status();
    }
}