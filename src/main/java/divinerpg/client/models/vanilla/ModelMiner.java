package divinerpg.client.models.vanilla;

import com.google.common.collect.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelMiner<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	public final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	public float swimAnimation;

	public ModelMiner() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		RightArm.texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		LeftArm.texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		RightLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		LeftLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		EntityMiner ent = (EntityMiner) entityIn;
		this.swimAnimation = ent.getSwimAmount(partialTick);
		super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag = entityIn.fallDistance > 4;
		boolean flag1 = entityIn.isVisuallySwimming();
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		if (flag) {
			this.Head.xRot = (-(float)Math.PI / 4F);
		} else if (this.swimAnimation > 0.0F) {
			if (flag1) {
				this.Head.xRot = this.rotlerpRad(this.swimAnimation, this.Head.xRot, (-(float)Math.PI / 4F));
			} else {
				this.Head.xRot = this.rotlerpRad(this.swimAnimation, this.Head.xRot, headPitch * ((float)Math.PI / 180F));
			}
		} else {
			this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		}

		this.Body.yRot = 0.0F;
		this.RightArm.z = 0.0F;
		this.RightArm.x = -5.0F;
		this.LeftArm.z = 0.0F;
		this.LeftArm.x = 5.0F;
		float f = 1.0F;
		if (flag) {
			f = (float)entityIn.getDeltaMovement().lengthSqr();
			f = f / 0.2F;
			f = f * f * f;
		}

		if (f < 1.0F) {
			f = 1.0F;
		}

		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.RightArm.zRot = 0.0F;
		this.LeftArm.zRot = 0.0F;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
		this.RightLeg.yRot = 0.0F;
		this.LeftLeg.yRot = 0.0F;
		this.RightLeg.zRot = 0.0F;
		this.LeftLeg.zRot = 0.0F;
		if (this.riding) {
			this.RightArm.xRot += (-(float)Math.PI / 5F);
			this.LeftArm.xRot += (-(float)Math.PI / 5F);
			this.RightLeg.xRot = -1.4137167F;
			this.RightLeg.yRot = ((float)Math.PI / 10F);
			this.RightLeg.zRot = 0.07853982F;
			this.LeftLeg.xRot = -1.4137167F;
			this.LeftLeg.yRot = (-(float)Math.PI / 10F);
			this.LeftLeg.zRot = -0.07853982F;
		}

		this.RightArm.yRot = 0.0F;
		this.LeftArm.yRot = 0.0F;

		this.setupAttackAnimation(entityIn, ageInTicks);
		this.Body.xRot = 0.0F;
		this.RightLeg.z = 0.1F;
		this.LeftLeg.z = 0.1F;
		this.RightLeg.y = 12.0F;
		this.LeftLeg.y = 12.0F;
		this.Head.y = 0.0F;
		this.Body.y = 0.0F;
		this.LeftArm.y = 2.0F;
		this.RightArm.y = 2.0F;

		ModelHelper.bobArms(this.RightArm, this.LeftArm, ageInTicks);
		if (this.swimAnimation > 0.0F) {
			float f1 = limbSwing % 26.0F;
			HandSide handside = HandSide.RIGHT;
			float f2 = handside == HandSide.RIGHT && this.attackTime > 0.0F ? 0.0F : this.swimAnimation;
			float f3 = handside == HandSide.LEFT && this.attackTime > 0.0F ? 0.0F : this.swimAnimation;
			if (f1 < 14.0F) {
				this.LeftArm.xRot = this.rotlerpRad(f3, this.LeftArm.xRot, 0.0F);
				this.RightArm.xRot = MathHelper.lerp(f2, this.RightArm.xRot, 0.0F);
				this.LeftArm.yRot = this.rotlerpRad(f3, this.LeftArm.yRot, (float)Math.PI);
				this.RightArm.yRot = MathHelper.lerp(f2, this.RightArm.yRot, (float)Math.PI);
				this.LeftArm.zRot = this.rotlerpRad(f3, this.LeftArm.zRot, (float)Math.PI + 1.8707964F);
				this.RightArm.zRot = MathHelper.lerp(f2, this.RightArm.zRot, (float)Math.PI - 1.8707964F);
			} else if (f1 >= 14.0F && f1 < 22.0F) {
				float f6 = (f1 - 14.0F) / 8.0F;
				this.LeftArm.xRot = this.rotlerpRad(f3, this.LeftArm.xRot, ((float)Math.PI / 2F) * f6);
				this.RightArm.xRot = MathHelper.lerp(f2, this.RightArm.xRot, ((float)Math.PI / 2F) * f6);
				this.LeftArm.yRot = this.rotlerpRad(f3, this.LeftArm.yRot, (float)Math.PI);
				this.RightArm.yRot = MathHelper.lerp(f2, this.RightArm.yRot, (float)Math.PI);
				this.LeftArm.zRot = this.rotlerpRad(f3, this.LeftArm.zRot, 5.012389F - 1.8707964F * f6);
				this.RightArm.zRot = MathHelper.lerp(f2, this.RightArm.zRot, 1.2707963F + 1.8707964F * f6);
			} else if (f1 >= 22.0F && f1 < 26.0F) {
				float f4 = (f1 - 22.0F) / 4.0F;
				this.LeftArm.xRot = this.rotlerpRad(f3, this.LeftArm.xRot, ((float)Math.PI / 2F) - ((float)Math.PI / 2F) * f4);
				this.RightArm.xRot = MathHelper.lerp(f2, this.RightArm.xRot, ((float)Math.PI / 2F) - ((float)Math.PI / 2F) * f4);
				this.LeftArm.yRot = this.rotlerpRad(f3, this.LeftArm.yRot, (float)Math.PI);
				this.RightArm.yRot = MathHelper.lerp(f2, this.RightArm.yRot, (float)Math.PI);
				this.LeftArm.zRot = this.rotlerpRad(f3, this.LeftArm.zRot, (float)Math.PI);
				this.RightArm.zRot = MathHelper.lerp(f2, this.RightArm.zRot, (float)Math.PI);
			}

			float f7 = 0.3F;
			float f5 = 0.33333334F;
			this.LeftLeg.xRot = MathHelper.lerp(this.swimAnimation, this.LeftLeg.xRot, 0.3F * MathHelper.cos(limbSwing * 0.33333334F + (float)Math.PI));
			this.RightLeg.xRot = MathHelper.lerp(this.swimAnimation, this.RightLeg.xRot, 0.3F * MathHelper.cos(limbSwing * 0.33333334F));
		}
	}
	protected float rotlerpRad(float p_205060_1_, float p_205060_2_, float p_205060_3_) {
		float f = (p_205060_3_ - p_205060_2_) % ((float)Math.PI * 2F);
		if (f < -(float)Math.PI) {
			f += ((float)Math.PI * 2F);
		}

		if (f >= (float)Math.PI) {
			f -= ((float)Math.PI * 2F);
		}

		return p_205060_2_ + p_205060_1_ * f;
	}

	protected void setupAttackAnimation(T p_230486_1_, float p_230486_2_) {
		if (!(this.attackTime <= 0.0F)) {
			HandSide handside = HandSide.RIGHT;
			ModelRenderer modelrenderer = this.RightArm;
			float f = this.attackTime;
			this.Body.yRot = MathHelper.sin(MathHelper.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;
			if (handside == HandSide.LEFT) {
				this.Body.yRot *= -1.0F;
			}

			this.RightArm.z = MathHelper.sin(this.Body.yRot) * 5.0F;
			this.RightArm.x = -MathHelper.cos(this.Body.yRot) * 5.0F;
			this.LeftArm.z = -MathHelper.sin(this.Body.yRot) * 5.0F;
			this.LeftArm.x = MathHelper.cos(this.Body.yRot) * 5.0F;
			this.RightArm.yRot += this.Body.yRot;
			this.LeftArm.yRot += this.Body.yRot;
			this.LeftArm.xRot += this.Body.yRot;
			f = 1.0F - this.attackTime;
			f = f * f;
			f = f * f;
			f = 1.0F - f;
			float f1 = MathHelper.sin(f * (float)Math.PI);
			float f2 = MathHelper.sin(this.attackTime * (float)Math.PI) * -(this.Head.xRot - 0.7F) * 0.75F;
			modelrenderer.xRot = (float)((double)modelrenderer.xRot - ((double)f1 * 1.2D + (double)f2));
			modelrenderer.yRot += this.Body.yRot * 2.0F;
			modelrenderer.zRot += MathHelper.sin(this.attackTime * (float)Math.PI) * -0.4F;
		}
	}

	@Override
	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(Head, Body, RightArm, LeftArm, RightLeg, LeftLeg);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}