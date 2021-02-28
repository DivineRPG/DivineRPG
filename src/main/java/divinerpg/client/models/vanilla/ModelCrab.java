package divinerpg.client.models.vanilla;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelCrab<T extends Entity> extends SegmentedModel<T> {
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
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 18.0F, 2.0F);
		Body.setTextureOffset(0, 0).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 6.0F, 12.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setRotationPoint(6.0F, 20.0F, 7.0F);
		BackLeftLeg.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setRotationPoint(-6.0F, 20.0F, 7.0F);
		BackRightLeg.setTextureOffset(16, 31).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		MiddleLeftLeg = new ModelRenderer(this);
		MiddleLeftLeg.setRotationPoint(7.0F, 22.0F, 4.0F);
		MiddleLeftLeg.setTextureOffset(0, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		MiddleRightLeg = new ModelRenderer(this);
		MiddleRightLeg.setRotationPoint(-6.0F, 20.0F, 4.0F);
		MiddleRightLeg.setTextureOffset(8, 29).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setRotationPoint(6.0F, 20.0F, 1.0F);
		FrontLeftLeg.setTextureOffset(14, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setRotationPoint(-6.0F, 20.0F, 1.0F);
		FrontRightLeg.setTextureOffset(0, 29).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightClaw = new ModelRenderer(this);
		RightClaw.setRotationPoint(-8.0F, 19.5F, -2.0F);
		RightClaw.setTextureOffset(0, 18).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 6.0F, 0.0F, false);

		LeftClaw = new ModelRenderer(this);
		LeftClaw.setRotationPoint(8.0F, 19.5F, -2.0F);
		LeftClaw.setTextureOffset(20, 20).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.MiddleRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.E) * 1.4F * limbSwingAmount;
		this.MiddleLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.E) * 1.4F * limbSwingAmount;

		this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(Body, BackLeftLeg, BackRightLeg, MiddleLeftLeg, MiddleRightLeg, FrontLeftLeg, FrontRightLeg, RightClaw, LeftClaw);
	}



	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}