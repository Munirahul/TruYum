package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;

import java.util.List;

public class CartDaoCollectionImplTest {

    public static void main(String[] args) {
        System.out.println(1 + "\n");
        testAddCartItem();
        System.out.println(2 + "\n");
        testGetAllCartItems();
        System.out.println(3 + "\n");
        testRemoveCartItem();
    }

    private static void testAddCartItem(){
        CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
        cartDao.addCartItem(1, 400);
        cartDao.addCartItem(1, 100);
        cartDao.addCartItem(2, 500);
        try {
            List<MenuItem> cartItems = cartDao.getAllCartItems(1);
            for (MenuItem item: cartItems) {
                System.out.println(item.toString());
            }
        } catch (CartEmptyException e) {
            e.printStackTrace();
        }
    }

    private static void testGetAllCartItems() {
        CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
        try {
            List<MenuItem> cartItems = cartDao.getAllCartItems(1);
            for (MenuItem item: cartItems) {
                System.out.println(item.toString());
            }
        } catch (CartEmptyException e) {
            e.printStackTrace();
        }
    }

    private static void testRemoveCartItem() {
        CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
        cartDao.removeCartItem(1, 400);
        try {
            List<MenuItem> cartItems = cartDao.getAllCartItems(1);
            for (MenuItem item: cartItems) {
                System.out.println(item.toString());
            }
        } catch (CartEmptyException e) {
            e.printStackTrace();
        }

    }
}

