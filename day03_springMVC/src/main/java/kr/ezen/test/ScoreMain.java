package kr.ezen.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//public class ScoreMain {
//	public static void main(String[] args) {
//		String kor = args[0];
//		String eng = args[1];
//		String math = args[2];
//		
//		int kScore = Integer.parseInt(kor);
//		int eScore = Integer.parseInt(eng);
//		int mScore = Integer.parseInt(math);
//		
//		int total = kScore+eScore+mScore;
//		double avg = total /3.0;
//		
//		String strAvg = String.format("%.2f", avg);
//		
//		System.out.println("총점: "+ total );
//		System.out.println("평균: "+ strAvg );
//		
//	}
//}

//요청(자동 객체생성)
@Controller
public class ScoreMain {
	
	//요청되면 메인이 실행이 되도록
	@RequestMapping("/score")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
				
//		String kor = args[0];
//		String eng = args[1];
//		String math = args[2];
		
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String math = request.getParameter("math");
		
		int kScore = Integer.parseInt(kor);
		int eScore = Integer.parseInt(eng);
		int mScore = Integer.parseInt(math);
		
		int total = kScore+eScore+mScore;
		double avg = total /3.0;
		
		String strAvg = String.format("%.2f", avg);
		
		//출력
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
	      out.println("<html>");
	      out.println("<head>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("총점 : " + total + "점");
	      out.println("평균 : " + strAvg + "점");      
	      out.println("</body>");      
	      out.println("</html>");
		
	}
}
