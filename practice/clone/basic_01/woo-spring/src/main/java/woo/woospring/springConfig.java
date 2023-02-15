package woo.woospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import woo.woospring.repository.JdbcTemplateMemberRepository;
import woo.woospring.repository.JpaMemberRepository;
import woo.woospring.repository.MemberRepository;
import woo.woospring.repository.MemoryMemberRepository;
import woo.woospring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class springConfig {
    // JDBC 할때 사용하는 datasource
//    private DataSource dataSource;
//    @Autowired
//    public springConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    // JPA
//    private EntityManager em;
//
//    @Autowired
//    public springConfig(EntityManager em) {
//        this.em = em;
//    }
    // SpringDataJpa
    private final MemberRepository memberRepository;

    @Autowired
    public springConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // spring bean 에 등록
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    } jdbc, jpa 시 사용
    // springdatajpa 사용
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    // memberRepository 를 service 에 등록 repository 는 인터페이스 이기때문에 구현체(memorymember)로 등록
//    @Bean
//    public MemberRepository memberRepository() {
// DB사용 안할때        return new MemoryMemberRepository();
// JDBC 사용        return new JdbcTemplateMemberRepository(dataSource);
// jpa        return new JpaMemberRepository(em);

//    }

}
