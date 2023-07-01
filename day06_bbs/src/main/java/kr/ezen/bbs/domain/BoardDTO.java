package kr.ezen.bbs.domain;

//model 을 domain 으로도 사용
//domain에 dao, dto 등을 설정해줌

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
//data 는 getter와 setter를 자동으로 만들어 준다.
//필요한것만 넣어 주어도 된다.
//@Setter
//@Getter
//@ToString
public class BoardDTO {
	private int bid;
	private String subject;
	private String contents;
	private int hit;
	private String writer;
	private Date reg_date;
}
