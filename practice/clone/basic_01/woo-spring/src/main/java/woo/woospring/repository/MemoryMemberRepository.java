package woo.woospring.repository;

import org.springframework.stereotype.Repository;
import woo.woospring.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // sequence 값에 1씩 추가하여 member id에 넣기
        store.put(member.getId(), member); // member id 를 store 에 넣기
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 이름 과 같은값을 찾아서 리턴 , null 값이면 null 값 반환(Optional 이용해서)
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store 에있는 values( member) 들을 전부 반환
    }
    public void clearStore(){
        store.clear();
    }
}
