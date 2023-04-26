package com.example.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyDTO;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

// @Controller annotation을 사용하면 View Resolver가 관여하여 REST를 만족시킬 수 없다.

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/*")
@Log4j
public class ReplyController {
	
	private final ReplyService replyService;
	
	// 구글 웹 스토어 - talend 확장 플러그인으로 테스트
	
	
	// 댓글 등록 : json으로 보내기
	// consumes : 외부에서 전달 받을 파라미터 타입
	// @RequestBody : 전달 받은 값과 파라미터를 맵핑한다. 타입이 클래스일 때 사용할 수 있다.
	// produces : 리턴 타입을 정해준다.
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {
		return replyService.register(replyVO) 
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 전체 조회 : xml로 보내기
	// 'bno'만 입력하면 XML, 'bno.json'으로 입력하면 JSON으로 전달
	@GetMapping(value = "/{bno}/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyDTO> getList(@PathVariable("bno") Long bno, @PathVariable("rno") int page) {
		log.info("get list : /" + bno + "/" + page);
		return new ResponseEntity<>(new ReplyDTO(replyService.findAllByBNO(bno, new Criteria(page, 10)), replyService.getTotal(bno)), HttpStatus.OK);
	}
	
	// 댓글 하나 조회
	// Header에 무언가를 담아야 할 때는 반드시 ResponseEntity를 사용해야 한다.
	// 아래의 경우 관련이 없으므로 바로 클래스를 리턴해도 json 형식으로 반환한다.
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ReplyVO getReply(@PathVariable("rno") Long rno) {
		log.info("get reply : " + rno);
		return replyService.findByRNO(rno);
	}
	
	// 댓글 삭제
	// DeleteMapping을 사용하는 실용적인 이유 : 가독성 및 식별 기능
	// 똑같은 rno를 전달하지만, mapping 방식이 달라서 서로 구분이 된다.
	// API에서도 GET과 POST를 사용하기를 권장한다.
	@DeleteMapping(value = "/{rno}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String remove(@PathVariable Long rno) {
		log.info("remove : " + rno);
		return replyService.remove(rno) ? "success" : "fail";
	}
	
	// 댓글 수정
	// PUT : 자원의 전체 수정, 자원 내 모든 필드를 전달해야 함
	// PATCH : 자원의 일부 수정, 수정할 필드만 전송(나머지는 default 값이 들어감 -> optional을 사용)
	// -> 가독성 및 식별 기능
	@PutMapping(value = "/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@PathVariable Long rno, @RequestBody ReplyVO replyVO) {
		replyVO.setRno(rno);
		return replyService.modify(replyVO) ? "success" : "fail";
	}
}
