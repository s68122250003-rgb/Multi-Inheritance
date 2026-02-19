class GPSTracker {
    private double lat;
    private double lon;

    public void updatePosition(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String currentPosition() {
        return String.format("(%.5f, %.5f)", lat, lon);
    }
}