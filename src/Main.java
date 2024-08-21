import com.library.*;
import com.library.enums.BookType;
import com.library.enums.ReaderType;
import com.library.enums.Status;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library.getLibrary().newBook(new Book(1,new Author(1,"George Orwell", "Motihari Hindistan", "1903"), "Hayvan Çiftliği", 19.90, Status.AVAIABLE, 75, BookType.NOVEL));
        Library.getLibrary().newBook(new Book(2,new Author(2,"José Mauro de Vasconceles","Rio de Jenerio Brazilya", "1920"), "Şeker Portakalı", 18.90, Status.AVAIABLE, 154, BookType.NOVEL));
        Library.getLibrary().newBook(new Book(3,new Author(3,"Ahmet Tulgar","Ataşehir İstanbul", "1959"), "Trajik Nüans", 12.75, Status.AVAIABLE, 1, BookType.STORY));
        Library.getLibrary().newBook(new Book(4,new Author(4,"Tevfik Fikret", "Taksim İstanbul", "1867"), "Küçük Aile", 18.25, Status.AVAIABLE, 1, BookType.STORY));
        Library.getLibrary().newBook(new Book(5,new Author(5,"Stephen Hawking","Oxford Birleşik Krallık", "1942"), "Zamanın Kısa Tarihi", 32.00, Status.AVAIABLE, 1,BookType.SCIENCE));
        Library.getLibrary().newBook(new Book(6,new Author(6,"Carl Sagan","New York ABD", "1934"), "Kozmos", 35.46, Status.AVAIABLE, 12,BookType.SCIENCE));
        Library.getLibrary().newBook(new Book(7,new Author(7,"Mustafa Kemal Atatürk","Selanik Vilayeti", "1881"), "Nutuk", 150, Status.AVAIABLE, 1,BookType.HISTORY));
        Library.getLibrary().newBook(new Book(8,new Author(8,"Sinan Meydan","Şavşat Artvin", "1975"),"Pusula", 120,Status.AVAIABLE,21, BookType.HISTORY));
        Library.getLibrary().newBook(new Book(9,new Author(9,"Gustave Flaubert","Rounen Fransa", "1821"), "Madame Bovary",15.15 ,Status.AVAIABLE,12,BookType.LITERATURE));
        Library.getLibrary().newBook(new Book(10,new Author(10,"Herman Menville","New York ABD", "1819"), "Moby-Dick", 13.45, Status.AVAIABLE, 5,BookType.LITERATURE));
        Library.getLibrary().newBook(new Book(11,new Author(11,"Beatrice Forbes Manz","Londra Birleşik Krallık", "1951"), "Timurlenk", 55.55, Status.AVAIABLE, 45, BookType.BIOGRAPHY));
        Library.getLibrary().newBook(new Book(12,new Author(12,"İclal Akşamoğlu","İstanbul Türkiye", "1957"), "Isaac Newton", 91.00, Status.AVAIABLE, 18,BookType.BIOGRAPHY));
        Library.getLibrary().newBook(new Book(13,new Author(13,"Rollo May","Ohio ABD", "1909"), "Yaratma Cesareti", 51, Status.AVAIABLE, 54, BookType.ART));
        Library.getLibrary().newBook(new Book(14,new Author(14,"Ulus Baker", "Ankara Türkiye", "1960"),"Sanat ve Arzu", 19.85, Status.AVAIABLE, 3,BookType.ART));
        Library.getLibrary().newBook(new Book(15,new Author(15,"Oliver Sacks","Londra Birleşik Krallık", "1933"), "Hareket Halinde", 125.00, Status.AVAIABLE, 2, BookType.STUDYBOOK));
        Library.getLibrary().newBook(new Book(16,new Author(16,"Chris Scott","Londra Birleşik Krallık", "1956"), "Adventure Motorcycling Handbook", 75.50, Status.AVAIABLE, 4, BookType.STUDYBOOK));

        Library.getLibrary().addLibrarian(new Librarian(1,"Furkan", "test123"));
        Library.getLibrary().addLibrarian(new Librarian(2,"Yunus", "test789"));
        Library.getLibrary().addLibrarian(new Librarian(3,"Batuhan", "test456"));

        Library.getLibrary().addUser(1,new Reader(17,"Furkan","Yeşilpınar EyüpSultan", "5385486522", new HashSet<>(),5, ReaderType.STUDENT));

        Library.library.showBooks();

        Scanner kullanici = new Scanner(System.in);

        System.out.println("1 = Kütüphaneci");
        System.out.println("2 = Yazar");
        System.out.println("3 = Okuyucu");

        System.out.println("Kullanıcı Tipi Seçiniz: ");

        int tip = kullanici.nextInt();

        switch (tip){
            case 1:
                System.out.println("Kullanıcı adınızı giriniz: ");
                String name = kullanici.next();
                System.out.println("Şifrenizi giriniz: ");
                String password = kullanici.next();
                if(Library.getLibrary().librarians.get(name).equals(password)){
                    System.out.println("Giriş Başarılı!");;
                    System.out.println("1 = Kitap ekleme");
                    System.out.println("2 = Kitap ödünç vermek");
                    System.out.println("3 = Kitap geri alma");
                    System.out.println("4 = Kitap sorgulama");
                    System.out.println("5 = Fatura kesme");

                    System.out.println("Yapmak istediğiniz işlemi seçin: ");

                    int islem = kullanici.nextInt();

                    switch (islem){
                        case 1:
                            System.out.println("Kitap adı giriniz: ");
                            String bookName = kullanici.next();

                            System.out.println("Kiralama bedelini belirleyiniz: ");
                            double bookPrice = kullanici.nextDouble();

                            System.out.println("Kitabın baskı sayısını belirtiniz: ");
                            int prints = kullanici.nextInt();

                            System.out.println("NOVEL");
                            System.out.println("STORY");
                            System.out.println("SCIENCE");
                            System.out.println("HISTORY");
                            System.out.println("LITERATURE");
                            System.out.println("BIOGRAPHY");
                            System.out.println("ART");
                            System.out.println("STUDYBOOK");
                            System.out.println("Lütfen kitap türünü yazınız: ");
                            String bookType = kullanici.next();

                            System.out.println("Yazar adı giriniz: ");
                            String writer = kullanici.next();

                            if(Library.getLibrary().readers.values().stream().anyMatch(o -> o.getName().equals(writer))) {
                                Double id = Math.random();
                                Library.getLibrary().newBook(new Book(
                                        id.longValue(),
                                        (Author) Library.getLibrary().readers.values().stream()
                                                .filter(o -> o.getName().equals(writer))
                                                .findFirst()
                                                .get(),
                                        bookName,
                                        bookPrice,
                                        Status.AVAIABLE,
                                        prints,
                                        BookType.valueOf(bookType)
                                ));
                            } else {
                                System.out.println("Yazar doğum yerini giriniz: ");
                                String writerBorn = kullanici.next();

                                System.out.println("Yazar telefon numarası giriniz: ");
                                String phone = kullanici.next();

                                Double id = Math.random();
                                Library.getLibrary().newBook(new Book(id.longValue(), new Author(id.longValue(), writer, writerBorn, phone), bookName, bookPrice, Status.AVAIABLE, prints, BookType.valueOf(bookType)));
                                System.exit(0);
                            }
                        case 2:
                            System.out.println("Kitap id'si giriniz: ");
                            long bookId = kullanici.nextLong();

                            System.out.println("Kullanıcı id'si giriniz: ");
                            long userId = kullanici.nextLong();

                            Library.library.lendBook(bookId,userId);
                            System.exit(0);
                        case 3:
                            System.out.println("Teslim edecek olan kişinin id'sini giriniz: ");
                            long user = kullanici.nextLong();

                            System.out.println("Teslim edilen kitabın id'sini giriniz: ");
                            long book = kullanici.nextLong();

                            Library.library.takeBackBook(user, book);
                            System.exit(0);
                        case 4:
                            System.out.println("Sorgulamak istediğiniz kitabın id'sini giriniz: ");
                            long searching = kullanici.nextLong();

                            System.out.println("Soruglama yapmak isteyen kütüphanecinin id'si: ");
                            long searcher = kullanici.nextLong();

                            Library.library.librarians.get(searcher).searchBook(searching);
                            System.exit(0);
                        case 5:
                            System.out.println("Fatura oluşturmak isteyen kütüphane görevlisinin id'si: ");
                            long creater = kullanici.nextLong();

                            System.out.println("Faturası kesilecek olan okuyucunun id'si: ");
                            long reader = kullanici.nextLong();

                            System.out.println(Library.library.librarians.get(creater).createBill((Reader) Library.library.readers.get(reader)));
                            System.exit(0);
                    }
                } else {
                    System.out.println("Kullanıcı bilgileri doğrulanamadı!!!");
                    System.exit(0);
                }
            case 2:
                System.out.println("1 = Kitaplarımı görüntüle");
                System.out.println("2 = Yeni kitap ekle");

                System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
                int islem = kullanici.nextInt();
                switch (islem){
                    case 1:
                        System.out.println("Yazar id'nizi giriniz: ");
                        long authorId = kullanici.nextLong();

                        Author author = (Author) Library.library.readers.get(authorId);
                        System.out.println(author.getMyBooks());
                        System.exit(0);

                    case 2:
                        System.out.println("Kitap adı giriniz: ");
                        String bookName = kullanici.next();

                        System.out.println("Kiralama bedelini belirleyiniz: ");
                        double bookPrice = kullanici.nextDouble();

                        System.out.println("Kitabın baskı sayısını belirtiniz: ");
                        int prints = kullanici.nextInt();

                        System.out.println("NOVEL");
                        System.out.println("STORY");
                        System.out.println("SCIENCE");
                        System.out.println("HISTORY");
                        System.out.println("LITERATURE");
                        System.out.println("BIOGRAPHY");
                        System.out.println("ART");
                        System.out.println("STUDYBOOK");
                        System.out.println("Lütfen kitap türünü yazınız: ");
                        String bookType = kullanici.next();

                        System.out.println("Yazar id'nizi giriniz: ");
                        long writer = kullanici.nextLong();

                        if(Library.library.books.values().stream().anyMatch(o->o.getTitle().equals(bookName))){
                            System.out.println("Bu kitap zaten mevcut!!");
                        }

                        Author writerr = (Author) Library.library.readers.get(writer);
                        Double id = Math.random();
                        writerr.newBook(new Book(id.longValue(),writerr,bookName,bookPrice,Status.AVAIABLE,prints,BookType.valueOf(bookType)));
                        System.out.println("Kitabınız başarılı şekilde eklendi.");
                        System.exit(0);
                }
            case 3:
                System.out.println("1 = Kitap kirala");
                System.out.println("2 = Kitabı geri teslim et");
                System.out.println("3 = Ödünç aldığım kitapları görüntüle");

                System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
                int islemim = kullanici.nextInt();

                switch (islemim){
                    case 1:
                        System.out.println("Kullanıcı id'nizi giriniz: ");
                        long userId = kullanici.nextLong();

                        System.out.println("Kiralamak istediğiniz kitabın id'sini giriniz: ");
                        long bookId = kullanici.nextLong();

                        Reader user = (Reader) Library.library.readers.get(userId);
                        user.purchaseBook(bookId);
                        System.exit(0);

                    case 2:
                        System.out.println("Kullanıcı id'nizi giriniz: ");
                        long userIdd = kullanici.nextLong();

                        System.out.println("Geri teslim etmek istediğiniz kitabın id'sini giriniz: ");
                        long bookIdd = kullanici.nextLong();

                        Reader userr = (Reader) Library.library.readers.get(userIdd);
                        userr.returnBook(bookIdd);
                        System.exit(0);

                    case 3:
                        System.out.println("Kullanıcı id'nizi giriniz: ");
                        long userrId = kullanici.nextLong();

                        Reader userd = (Reader) Library.library.readers.get(userrId);
                        userd.showBooks();
                        System.exit(0);
                }
        }
    }
}