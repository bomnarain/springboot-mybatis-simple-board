package kr.co.ggoom.sample.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Board implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int boardSeq;
	private String title;
	private String contents;
	private Date regDate;
	private Date logDate;

}
