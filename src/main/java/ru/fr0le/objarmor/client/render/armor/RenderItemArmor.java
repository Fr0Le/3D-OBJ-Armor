package ru.fr0le.objarmor.client.render.armor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import ru.fr0le.objarmor.client.ClientProxy;
import ru.fr0le.objarmor.client.resources.Resources;
import ru.fr0le.objarmor.items.armor.ArmorType.customArmor;

public class RenderItemArmor {

	private static ResourceLocation texture;
	private static String model;

	public static void setResources(ItemStack item) {				
		Item equip = item.getItem();
		if(equip instanceof customArmor) {
			texture = Resources.customArmorTexture;
			model = "customArmorModel";
		}		
	}

	public static class renderItemHelmet implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -3.6F, 0F);
				GL11.glScalef(1F, 1F, 1F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "head"));
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0.25F, -3F, 0.5F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "head"));
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -1.5F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "head"));
				GL11.glPopMatrix();
			}
		}
	}

	public static class renderItemBody implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) { 
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {	
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -1.75F, 0F);
				GL11.glScalef(0.75F, 0.75F, 0.9F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "body"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandRight"));

				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);	
				GL11.glTranslatef(-0.25F, -2F, 0.75F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "body"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandRight"));
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -0.5F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "body"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandRight"));
				GL11.glPopMatrix();
			}
		}
	}

	public static class renderItemPants implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) { 
			return true;
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {	
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -0.9F, 0F);
				GL11.glScalef(1F, 1F, 1.1F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "legLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "legRight"));
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0.25F, -0.5F, 0.75F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "legLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "legRight"));
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 0F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "legLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "legRight"));
				GL11.glPopMatrix();
			}
		}
	}

	public static class renderItemBoots implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true;
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true;
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {	
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -.25F, 0F);
				GL11.glScalef(1.2F, 1.2F, 1.2F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "bootLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bootRight"));
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0.25F, 0.5F, 0.75F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "bootLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bootRight"));
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 0.5F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				GL11.glCallList(ClientProxy.getRenderPart(model, "bootLeft"));
				GL11.glCallList(ClientProxy.getRenderPart(model, "bootRight"));
				GL11.glPopMatrix();
			}
		}
	}

}