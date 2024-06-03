package com.sh.book.view;

import com.sh.book.controller.BookController;

import java.util.Scanner;

public class BookView {
    private BookController bookController = new BookController();
    Scanner sc = new Scanner(System.in);
    public void bookMenu() {
        String menu = """
                ===========================================
                도서 관리 메뉴
                1. 도서 등록
                2. 도서 조회
                3. 도서 수정
                4. 도서 삭제
                0. 뒤로가기
                ===========================================
                """;
        System.out.println(menu);
        String choice = sc.next();
        switch (choice) {
            case "1" :
                System.out.println("도서 등록");
                break;
            case "2" :
                findMenu();
                break;
            case "3" :
                System.out.println("도서 수정");
                break;
            case "4" :
                System.out.println("도서 삭제");
                break;
            case "0" :
                return;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    private void findMenu() {
        String menu = """
                ===========================================
                도서 조회 메뉴
                1. 도서 전체 조회
                2. ID로 조회
                3. 도서 이름으로 조회
                4. 도서 저자로 조회
                0. 뒤로가기
                ===========================================
                """;
        System.out.println(menu);
        String choice = sc.next();
        switch (choice) {
            case "1" :
                bookController.findAll();
                break;
            case "2" :
                System.out.println("ID 입력 : ");
                int id = sc.nextInt();
                bookController.findByBookId(id);
                break;
            case "3" :
                System.out.println("도서 이름 입력 : ");
                String title = sc.next();
                bookController.findByBookTitle(title);
                break;
            case "4" :
                System.out.println("저자 이름 입력 : ");
                String author = sc.next();
                bookController.findByAuthor(author);
                break;
            case "0" :
                return;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
}
