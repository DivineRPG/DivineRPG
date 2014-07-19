package net.divinerpg.client.render;

import net.divinerpg.api.entity.DivineBossStatus;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.libs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BossTickHandler {

	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		if(event.phase == Phase.START){
			onTickStart();
		} else {
			onTickEnd();
		}
	}

	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	@SideOnly(Side.CLIENT)
	private void onTickRender() {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		this.mc.mcProfiler.startSection("divineBossHealth");
		this.renderBossHealth();
		this.mc.mcProfiler.endSection();
		GL11.glDisable(GL11.GL_BLEND);
	}

	@SideOnly(Side.CLIENT)
	private void renderBossHealth() {
		ResourceLocation r = null;

		switch(DivineBossStatus.bossNumber){
		//Vanilla
		case EntityStats.ancientEntityBossID:
			r = set("ancientEntity");
			break;
		case EntityStats.ayeracoGreenBossID:
			r = set("greenAyeraco");
			break;
		case EntityStats.ayeracoPurpleBossID:
			r = set("prupleAyeraco");
			break;
		case EntityStats.ayeracoYellowBossID:
			r = set("yellowAyeraco");
			break;
		case EntityStats.ayeracoRedBossID:
			r = set("redAyeraco");
			break;
		case EntityStats.ayeracoBlueBossID:
			r = set("blueAyeraco");
			break;
		case EntityStats.scorcherKingBossID:
			r = set("kingofScorchers");
			break;
		case EntityStats.netherWatcherBossID:
			r = set("theWatcher");
			break;
		//Twilight
		case EntityStats.densosBossID:
			r = set("densos");
			break;
		case EntityStats.reyvorBossID:
			r = set("reyvor");
			break;
		case EntityStats.twilightDemonBossID:
			r = set("twilightDemon");
			break;
		case EntityStats.soulFiendBossID:
			r = set("soulFiend");
			break;
		case EntityStats.vamacheronBossID:
			r = set("vamacheron");
			break;
		case EntityStats.karotBossID:
			r = set("karot");
			break;
		//Arcana
		case EntityStats.dramixBossID:
			r = set("dramix");
			break;
		case EntityStats.parasectaBossID:
			r = set("parasecta");
			break;
		//Vethea
		case EntityStats.hiveQueenBossID:
			r = set("hiveQueen");
			break;
		case EntityStats.raglokBossID:
			r = set("raglok");
			break;
		case EntityStats.quadroBossID:
			r = set("quadro");
			break;
		case EntityStats.ladylunaBossID:
			r = set("ladyLuna");
			break;
		case EntityStats.wreckBossID:
			r = set("wreck");
			break;
		case EntityStats.karosBossID:
			r = set("drKaros");
			break;
		}

		if(DivineBossStatus.statusBarTime > 0) {
			DivineBossStatus.statusBarTime--;
			GuiIngame gig = mc.ingameGUI;
			FontRenderer fontrenderer = this.mc.fontRenderer;
			ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			int barLength = 182;
			int finalBarLength = barLength + 1;
			int barDisX = i / 2 - barLength / 2;
			int barDisY = 12;
			int health = (int)(DivineBossStatus.healthScale * (float)(finalBarLength));
			int barHeight = 10;
			this.mc.getTextureManager().bindTexture(r);
			gig.drawTexturedModalRect(barDisX, barDisY, 0, 0, health, barHeight);
			gig.drawTexturedModalRect(barDisX, barDisY, 0, barHeight, finalBarLength, barHeight);
			if(health > 0)
				gig.drawTexturedModalRect(barDisX, barDisY, 0, 0, health, 10);
		}
	}

	public ResourceLocation set(String name){
		return new ResourceLocation(Reference.PREFIX + "textures/gui/bossBar/" + name + ".png");
	}

	private void onTickEnd() { }

	private void onTickStart() { }
}