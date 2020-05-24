package ru.fr0le.objarmor.items.armor;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import ru.fr0le.objarmor.Info;
import ru.fr0le.objarmor.creativetabs.LoadTab;
import ru.fr0le.objarmor.items.armor.ArmorType.armorTypeBody;
import ru.fr0le.objarmor.items.armor.ArmorType.armorTypeBoots;
import ru.fr0le.objarmor.items.armor.ArmorType.armorTypeHelmet;
import ru.fr0le.objarmor.items.armor.ArmorType.armorTypePants;
import ru.fr0le.objarmor.items.armor.ArmorType.customArmor;

public class CustomItemArmor {

	public static class Helmet extends ItemArmor implements customArmor, armorTypeHelmet {
		public Helmet(ArmorMaterial armorMaterial, int par3, int par4) {
			super(armorMaterial, par3, par4);
			this.setCreativeTab(LoadTab.tabArmor);
			this.setUnlocalizedName("customHelmet");
			this.setTextureName(Info.modid + ":null");
		}

		@SideOnly(Side.CLIENT)
		public void addInformation(final ItemStack stack, final EntityPlayer player, final List line, boolean advanced) {
			ArmorType.getDefence(line, this.damageReduceAmount);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
			return Info.modid + ":textures/items/null.png";
		} 
	}

	public static class Body extends ItemArmor implements customArmor, armorTypeBody {
		public Body(ArmorMaterial armorMaterial, int par3, int par4) {
			super(armorMaterial, par3, par4);
			this.setCreativeTab(LoadTab.tabArmor);
			this.setUnlocalizedName("customBody");
			this.setTextureName(Info.modid + ":null");
		}

		@SideOnly(Side.CLIENT)
		public void addInformation(final ItemStack stack, final EntityPlayer player, final List line, boolean advanced) {
			ArmorType.getDefence(line, this.damageReduceAmount);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
			return Info.modid + ":textures/items/null.png";
		}
	}

	public static class Pants extends ItemArmor implements customArmor, armorTypePants {
		public Pants(ArmorMaterial armorMaterial, int par3, int par4) {
			super(armorMaterial, par3, par4);
			this.setCreativeTab(LoadTab.tabArmor);
			this.setUnlocalizedName("customPants");
			this.setTextureName(Info.modid + ":null");
		}

		@SideOnly(Side.CLIENT)
		public void addInformation(final ItemStack stack, final EntityPlayer player, final List line, boolean advanced) {
			ArmorType.getDefence(line, this.damageReduceAmount);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
			return Info.modid + ":textures/items/null.png";
		}
	}

	public static class Boots extends ItemArmor implements customArmor, armorTypeBoots {
		public Boots(ArmorMaterial armorMaterial, int par3, int par4) {
			super(armorMaterial, par3, par4);
			this.setCreativeTab(LoadTab.tabArmor);
			this.setUnlocalizedName("customBoots");
			this.setTextureName(Info.modid + ":null");
		}

		@SideOnly(Side.CLIENT)
		public void addInformation(final ItemStack stack, final EntityPlayer player, final List line, boolean advanced) {
			ArmorType.getDefence(line, this.damageReduceAmount);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
			return Info.modid + ":textures/items/null.png";
		}
	}

}