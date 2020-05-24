package ru.fr0le.objarmor.client.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import ru.fr0le.objarmor.client.render.RenderBody;
import ru.fr0le.objarmor.client.render.RenderBoots;
import ru.fr0le.objarmor.client.render.RenderHelmet;
import ru.fr0le.objarmor.client.render.RenderPants;

public class PlayerRenderHandler {

	private RenderHelmet renderHelmet = new RenderHelmet();
	private RenderBody renderBody = new RenderBody();
	private RenderPants renderPants = new RenderPants();
	private RenderBoots renderBoots = new RenderBoots();

	@SubscribeEvent
	public void onPlayerRenderTick(RenderPlayerEvent.Specials.Post event) {
		if(event.entityPlayer == null) {
			return;
		}		

		EntityPlayer player = (EntityPlayer) event.entityLiving;
		if(player.getCurrentArmor(3) != null) renderHelmet.render(player, event.renderer);
		if(player.getCurrentArmor(2) != null) renderBody.render(player, event.renderer);
		if(player.getCurrentArmor(1) != null) renderPants.render(player, event.renderer);
		if(player.getCurrentArmor(0) != null) renderBoots.render(player, event.renderer);
	}

}