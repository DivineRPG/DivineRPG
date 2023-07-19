package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSkyre<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("skyre");
	private final ModelPart Skull;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Body;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;

	public ModelSkyre(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Skull = root.getChild("Skull");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.Body = root.getChild("Body");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Skull = partdefinition.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(30, 6).addBox(-3.0F, -6.0F, -6.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -4.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(36, 34).addBox(0.0F, -2.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 28).addBox(1.0F, 1.0F, -8.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(48, 28).addBox(1.01F, 1.0F, -8.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 12.0F, -1.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(10, 35).addBox(-2.0F, -2.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-1.0F, 1.0F, -8.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 47).addBox(-1.01F, 1.0F, -8.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 12.0F, -1.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -6.0F, -4.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 23).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(32, 15).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 19.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(42, 15).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 19.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Skull.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Skull.xRot = headPitch / (180F / (float)Math.PI);
		this.RightArm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
		this.LeftArm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
		this.RightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.LeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}