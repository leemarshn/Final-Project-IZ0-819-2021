package annotations;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Monday 11 October 2021 - 6:14 AM
 */
public class Lion {
    @ZooSchedule(hour={"9am", "5pm", "10pm"}) private void feedLion(){
        System.out.println("Time to feed Lions");
    }
}
