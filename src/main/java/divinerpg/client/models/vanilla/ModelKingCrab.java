package divinerpg.client.models.vanilla;// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelKingCrab extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer FrontRightLeg;
	private final ModelRenderer FrontRightLeg_r1;
	private final ModelRenderer FrontLeftLeg;
	private final ModelRenderer FrontLeftLeg_r1;
	private final ModelRenderer MiddleRightLeg;
	private final ModelRenderer MiddleRightLeg_r1;
	private final ModelRenderer MiddleLeftLeg;
	private final ModelRenderer MiddleLeftLeg_r1;
	private final ModelRenderer BackLeftLeg;
	private final ModelRenderer BackLeftLeg_r1;
	private final ModelRenderer BackRightLeg;
	private final ModelRenderer BackRightLeg_r1;
	private final ModelRenderer LeftClaw;
	private final ModelRenderer RightClaw;

	public ModelKingCrab() {
		texWidth = 128;
		texHeight = 128;

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 10.0F, 4.6667F);
		Body.texOffs(0, 64).addBox(-8.0F, -7.0F, -9.6667F, 16.0F, 2.0F, 20.0F, 0.0F, false);
		Body.texOffs(0, 36).addBox(-11.0F, -7.0F, -12.6667F, 22.0F, 2.0F, 26.0F, 0.0F, false);
		Body.texOffs(0, 0).addBox(-11.0F, -5.0F, -12.6667F, 22.0F, 10.0F, 26.0F, 0.0F, false);

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setPos(-12.0F, 1.0F, -4.6667F);
		Body.addChild(FrontRightLeg);


		FrontRightLeg_r1 = new ModelRenderer(this);
		FrontRightLeg_r1.setPos(0.0F, 2.0F, 0.0F);
		FrontRightLeg.addChild(FrontRightLeg_r1);
		setRotationAngle(FrontRightLeg_r1, 0.0F, 0.0F, 0.3491F);
		FrontRightLeg_r1.texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setPos(12.0F, 1.0F, -4.6667F);
		Body.addChild(FrontLeftLeg);
		

		FrontLeftLeg_r1 = new ModelRenderer(this);
		FrontLeftLeg_r1.setPos(0.0F, 2.0F, 0.0F);
		FrontLeftLeg.addChild(FrontLeftLeg_r1);
		setRotationAngle(FrontLeftLeg_r1, 0.0F, 0.0F, -0.3491F);
		FrontLeftLeg_r1.texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		MiddleRightLeg = new ModelRenderer(this);
		MiddleRightLeg.setPos(-12.0F, 1.0F, 2.3333F);
		Body.addChild(MiddleRightLeg);
		

		MiddleRightLeg_r1 = new ModelRenderer(this);
		MiddleRightLeg_r1.setPos(0.0F, 2.0F, 0.0F);
		MiddleRightLeg.addChild(MiddleRightLeg_r1);
		setRotationAngle(MiddleRightLeg_r1, 0.0F, 0.0F, 0.3491F);
		MiddleRightLeg_r1.texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		MiddleLeftLeg = new ModelRenderer(this);
		MiddleLeftLeg.setPos(12.0F, 1.0F, 2.3333F);
		Body.addChild(MiddleLeftLeg);
		

		MiddleLeftLeg_r1 = new ModelRenderer(this);
		MiddleLeftLeg_r1.setPos(0.0F, 2.0F, 0.0F);
		MiddleLeftLeg.addChild(MiddleLeftLeg_r1);
		setRotationAngle(MiddleLeftLeg_r1, 0.0F, 0.0F, -0.3491F);
		MiddleLeftLeg_r1.texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setPos(12.0F, 1.0F, 9.3333F);
		Body.addChild(BackLeftLeg);
		

		BackLeftLeg_r1 = new ModelRenderer(this);
		BackLeftLeg_r1.setPos(0.0F, 2.0F, 0.0F);
		BackLeftLeg.addChild(BackLeftLeg_r1);
		setRotationAngle(BackLeftLeg_r1, 0.0F, 0.0F, -0.3491F);
		BackLeftLeg_r1.texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setPos(-12.0F, 1.0F, 9.3333F);
		Body.addChild(BackRightLeg);
		

		BackRightLeg_r1 = new ModelRenderer(this);
		BackRightLeg_r1.setPos(0.0F, 2.0F, 0.0F);
		BackRightLeg.addChild(BackRightLeg_r1);
		setRotationAngle(BackRightLeg_r1, 0.0F, 0.0F, 0.3491F);
		BackRightLeg_r1.texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		LeftClaw = new ModelRenderer(this);
		LeftClaw.setPos(11.0F, 8.25F, -6.0F);
		LeftClaw.texOffs(77, 64).addBox(0.0F, -3.25F, -10.0F, 6.0F, 1.0F, 12.0F, 0.0F, false);
		LeftClaw.texOffs(70, 36).addBox(0.0F, -2.25F, -10.0F, 6.0F, 10.0F, 12.0F, 0.0F, false);

		RightClaw = new ModelRenderer(this);
		RightClaw.setPos(-11.0F, 7.75F, -5.5F);
		RightClaw.texOffs(52, 64).addBox(-6.0F, -3.75F, -11.5F, 6.0F, 1.0F, 13.0F, 0.0F, false);
		RightClaw.texOffs(70, 0).addBox(-6.0F, -2.75F, -11.5F, 6.0F, 12.0F, 13.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.FrontRightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.BackRightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.MiddleRightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.E) * 1.4F * limbSwingAmount;
		this.MiddleLeftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.E) * 1.4F * limbSwingAmount;

		this.FrontLeftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.BackLeftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void prepareMobModel(Entity e, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
		super.prepareMobModel(e, p_212843_2_, p_212843_3_, p_212843_4_);
	}


	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftClaw.render(matrixStack, buffer, packedLight, packedOverlay);
			RightClaw.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}