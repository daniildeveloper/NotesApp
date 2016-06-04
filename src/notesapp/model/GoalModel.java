package notesapp.model;

import java.util.Calendar;

/**
 * How a single goal looks
 *
 * @author Lama
 */
public class GoalModel {

    /**
     * day when goal must be completed
     */
    private Calendar day;

    /**
     * is goal completed
     */
    private boolean ready;

    /**
     * what must be completed
     */
    private String goalText;

    /**
     * Constructor for goal.
     *
     * @param day day when goal must be completed
     * @param goalText what must be completed
     */
    public GoalModel(Calendar day, String goalText) {
        this.day = day;
        this.goalText = goalText;
    }

    public Calendar getDay() {
        return day;
    }

    public void setDay(Calendar day) {
        this.day = day;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getGoalText() {
        return goalText;
    }

    public void setGoalText(String goalText) {
        this.goalText = goalText;
    }


}
