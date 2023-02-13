package com.estia.mbds.cart.controllers;

import com.estia.mbds.cart.model.Cart;
import com.estia.mbds.cart.model.CartItem;
import com.estia.mbds.cart.repositories.CartItemRepository;
import com.estia.mbds.cart.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @PostMapping(value = "/cart")
    public Long createNewCart()
    {
        Cart cart;
        try {
            cart = cartRepository.save(new Cart());
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new cart");
        }

        System.out.println("INJECTION DE GETIDCARD DEPUIS CART: " + cart.getId());
        return cart.getId();
    }

    @GetMapping(value = "/cart/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id)
    {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if(cartOptional.isPresent()) {
            return new ResponseEntity<Cart>(cartOptional.get(), HttpStatus.CREATED);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Specified product doesn't exist");
    }

    @PostMapping(value = "/cart/{id}/addProduct")
    public ResponseEntity<CartItem> addProductToCart(@PathVariable Long id, @RequestBody CartItem cartItem)
    {
        Optional<Cart> cartOptional = cartRepository.findById(id);

        if(!cartOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erreur");
        }

        Cart cart = cartOptional.get();

        boolean testId = false;
        int i;
        int j = 0;
        for(i = 0; i < cart.getItems().size(); i++){
            Long idItems = cart.getItems().get(i).getProductId();

            if(idItems == cartItem.getProductId()){
                testId = true;
                j = i;
            }
        }
        if(testId){
            cart.getItems().get(j).setQuantity( cart.getItems().get(j).getQuantity() + cartItem.getQuantity());
        }else{
            cart.addItem(cartItem);
        }

        try{
            cartRepository.save(cart);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur");
        }

        return new ResponseEntity<CartItem>(cartItem, HttpStatus.CREATED);

    }


}