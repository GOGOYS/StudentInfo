package com.callor.student.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.model.StudentVO;
import com.callor.student.service.StudentService;
import com.callor.utils.Line;

public class StudentServiceImpl implements StudentService{
	
	protected final String saveFile;
	protected final Scanner scan;
	protected final List<StudentVO> stList;
	
	public StudentServiceImpl() {
		this("src/com/callor/student/model/saveFile.txt");
	}
	public StudentServiceImpl(String saveFile) {
		scan = new Scanner(System.in);
		stList = new ArrayList<>();
		this.saveFile = saveFile;
	}
	
	
	public void loadStudent() {
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(this.saveFile);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			return;
		}
		scan = new Scanner(is);
		
		int NUM = 0;
		int NAME =1;
		int DEPT =2;
		int GRADE =3;
		final int TEL =4;
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] st = line.split(":");
			
			if(st.length < TEL+1) continue;
			
			StudentVO stVO = new StudentVO();
			
			stVO.setStNum(st[NUM]);
			stVO.setStName(st[NAME]);
			stVO.setStDept(st[DEPT]);
			stVO.setStGrade(st[GRADE]);
			stVO.setStTel(st[TEL]);
			
			stList.add(stVO);	
		}
		
		printStudent();
	}
	
	


	@Override
	public void inputStudent() {
		System.out.println(Line.dLine(50));
		System.out.println("학생 정보를 입력해 주세요");
		System.out.println(Line.sLine(50));
		while(true) {
			StudentVO stVO = new StudentVO();
			System.out.println("학번 >>");
			String stNum = scan.nextLine();
			stVO.setStNum(stNum);
			System.out.println("이름 >>");
			String stName = scan.nextLine();
			stVO.setStName(stName);
			System.out.println("학과 >>");
			String stDept = scan.nextLine();
			stVO.setStDept(stDept);
			System.out.println("학년 >>");
			String stGrade = scan.nextLine();
			stVO.setStGrade(stGrade);
			System.out.println("전화번호 >>");
			String stTel = scan.nextLine();
			stVO.setStTel(stTel);
			
			stList.add(stVO);
			System.out.println("그만하시겠습니까 : YES");
			String yes = scan.nextLine();
			
			if(yes.equals("YES")) {
				break;
			}
			
		}
		
	}
	
	public void save(String saveFile) throws IOException {
		
		FileWriter writer = null;
		PrintWriter out = null;
		
		writer = new FileWriter(saveFile);
		out = new PrintWriter(writer);
		
		for(StudentVO vo : stList) {
			out.printf("%s:",vo.getStNum());
			out.printf("%s:",vo.getStName());
			out.printf("%s:",vo.getStDept());
			out.printf("%s:",vo.getStGrade());
			out.printf("%s\n",vo.getStTel());
		}
		
		out.flush();
		out.close();
		writer.close();
		
	}

	@Override
	public void printStudent() {
		System.out.println("=".repeat(50));
		System.out.println("학생정보 리스트");
		System.out.println("-".repeat(50));
		System.out.printf("학번\t 이름\t 학과\t 학년\t 전화번호\n");
		for(StudentVO stVO : stList) {
			System.out.println(stVO.toString());
		}
		System.out.println("=".repeat(50));
	}

}
