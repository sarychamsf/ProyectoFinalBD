package model;

import java.util.HashMap;

/**
 *
 * @author Brenda
 */
public class CartQuejas {
     HashMap<String, Queja> cartQuejas;
      
    public CartQuejas() {
        cartQuejas = new HashMap<>();

    }

    public HashMap getCartQuejas() {
        return cartQuejas;
    }

    public void addToCart( String index,Queja item) {
        cartQuejas.put(index, item);
    }
    
    public void deleteFromCart(String index){
        cartQuejas.remove(index);
    }
}
