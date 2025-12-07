package book.decorator;

public class K2559495_SpecialEditionBook extends K2559495_BookDecorator {
    public K2559495_SpecialEditionBook(K2559495_BookFeature book) {
        super(book);
    }

    @Override
    public String getDescription() {
        return decoratedBookFeature.getDescription() + " #SpecialEdition";
    }
}