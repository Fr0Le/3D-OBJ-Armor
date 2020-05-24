package ru.fr0le.objarmor.items.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class LoadItemArmor {

	public static ItemArmor customHelmet, customBody, customPants, customBoots;

	public static ArmorMaterial CUSTOMARMOR;

	public static void registerItems() {		
		CUSTOMARMOR = EnumHelper.addArmorMaterial("ARMOR", 100, new int[] {4, 7, 6, 3}, 0);

		customHelmet = new CustomItemArmor.Helmet(LoadItemArmor.CUSTOMARMOR, 0, 0);
		customBody = new CustomItemArmor.Body(LoadItemArmor.CUSTOMARMOR, 1, 1);
		customPants = new CustomItemArmor.Pants(LoadItemArmor.CUSTOMARMOR, 2, 2);
		customBoots = new CustomItemArmor.Boots(LoadItemArmor.CUSTOMARMOR, 3, 3);		

		GameRegistry.registerItem(customHelmet, customHelmet.getUnlocalizedName());
		GameRegistry.registerItem(customBody, customBody.getUnlocalizedName());
		GameRegistry.registerItem(customPants, customPants.getUnlocalizedName());
		GameRegistry.registerItem(customBoots, customBoots.getUnlocalizedName());
	}

}