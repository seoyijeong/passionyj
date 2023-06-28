package kr.ezen.ajax2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class FileController {
	@RequestMapping("/form.do")
	public String form() {
		return "uploadForm";
	}
	// 파일 업로드 시 필요한 API : Apache Commons FileUpload
	// https://mvnrepository.com/ 파일 다운
	// Apache Commons FileUpload 검색하여 최상위 버전 다운
	// pom.xml 에 파일 붙여넣기
	// 자바 설정 ->servletConfig
	// 스프링 설정 -> servlet-context.xml
	// fileRepo 파일 만들기, 파일 업로드 폴더 지정

	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest mhr, HttpServletRequest request, Model model) throws IOException {

		String repo = "resources/fileRepo";

		// 서버의 실제 물리경로 얻어오기
		// separator : 윈도우 시스템 (os :\\) (리눅스 ://)에 따라 변경해줌
		String savePath = request.getServletContext().getRealPath("") + File.separator + repo;
		System.out.println(savePath);

		Map map = new HashMap();

		// MultipartHttpServletRequest mhr: text파일, 바이너리 파일의 정보를 모두 얻어 올 수 있다.
		Enumeration<String> enu = mhr.getParameterNames();

		// 일반 텍스트 파일의 파라미터 명(key), 파라미터명에 해당하는 값(value =브라우저에서 넘겨받은 값)을 가져옴
		// key value 형태로 받아옴
		while (enu.hasMoreElements()) {
			String paramName = enu.nextElement();
			String paramValue = mhr.getParameter(paramName);

			System.out.println(paramName + ":" + paramValue);
			map.put(paramName, paramValue);
		}
		// 파일에 대한 정보 가져오기
		// getFileNames 는 이터레이터로 불러와야함
		Iterator<String> iter = mhr.getFileNames();
		// 파일을 한개씩 담기
		List<String> fileList = new ArrayList<String>();

		while (iter.hasNext()) {
			String fileParamName = iter.next();
			System.out.println("fileParamName :" + fileParamName);

			// MultipartFile : 파일 정보를 갖고있는 객체(해당 파라미터)
			// mFile 로 사이즈, 이름 등을 알 수 있다
			MultipartFile mFile = mhr.getFile(fileParamName);

			// 실제 파일을 올릴때의 이름(ex)8be72c9b2.jpg)
			String originName = mFile.getOriginalFilename();
			System.out.println("originName :" + originName);

			// 현재 경로 fileRepo + 파라미터 네임(file)
			File file = new File(savePath + "\\" + fileParamName);

			if (mFile.getSize() != 0) { // 실제 업로드가 된 경우(사이즈가 0보다 크기 때문)
				if (!file.exists()) { // 파일이 실제 경로에 존재하지 않으면 최초로 한번만 실행
					if (file.getParentFile().mkdir()) { // savePath에 지정된 폴더(fileRepo) 생성
						file.createNewFile(); // 임시파일 생성
					} // if
				} // if

				// 실제 파일 이름
				File uploadFile = new File(savePath + "\\" + originName);

				// 파일 중복처리 //초 단위로 쪼개진 시간으로 업로드된 사진 파일 중복 처리
				// 파일이 중복되면 시간 값으로 파일명 대체
				if (uploadFile.exists()) { // true 리턴
					originName = System.currentTimeMillis() + " " + originName;
					uploadFile = new File(savePath + "\\" + originName);
				}

				// 실제 파일 업로드 하기
				mFile.transferTo(uploadFile);
				fileList.add(originName);
			} // if
		} // while

		map.put("fileList", fileList);
		model.addAttribute("map", map);

		// view에서 map을 불러와 전부 뿌려줌

		return "uploadResult";
	}

	// 파일을 다운로드 하려면
	// 1. 서버로 다운로드 요청
	// 2. 서버에서 파일 찾기
	// 3. 서버에서 읽어오기
	// 4. 폴더에 빨대 꽂아서 가져오기
	// 5. 출력 스트림을 만들어서 전달하기
	// input과 output 스트림 만들기
	@RequestMapping("/download.do")
	// @RequestParam 파일네임으로 넘어온 파라미터값 받기
	public void download(@RequestParam("fileName") String fileName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String repo = "resources/fileRepo";

		String savePath = request.getServletContext().getRealPath("") + File.separator + repo;
		// 파라미터로 넘어온 값 받기
		File file = new File(savePath + "\\" + fileName);

		// 다운로드를 위한 준비과정 //문법 이므로 그냥 붙여서 씀
		response.setContentLength((int) file.length());  //파일의 크기
		response.setContentType("application/x-msdownload;charset=utf-8");  //context 타입

		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ";");  //꼭 들어가야함 //attachment :첨부
		response.setHeader("Content-Transfer-Encoding", "binary");
//	      response.setHeader("Pragma", "no-cache");
//	      response.setHeader("Expires", "0");
		
		//다운로드 //예외처리
		FileInputStream fis = new FileInputStream(file);
		//출력스트림
		OutputStream out= response.getOutputStream();
		//바이너리 파일이므로 바이트로 전송
		byte[] buffer = new byte[1024];
		
		//버퍼에 담긴 값이 없어질때까지 계속 읽음
		while(true) {
			int cnt = fis.read(buffer);
			if(cnt == -1) { //파일을 전부 다 읽으면(파일의 끝:end of file) -1을 리턴하게됨 (더이상 읽을것이 없음)
				break;
			}
			out.write(buffer, 0, cnt); //읽어 들인 만큼 스트림에 출력
		}
		//다 읽고 자원 반납
		fis.close();
		out.close();
	}

}