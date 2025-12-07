package book.builder;

import java.util.ArrayList;
import java.util.List;
import book.decorator.K2559495_BookFeature;

public class K2559495_Book implements K2559495_BookFeature {

    private final String bookId;
    private String title;
    private String author;
    private String category;
    private String isbn;

    // Optional metadata
    List<String> reviews = new ArrayList<>();
    List<String> tags = new ArrayList<>();
    String edition;

    public K2559495_Book(K2559495_BookBuilder builder) {
        this.bookId = builder.bookId;
        this.title = builder.title;
        this.author = builder.author;
        this.category = builder.category;
        this.isbn = builder.isbn;
        this.reviews = builder.reviews;
        this.tags = builder.tags;
        this.edition = builder.edition;
    }

    @Override
    public String getDescription() {
        return title + " by " + author + " (" + category + ")";
    }

    // Getters for book fields
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getEdition() {
        return edition;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateAuthor(String author) {
        this.author = author;
    }

    public void updateCategory(String category) {
        this.category = category;
    }

    public void updateIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void updateEdition(String edition) {
        this.edition = edition;
    }

    public void addReview(String review) {
        this.reviews.add(review);
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    //Display book details
    public void displayBookInfo() {
        System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::::::::::::::::::::::: Book Details ::::::::::::::::::::::::");
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("ISBN: " + isbn);
        System.out.println("Edition: " + edition);
        System.out.println("Tags: " + String.join(", ", tags));
        System.out.println("Reviews: ");
        for (String review : reviews) {
            System.out.println("\t# " + review);
        }
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
    }

}
