package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.*;

@Slf4j
@Repository
public class MemberRepository {
    private static Map<Long,Member> store = new HashMap<>(); //static 사용
    private static long sequence = 0L; //static 사용
    public Member save(Member member){
        member.setId(++sequence);
        log.info("save: member = {}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }
    public List<Member> findAll(){
    return new ArrayList<>(store.values()); //store의 key를 제외한 value만 뽑아 List로 만듬
    }
    public Optional<Member> findByLoginId(String loginId){
        /*List<Member> all = findAll();
        for (Member m : all) {
            if(m.getLoginId().equals(loginId)){
                return Optional.of(m);
            }
        }
        return Optional.empty();*/
        return findAll().stream().filter(m->m.getLoginId().equals(loginId)).findFirst();
    }
    public void clearStore(){
        store.clear();
    }
}
