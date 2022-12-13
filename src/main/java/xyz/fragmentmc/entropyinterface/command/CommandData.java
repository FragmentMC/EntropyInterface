package xyz.fragmentmc.entropyinterface.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandData {
    String name();

    String message() default "";
}
