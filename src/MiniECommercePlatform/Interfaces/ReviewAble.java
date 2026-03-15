package MiniECommercePlatform.Interfaces;

import MiniECommercePlatform.Exceptions.UnauthorizedActionException;
import MiniECommercePlatform.Products.Product;

public interface ReviewAble {
    void leaveReview(Product p, String text, int rating) throws UnauthorizedActionException;
}
