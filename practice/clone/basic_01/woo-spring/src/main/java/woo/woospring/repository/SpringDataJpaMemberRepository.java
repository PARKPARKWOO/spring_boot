package woo.woospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woo.woospring.domain.Member;

import java.util.Optional;

// spring data jpa

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
