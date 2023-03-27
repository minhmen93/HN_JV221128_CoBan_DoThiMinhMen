package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private String bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, String bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus ) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sách : ");
        this.bookId = Integer.parseInt(input.nextLine());
        System.out.println("Nhập tên sách : ");
        this.bookName = input.nextLine();
        System.out.println("Nhập tiêu đề sách : ");
        this.title = input.nextLine();
        System.out.println("Nhập số trang sách ");
        this.numberOfPages= Integer.parseInt(input.nextLine());
        System.out.println("Nhập giá nhập sách : ");
        this.importPrice = Float.parseFloat(input.nextLine());
        System.out.println("Nhập giá bán sách : ");
        this.exportPrice= Float.parseFloat(input.nextLine());
        System.out.println("Nhập trạng thái sách : ");
        this.bookStatus = input.nextLine();
        this.interest = this.exportPrice - this.importPrice;
        Book book = new Book(bookId,bookName,title,numberOfPages,importPrice,exportPrice,interest,bookStatus);

    }

    @Override
    public void displayData() {
        System.out.println("BookID "+ bookId);
        System.out.println("BookName "+bookName);
        System.out.println("Title "+title);
        System.out.println("NumberOfPages : "+numberOfPages);
        System.out.println("ImportPrice "+importPrice);
        System.out.println("ExportPrice "+exportPrice);
        System.out.println("Interest "+interest);
        System.out.println("BookStatus "+bookStatus);

    }


    @Override
    public int compareTo(Book books) {
        return Double.compare(this.getInterest(),books.getInterest());
    }
}
