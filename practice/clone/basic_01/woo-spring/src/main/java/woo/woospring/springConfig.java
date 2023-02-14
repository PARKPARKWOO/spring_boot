package woo.woospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import woo.woospring.repository.MemberRepository;
import woo.woospring.repository.MemoryMemberRepository;
import woo.woospring.service.MemberService;

@Configuration
public class springConfig {

    // spring bean 에 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    // memberRepository 를 service 에 등록 repository 는 인터페이스 이기때문에 구현체(memorymember)로 등록
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
