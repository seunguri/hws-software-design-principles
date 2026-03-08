package di;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 1. "이 클래스를 스캔해서 객체로 만들어줘"라는 표식
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyDependency { }
