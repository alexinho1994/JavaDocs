package ro.teamnet.zth.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Alexandru.Grameni on 7/12/2017.
 */
@Target(ElementType.FIELD)
@Retention(RUNTIME)
public @interface Column {

    String name() default "";
}
