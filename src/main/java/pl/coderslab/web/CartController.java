package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CartController {

    private final Cart cart;
    private final ProductDao productDao;

    @Autowired
    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }


    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart(@RequestParam Long id, @RequestParam Integer quantity) {
        List<Product> products = productDao.getList();
        Product selectedProduct = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);


        if (selectedProduct != null) {
            boolean found = false;
            for (CartItem item : cart.getCartItems()) {
                if (item.getProduct().getId().equals(id)) {
                    item.setQuantity(item.getQuantity() + quantity);
                    found = true;
                    break;
                }
            }

            if (!found) {
                cart.addToCart(new CartItem(quantity, selectedProduct));
            }


        }

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String cart() {
        StringBuilder sb = new StringBuilder();
        for (CartItem ci : cart.getCartItems()) {
            sb.append(ci.getProduct().getName())
                    .append(" : ")
                    .append(ci.getProduct().getPrice())
                    .append(" : ")
                    .append(ci.getQuantity())
                    .append(", ");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
}
