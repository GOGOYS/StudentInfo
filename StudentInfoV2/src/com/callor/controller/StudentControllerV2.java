package com.callor.controller;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.callor.student.model.StudentVO;
import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV2;

public class StudentControllerV2 {
	
	/*
	 * ControllerV1 에서는 ServiceV1을 사용할때 
	 * 단순히 기본 생성자를 호출하여 ServiceV1에서 stList와 fileName을 
	 * 직접 관리 하도록 하였다. 
	 * 만약 List 변수와 file을 다른 변수로 바꾸려면 serviceV1 코드를 변경해야하는데
	 * ControllerV2에서는 ServiceV2를 사용할때 
	 * stList와 file변수를 생성자 매개변수로 전달하고 있다
	 * 이러한 경우는 컨트롤러와 서비스간의 결합도를 낮추어 더 좋은 패턴의 코드가 된다.-
	 */
	public static void main(String[] args) throws FileNotFoundException {
		List<StudentVO> stList = new ArrayList<>();
		String fileName ="src/com/callor/student/student.txt";
		
		
		//java 1.5에상에서 text 파일에 내용을 기록하기 위하여
		//단독으로 사용할 수 있는 클래스
		String printFile ="src/com/callor/student/print.txt";
		PrintStream ps = new PrintStream(printFile);
		PrintStream psConsole = System.out;
		
		//stList와 원본 데이터(studnet.txt) 파일을 생성자에 주입하여
		//student.txt 파일에서 데이터를 읽어 stList를 준비해라
		StudentService stService = new StudentServiceImplV2(stList, fileName, ps);
		
		stService.printStudent();
		
		StudentService stService1 = new StudentServiceImplV2(stList, fileName, psConsole);
		stService1.printStudent();
	}
}
