package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuItemDaoSqlImpl implements MenuItemDao{
	
	private  List<MenuItem> getMenuItemList (String query)
    {
    	 try {
             Connection conn = ConnectionHandler.getConnection();
             List<MenuItem> menuItemList = new ArrayList<>();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet result = pstmt.executeQuery();
             while (result.next()){
                 long id = result.getInt(1);
                 String name = result.getString(2);
                 float price = result.getFloat(3);
                 boolean active = result.getBoolean(4);
                 Date dateOfLaunch = result.getDate(5);
                 String category = result.getString(6);
                 boolean freeDelivery = result.getBoolean(7);
                 MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
                 menuItemList.add(menuItem);
             }
             return  menuItemList;
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         return null;
    }
	@Override
    public List<MenuItem> getMenuItemListAdmin() {
		 String query = "select * from menu_item";
		 return getMenuItemList (query) ;
	}
    @Override
    public List<MenuItem> getMenuItemListCustomer() {
    	 String query = "select * from menu_item where active is true and date_of_launch < curdate()";
    	 return getMenuItemList (query) ;
    }
	@Override
	public void modifyMenuItem(MenuItem menuitem) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		return null;
	}
}