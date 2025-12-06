package book.builder;

import java.util.ArrayList;
import java.util.List;

public class K2559495_BookBuilder {

    public  String bookId;
    public String title;
    public String author;
    public String category;
    public String isbn;
    
    // Optional metadata
    List<String> reviews = new ArrayList<>();
    List<String> tags = new ArrayList<>();
    String edition;


    public K2559495_BookBuilder(String bookId, String title, String author,String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    //Optional fields setters
    public K2559495_BookBuilder addCategory(String category) {
        this.category = category;
        return this;
    }

    public K2559495_BookBuilder addReview(String review) {
        this.reviews.add(review);
        return this;
    }

    public K2559495_BookBuilder addTag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public K2559495_BookBuilder addEdition(String edition) {
        this.edition = edition;
        return this;
    }

    //Build method
    public K2559495_Book build() {
        return new K2559495_Book(this);
    }

}