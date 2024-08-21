package com.library;

import com.library.enums.BookType;
import com.library.enums.Status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Librarian {
    private long id;
    private String name;
    private String password;

    public Librarian(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public Status searchBook(long bookId){
        return Library.getLibrary().books.get(bookId).getStatus();
    }

    public boolean verifyMember(Reader reader){
        return Library.getLibrary().readers.get(reader.getId()).equals(reader);
    }

    public BookType issueBook(long id){
        return Library.getLibrary().books.get(id).getBookType();
    }

    public double createBill(Reader reader){
        List<Double> prices = new ArrayList<>();
        prices.addAll((Collection<? extends Double>) reader.getNoBooksIssued().stream().map(Book::getPrice));
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Librarian librarian)) return false;
        return Objects.equals(name, librarian.name) && Objects.equals(password, librarian.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
