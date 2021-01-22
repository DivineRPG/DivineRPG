package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelRotatick<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer RightMandible;
	private final ModelRenderer LeftMandible;
	private final ModelRenderer Body;
	private final ModelRenderer BackLeftLeg;
	private final ModelRenderer BackRightLeg;
	private final ModelRenderer MiddleLeftLeg;
	private final ModelRenderer MiddleRightLeg;
	private final ModelRenderer FrontLeftLeg;
	private final ModelRenderer FrontRightLeg;

	public ModelRotatick() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 16.0F, -5.0F);
		Head.setTextureOffset(38, 38).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 5.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(0, 36).addBox(-6.0F, -5.0F, -7.0F, 12.0F, 4.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(38, 25).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		RightMandible = new ModelRenderer(this);
		RightMandible.setRotationPoint(-5.5F, 2.5F, -5.0F);
		Head.addChild(RightMandible);
		RightMandible.setTextureOffset(42, 7).addBox(-0.5F, -1.5F, -3.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		LeftMandible = new ModelRenderer(this);
		LeftMandible.setRotationPoint(6.0F, 2.0F, -5.0F);
		Head.addChild(LeftMandible);
		LeftMandible.setTextureOffset(42, 0).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 16.0F, 2.0F);
		Body.setTextureOffset(0, 0).addBox(-7.0F, -4.0F, -7.0F, 14.0F, 4.0F, 14.0F, 0.0F, false);
		Body.setTextureOffset(0, 18).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 4.0F, 14.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setRotationPoint(5.5F, 4.0F, 4.5F);
		Body.addChild(BackLeftLeg);
		BackLeftLeg.setTextureOffset(0, 25).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setRotationPoint(-5.5F, 4.0F, 4.5F);
		Body.addChild(BackRightLeg);
		BackRightLeg.setTextureOffset(0, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		MiddleLeftLeg = new ModelRenderer(this);
		MiddleLeftLeg.setRotationPoint(5.5F, 4.0F, 0.5F);
		Body.addChild(MiddleLeftLeg);
		MiddleLeftLeg.setTextureOffset(31, 36).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		MiddleRightLeg = new ModelRenderer(this);
		MiddleRightLeg.setRotationPoint(-5.5F, 4.0F, 0.5F);
		Body.addChild(MiddleRightLeg);
		MiddleRightLeg.setTextureOffset(0, 7).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setRotationPoint(5.5F, 4.0F, -3.5F);
		Body.addChild(FrontLeftLeg);
		FrontLeftLeg.setTextureOffset(38, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setRotationPoint(-5.5F, 4.0F, -3.5F);
		Body.addChild(FrontRightLeg);
		FrontRightLeg.setTextureOffset(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float var1, float var2, float var3, float var4, float var5){
		this.Head.rotateAngleY = var4 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = var5 / (180F / (float) Math.PI);

		this.BackLeftLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
		this.MiddleLeftLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
		this.FrontLeftLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
		this.BackRightLeg.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
		this.MiddleRightLeg.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
		this.FrontRightLeg.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;

		this.BackRightLeg.rotateAngleY = 0.3F;
		this.MiddleRightLeg.rotateAngleY = 0.2F;
		this.FrontRightLeg.rotateAngleY = 0.1F;
		this.BackLeftLeg.rotateAngleY = 0.3F;
		this.MiddleLeftLeg.rotateAngleY = 0.2F;
		this.FrontLeftLeg.rotateAngleY = 0.1F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(Head, RightMandible, LeftMandible, Body, BackLeftLeg, BackRightLeg, MiddleLeftLeg, MiddleRightLeg, BackLeftLeg, BackRightLeg);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}