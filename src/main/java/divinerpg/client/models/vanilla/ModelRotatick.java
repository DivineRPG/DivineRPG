package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.*;
//Made by Declan/WS97/SirDeccy
@OnlyIn(Dist.CLIENT)
public class ModelRotatick<T extends Entity> extends EntityModel<T> {
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
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 16.0F, -5.0F);
		Head.texOffs(38, 38).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 5.0F, 6.0F, 0.0F, false);
		Head.texOffs(0, 36).addBox(-6.0F, -5.0F, -7.0F, 12.0F, 4.0F, 7.0F, 0.0F, false);
		Head.texOffs(38, 25).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		RightMandible = new ModelRenderer(this);
		RightMandible.setPos(-5.5F, 2.5F, -5.0F);
		Head.addChild(RightMandible);
		RightMandible.texOffs(42, 7).addBox(-0.5F, -1.5F, -3.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		LeftMandible = new ModelRenderer(this);
		LeftMandible.setPos(6.0F, 2.0F, -5.0F);
		Head.addChild(LeftMandible);
		LeftMandible.texOffs(42, 0).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 16.0F, 2.0F);
		Body.texOffs(0, 0).addBox(-7.0F, -4.0F, -7.0F, 14.0F, 4.0F, 14.0F, 0.0F, false);
		Body.texOffs(0, 18).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 4.0F, 14.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setPos(5.5F, 4.0F, 4.5F);
		Body.addChild(BackLeftLeg);
		BackLeftLeg.texOffs(0, 25).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setPos(-5.5F, 4.0F, 4.5F);
		Body.addChild(BackRightLeg);
		BackRightLeg.texOffs(0, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		MiddleLeftLeg = new ModelRenderer(this);
		MiddleLeftLeg.setPos(5.5F, 4.0F, 0.5F);
		Body.addChild(MiddleLeftLeg);
		MiddleLeftLeg.texOffs(31, 36).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		MiddleRightLeg = new ModelRenderer(this);
		MiddleRightLeg.setPos(-5.5F, 4.0F, 0.5F);
		Body.addChild(MiddleRightLeg);
		MiddleRightLeg.texOffs(0, 7).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setPos(5.5F, 4.0F, -3.5F);
		Body.addChild(FrontLeftLeg);
		FrontLeftLeg.texOffs(38, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setPos(-5.5F, 4.0F, -3.5F);
		Body.addChild(FrontRightLeg);
		FrontRightLeg.texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float var1, float var2, float var3, float var4, float var5){
		this.Head.yRot = var4 / (180F / (float) Math.PI);
		this.Head.xRot = var5 / (180F / (float) Math.PI);

		this.BackLeftLeg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
		this.MiddleLeftLeg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
		this.FrontLeftLeg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
		this.BackRightLeg.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
		this.MiddleRightLeg.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
		this.FrontRightLeg.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;

		this.BackRightLeg.yRot = 0.3F;
		this.MiddleRightLeg.yRot = 0.2F;
		this.FrontRightLeg.yRot = 0.1F;
		this.BackLeftLeg.yRot = 0.3F;
		this.MiddleLeftLeg.yRot = 0.2F;
		this.FrontLeftLeg.yRot = 0.1F;
	}

	public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
