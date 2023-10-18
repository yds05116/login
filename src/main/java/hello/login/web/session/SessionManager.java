package hello.login.web.session;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@Component
public class SessionManager {
    private Map<String,Object> sessionStore = new ConcurrentMap<String, Object>() // 동시성 이슈 있을 수 있으므로 ConcurrentMap 사용 {
    }
}
