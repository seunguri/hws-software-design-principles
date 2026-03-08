package di;

import java.lang.reflect.Field;
import java.util.List;

public class MyContainer {
    // 객체를 생성하고 의존성을 주입해주는 마법의 메서드
    public static <T> T getBean(Class<T> classType) throws Exception {
        // 1. 요청받은 클래스의 인스턴스를 먼저 생성 (Service 생성)
        T instance = classType.getDeclaredConstructor().newInstance();
        // 2. 클래스의 모든 필드를 조사
        for (Field field : classType.getDeclaredFields()) {

            // 3. 필드에 @MyInject 어노테이션이 붙어 있는지 확인
            if (field.isAnnotationPresent(MyInject.class)) {
                // 4. 주입할 부품(Repository) 객체 생성
                Object dependency = findDependency(field.getType());
                if (dependency != null) {
                    // 5. private 필드 접근 허용 및 값 주입
                    field.setAccessible(true);
                    field.set(instance, dependency);
                    System.out.println(field.getName() + " 필드에 객체 주입 완료!");
                }
            }
        }
        return instance;
    }

    /**
     * 프로젝트 내의 클래스들을 스캔하여 조건에 맞는 @MyDependency 객체를 찾아 생성합니다.
     */
    private static Object findDependency(Class<?> targetType) throws Exception {
        // 실제 패키지 경로에 맞게 수정 (예: "org.example")
        List<Class<?>> allFileClasses = MyScanner.scan("messaging");
        for (Class<?> clazz : allFileClasses) {
            // 조건: 1. @MyDependency가 붙어 있는가? 2. 주입하려는 타입(인터페이스/클래스)과 호환되는가?
            if (clazz.isAnnotationPresent(MyDependency.class) &&
                    targetType.isAssignableFrom(clazz)) {
                return clazz.getDeclaredConstructor().newInstance();
            }
        }
        throw new RuntimeException(targetType.getSimpleName() + " 타입을 구현한 @MyDependency 클래스를 찾을 수 없습니다.");
    }
}
