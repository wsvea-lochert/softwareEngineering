package no.hiof.softwareEngineering;

public class ClassToCheckIfTestingWorks {
    private int weight;
    private double height;

    public ClassToCheckIfTestingWorks(double height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int calculateBmi(){
        return (int) (weight / (height * height));
    }
}
