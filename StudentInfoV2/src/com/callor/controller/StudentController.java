package com.callor.controller;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV1;

public class StudentController {
	/*
	 * stService 객체를 생성하는 순간
	 *Student.txt 파일 데이터를 읽어
	 *stList가 준비된다.
	 */
	public static void main(String[] args) {
		
		StudentService stService = new StudentServiceImplV1();
		stService.printStudent();
	}

}
