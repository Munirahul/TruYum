package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {

	 List<MenuItem> getMenuItemListAdmin();
	 List<MenuItem> getMenuItemListCustomer();
	 void modifyMenuItem(MenuItem menuitem);
	 MenuItem getMenuItem(long menuItemId);
}
