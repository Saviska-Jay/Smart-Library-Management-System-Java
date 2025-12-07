package book.decorator;

public abstract class K2559495_BookDecorator implements K2559495_BookFeature {
    protected K2559495_BookFeature decoratedBookFeature;

    public K2559495_BookDecorator(K2559495_BookFeature book) {
        this.decoratedBookFeature = book;
    }

    @Override
    public String getDescription() {
        return decoratedBookFeature.getDescription();
    }
}