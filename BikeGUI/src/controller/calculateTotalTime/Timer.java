package controller.calculateTotalTime;

/**
 * @author san.dl170111
 */
public class Timer extends TimerAbstract {

    public Timer(long startTime) {
        super(startTime);
    }

    @Override
    public long getTimeUsing() {
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000;
    }
}
