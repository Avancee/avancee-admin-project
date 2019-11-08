package com.github.avancee.admin.core.annotation;

import java.lang.annotation.*;

/**
 * log process annotation
 *
 * @see LogProcessor
 * @author byference
 * @since 2019-11-08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
