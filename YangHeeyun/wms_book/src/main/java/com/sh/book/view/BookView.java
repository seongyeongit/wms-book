package com.sh.book.view;

import java.util.Scanner;

public class BookView {
    private MainView mainView = new MainView();

    private Scanner sc = new Scanner(System.in);
    private MainView mainView = new MainView();

    public void bookMenu(){
        String menu = """
        =====================
        1. 도서 정보 등록
        2. 도서 정보 수정
        3. 도서 목록 조회
        4. 도서 목록 검색
        =====================
        입력 : """;

        while(true){
            System.out.println(menu);
            String choice = sc.next();
            switch(choice){
                case "1" : break;
                case "2" : break;
                case "3" : break;
                case "4" : break;
                case "0" : ; return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
