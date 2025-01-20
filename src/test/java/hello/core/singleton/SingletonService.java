package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonService {
    // 1. static 영역에 객체 1개만 생성
    private static final SingletonService instance = new SingletonService();

    // 2. static 매서드를 통해서만 조회 가능
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자 막음
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // SameAs : 객체가 같은지
        // equals : override 된 equals
        assertThat(singletonService).isSameAs(singletonService2);

        singletonService.logic();
    }
}


