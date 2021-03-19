package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private static List<MenuItem> menuItemList = new ArrayList<>();
	
	public MenuItemDaoCollectionImpl() {
        MenuItem sandwich = new MenuItem(100, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"), "Main Course", true);
        menuItemList.add(sandwich);
        MenuItem burger = new MenuItem(200, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"), "Main Course", false);
        menuItemList.add(burger);
        MenuItem pizza = new MenuItem(300, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"), "Main Course", false);
        menuItemList.add(pizza);
        MenuItem frenchFries = new MenuItem(400, "French Fries", 57.00f, false, DateUtil.convertToDate("02/07/2017"), "Starters", true);
        menuItemList.add(frenchFries);
        MenuItem chocolateBrownie = new MenuItem(500, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"), "Dessert", true);
        menuItemList.add(chocolateBrownie);
	}
        

        @Override
        public List<MenuItem> getMenuItemListAdmin() {
            return menuItemList;
        }

        @Override
        public List<MenuItem> getMenuItemListCustomer() {
            List<MenuItem> displayMenuItem = new ArrayList<>();
            Date currentDate = new Date();
            boolean flag1;
            boolean flag2;
            boolean flag3;
           for (int i = 0; i < menuItemList.size(); i++){
                MenuItem item = menuItemList.get(i);
                flag1 = item.isActive();
                flag2 = item.getDateOfLaunch().before(currentDate);
                flag3 = item.getDateOfLaunch().equals(currentDate);
                if (flag1 && (flag2 || flag3))
                {
                    displayMenuItem.add(item);
                }
           	}
		return displayMenuItem; 
        }


        @Override
        public void modifyMenuItem(MenuItem menuItem) {
            MenuItem item;
            for(int i = 0; i < menuItemList.size(); i++){
                item = menuItemList.get(i);
                if(item.equals(menuItem)){
                    menuItemList.set(i, menuItem);
                }
            }
        }

        @Override
        public MenuItem getMenuItem(long menuItemId) {

            for (MenuItem item: menuItemList) {
                if(item.getId() == menuItemId){
                    return  item;
                }
            }
            return null;
	}

}
