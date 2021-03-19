package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

import java.util.List;

public class MenuItemDaoCollectionImplTest {

    public static void main(String[] args) {
        System.out.println("AdminList");
        testGetMenuItemListAdmin();
        System.out.println("customerList");
        testGetMenuItemListCustomer();
        System.out.println("modifyItem");
        testModifyMenuItem();
    }

    private static void testGetMenuItemListAdmin() {
        MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
        for (MenuItem item : menuItemDao.getMenuItemListAdmin()) {
            System.out.println(item.toString());
        };
    }

    private static void testGetMenuItemListCustomer() {
        MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
        for (MenuItem item: menuItemDao.getMenuItemListCustomer()) {
            System.out.println(item.toString());
        }
    }

    private static void testModifyMenuItem() {
        MenuItem burger = new MenuItem(200, "Burger", 159.00f, true, DateUtil.convertToDate("23/12/2017"), "Main Course", false);
        MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
        menuItemDao.modifyMenuItem(burger);
        System.out.println(menuItemDao.getMenuItem(200));

    }

}
