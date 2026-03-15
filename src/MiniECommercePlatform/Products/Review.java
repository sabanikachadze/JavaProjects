package MiniECommercePlatform.Products;

public class Review {
    private final Product product;
    private final String text;
    private final int rating;

    public Review(Product product, String text, int rating) {
        if (rating < 1 || rating > 5)
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        this.product = product;
        this.text = text;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Product: %s | Rating: %d/5 | \"%s\"",
                product.getName(), rating, text);
    }
}