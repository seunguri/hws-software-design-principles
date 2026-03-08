package di;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyScanner {
    public static List<Class<?>> scan(String packageName) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        
        // 1. 패키지명(org.example)을 경로(org/example)로 변환
        String path = packageName.replace('.', '/');
        
        // 2. 현재 실행 중인 환경에서 해당 경로의 리소스(폴더)를 가져옴
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(path);
        
        if (resource == null) return classes;

        // 3. 실제 물리적 폴더 경로 확보
        File directory = new File(resource.getFile());

        if (directory.exists()) {
            // 4. 폴더 내의 모든 파일 검사
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    // .class 파일만 골라내기
                    if (file.getName().endsWith(".class")) {
                        String className = packageName + "." + file.getName().replace(".class", "");
                        // 5. 클래스 이름으로 Class 객체 로딩
                        classes.add(Class.forName(className));
                    }
                }
            }
        }
        return classes;
    }
}
