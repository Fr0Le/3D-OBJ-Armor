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
		renderModels();
	}

	@Override
	public void postInit() {
		super.postInit(); 
	}

	public void renderEquip() {	
		MinecraftForge.EVENT_BUS.register(new PlayerRenderHandler());		
	}

	public void renderIcons() {	
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.customHelmet, new RenderItemArmor.renderItemHelmet());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.customBody, new RenderItemArmor.renderItemBody());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.customPants, new RenderItemArmor.renderItemPants());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.customBoots, new RenderItemArmor.renderItemBoots());			
	}

	public void renderModels() {	
		//при условии что все *.obj модели будут иметь одинаковую структуру
		for(int i = 1; i <= 1; i++) {
			String model = "";
			//тут добавляем название моделей
			switch(i) {
			case(1):
				model = "customArmorModel";
			break;
			default:				
				break;
			}

			for(int j = 1; j <= 8; j++) {
				String part = "";
				//тут добавляем название частей модели
				switch(j) {
				case(1):
					part = "head";
				break;
				case(2):
					part = "body";
				break;
				case(3):
					part = "bodyHandLeft";
				break;
				case(4):
					part = "bodyHandRight";
				break;		
				case(5):
					part = "legLeft";
				break;
				case(6):
					part = "legRight";
				break;
				case(7):
					part = "bootLeft";
				break;
				case(8):
					part = "bootRight";
				break;
				default:
					break;
				}

				GL11.glCallList(ClientProxy.getRenderPart(model, part));
			}
		}
	}

	public static int getRenderPart(String model, String partName) {
		if(hash.containsKey(model + "_" + partName)) 
			return hash.get(model + "_" + partName);

		int displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		AdvancedModelLoader.loadModel(new ResourceLocation(Info.modid, "models/armor/" + model + ".obj")).renderPart(partName);
		GL11.glEndList();
		hash.put(model + "_" + partName, displayList);
		System.out.println("" + model + "_" + partName);
		return displayList;
	}

}