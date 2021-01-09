package controller.calculateTotalTime;

/**
 * @author san.dl170111
 */
public abstract class TimerAbstract {
    long startTime;
    public TimerAbstract(long startTime) {
        this.startTime = startTime;
    }
    public abstract long getTimeUsing();
}
