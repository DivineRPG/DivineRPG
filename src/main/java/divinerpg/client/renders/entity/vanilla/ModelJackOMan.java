package divinerpg.client.renders.entity.vanilla;


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelJackOMan<T extends Entity> extends SegmentedModel<T> {
	public final ModelRenderer Head;
	public final ModelRenderer Body;
	public final ModelRenderer RightArm;
	public final ModelRenderer LeftArm;
	public final ModelRenderer RightLeg;
	public final ModelRenderer LeftLeg;
	public float swimAnimation;

	public ModelJackOMan() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		RightArm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		LeftArm.setTextureOffset(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		LeftArm.setTextureOffset(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		RightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		LeftLeg.setTextureOffset(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		EntityJackOMan ent = (EntityJackOMan) entityIn;
		this.swimAnimation = ent.getSwimAnimation(partialTick);
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag1 = entityIn.isActualySwimming();
		this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);

		this.Body.rotateAngleY = 0.0F;
		this.RightArm.rotationPointZ = 0.0F;
		this.RightArm.rotationPointX = -5.0F;
		this.LeftArm.rotationPointZ = 0.0F;
		this.LeftArm.rotationPointX = 5.0F;
		float f = 1.0F;

		if (f < 1.0F) {
			f = 1.0F;
		}

		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.RightArm.rotateAngleZ = 0.0F;
		this.LeftArm.rotateAngleZ = 0.0F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.RightLeg.rotateAngleZ = 0.0F;
		this.LeftLeg.rotateAngleZ = 0.0F;
		if (this.isSitting) {
			this.RightArm.rotateAngleX += (-(float)Math.PI / 5F);
			this.LeftArm.rotateAngleX += (-(float)Math.PI / 5F);
			this.RightLeg.rotateAngleX = -1.4137167F;
			this.RightLeg.rotateAngleY = ((float)Math.PI / 10F);
			this.RightLeg.rotateAngleZ = 0.07853982F;
			this.LeftLeg.rotateAngleX = -1.4137167F;
			this.LeftLeg.rotateAngleY = (-(float)Math.PI / 10F);
			this.LeftLeg.rotateAngleZ = -0.07853982F;
		}

		this.RightArm.rotateAngleY = 0.0F;
		this.LeftArm.rotateAngleY = 0.0F;
			this.Body.rotateAngleX = 0.0F;
			this.RightLeg.rotationPointZ = 0.1F;
			this.LeftLeg.rotationPointZ = 0.1F;
			this.RightLeg.rotationPointY = 12.0F;
			this.LeftLeg.rotationPointY = 12.0F;
			this.Head.rotationPointY = 0.0F;
			this.Body.rotationPointY = 0.0F;
			this.LeftArm.rotationPointY = 2.0F;
			this.RightArm.rotationPointY = 2.0F;

		ModelHelper.func_239101_a_(this.RightArm, this.LeftArm, ageInTicks);

		float f7 = 0.3F;
		float f5 = 0.33333334F;
		this.LeftLeg.rotateAngleX = MathHelper.lerp(this.swimAnimation, this.LeftLeg.rotateAngleX, 0.3F * MathHelper.cos(limbSwing * 0.33333334F + (float)Math.PI));
		this.RightLeg.rotateAngleX = MathHelper.lerp(this.swimAnimation, this.RightLeg.rotateAngleX, 0.3F * MathHelper.cos(limbSwing * 0.33333334F));
	}



	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(Head, Body, RightArm, LeftArm, RightLeg, LeftLeg);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}