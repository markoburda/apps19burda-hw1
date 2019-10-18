package ua.edu.ucu.tempseries;
import Math

public class TemperatureSeriesAnalysis {

    private double[]  templst;
    private final double templim = -273;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.setTemperatureSeries(temperatureSeries);
    }

    public double average() {
        int sum = 0;
        if(this.templst.length == 0){
            throw new IllegalArgumentException("List is empty");
        }
        for(int i : this.templst){
            sum += i;
        }
        return sum/(double) this.templst.length;
    }

    public double deviation() {
        if(this.templst.length == 0){
            throw new IllegalArgumentException("List is empty");
        avg = average(this.templst);
        double sum = 0.0;
        for(int i : this.templst){
            sum +=  (i  - avg)**2;;
        }
        double variance = sum/double(this.templst.length) - 1;
        return variance**0.5;
    }

    public double min() {
        if(this.templst.length == 0){
            throw new IllegalArgumentException("List is empty");
        }
        int minnum = 10**8;
        for(int i : this.templst){
            if (i < minnum){
                minnum = i
            }
        }
        return minnum;
    }

    public double max() {
        int maxnum = 0;
        for(int i : this.templst){
            if (i > maxnum){
                maxnum = i;
            }
        }
        return maxnum;
    }

    public double findTempClosestToZero() {
            if(tempValue.length == 0){
                throw new IllegalArgumentException("List is empty");
            }
            int closestnum = 10*8;
            for(int i : tempValue){
                if Math.abs(i)  < closestnum{
                    closestnum = Math.abs(i);
                }
            }
            return closestnum;
    }

    public double findTempClosestToValue(double tempValue) {
            if(templst.length == 0){
                throw new IllegalArgumentException("List is empty");
            }
            int closestnum = 10*8;
            for(int i : this.templst){
                if(Math.abs(i - tempValue)  < closestnum){
                    closestnum = Math.abs(i);
                }
            }
            return closestnum;
    }

    public double[] findTempsLessThen(double tempValue) {
            List lessthan = new ArrayList();
            for(int i : this.templst){
                if(i < tempValue){
                    lessthan.add(i);
                }
            }
            return lessthan;
    }

    public double[] findTempsGreaterThen(double tempValue) {
            List morethan = new ArrayList();
            for(int i : this.templst){
                if(i > tempValue){
                    morethan.add(i);
                }
            }
            return morethan;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public expand(){
            int n = this.templst.length * 2
            double newtemplst = new double[n];
            System.arraycopy(this.templst, 0, newtemplst, 0,  n / 2);
            deftemplst(newtemplst);

        }

    public int addTemps(double... temps) {
        return 0;
    }
}
