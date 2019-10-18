package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {

    private double[]  templst;
    private final double templim = -273;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
    }

    public double average() {
        int sum = 0;
        if(this.templst.length == 0){
            throw new IllegalArgumentException("List is empty");
        }
        for (double i  : this.templst) {
            sum += i;
        }
        return sum / this.templst.length;
    }

    public double deviation() {
        double result = 0, avgnum;
        if (this.templst.length == 0) {
            throw new IllegalArgumentException("List is empty");
        }
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
        if(this.templst.length == 0){
            throw new IllegalArgumentException("List is empty");
        }
        double minnum = 1000;
        for(double i : this.templst){
            if (i < minnum){
                minnum = i;
            }
        }
        return minnum;
    }

    public double max() {
        int maxnum = 0;
        for(double i : this.templst){
            if (i > maxnum){
                maxnum = i;
            }
        }
        return maxnum;
    }

    public double findTempClosestToZero(double tempValue) {
            if(templst.length == 0){
                throw new IllegalArgumentException("List is empty");
            }
            int closestnum = 10*8;
            for(double i : templst){
                if(Math.abs(i)  < closestnum){
                    closestnum = Math.abs(i);
                }
            }
            return closestnum;
    }

    public double findTempClosestToValue(double tempValue) {
            if(templst.length == 0){
                throw new IllegalArgumentException("List is empty");
            }
            double closestnum = 10*8;
            for(double i : this.templst){
                if(Math.abs(i - tempValue)  < closestnum){
                    closestnum = Math.abs(i);
                }
            }
            return closestnum;
    }

    public double[] findTempsLessThen(double tempValue) {
            List lessthan = new ArrayList();
            for(double i : this.templst){
                if(i < tempValue){
                    lessthan.add(i);
                }
            }
            return lessthan;
    }

    public double[] findTempsGreaterThen(double tempValue) {
            double[] morethan = new double[this.templst.length];
            int n;
            for(double i : this.templst){
                if(i > tempValue){
                    morethan[n++] = i;
                }
            }
            return morethan;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    private void expand(){
            int n = this.templst.length * 2;
            double newtemplst = new double[n];
            System.arraycopy(this.templst, 0, newtemplst, 0,  n / 2);
            deftemplst(newtemplst);

        }

    public int addTemps(double... temps) {
        return 0;
    }
}
