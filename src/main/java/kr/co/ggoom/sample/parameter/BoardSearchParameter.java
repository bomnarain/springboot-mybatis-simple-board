package kr.co.ggoom.sample.parameter;

import java.util.List;

import kr.co.ggoom.sample.domain.BoardType;
import lombok.Data;

@Data
public class BoardSearchParameter {

	private String keyword;
	private List<BoardType> boardTypes;

	public BoardSearchParameter() {
		
	}
	
	public BoardSearchParameter(String keyword) {
		this.keyword = keyword;
	}
}
