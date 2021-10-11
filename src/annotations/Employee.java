package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Monday 11 October 2021 - 7:06 AM
 */
public class Employee {
    @EmployeeSchedule(value = 9, hoursPerDay = 8, startHour = 4) private void earlyShift(){
        System.out.println("coming early");
    }

    @EmployeeSchedule(9) private void soldiersShift(){
        System.out.println("security officers shift");
    }

    public static void main(String[] args) {
        new Employee().soldiersShift();
    }

}
