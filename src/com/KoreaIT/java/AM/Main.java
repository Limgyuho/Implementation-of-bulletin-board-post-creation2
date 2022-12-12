package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		// 스캐너 타입의 sc라는 변수를 만들고 스캐너객체를 만들어서 연결한다
		Scanner sc = new Scanner(System.in);

		List<Article> articles = new ArrayList();
		//작성한 대로 공간을 증가하기 위해 ArraytList를 사용해랴한다

		int lastArticleId = 0;
		// while문 밖에 있는 이유는 매번 0이 되면 안되기때문이다

		while (true) {
			// 무한루프
			System.out.println("명령어) ");
			String cmd = sc.nextLine();
			System.out.println("입력된명령어 > " + cmd);

			// 이 안에 있는 명령어가 계속 실행된다

			if (cmd.equals("exit")) {
				// 조건문 cmd라는변수의 값이 exit라는 문자와 같다면
				break;
				// 탈출해라 break를 하지 않으면 무한반복문으로 실행된다
			}
			if (cmd.equals("article write")) {

				int id = lastArticleId + 1;
				lastArticleId = id;
				System.out.println("제목) ");
				String title = sc.nextLine();
				System.out.println("내용) ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				//제목과 내용을 쓰기 위해 article write 기능의 조건문에 있어야 한다
				articles.add(article);
				//ArrayList의 요소를 추가 하기 위함이디

				System.out.printf("%d번글이 생성되었습니다\n", id);

			}

			else if (cmd.equals("article list")) {
				if (articles.size() == 0) {

					System.out.println("게시글이 없습니다");
					continue;
				} else {
					System.out.println("게시물이 있습니다");
				}
				System.out.println("번호   : 제목");
				for(int i = articles.size()-1; i >= 0; i--) {
					//게시물이 저장되고 보여줄때 1번 부터 보여주게 하기 위함
					Article article = articles.get(i);
					
					System.out.printf("%d   :  %s\n",article.id,article.title);  
				}
				
				
			} else {
				System.out.println("존재하디 않는 명령어 입니다");
			}
		}

		sc.close(); // 스캐너기능을 하용하면 반드시 이 실행문을 추가햐야한다

		System.out.println("==프로그램 종료==");

	}

}

class Article {

	int id;
	String title;
	String body;

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

}
