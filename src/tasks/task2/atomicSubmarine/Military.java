package tasks.task2.atomicSubmarine;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Egor on 02.09.2016.
 */
@Documented
@Target(ElementType.FIELD)
public @interface Military {
    Countries country();
}
