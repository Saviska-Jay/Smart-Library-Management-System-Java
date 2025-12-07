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
    
    // Decorator features
    private boolean isFeatured = false;
    private boolean isRecommended = false;
    private boolean isSpecialEdition = false;

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
    
    // Decorator feature setters and getters
    public void setFeatured(boolean featured) {
        this.isFeatured = featured;
    }
    
    public void setRecommended(boolean recommended) {
        this.isRecommended = recommended;
    }
    
    public void setSpecialEdition(boolean specialEdition) {
        this.isSpecialEdition = specialEdition;
    }
    
    public boolean isFeatured() {
        return isFeatured;
    }
    
    public boolean isRecommended() {
        return isRecommended;
    }
    
    public boolean isSpecialEdition() {
        return isSpecialEdition;
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
        System.out.println("Edition: " + (edition != null ? edition : "N/A"));
        
        // Display decorator features
        List<String> features = new ArrayList<>();
        if (isFeatured) features.add("Featured");
        if (isRecommended) features.add("Recommended");
        if (isSpecialEdition) features.add("Special Edition");
        System.out.println("Features: " + (features.isEmpty() ? "None" : String.join(", ", features)));
        
        System.out.println("Tags: " + (tags.isEmpty() ? "None" : String.join(", ", tags)));
        System.out.println("Reviews: ");
        if (reviews.isEmpty()) {
            System.out.println("\tNo reviews yet");
        } else {
            for (String review : reviews) {
                System.out.println("\t# " + review);
            }
        }
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
    }

}
