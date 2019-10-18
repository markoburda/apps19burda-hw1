package ua.edu.ucu.tempseries;
import java.util.InputMismatchException;


public class TemperatureSeriesAnalysis {

    private double[]  temperatureSeries;
    private final double templim = -273;

    private void isEmpty(){
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.expand(temperatureSeries);
    }

    public double average() {
        int sum = 0;
        this.isEmpty();
        for (double i  : this.temperatureSeries) {
            sum += i;
        }
        return sum / this.temperatureSeries.length;
    }

    public double deviation() {
        double result = 0, avgnum;
        this.isEmpty();
        avgnum = this.average();
        double l;
        l = this.temperatureSeries.length;
        for (double i : this.temperatureSeries) {
            result += (i-avgnum)*(i - avgnum);
        }
        result /= l;
        result = Math.sqrt(result);
        return result;
    }

    public double min() {
        this.isEmpty();
        double minnum = 1000;
        for(double i : this.temperatureSeries){
            if (i < minnum){
                minnum = i;
            }
        }
        return minnum;
    }

    public double max() {
        double maxnum = 0;
        for(double i : this.temperatureSeries){
            if (i > maxnum){
                maxnum = i;
            }
        }
        return maxnum;
    }

    public double findTempClosestToZero(double tempValue) {
            this.isEmpty();
            double closestnum = 1000;
            for(double i : temperatureSeries){
                if(Math.abs(i)  < closestnum){
                    closestnum = Math.abs(i);
                }
            }
            return closestnum;
    }

    public double findTempClosestToValue(double tempValue) {
            this.isEmpty();
            double closestnum = 10*8;
            for(double i : this.temperatureSeries){
                if(Math.abs(i - tempValue)  < closestnum){
                    closestnum = Math.abs(i);
                }
            }
            return closestnum;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] lessthanlst = new double[this.temperatureSeries.length];
        int cnt = 0;
        for (double i : this.temperatureSeries) {
            if (i < tempValue) {
                lessthanlst[cnt++] = i;
            }
        }
        double[] newtemperatureSeries = new double[cnt];
        System.arraycopy(lessthanlst, 0, newtemperatureSeries, 0, cnt);
        return newtemperatureSeries;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[]  morethanlst = new double[this.temperatureSeries.length];
        int cnt = 0;
        for (double i : this.temperatureSeries) {
            if (i > tempValue) {
                morethanlst[cnt++] = i;
            }
        }
        double[] newtemperatureSeries = new double[cnt];
        System.arraycopy(morethanlst, 0, newtemperatureSeries, 0, cnt);
        return newtemperatureSeries;
    }

    public TempSummaryStatistics summaryStatistics() {
        this.isEmpty();
        return new TempSummaryStatistics(this);
    }

    private void assignlst(double[] temperatureSeries){
        for (double i : temperatureSeries)
            if (i < templim) {
                throw new InputMismatchException();
            }
        this.temperatureSeries = new double[temperatureSeries.length];
        System.arraycopy(temperatureSeries, 0, this.temperatureSeries, 0, temperatureSeries.length);
    }

    private void expand(){
            int n = this.temperatureSeries.length;
            double[] newtemperatureSeries = new double[n * 2];
            System.arraycopy(this.temperatureSeries, 0, newtemperatureSeries, 0,  n);
            assignlst(newtemperatureSeries);
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
