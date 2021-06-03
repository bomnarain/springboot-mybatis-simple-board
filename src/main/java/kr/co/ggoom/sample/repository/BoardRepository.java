package kr.co.ggoom.sample.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ggoom.sample.domain.Board;
import kr.co.ggoom.sample.parameter.BoardSearchParameter;

@Repository
public interface BoardRepository {

	List<Board> getList(BoardSearchParameter parameter) throws Exception;
	
	Board get(int boardSeq) throws Exception;
	
	int save(Board board) throws Exception;
	
	int update(Board board) throws Exception;
	
	int delete(int boardSeq) throws Exception;	
	
}
