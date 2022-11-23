package jpabook.jpabook.domain.onetoone;

import javax.persistence.*;

@Entity
public class BoardDetail {

    @Id
    private Long boardId;

    @MapsId
    @OneToOne
    @JoinColumn(name="BOARD_ID")
    private Board board;

    private String content;
}
