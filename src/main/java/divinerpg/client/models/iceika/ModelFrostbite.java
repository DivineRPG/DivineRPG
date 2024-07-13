package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFrostbite extends EntityModel<EntityDivineMonster> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("frostbite");
	private final ModelPart Spine;

	public ModelFrostbite(ModelPart root) {
		this.Spine = root.getChild("Spine");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition Head = Spine.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 25).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 36).addBox(-1.5F, -2.0F, -7.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -7.0F));

		Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(8, 3).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, -2.0F));

		Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, -2.0F));

		PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(24, 9).addBox(0.0F, -7.0F, -7.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -7.0F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(8, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 3.0F, -5.0F));

		Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(30, 35).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 3.0F, 5.0F));

		Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, 5.0F));

		Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, -5.0F));

		Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityDivineMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}