package ru.fr0le.objarmor.common;

import ru.fr0le.objarmor.creativetabs.LoadTab;
import ru.fr0le.objarmor.items.armor.LoadItemArmor;

public class CommonProxy {

	public void preInit() {
		loadTabs();
		loadArmors();		
	}

	public void Init() {

	}

	public void postInit() {

	}

	public void loadTabs() {
		LoadTab.registerTabs();
	}

	public void loadArmors() {
		LoadItemArmor.registerItems();
	}

}