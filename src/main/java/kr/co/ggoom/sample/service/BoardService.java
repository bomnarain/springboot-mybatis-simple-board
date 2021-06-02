package kr.co.ggoom.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ggoom.sample.domain.Board;
import kr.co.ggoom.sample.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired(required=true)
	private BoardRepository boardRepository;
	
	public List<Board> getList() throws Exception{
		return boardRepository.getList();
	}
	
	public Board get(int boardSeq) throws Exception {
		return boardRepository.get(boardSeq);
	}
	
	public int save(Board board) throws Exception {	
		boardRepository.save(board);
		return board.getBoardSeq();
	}
	
	public int update(Board board) throws Exception {
		return boardRepository.update(board);
	}
	
	public int delete(int boardSeq) throws Exception {
		return boardRepository.delete(boardSeq);
	}	
	
	
}
