package ru.fr0le.objarmor.client.render.armor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import ru.fr0le.objarmor.client.ClientProxy;
import ru.fr0le.objarmor.client.resources.Resources;
import ru.fr0le.objarmor.items.armor.ArmorType.customArmor;

public class RenderEquipArmor {

	private static ResourceLocation texture;
	private static String model;

	public static void setResources(Item equip) {		
		if(equip instanceof customArmor) {
			texture = Resources.customArmorTexture;
			model = "customArmorModel";
		}		
	}

	public static void renderHelmet(RenderPlayer renderModel, Item equip) {
		setResources(equip);

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedHead.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-0.005F, -1.54F, 0.0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "head"));
		GL11.glPopMatrix();
	}

	public static void renderBody(RenderPlayer renderModel, Item equip) {
		setResources(equip);

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedBody.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(0F, -1.51F, 0.0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "body"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.32F, -1.4F, 0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.32F, -1.4F, 0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandRight"));
		GL11.glPopMatrix();
	}

	public static void renderPants(RenderPlayer renderModel, Item equip) {
		setResources(equip);

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.125F, -0.75F, 0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "legLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.125F, -0.75F, 0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "legRight"));
		GL11.glPopMatrix();
	}

	public static void renderBoots(RenderPlayer renderModel, Item equip) {
		setResources(equip);

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.125F, -0.75F, 0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "bootLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.125F, -0.75F, 0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "bootRight"));
		GL11.glPopMatrix();
	}

}