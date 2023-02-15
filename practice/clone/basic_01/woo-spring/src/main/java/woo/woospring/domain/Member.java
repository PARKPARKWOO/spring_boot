package woo.woospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // pk(id)를 자동으로 추가
    private Long id; // 데이터를 구분하기 위한 시스템이 정하는 임의의 값

   // @Column(name = "username")  name 속성을 username으로 하고싶을때
    private String name; // 그냥 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
