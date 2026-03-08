package di;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // 필드에만 붙일 수 있음
@Retention(RetentionPolicy.RUNTIME) // 실행 중(Runtime)에 리플렉션으로 읽어야 하므로 필수
public @interface MyInject {
}

