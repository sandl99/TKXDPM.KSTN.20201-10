package controller.calculateMoney;

/**
 * @author san.dl170111
 */
public class CalculatorNormal implements ICalculatorStrategy {
    @Override
    public int getTotal(long totalTime) {
//        this.getTransaction().setTotalTime((int) totalTime);
//        long t = 2100;
        if (totalTime <= 600) {
            return 0;
        } else if (totalTime <= 900) {
            return 10000;
        }
        totalTime /= 60;
        double numT = ((double) totalTime) / 15;
        return 10000 + 3000 * ((int)Math.ceil(numT));
    }
}
