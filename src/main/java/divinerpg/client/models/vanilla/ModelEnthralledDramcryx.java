package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnthralledDramcryx<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("enthralled_dramcryx");
	private final ModelPart Head;
	private final ModelPart BackRightLeg;
	private final ModelPart FrontLeftLeg;
	private final ModelPart FrontRightLeg;
	private final ModelPart BackLeftLeg;
	private final ModelPart Body;

	public ModelEnthralledDramcryx(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.Body = root.getChild("Body");
		}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(4, 28).addBox(5.0F, -1.0F, -10.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-6.0F, -1.0F, -10.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-6.0F, -5.0F, -8.0F, 12.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 65).addBox(-5.0F, -2.0F, -10.0F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 28).addBox(1.0F, -7.8712F, -4.1983F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(66, 0).addBox(-5.0F, -7.907F, -4.1983F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, -7.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 46).addBox(-4.0F, -3.0F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 14.0F, 7.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(48, 50).addBox(-2.0F, -3.0F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 14.0F, -5.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(24, 50).addBox(-4.0F, -3.0F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 14.0F, -5.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -3.0F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 14.0F, 7.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 2.0F));

		Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -7.0F, -19.0F, 14.0F, 8.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 8.0F, -0.2618F, 0.0F, 0.0F));

		Body.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(62, 28).addBox(-4.0F, -8.0F, -2.5F, 8.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 11.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Spines = Body.addOrReplaceChild("Spines", CubeListBuilder.create().texOffs(40, 28).addBox(-1.0F, -17.0F, -6.5F, 5.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.0F, 0.5F));

		Spines.addOrReplaceChild("BackSpine_r1", CubeListBuilder.create().texOffs(66, 43).addBox(-1.0F, -18.0343F, -6.9435F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 7.0F, -3.5F, -1.0908F, 0.0F, 0.0F));

		Spines.addOrReplaceChild("MiddleSpine_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.01F, -22.5391F, -2.2898F, 5.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 7.0F, -3.5F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Head.xRot = headPitch / (180F / (float)Math.PI);

		this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}