package net.divinerpg.client.render.entity.vethea;

import net.divinerpg.client.render.entity.vethea.model.WreckForm1;
import net.divinerpg.client.render.entity.vethea.model.WreckForm2;
import net.divinerpg.client.render.entity.vethea.model.WreckForm3;
import net.divinerpg.entities.base.DivineBossStatus;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.entities.vethea.EntityWreck;
import net.divinerpg.libs.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWreck extends RenderLiving {
	
	private ModelBase form1 = new WreckForm1();
	private ModelBase form2 = new WreckForm2();
	private ModelBase form3 = new WreckForm3();

	public RenderWreck(ModelBase var1, float var2) {
		super(var1, var2);
	}

	public void renderWreck(EntityWreck entity, double var2, double var4, double var6, float var8, float var9) {
		if(entity.getAbilityType() == 0) {
			this.mainModel = form1;
		}
		else if (entity.getAbilityType() == 1) {
			this.mainModel = form2;
		} else {
			this.mainModel = form3;
		}
		DivineBossStatus.setBossStatus(entity, EntityStats.wreckBossID);
		super.doRender(entity, var2, var4, var6, var8, var9);
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
		EntityWreck wreck = (EntityWreck)entity;
		if(wreck.getAbilityType() == 0) {
			return new ResourceLocation(Reference.PREFIX + "textures/mobs/wreckMelee.png");
		} else if(wreck.getAbilityType() == 1) {
			return new ResourceLocation(Reference.PREFIX + "textures/mobs/wreckArcanic.png");
		} else if(wreck.getAbilityType() == 2) {
			return new ResourceLocation(Reference.PREFIX + "textures/mobs/wreckRanged.png");
		}
		return new ResourceLocation(Reference.PREFIX + "textures/mobs/wreckMelee.png");
	}
}