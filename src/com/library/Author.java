package com.library;

import com.library.enums.ReaderType;
import com.library.enums.UserType;
import com.library.interfaces.ShowBooks;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Author extends Member implements ShowBooks {

    private Set<Book> myBooks = new HashSet<>();

    public Set<Book> getMyBooks() {
        return myBooks;
    }

    public Author(long id, String name, String address, String phoneNo) {
        super(id, name, address, phoneNo, UserType.AUTHOR, LocalDate.now());
    }

    public void newBook(Book book){
        if(!myBooks.equals(book)){
            myBooks.add(book);
        } else {
            System.out.println("Bu kitap, zaten profilinize eklenmiş durumda.");
        }
    }

    @Override
    public String whoAreYou() {
        return getType() + " " + getName();
    }

    @Override
    public void showBooks() {
        myBooks.forEach(Book::toString);
    }
}
