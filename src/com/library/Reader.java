package com.library;

import com.library.enums.ReaderType;
import com.library.enums.Status;
import com.library.enums.UserType;
import com.library.interfaces.ShowBooks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Reader extends Member implements ShowBooks {
    private Set<Book> noBooksIssued;
    private int maxBookLimit;
    private ReaderType readerType;
    private double debt;


    public Book getBook(long bookId){
        return (Book) noBooksIssued.stream().filter(o->o.getId() == bookId);
    }

    public Set<Book> getNoBooksIssued() {
        return noBooksIssued;
    }

    public void sumDebt(double debt) {
        this.debt += debt;
    }

    public void difDebt(double debt) {
        this.debt -= debt;
    }

    public Reader(long id, String name, String address, String phoneNo, Set<Book> noBooksIssued, int maxBookLimit, ReaderType readerType) {
        super(id, name, address, phoneNo, UserType.READER, LocalDate.now());
        this.noBooksIssued = noBooksIssued;
        this.maxBookLimit = maxBookLimit;
        this.readerType = readerType;
        this.debt = 0.0;
    }

    public void setNoBooksIssued(Book noBooksIssued) {
        if(this.noBooksIssued.size() > 5){
            System.out.println("5 kitaptan daha fazlasını alamazsınız!");
        }
        this.noBooksIssued.add(noBooksIssued);
    }

    public void purchaseBook(long bookId){
        if(!Library.getLibrary().books.get(bookId).getStatus().equals(Status.AVAIABLE)){
            System.out.println("Bu kitap henüz mevcut değil!");
        }
        setNoBooksIssued(Library.getLibrary().books.get(bookId));
        LocalDate purchaseDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        Library.getLibrary().books.get(bookId).setDateOfPurchase(purchaseDate.format(formatter));
        Library.getLibrary().books.get(bookId).setStatus(Status.CHECKEDOUT);
        debt +=  Library.getLibrary().books.get(bookId).getPrice();
    }

    public void returnBook(long bookId){
        noBooksIssued.remove(noBooksIssued.stream().filter(o -> o.getId() == bookId));
        debt-= Library.getLibrary().books.get(bookId).getPrice();
        Library.getLibrary().books.get(bookId).setDateOfPurchase("Kitap şuan kütüphanede.");
        Library.getLibrary().books.get(bookId).setStatus(Status.AVAIABLE);
    }

    @Override
    public void showBooks(){
        noBooksIssued.forEach(System.out::println);
    }

    @Override
    public String whoAreYou() {
        return getType() + " " + getName();
    }


}
