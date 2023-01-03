package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Mob;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelWatcher extends EntityModel<Mob> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("watcher");
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Tentacle11;
	private final ModelPart Tentacle12;
	private final ModelPart Tentacle21;
	private final ModelPart Tentacle22;
	private final ModelPart Tentacle31;
	private final ModelPart Tentacle32;

	public ModelWatcher(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Jaw = root.getChild("Jaw");
		this.Tentacle11 = root.getChild("Tentacle11");
		this.Tentacle12 = root.getChild("Tentacle12");
		this.Tentacle21 = root.getChild("Tentacle21");
		this.Tentacle22 = root.getChild("Tentacle22");
		this.Tentacle31 = root.getChild("Tentacle31");
		this.Tentacle32 = root.getChild("Tentacle32");
	}

	public ModelWatcher(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Jaw = root.getChild("Jaw");
		this.Tentacle11 = root.getChild("Tentacle11");
		this.Tentacle12 = root.getChild("Tentacle12");
		this.Tentacle21 = root.getChild("Tentacle21");
		this.Tentacle22 = root.getChild("Tentacle22");
		this.Tentacle31 = root.getChild("Tentacle31");
		this.Tentacle32 = root.getChild("Tentacle32");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

		Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -13.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Jaw = partdefinition.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 5.0F));

		Jaw.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-5.0F, -3.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -5.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Tentacle11 = partdefinition.addOrReplaceChild("Tentacle11", CubeListBuilder.create(), PartPose.offset(5.0F, 16.0F, 0.0F));

		Tentacle11.addOrReplaceChild("Tentacle11_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(8.0F, -9.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 8.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Tentacle12 = partdefinition.addOrReplaceChild("Tentacle12", CubeListBuilder.create(), PartPose.offset(9.0F, 16.0F, 0.0F));

		Tentacle12.addOrReplaceChild("Tentacle12_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(5.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 8.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Tentacle21 = partdefinition.addOrReplaceChild("Tentacle21", CubeListBuilder.create(), PartPose.offset(-5.0F, 16.0F, 0.0F));

		Tentacle21.addOrReplaceChild("Tentacle21_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-10.0F, -9.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 8.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Tentacle22 = partdefinition.addOrReplaceChild("Tentacle22", CubeListBuilder.create(), PartPose.offset(-9.0F, 16.0F, 0.0F));

		Tentacle22.addOrReplaceChild("Tentacle22_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-10.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 8.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Tentacle31 = partdefinition.addOrReplaceChild("Tentacle31", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		Tentacle31.addOrReplaceChild("Tentacle31_r1", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -16.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Tentacle32 = partdefinition.addOrReplaceChild("Tentacle32", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));

		Tentacle32.addOrReplaceChild("Tentacle32_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -18.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Mob entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Jaw.xRot = (float) (Math.cos(ageInTicks * 0.3F) * Math.PI * 0.05F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle31.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle32.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}