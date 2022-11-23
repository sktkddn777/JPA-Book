package jpabook.jpabook.domain;

import javax.persistence.*;

//@Entity
//@SequenceGenerator(
//        name = "BOARD_SEQ_GENERATOR",
//        sequenceName = "BOARD_SEQ",
//        initialValue = 1,
//        allocationSize = 1
//)
@TableGenerator(
        name = "BOARD_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "BOARD_SEQ",
        allocationSize = 1
)
public class Board {

    @Id
    @GeneratedValue(
//            strategy = GenerationType.IDENTITY,
//            strategy = GenerationType.SEQUENCE,
            strategy = GenerationType.TABLE,
            generator = "BOARD_SEQ_GENERATOR"
    )
    private Long id;
}
