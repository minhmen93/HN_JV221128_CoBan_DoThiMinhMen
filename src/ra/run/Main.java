package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        int choice = 0;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số sách và nhập thông tin sách \n" +
                    "2. Hiển thị thông tin các sách \n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần \n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm sách theo tên sách \n" +
                    "6. Thay đổi trạng thái của sách theo mã sách \n" +
                    "7. Thoát ");
            System.out.println("Nhập sự lựa chon của bạn : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào số lượng sách cần thêm : ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Book " + (i + 1) + " : ");
                        Book book = new Book();
                        book.inputData();
                        System.out.println("Nhập trạng thái của sách : 1 là Còn sách, 2 là Hết sách)");
                        int statusChoice = scanner.nextInt();
                        if (statusChoice == 1) {
                            book.setBookStatus("Còn sách");
                        } else if (statusChoice == 2) {
                            book.setBookStatus("Hết sách");
                        } else {
                            System.out.println("Lựa chọn không hợp lệ, sách được đánh dấu là đã hết sách .");
                            book.setBookStatus("Không có sẵn");
                        }
                        books.add(book);
                    }
                    break;
                case 2:
                    if (books.isEmpty()) {
                        System.out.println("Không có sách trong danh sách.");
                    } else {
                        System.out.println("Danh sách các sách hiện có : ");
                        for (Book book : books) {
                            book.displayData();
                        }
                    }
                    break;
                case 3:

                    System.out.println("Sắp xếp sách theo lợi nhuận giảm dần : ");
                    Collections.sort(books);
                    for (Book book : books) {
                        book.displayData();
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    int bookId = scanner.nextInt();
                    boolean isRemoved = false;
                    for (Book book : books) {
                        if (book.getBookId() == bookId) {
                            books.remove(book);
                            isRemoved = true;
                            break;
                        }
                    }
                    if (isRemoved) {
                        System.out.println("Đã xóa sản phẩm có mã " + bookId);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm có mã " + bookId);
                    }
                    break;
                case 5:
                    if (books.isEmpty()) {
                        System.out.println("Không có sách trong danh sách. ");
                    } else {
                        System.out.println("Nhập vào tên sách cần tìm kiếm : ");
                        String searchName = scanner.next();
                        List<Book> matchingBooks = new ArrayList<>();
                        for (Book book : books) {
                            if (book.getBookName().equalsIgnoreCase(searchName)) {
                                matchingBooks.add(book);
                            }
                        }
                        if (matchingBooks.isEmpty()) {
                            System.out.println("Không tìm thấy sách có tên " + searchName + " .");
                        } else {
                            System.out.println("Danh sách các sách có tên " + searchName + " : ");
                            for (Book book : matchingBooks) {
                                book.displayData();
                            }
                        }
                    }
                    break;
                case 6:
                    if (books.isEmpty()) {
                        System.out.println("Không có sách trong danh sách.");
                    } else {
                        System.out.println("Nhập vào mã sách cần thay đổi trạng thái : ");
                        int bookIdChange = scanner.nextInt();
                        boolean foundBook = false;
                        for (Book book : books) {
                            if (book.getBookId()== bookIdChange){
                                foundBook = true;
                                System.out.println("Trạng thái hiện tại của sách : "+book.getBookStatus()+" .");
                                System.out.println("Nhập vào trạng thái mới của tình trạng sách (1. Còn sách, 2.Hết sách ");
                                int newStatus = scanner.nextInt();
                                if (newStatus == 1) {
                                    System.out.println(book.getBookStatus());
                                } else if (newStatus == 2) {
                                    book.setBookStatus("Hết sách");
                                } else {
                                    System.out.println("Trạng thái không hợp lệ.");
                                }
                                System.out.println("Trạng thái của sách \"" + book.getBookName() + "\" đã được thay đổi thành \"" + book.getBookStatus() + "\".");
                                break;
                            }
                        }

                        if (!foundBook) {
                            System.out.println("Không tìm thấy sách có mã \"" + bookIdChange + "\".");
                        }
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);


    }
}
