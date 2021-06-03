package kr.co.ggoom.sample.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.ggoom.sample.configuration.exception.BaseException;
import kr.co.ggoom.sample.configuration.http.BaseResponse;
import kr.co.ggoom.sample.configuration.http.BaseResponseCode;
import kr.co.ggoom.sample.configuration.http.ErrorResponse;
import kr.co.ggoom.sample.domain.Board;
import kr.co.ggoom.sample.service.BoardService;


@RestController
@RequestMapping("/board")
@Tag(name = "board RestController", description = "게시물 REST컨트롤러입니다.")
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired(required=true)
	private BoardService boardService;
	
	// CRUD : Read
	@GetMapping("/")
	public String hellow() throws URISyntaxException {
		System.out.println("/");
		return "Hello Spring Boot";
	}
	
	// CRUD : Read
	@Operation(summary = "게시물 목록", description = "게시물 목록조회API입니다.", responses = {
					@ApiResponse(responseCode = "200", description = "successful operation",
							content = @Content(array = @ArraySchema(schema = @Schema(implementation = Board.class)))),
					@ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", 
							content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
					@ApiResponse(responseCode = "500", description = "Internal server error",
							content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
					})	
	@GetMapping("/list")
	public BaseResponse<List<Board>> getList() throws Exception {
		logger.info("getList");
		return new BaseResponse<List<Board>>(boardService.getList());
	}
	
	// CRUD : Read
	@Operation(summary = "게시물 내용", description = "게시물 내용조회API입니다.", tags = { "contact" })
	@ApiResponses(value = {
					@ApiResponse(responseCode = "200", description = "successful operation",
							content = @Content(array = @ArraySchema(schema = @Schema(implementation = Board.class)))) })		
	@GetMapping("/{boardSeq}")
	public BaseResponse<Board> get(@PathVariable int boardSeq) throws Exception {
		Board board = boardService.get(boardSeq);
		// null 처리
		if (board == null) {
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물이 없습니다."});
		}		
		return new BaseResponse<Board>(board);
	}
	
	// CRUD : Create
	@SuppressWarnings("deprecation")
	@Operation(summary = "게시물 등록", description = "게시물 등록API입니다.", tags = { "contact" })
	@ApiResponses(value = {
					@ApiResponse(responseCode = "200", description = "successful operation",
							content = @Content(array = @ArraySchema(schema = @Schema(implementation = Board.class)))) })
	@Parameters({
		@Parameter(name="boardSeq", description ="게시물번호", example = "1")
	})
	@PostMapping("/save")
	public BaseResponse<Integer> save(@RequestBody Board parameter) throws Exception {
		// 제목 필수
		if (StringUtils.isEmpty(parameter.getTitle())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"title","제목"});
		}
		// 내용 필수
		if (StringUtils.isEmpty(parameter.getContents())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"contents","내용"});
		}		
		return new BaseResponse<Integer>(boardService.save(parameter));
	}

	// CRUD : Update
	@Operation(summary = "게시물 수정", description = "게시물 수정API입니다.", tags = { "contact" })
	@ApiResponses(value = {
					@ApiResponse(responseCode = "200", description = "successful operation",
							content = @Content(array = @ArraySchema(schema = @Schema(implementation = Board.class)))) })	
	@PutMapping("/update")
	public  BaseResponse<Boolean> update(Board parameter) throws Exception {
		Boolean resultValue = false;
		System.out.println(parameter.toString());
		Board board	= boardService.get(parameter.getBoardSeq());
		if ( board != null ) {
			if ( boardService.update(parameter) > 0 ) {
				resultValue = true;
			}
		}
		return new BaseResponse<Boolean>(resultValue); 
	}
	
	// CRUD : Delete
	@Operation(summary = "게시물 삭제", description = "게시물 삭제API입니다.", tags = { "contact" })
	@ApiResponses(value = {
					@ApiResponse(responseCode = "200", description = "successful operation",
							content = @Content(array = @ArraySchema(schema = @Schema(implementation = Board.class)))) })	
	@DeleteMapping("/delete")
	public BaseResponse<Boolean> delete(int boardSeq) throws Exception {
		return new BaseResponse<Boolean>((boardService.delete(boardSeq) > 0 )? true : false );
	}	
}