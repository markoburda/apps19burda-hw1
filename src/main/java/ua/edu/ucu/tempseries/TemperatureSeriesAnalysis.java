package ua.edu.ucu.tempseries;
import java.util.InputMismatchException;


public class TemperatureSeriesAnalysis {

    private double[]  templst;
    private final double templim = -273;

    private void isEmpty(){
        if (this.templst.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.expand(templst);
    }

    public double average() {
        int sum = 0;
        this.isEmpty();
        for (double i  : this.templst) {
            sum += i;
        }
        return sum / this.templst.length;
    }

    public double deviation() {
        double result = 0, avgnum;
        this.isEmpty();
        avgnum = this.average();
        double l;
        l = this.templst.length;
        for (double i : this.templst) {
            result += (i-avgnum)*(i - avgnum);
        }
        result /= l;
        result = Math.sqrt(result);
        return result;
    }

    public double min() {
        this.isEmpty();
        double minnum = 1000;
        for(double i : this.templst){
            if (i < minnum){
                minnum = i;
            }
        }
        return minnum;
    }

    public double max() {
        double maxnum = 0;
        for(double i : this.templst){
            if (i > maxnum){
                maxnum = i;
            }
        }
        return maxnum;
    }

    public double findTempClosestToZero(double tempValue) {
            this.isEmpty();
            double closestnum = 1000;
            for(double i : templst){
                if(Math.abs(i)  < closestnum){
                    closestnum = Math.abs(i);
                }
            }
            return closestnum;
    }

    public double findTempClosestToValue(double tempValue) {
            this.isEmpty();
            double closestnum = 10*8;
            for(double i : this.templst){
                if(Math.abs(i - tempValue)  < closestnum){
                    closestnum = Math.abs(i);
                }
            }
            return closestnum;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] lessthanlst = new double[this.templst.length];
        int cnt = 0;
        for (double i : this.templst) {
            if (i < tempValue) {
                lessthanlst[cnt++] = i;
            }
        }
        double[] newtemplst = new double[cnt];
        System.arraycopy(lessthanlst, 0, newtemplst, 0, cnt);
        return newtemplst;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[]  morethanlst = new double[this.templst.length];
        int cnt = 0;
        for (double i : this.templst) {
            if (i > tempValue) {
                morethanlst[cnt++] = i;
            }
        }
        double[] newtemplst = new double[cnt];
        System.arraycopy(morethanlst, 0, newtemplst, 0, cnt);
        return newtemplst;
    }

    public TempSummaryStatistics summaryStatistics() {
        this.isEmpty();
        return new TempSummaryStatistics(this);
    }

    private void assignlst(double[] templst){
        for (double i : templst)
            if (i < templim) {
                throw new InputMismatchException();
            }
        this.templst = new double[templst.length];
        System.arraycopy(templst, 0, this.templst, 0, templst.length);
    }

    private void expand(){
            int n = this.templst.length;
            double[] newtemplst = new double[n * 2];
            System.arraycopy(this.templst, 0, newtemplst, 0,  n);
            assignlst(newtemplst);
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
