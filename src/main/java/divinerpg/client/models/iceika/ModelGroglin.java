package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGroglin<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("groglin");
	private final ModelPart Goblin;

	public ModelGroglin(ModelPart root) {
		this.Goblin = root.getChild("Goblin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Goblin = partdefinition.addOrReplaceChild("Goblin", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition Head = Goblin.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 34).addBox(4.0F, -9.0F, 0.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 24).addBox(-5.0F, -9.0F, 0.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -2.0F));

		PartDefinition Spine = Goblin.addOrReplaceChild("Spine", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, -5.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition LeftLeg = Spine.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 42).addBox(-2.0F, 3.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 7.0F, 0.0F));

		PartDefinition RightLeg = Spine.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 42).addBox(-2.0F, 3.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 7.0F, 0.0F));

		PartDefinition RightArm = Spine.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(24, 14).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 16).addBox(-1.5F, 5.0F, -2.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = Spine.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(48, 0).addBox(-1.5F, 5.0F, -2.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 29).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Goblin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}