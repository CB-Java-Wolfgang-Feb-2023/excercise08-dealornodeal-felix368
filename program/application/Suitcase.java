package application;

public class Suitcase {

    private double value;
    private boolean used;

    public Suitcase(double value) {
        this.value = value;
        used = false;
    }

    public double getValue() {
        return value;
    }

    public boolean isUsed() {
        return used;
    }


    public void setUsed(boolean used) {
        this.used = used;
    }


    @Override
    public String toString() {
        return "value=" + value;
    }
}
