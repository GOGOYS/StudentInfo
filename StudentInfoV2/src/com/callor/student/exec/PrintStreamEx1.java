package com.callor.student.exec;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.callor.utils.Line;

public class PrintStreamEx1 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println("우리나라만세");
		ps.println("우리나라만세");
		
		//PrintStream이 완전 짱이다
		PrintStream ps1 = new PrintStream("data.txt");
		ps1.println("우리나라만세");
		
		ps1.println(Line.dLine(50));
		ps1.println("7단 구구단");
		ps1.println(Line.dLine(50));
		for(int i =1; i < 10; i++) {
			ps1.printf("%d x %d = %d\n",7, i, 7*i);
		}
		ps1.println(Line.dLine(50));
		ps1.close();
	}
}
