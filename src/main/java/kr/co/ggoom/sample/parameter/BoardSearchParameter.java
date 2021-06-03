package kr.co.ggoom.sample.parameter;

import lombok.Data;

@Data
public class BoardSearchParameter {

	private String keyword;

	public BoardSearchParameter() {
		
	}
	
	public BoardSearchParameter(String keyword) {
		this.keyword = keyword;
	}
}
