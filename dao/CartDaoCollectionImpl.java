package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDaoCollectionImpl implements CartDao {

    private static Map<Long, Cart> userCarts = new HashMap<>();

    CartDaoCollectionImpl(){
       //userCarts = null;
    }

    @Override
    public void addCartItem(long userId, long menuItemId) {
        MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
        MenuItem item = menuItemDao.getMenuItem(menuItemId);
        List<MenuItem> cartList1 = new ArrayList<>();

        if(userCarts.containsKey(userId)){
            Cart uCart = userCarts.get(userId);
            List<MenuItem> itemList = uCart.getMenuItemList();
            itemList.add(item);
            uCart.setMenuItemList(itemList);
            userCarts.put(userId, uCart);
        } else {
            ArrayList<MenuItem> newUserList = new ArrayList<>();
            newUserList.add(item);
            Cart newUserCart = new Cart(newUserList, (double)item.getPrice());
            userCarts.put(userId, newUserCart);
        }

    }

    @Override
    public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
        Cart uCart = userCarts.get(userId);
        double totalPrice = 0;
        if(uCart.getMenuItemList().size() == 0){
            throw new CartEmptyException();
        } else {
            for (MenuItem item: uCart.getMenuItemList()) {
                totalPrice += (double) item.getPrice();
            }
            uCart.setTotal(totalPrice);
        }

        return uCart.getMenuItemList();
    }

    @Override
    public void removeCartItem(long userId, long menuItemId) {
        List<MenuItem> itemList = userCarts.get(userId).getMenuItemList();
        for (int i = 0; i < itemList.size(); i++){
            if (itemList.get(i).getId() == menuItemId){
                itemList.remove(i);
            }
        }
    }
}
