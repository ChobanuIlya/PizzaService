package com.example.pizzaservice.controller;

import com.example.pizzaservice.entity.Customer;
import com.example.pizzaservice.entity.Pizza;
import com.example.pizzaservice.repository.CustomerRepository;
import com.example.pizzaservice.repository.PizzaRepository;
import com.example.pizzaservice.service.CustomerService;
import com.example.pizzaservice.service.OrderService;
import com.example.pizzaservice.service.PizzaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Slf4j
@Controller
public class MainController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final PizzaService pizzaService;
    private final PizzaRepository pizzaRepository;
    private final OrderService orderService;

    public MainController(PizzaRepository pizzaRepository, CustomerRepository customerRepository, CustomerService customerService, PizzaService pizzaService, PizzaRepository pizzaRepository1, OrderService orderService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.pizzaService = pizzaService;
        this.pizzaRepository = pizzaRepository1;
        this.orderService = orderService;
    }

    private static Integer totalPrice = 0;
    private static HashMap<Pizza, Integer> cart = new HashMap<>();
    private static Pizza customerPizza = new Pizza();

    @GetMapping("/addPizzas")
    public void init(){
        Pizza margarita = new Pizza();
        List<Pizza.Ingredients> ingredients = new ArrayList<>();
        ingredients.add(Pizza.Ingredients.MOZZARELLA);
        ingredients.add(Pizza.Ingredients.TOMATOES);
        ingredients.add(Pizza.Ingredients.TOMATO_SAUCE);
        margarita.setPizzaName("Margarita");
        margarita.setDiameter(Pizza.Diameter.MEDIUM);
        margarita.setWeight(500);
        margarita.setPrice(100);
        margarita.setDoughType(Pizza.DoughType.THIN);
        margarita.setIngredients(ingredients);
        pizzaRepository.save(margarita);

        Pizza threeCheeses = new Pizza();
        List<Pizza.Ingredients> ingredients1 = new ArrayList<>();
        ingredients1.add(Pizza.Ingredients.WHITE_SAUCE);
        ingredients1.add(Pizza.Ingredients.MOZZARELLA);
        ingredients1.add(Pizza.Ingredients.CHEDDAR);
        ingredients1.add(Pizza.Ingredients.BLUE_CHEESE);
        threeCheeses.setPizzaName("Four Cheese");
        threeCheeses.setDiameter(Pizza.Diameter.MEDIUM);
        threeCheeses.setWeight(500);
        threeCheeses.setPrice(170);
        threeCheeses.setDoughType(Pizza.DoughType.THIN);
        threeCheeses.setIngredients(ingredients1);
        pizzaRepository.save(threeCheeses);

        Pizza villager = new Pizza();
        List<Pizza.Ingredients> ingredients2 = new ArrayList<>();
        ingredients2.add(Pizza.Ingredients.TOMATO_SAUCE);
        ingredients2.add(Pizza.Ingredients.MOZZARELLA);
        ingredients2.add(Pizza.Ingredients.MUSHROOM);
        ingredients2.add(Pizza.Ingredients.CHICKEN);
        ingredients2.add(Pizza.Ingredients.TOMATOES);
        villager.setPizzaName("Villager");
        villager.setDiameter(Pizza.Diameter.MEDIUM);
        villager.setWeight(500);
        villager.setPrice(125);
        villager.setDoughType(Pizza.DoughType.THIN);
        villager.setIngredients(ingredients2);
        pizzaRepository.save(villager);

        Pizza superMeat = new Pizza();
        List<Pizza.Ingredients> ingredients3 = new ArrayList<>();
        ingredients3.add(Pizza.Ingredients.TOMATO_SAUCE);
        ingredients3.add(Pizza.Ingredients.MOZZARELLA);
        ingredients3.add(Pizza.Ingredients.CHICKEN);
        ingredients3.add(Pizza.Ingredients.BEEF);
        ingredients3.add(Pizza.Ingredients.SAUSAGE);
        superMeat.setPizzaName("Super Meat");
        superMeat.setDiameter(Pizza.Diameter.MEDIUM);
        superMeat.setWeight(500);
        superMeat.setPrice(150);
        superMeat.setDoughType(Pizza.DoughType.THIN);
        superMeat.setIngredients(ingredients3);
        pizzaRepository.save(superMeat);

        Pizza diablo = new Pizza();
        List<Pizza.Ingredients> ingredients4 = new ArrayList<>();
        ingredients4.add(Pizza.Ingredients.TOMATO_SAUCE);
        ingredients4.add(Pizza.Ingredients.MOZZARELLA);
        ingredients4.add(Pizza.Ingredients.CHORIZO);
        ingredients4.add(Pizza.Ingredients.ONION);
        diablo.setPizzaName("Diablo");
        diablo.setDiameter(Pizza.Diameter.MEDIUM);
        diablo.setWeight(500);
        diablo.setPrice(125);
        diablo.setDoughType(Pizza.DoughType.THIN);
        diablo.setIngredients(ingredients4);
        pizzaRepository.save(diablo);

        Pizza seafarer = new Pizza();
        List<Pizza.Ingredients>  ingredients5 = new ArrayList<>();
        ingredients5.add(Pizza.Ingredients.WHITE_SAUCE);
        ingredients5.add(Pizza.Ingredients.MOZZARELLA);
        ingredients5.add(Pizza.Ingredients.SHRIMP);
        ingredients5.add(Pizza.Ingredients.OLIVES);
        seafarer.setPizzaName("Seafarer");
        seafarer.setDiameter(Pizza.Diameter.MEDIUM);
        seafarer.setWeight(500);
        seafarer.setPrice(175);
        seafarer.setDoughType(Pizza.DoughType.THIN);
        seafarer.setIngredients(ingredients5);
        pizzaRepository.save(seafarer);
    }

    @GetMapping("/cart/addPizza/{pizzaName}")
    public String addPizza(Model model, @PathVariable String pizzaName) {
        totalPrice = pizzaService.addPizzaToCart(pizzaName, totalPrice, cart);
        return "redirect:/main";
    }


    @GetMapping("/cart/removePizza/{pizzaName}&{pizzaPrice}")
    public String removePizza(@PathVariable String pizzaName, Map<String, Object> model, @PathVariable Integer pizzaPrice) {
        Pizza pizza = pizzaRepository.findPizzaByPizzaName(pizzaName);
        totalPrice -= cart.get(pizza) * pizza.getPrice();
        cart.remove(pizza);
        return "redirect:/main";
    }

    @GetMapping("/check")
    public String checkout(Model model, Authentication authentication) {
        model.addAttribute("link", "/confirmOrder");
        if (totalPrice == 0) {
            return "redirect:/main";
        }
        if (authentication == null){
            model.addAttribute("anon");
            model.addAttribute("link", "/confirmOrderAnon");
        }
        model.addAttribute("totalPrice", totalPrice);
        return "checkout";
    }

    @GetMapping("/confirmOrder")
    public String confirmOrder(Authentication authentication){
            orderService.saveOrder(authentication, cart, totalPrice);
            totalPrice = 0;
            cart.clear();
        return "main";
    }

    @GetMapping("/confirmOrderAnon")
    public String confirmOrderAnon(@ModelAttribute("phone_number") String phoneNumber, @ModelAttribute("first_name") String firstName,
                                   @ModelAttribute("last_name") String lastName, @ModelAttribute("address") String address,
                                   @ModelAttribute("email") String email){
        orderService.saveOrderForAnon(firstName, lastName, address, phoneNumber, cart, totalPrice);
        totalPrice = 0;
        cart.clear();
        return "main";
    }

    @PostMapping("/redeemCode")
    public String redeemCode(){
        totalPrice = totalPrice/2;
        return "constructor";
    }

    @GetMapping("/main")
    public String main(Model model, Authentication authentication) {
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cart", cart);
        model.addAttribute("link", "/login");
        if (authentication != null) {
           model.addAttribute("link", "/profile");
        }
        return "main";
    }

    @GetMapping("/")
    public String redirectMain(Map<String, Object> model) {
        return "redirect:/main";
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/main";
        }
        Customer loggedInCustomer = customerRepository.findCustomerByPhoneNumber(authentication.getName());
        model.addAttribute("customer", loggedInCustomer);
        return "profile";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("password") String password, @ModelAttribute("first_name") String firstName,
                                 @ModelAttribute("last_name") String lastName, @ModelAttribute("address") String address,
                                 @ModelAttribute("email") String email, Authentication authentication){
        customerService.updateCustomer(password, firstName, lastName, address, email, authentication);
        return "redirect:/profile";
    }

    @GetMapping("/constructor")
    public String constructor(Model model, Authentication authentication) {
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cart", cart);
        model.addAttribute("link", "/login");
        if (authentication != null) {
            model.addAttribute("link", "/profile");
        }
        return "constructor";
    }

    @PostMapping("/constructor/create")
    public String customerPizza(@ModelAttribute("pizza_name") String pizzaName, @ModelAttribute("size") Integer diameter,
                               @ModelAttribute("dough_type") String doughType, @ModelAttribute("sauce") String sauce,
                               @ModelAttribute("ingredient1") String ingredient1, @ModelAttribute("ingredient2") String ingredient2,
                               @ModelAttribute("ingredient3") String ingredient3, @ModelAttribute("ingredient4") String ingredient4,
                                Model model, Authentication authentication) {
        model.addAttribute("link", "/login");
        if (authentication != null) {
            model.addAttribute("link", "/profile");
        }
        customerPizza = pizzaService.customerPizza(customerPizza, pizzaName, diameter, doughType, sauce, ingredient1, ingredient2,
                ingredient3, ingredient4);
        model.addAttribute("ingredients", customerPizza.getIngredients());
        model.addAttribute("name", customerPizza.getPizzaName());
        model.addAttribute("price", customerPizza.getPrice());
        model.addAttribute("weight", customerPizza.getWeight());
        model.addAttribute("size", customerPizza.getDiameter().toString());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cart", cart);
        if (customerPizza.getPizzaName().isEmpty()){
            return "redirect:/constructor";
        }
        return "constructor_pizza";
    }

    @GetMapping("/constructor/addCustomerPizza")
    public String addCustomerPizza(){
        totalPrice = pizzaService.addCustomerPizza(customerPizza, cart, totalPrice).getTotalPrice();
        return "redirect:/main";
    }
}
