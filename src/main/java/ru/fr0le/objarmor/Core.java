package ru.fr0le.objarmor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ru.fr0le.objarmor.common.CommonProxy;

@Mod(modid = Info.modid, name = Info.name, version = Info.version)

public class Core {

	@Mod.Instance(Info.modid)
	public static Core mod;

	@SidedProxy(clientSide="ru.fr0le.objarmor.client.ClientProxy", serverSide="ru.fr0le.objarmor.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {		
		proxy.preInit();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.Init();
		System.out.println(Info.name + " has been successfully initialized");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

}