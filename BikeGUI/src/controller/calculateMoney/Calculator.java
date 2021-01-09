package controller.calculateMoney;

/**
 * @author san.dl170111
 */
public class Calculator extends AbstractCalculator {

    public Calculator(ICalculatorStrategy iCalculatorStrategy) {
        super(iCalculatorStrategy);
    }

    @Override
    public int getTotal(long totalTime) {
        return iCalculatorStrategy.getTotal(totalTime);
    }

}
