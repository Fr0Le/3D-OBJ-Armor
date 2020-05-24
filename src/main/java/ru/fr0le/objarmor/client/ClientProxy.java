package ru.fr0le.objarmor.client;

import java.util.HashMap;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.common.MinecraftForge;
import ru.fr0le.objarmor.Info;
import ru.fr0le.objarmor.client.handlers.PlayerRenderHandler;
import ru.fr0le.objarmor.client.render.armor.RenderItemArmor;
import ru.fr0le.objarmor.common.CommonProxy;
import ru.fr0le.objarmor.items.armor.LoadItemArmor;

public class ClientProxy extends CommonProxy {

	private static final HashMap<String, Integer> hash = new HashMap<String, Integer>();

	@Override
	public void preInit() {
		super.preInit();  
		Display.setTitle(Info.name + " demo");
	}

	@Override
	public void Init() {
		super.Init();
		renderIcons();
		renderEquip();	
	}

	@Override
	public void postInit() {
		super.postInit(); 
	}

	public void renderIcons() {	
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.customHelmet, new RenderItemArmor.renderItemHelmet());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.customBody, new RenderItemArmor.renderItemBody());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.customPants, new RenderItemArmor.renderItemPants());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.customBoots, new RenderItemArmor.renderItemBoots());		
	}

	public void renderEquip() {	
		MinecraftForge.EVENT_BUS.register(new PlayerRenderHandler());		
	}

	public static int getRenderPart(String model, String partName) {
		if(hash.containsKey(model + "_" + partName)) 
			return hash.get(model + "_" + partName);

		int displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		AdvancedModelLoader.loadModel(new ResourceLocation(Info.modid, "models/armor/" + model + ".obj")).renderPart(partName);
		GL11.glEndList();
		hash.put(model + "_" + partName, displayList);
		return displayList;
	}

}