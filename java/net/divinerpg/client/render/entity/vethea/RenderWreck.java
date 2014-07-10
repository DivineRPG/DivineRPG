package net.divinerpg.client.render.entity.vethea;

import net.divinerpg.api.entity.DivineBossStatus;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.client.render.RenderDivineMob;
import net.divinerpg.client.render.entity.vethea.model.WreckForm1;
import net.divinerpg.client.render.entity.vethea.model.WreckForm2;
import net.divinerpg.client.render.entity.vethea.model.WreckForm3;
import net.divinerpg.entities.vethea.EntityWreck;
import net.divinerpg.libs.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWreck extends RenderDivineMob {
	
	private ModelBase form1 = new WreckForm1();
	private ModelBase form2 = new WreckForm2();
	private ModelBase form3 = new WreckForm3();

	public RenderWreck(ModelBase var1, float var2, ResourceLocation loc) {
		super(var1, var2, loc);
	}

	public void renderWreck(EntityWreck var1, double var2, double var4, double var6, float var8, float var9) {
		if(var1.stage == 1) {
			this.mainModel = form1;
		}
		else if (var1.stage == 2) {
			this.mainModel = form2;
		} else {
			this.mainModel = form3;
		}
		DivineBossStatus.setBossStatus(var1, EntityStats.wreckBossID);
		super.doRender(var1, var2, var4, var6, var8, var9);
	}

	@Override
	public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderWreck((EntityWreck)var1, var2, var4, var6, var8, var9);
	}

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderWreck((EntityWreck)var1, var2, var4, var6, var8, var9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		if(EntityWreck.stage == 1){
			return new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/wreck.png");
		}
		if(EntityWreck.stage == 2){
			return new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/wreckForm2.png");
		}
		if(EntityWreck.stage == 3){
			return new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/wreckForm3.png");
		}
		return new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/wreck.png");
	}
}