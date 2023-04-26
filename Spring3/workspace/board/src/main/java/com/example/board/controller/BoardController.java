package com.example.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileDTO;
import com.example.board.domain.vo.PageDTO;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

/*
Task		URL				Method			Parameter		Form		URL이동

전체목록	/board/list		GET								
등록		/board/register	POST(길이제한)	BoardVO			입력양식	전체목록
조회		/board/read		GET				bno				
삭제		/board/remove	GET				bno				삭제버튼	전체목록
수정		/board/modify	POST(길이제한)	BoardVO			입력양식	상세보기
*/

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Criteria criteria, Model model) {
		model.addAttribute("boardList", boardService.getList(criteria));
		model.addAttribute("pageDTO", new PageDTO(boardService.getTotal(criteria), criteria));
	}
	
	// ★ redirect를 하는 또 하나의 방법
	@PostMapping("/register")
	public String register(BoardDTO boardDTO, RedirectAttributes rttr) {
		boardService.register(boardDTO);
		
		// redirect를 하면 아래처럼 값을 model에 담아도 requestScope가 날아가버린다.
		// model.addAttribute("bno", boardVO.getBno());
		// 따라서 session 또는 QueryString을 사용해야 한다.
		
		// Session 중에서 Flash라고 하는 영역이 있다.
		// redirect로 초기화되기 전에 Flash 영역에 데이터를 저장해놓고, 초기화 이후 Flash 영역에서 데이터를 가져온다.
		// 데이터를 가져왔다면, Flash 영역의 데이터는 없어진다.
		rttr.addFlashAttribute("bno", boardDTO.getBno());
		
		// redirect로 전송할 때는 경로 앞에 "redirect:"를 붙여준다.
		return "redirect:/board/list";
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(Criteria criteria, Long bno, HttpServletRequest request, Model model) {
		 String url = request.getRequestURI(); // URL 안에 URI가 있으므로, 잘 모르겠으면 그냥 URL로 하면 된다.
		 log.info(url.substring(url.lastIndexOf("/")) + "?bno=" + bno);
		model.addAttribute("board", boardService.get(bno));
		
		// return이 없어도 views 아래에 /board/read 또는 /board/modify 경로를 가진 파일이 있으므로 자동으로 거기로 향한다.
	}
	
	@GetMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(Criteria criteria, BoardVO boardVO, RedirectAttributes rttr) {
		
		if(boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		// rttr.addAttribute("pageNum", criteria.getPageNum());
		return "redirect:/board/list" + criteria.getParams();
	}
	
	
	// ===================================================================================================
	
	
	@GetMapping("/register") // 같은 경로더라도 get이냐 post냐에 따라서 이동하는 페이지가 달라질 수 있다.
	public void register() {
		
	}
	
	// 첨부파일 전체 목록
	@GetMapping(value = "/files", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<FileDTO> getFiles(Long bno){
		return boardService.getFiles(bno);
	}
}
