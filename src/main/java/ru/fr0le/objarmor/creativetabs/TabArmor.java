package ru.fr0le.objarmor.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.fr0le.objarmor.items.armor.LoadItemArmor;

public class TabArmor extends CreativeTabs {

	public TabArmor(int nextID, String lable) {
		super(nextID, lable);
	}

	@Override
	public Item getTabIconItem() {
		return LoadItemArmor.customBody;
	}
	
}