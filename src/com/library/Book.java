package com.library;

import com.library.enums.BookType;
import com.library.enums.Status;

import java.util.Objects;
import java.util.Optional;

public class Book {
    private long id;
    private Author author;
    private String name;
    private double price;
    private Status status;
    private int edition;
    private String dateOfPurchase;
    private BookType bookType;

    public Book(long id, Author author, String name, double price, Status status, int edition, BookType bookType) {
        if(Library.getLibrary().books.values().stream().anyMatch(o -> o.getId() == id)){
            System.out.println("Bu id'ye sahip bir kitap mevcut!");
        }
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = "Kitap şuan kütüphanede.";
        this.bookType = bookType;
    }

    public String getTitle() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Status getStatus() {
        return status;
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return id == book.id && Objects.equals(author, book.author) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, name);
    }

    @Override
    public String toString() {
        return  name + ": {" +
                "Yazar = " + author.getName() + '\'' +
                ", Kiralama Bedeli = " + price + "₺" +
                ", Kitabın Durumu = " + status +
                ", Baskı Sayısı = " + edition +
                ", Veriliş Tarihi = " + dateOfPurchase + '\'' +
                ", Kitap Türü = " + bookType +
                '}';
    }
}
