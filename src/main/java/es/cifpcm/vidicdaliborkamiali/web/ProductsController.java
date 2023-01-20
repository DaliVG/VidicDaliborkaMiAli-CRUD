package es.cifpcm.vidicdaliborkamiali.web;

import es.cifpcm.vidicdaliborkamiali.dao.ProductsRepository;
import es.cifpcm.vidicdaliborkamiali.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductsController {
    @Autowired
    ProductsRepository productsRepository;

    @RequestMapping("/read-contact")
    public String showReadProductsPage(Model model) {
        model.addAttribute("products", ProductService.findAll());
        return "readproduct";
    }

    @RequestMapping("/create-product")
    public String showCreateProductsPage(Model model) {
        model.addAttribute("command", new Products());
        return "createcontact";
    }

    @RequestMapping(value = "/create-product", method = RequestMethod.POST)
    public String createProducts(@ModelAttribute("product") Products product) {
        ProductService.saveProduct(product);
        return "redirect:/read-contact";
    }

    @RequestMapping(value = "/update-product/{id}")
    public String showUpdateProductsPage(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", ProductService.findById(id).orElse(null));
        return "updateproduct";
    }

    @RequestMapping(value = "/update-product/{id}", method = RequestMethod.POST)
    public String updateProducts(@PathVariable int id, @ModelAttribute("product") Products product) {
        ProductService.updatedProduct(id, product);
        return "redirect:/read-product";
    }

    @RequestMapping(value = "/delete-product/{id}")
    public String deleteProducts(@PathVariable int id) {
        ProductService.deleteById(id);
        return "redirect:/read-product";
    }
//    @RequestMapping("/products")
//    public String products(Model model){
//        List<Products> listProducts = new ArrayList<>();
//        listProducts = productsRepository.findAll();
//        model.addAttribute("products", productsRepository.findAll());
//        return "products/products";
//    }
}
