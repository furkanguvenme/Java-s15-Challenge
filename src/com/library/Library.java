package com.library;

import com.library.enums.Status;
import com.library.interfaces.ShowBooks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Library implements ShowBooks {
    public Map<Long, Book> books;
    public Map<Long, Member> readers;
    public Map<Long, Librarian> librarians;

    public static Library library = new Library(new HashMap<>(), new HashMap<>(), new HashMap<>());

    public static com.library.Library getLibrary() {
        return library;
    }

    private Library(Map<Long, Book> books, Map<Long, Member> readers, Map<Long, Librarian> librarians) {
        this.books = books;
        this.readers = readers;
        this.librarians = librarians;
    }

    public Map<Long, Book> getBooks() {
        return books;
    }

    public Map<Long, Member> getReaders() {
        return readers;
    }

    public void addUser(long id, Member member){
        library.readers.put(member.getId(),member);
    }

    public void newBook(Book book){
        if(Library.getLibrary().books.equals(book)){
            System.out.println("Bu kitap zaten ekli!!!");
        }
        books.put(book.getId(), book);
        if(library.readers.values().stream().anyMatch(o -> o.getName().equals(Library.getLibrary().books.get(book.getId()).getAuthor().getName()))){
            Library.getLibrary().books.get(book.getId()).getAuthor().newBook(book);
        } else {
            library.addUser(Library.getLibrary().books.get(book.getId()).getAuthor().getId(),Library.getLibrary().books.get(book.getId()).getAuthor());
            Library.getLibrary().books.get(book.getId()).getAuthor().newBook(book);
        }
    }

    public void lendBook(long bookId, long userId){
        if(books.get(bookId).getStatus().equals(Status.CHECKEDOUT)){
            System.out.println("Bu kitap şu an kütüphanede değil!");
        }
        books.get(bookId).setStatus(Status.CHECKEDOUT);
        books.get(bookId).setDateOfPurchase(LocalDate.now().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        Book book = (Book) ((Reader) readers.get(userId)).getNoBooksIssued().stream().filter(o -> o.getId() == bookId);
        ((Reader)readers.get(userId)).sumDebt(book.getPrice());
        ((Reader)readers.get(userId)).setNoBooksIssued(books.get(bookId));
    };

    public void takeBackBook(long userId, long bookId){
        if(!((Reader)readers.get(userId)).getNoBooksIssued().stream().anyMatch(o->o.getId() == bookId)){
            System.out.println("Bu kitap kullanıcıda mevcut değil!!!");
        }
        books.get(bookId).setStatus(Status.AVAIABLE);
        books.get(bookId).setDateOfPurchase("Kitap şuan kütüphanede.");
        ((Reader)readers.get(userId)).difDebt(books.get(bookId).getPrice());
        ((Reader)readers.get(userId)).getNoBooksIssued().remove(((Reader) readers.get(userId)).getBook(bookId));
    }

    public void addLibrarian(Librarian librarian){
        if(library.librarians.values().stream().anyMatch(o->o.equals(librarian)) && library.librarians.size() > 3){
            System.out.println("Bu kullanıcıyı ekleyemezsiniz!");
        }
        library.librarians.put(librarian.getId(), librarian);
    }

    @Override
    public void showBooks(){
        Library.getLibrary().books.values().forEach(System.out::println);
    }
}
