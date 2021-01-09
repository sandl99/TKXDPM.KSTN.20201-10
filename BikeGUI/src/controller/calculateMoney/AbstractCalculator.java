package controller.calculateMoney;

import entity.Bike;

/**
 * @author san.dl170111
 */
public abstract class AbstractCalculator implements ICalculatorStrategy {

    /**
     * calculator total money of user
     * @param bike Bike
     * @param totalTime follow second
     * @return the current money
     */
    ICalculatorStrategy iCalculatorStrategy;

    public AbstractCalculator(ICalculatorStrategy iCalculatorStrategy) {
        this.iCalculatorStrategy = iCalculatorStrategy;
    }
    @Override
    public abstract int getTotal(long totalTime);
}
