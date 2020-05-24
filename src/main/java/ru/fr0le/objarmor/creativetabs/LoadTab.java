package ru.fr0le.objarmor.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

public class LoadTab {

	public static CreativeTabs tabArmor;

	public static void registerTabs() {
		tabArmor = new TabArmor(CreativeTabs.getNextID(), "tabArmor");
	}

}