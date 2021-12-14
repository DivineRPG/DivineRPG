package divinerpg.client.models.twilight;// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelCadillion extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Horn_r1;
	private final ModelRenderer Mouth;
	private final ModelRenderer Body;
	private final ModelRenderer FrontRightLeg;
	private final ModelRenderer FrontLeftLeg;
	private final ModelRenderer BackRightLeg;
	private final ModelRenderer BackLeftLeg;
	private final ModelRenderer bb_main;
	private final ModelRenderer RightEar_r1;
	private final ModelRenderer LeftEar_r1;

	public ModelCadillion() {
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 24.0F, 0.0F);
		Head.texOffs(33, 33).addBox(-4.0F, -24.0F, -14.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);
		Head.texOffs(54, 12).addBox(-3.0F, -21.0F, -17.0F, 6.0F, 4.0F, 3.0F, 0.0F, false);

		Horn_r1 = new ModelRenderer(this);
		Horn_r1.setPos(0.0F, -21.9528F, -12.7743F);
		Head.addChild(Horn_r1);
		setRotationAngle(Horn_r1, 0.3927F, 0.0F, 0.0F);
		Horn_r1.texOffs(14, 56).addBox(-1.0F, -7.5F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		Mouth = new ModelRenderer(this);
		Mouth.setPos(0.0F, -16.5F, -15.5F);
		Head.addChild(Mouth);
		Mouth.texOffs(0, 15).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 9.5F, 0.75F);
		Body.texOffs(0, 31).addBox(-4.0F, -4.5F, -8.75F, 8.0F, 8.0F, 17.0F, 0.0F, false);
		Body.texOffs(0, 0).addBox(-5.5F, -5.5F, -9.25F, 11.0F, 12.0F, 19.0F, 0.0F, false);

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setPos(-3.0F, 13.0F, -6.0F);
		FrontRightLeg.texOffs(50, 50).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setPos(3.0F, 13.0F, -6.0F);
		FrontLeftLeg.texOffs(41, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setPos(-3.0F, 13.0F, 8.0F);
		BackRightLeg.texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setPos(3.0F, 13.0F, 8.0F);
		BackLeftLeg.texOffs(0, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);


		RightEar_r1 = new ModelRenderer(this);
		RightEar_r1.setPos(-8.0F, -21.0F, -10.0F);
		bb_main.addChild(RightEar_r1);
		setRotationAngle(RightEar_r1, 0.0F, 0.0F, -0.1309F);
		RightEar_r1.texOffs(55, 31).addBox(0.0F, -6.47F, 1.0F, 6.0F, 7.0F, 0.0F, 0.0F, false);

		LeftEar_r1 = new ModelRenderer(this);
		LeftEar_r1.setPos(3.0F, -21.0F, -10.0F);
		bb_main.addChild(LeftEar_r1);
		setRotationAngle(LeftEar_r1, 0.0F, 0.0F, 0.1309F);
		LeftEar_r1.texOffs(1, 56).addBox(-1.0F, -7.0F, 1.0F, 6.0F, 7.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity p_225597_1_, float var1, float var2, float var3, float var4, float var5) {
		this.Head.yRot = (var4 / 57.295776F);
		this.RightEar_r1.yRot = (var4 / 57.295776F);
		this.LeftEar_r1.yRot = (var4 / 57.295776F);
		this.Horn_r1.yRot = (var4 / 57.295776F);
		this.FrontLeftLeg.xRot = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2);
		this.FrontRightLeg.xRot = (MathHelper.cos(var1 * 0.6662F + 3.141593F) * 1.4F * var2);
		this.BackLeftLeg.xRot = (MathHelper.cos(var1 * 0.6662F + 3.141593F) * 1.4F * var2);
		this.BackRightLeg.xRot = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		FrontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		FrontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		BackRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		BackLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

}