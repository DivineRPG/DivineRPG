package net.divinerpg.client.render.entity.vethea;

import net.divinerpg.api.entity.DivineBossStatus;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.client.render.RenderDivineMob;
import net.divinerpg.client.render.entity.vethea.model.LadyLuna;
import net.divinerpg.entities.vethea.EntityLadyLuna;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLadyLuna extends RenderDivineMob {

	private ModelBase model = new LadyLuna();

	public RenderLadyLuna(ModelBase var1, float var2, ResourceLocation loc) {
		super(var1, var2, loc);
	}

	public void renderLadyLuna(EntityLadyLuna var1, double var2, double var4, double var6, float var8, float var9) {
		this.mainModel = model;
		DivineBossStatus.setBossStatus(var1, EntityStats.ladylunaBossID);
		super.doRender(var1, var2, var4, var6, var8, var9);
	}

	@Override
	public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderLadyLuna((EntityLadyLuna)var1, var2, var4, var6, var8, var9);
	}

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderLadyLuna((EntityLadyLuna)var1, var2, var4, var6, var8, var9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return EntityResourceLocation.LADY_LUNA_MELEE;
	}
}