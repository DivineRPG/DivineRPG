package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDramcryx<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("dramcryx");
	private final ModelPart Body, Leg1, Leg2, Leg3, Leg4, Tail, head;

	public ModelDramcryx(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Body = root.getChild("Body");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.Tail = root.getChild("Tail");
		this.head = root.getChild("head");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(21, 0).mirror().addBox(-5.0F, -3.0F, -7.0F, 8.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, 0.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 14.0F, 2.0F));

		Body.addOrReplaceChild("Shape3_r1", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(-2.0F, -25.0F, -3.7667F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, -2.0F, 0.0436F, 0.0F, 0.0F));

		Body.addOrReplaceChild("Shape1_r1", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(-2.0F, -18.8F, -5.8F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, -1.0F, -0.7679F, 0.0F, 0.0F));

		Body.addOrReplaceChild("Shape2_r1", CubeListBuilder.create().texOffs(52, 15).mirror().addBox(-1.0F, 1.6651F, -3.1489F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -1.0F, -3.0F, 2.7053F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, 16.0F, 7.0F));

		partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 16.0F, 7.0F));

		partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.2F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 16.0F, -4.0F));

		partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.1F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 16.0F, -4.0F));

		partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(22, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 14.0F, 7.0F, 1.1301F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(3.0F, -5.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 14).mirror().addBox(-3.0F, -5.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.9F, -7.0F, 0.3491F, 0.0F, 0.0F));

		head.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-4.0F, -10.7F, -17.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-6.0F, -13.7F, -13.0F, 10.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 14.1F, 7.0F, -0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Leg1.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.Leg2.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.Leg3.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.Leg4.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}