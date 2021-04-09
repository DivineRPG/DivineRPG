package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelCrab<T extends Entity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer BackLeftLeg;
	private final ModelRenderer BackRightLeg;
	private final ModelRenderer MiddleLeftLeg;
	private final ModelRenderer MiddleRightLeg;
	private final ModelRenderer FrontLeftLeg;
	private final ModelRenderer FrontRightLeg;
	private final ModelRenderer RightClaw;
	private final ModelRenderer LeftClaw;

	public ModelCrab() {
		texWidth = 64;
		texHeight = 64;

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 18.0F, 2.0F);
		Body.texOffs(0, 0).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 6.0F, 12.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setPos(6.0F, 20.0F, 7.0F);
		BackLeftLeg.texOffs(0, 0).addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setPos(-6.0F, 20.0F, 7.0F);
		BackRightLeg.texOffs(16, 31).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		MiddleLeftLeg = new ModelRenderer(this);
		MiddleLeftLeg.setPos(7.0F, 22.0F, 4.0F);
		MiddleLeftLeg.texOffs(0, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		MiddleRightLeg = new ModelRenderer(this);
		MiddleRightLeg.setPos(-6.0F, 20.0F, 4.0F);
		MiddleRightLeg.texOffs(8, 29).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setPos(6.0F, 20.0F, 1.0F);
		FrontLeftLeg.texOffs(14, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setPos(-6.0F, 20.0F, 1.0F);
		FrontRightLeg.texOffs(0, 29).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightClaw = new ModelRenderer(this);
		RightClaw.setPos(-8.0F, 19.5F, -2.0F);
		RightClaw.texOffs(0, 18).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 6.0F, 0.0F, false);

		LeftClaw = new ModelRenderer(this);
		LeftClaw.setPos(8.0F, 19.5F, -2.0F);
		LeftClaw.texOffs(20, 20).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		BackLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		BackRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		MiddleLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		MiddleRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		FrontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		FrontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		RightClaw.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftClaw.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}