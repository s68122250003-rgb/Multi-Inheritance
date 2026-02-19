import java.util.Random;

class ThermalCamera {
    private Random rand = new Random();

    public double readTemperatureC() {

        return 30 + (10 * rand.nextDouble());
    }

    public boolean detectHuman(double thresholdC) {
        double temp = readTemperatureC();
        return temp >= thresholdC;
    }
}