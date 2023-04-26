package com.example.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.domain.vo.FileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class FileController {
	
	// @ResponseBody : 일반 컨트롤러에서 REST로 사용해야 할 때 작성하는 annotation
	@PostMapping(value="/upload", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<FileDTO>> upload(MultipartFile[] multipartFiles){
		log.info("upload");
		
		List<FileDTO> files = new ArrayList<FileDTO>();
		String uploadDirectory = "C:/Users/HP/Desktop/Coding/Spring3_psam/workspace/board/src/main/webapp/resources/upload";
		String uploadDatePath = getDirectoryForm();
		
		File uploadPath = new File(uploadDirectory, uploadDatePath);
		log.info("uploadPath : " + uploadPath);
		
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile multipartFile : multipartFiles) {
			log.info("upload file name : " + multipartFile.getOriginalFilename());
			log.info("upload file size : " + multipartFile.getSize());
			
			FileDTO fileDTO = new FileDTO();
			
			String originalFileName = multipartFile.getOriginalFilename();
			
			String fileName = null;
			
			UUID uuid = UUID.randomUUID();
			fileName = uuid.toString() + "_" + originalFileName;
			
			fileDTO.setUuid(uuid.toString());
			fileDTO.setFileName(originalFileName);
			fileDTO.setUploadPath(uploadDatePath);
			
			try {
				File file = new File(uploadPath, fileName);
				multipartFile.transferTo(file); // 해당 경로에 파일 업로드
				
				// 이미지일 경우 섬네일 만들기
				InputStream in = new FileInputStream(file);
				if(checkImageType(file)) {
					fileDTO.setFileType(true);
					
					FileOutputStream out = new FileOutputStream(new File(uploadPath, "t_" + fileName));
					Thumbnailator.createThumbnail(in, out, 100, 100);
					in.close();
					out.close();
				}
				
				files.add(fileDTO);
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<List<FileDTO>>(files, HttpStatus.OK);
	}
	
	private String getDirectoryForm() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date today = new Date();
		return simpleDateFormat.format(today);
	}
	
	private boolean checkImageType(File file) throws IOException {
		
		// Header에 포함된 파일 종류를 알 수 있는 메소드
		String contentType = Files.probeContentType(file.toPath());
		return contentType.startsWith("image");
	}
	
	// 이미지를 가져오기 위해 byte[]를 가져온다.
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName){
		
		File file = new File("C:/Users/HP/Desktop/Coding/Spring3_psam/workspace/board/src/main/webapp/resources/upload/" + fileName);
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		
		// springframework의 HttpHeaders이다.
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping(value="/download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> download(String fileName) {
		Resource resource = new FileSystemResource("C:/Users/HP/Desktop/Coding/Spring3_psam/workspace/board/src/main/webapp/resources/upload/" + fileName);
		if(!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders header = new HttpHeaders();
		
		String resourceName = resource.getFilename();
		resourceName = resourceName.substring(resourceName.indexOf("_") + 1);
		
		try {
			header.add("Content-Disposition", "attachment; filename=" + new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("fileName") String fileName,@RequestParam("fileType") boolean fileType) {
		File file = null;
		try {
			file = new File("C:/Users/HP/Desktop/Coding/Spring3_psam/workspace/board/src/main/webapp/resources/upload/" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			
			// grabage collector를 불러와서 기존에 열려있던 stream을 모두 닫는다(최종수단).
			// grabage collector를 내 마음대로 조작하면 문제도 생길 수 있고, 실행속도도 느려진다.
			// 글 삭제와 같이, 다른 알고리즘으로 작성하면 아마 첨부파일 삭제가 잘 될 것이다.
			System.gc();
			System.runFinalization();
			
			if(fileType) {
				file = new File(file.getPath().replace("t_", ""));
				file.delete();
			}
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "deleted";
	}
}




