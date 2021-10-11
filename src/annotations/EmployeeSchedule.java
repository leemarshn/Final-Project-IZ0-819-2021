package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Monday 11 October 2021 - 7:04 AM
 */

@Target({ElementType.TYPE, ElementType.METHOD})
public @interface EmployeeSchedule {
    int hoursPerDay() default 12;
    int startHour() default 8;
    int value();

}
