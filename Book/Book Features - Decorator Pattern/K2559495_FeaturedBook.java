public class K2559495_FeaturedBook extends K2559495_BookDecorator {
    public K2559495_FeaturedBook(K2559495_BookFeature book) {
        super(book);
    }

    @Override
    public String getDescription() {
        return decoratedBookFeature.getDescription() + " #Featured";
    }
}