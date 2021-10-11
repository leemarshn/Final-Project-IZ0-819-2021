package annotations;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Monday 11 October 2021 - 6:26 AM
 */
public class Peacock {

    @ZooSchedule(hour = {"4am", "5pm"}) void cleanPeacocksPen(){
        System.out.println("Cleaning peacocks pen");
    }
}
