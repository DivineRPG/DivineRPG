package divinerpg.client.models.vanilla;
// Made with Blockbench 4.0.4

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;

public class ModelAequorea<E extends EntityDivineWaterMob> extends EntityModel<EntityAequorea> {
	private final ModelRenderer tenticles;
	private final ModelRenderer bb_main;

	public ModelAequorea() {
		texWidth = 32;
		texHeight = 32;

		tenticles = new ModelRenderer(this);
		tenticles.setPos(0.0F, 24.0F, 0.0F);
		tenticles.texOffs(6, 18).addBox(2.0F, 0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F, false);
		tenticles.texOffs(4, 19).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, false);
		tenticles.texOffs(4, 0).addBox(-2.0F, 0.0F, -2.0F, 0.0F, 7.0F, 1.0F, 0.0F, false);
		tenticles.texOffs(2, 18).addBox(3.0F, 0.0F, -2.0F, 0.0F, 8.0F, 1.0F, 0.0F, false);
		tenticles.texOffs(0, 10).addBox(1.0F, 0.0F, 3.0F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		tenticles.texOffs(0, 19).addBox(-2.0F, 0.0F, 2.0F, 1.0F, 9.0F, 0.0F, 0.0F, false);
		tenticles.texOffs(6, 0).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 6.0F, 0.0F, 0.0F, false);
		tenticles.texOffs(2, 0).addBox(-3.0F, 0.0F, 1.0F, 0.0F, 7.0F, 1.0F, 0.0F, false);
		tenticles.texOffs(0, 0).addBox(1.0F, 0.0F, -3.0F, 0.0F, 7.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 10).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(EntityAequorea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		tenticles.xRot = -limbSwingAmount/2;
//		tenticles.yRot = limbSwingAmount;
		tenticles.zRot = -limbSwingAmount/2;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		tenticles.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}