package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGruzzorlug<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("gruzzorlug");
	public final ModelPart Body, RightFoot, LeftFoot, RightArm, LeftArm, Head;

	public ModelGruzzorlug(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Body = root.getChild("Body");
		this.RightFoot = root.getChild("RightFoot");
		this.LeftFoot = root.getChild("LeftFoot");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(19, 19).addBox(-5.0F, -10.0F, -3.0F, 10.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -0.5F));

		PartDefinition RightFoot = partdefinition.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(47, 47).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 17.0F, -1.5F));

		PartDefinition LeftFoot = partdefinition.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(43, 8).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 17.0F, -1.5F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(36, 35).addBox(-3.5F, -1.0F, -2.5F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 7.0F, -0.5F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(8, 42).addBox(0.5F, -1.0F, -2.5F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 7.0F, -0.5F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.8125F, -3.1563F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(20, 0).addBox(-1.0F, -3.8125F, -4.1563F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -1.8125F, -5.1563F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -12.8125F, -3.1563F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.1875F, -0.8438F));

		PartDefinition Belly = Body.addOrReplaceChild("Belly", CubeListBuilder.create().texOffs(8, 35).addBox(-5.5F, 7.1875F, -4.1563F, 11.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.5125F, -1.7563F));

		PartDefinition Eyebrow = Head.addOrReplaceChild("Eyebrow", CubeListBuilder.create().texOffs(42, 0).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.8125F, -4.1563F));

		PartDefinition Moustache = Head.addOrReplaceChild("Moustache", CubeListBuilder.create().texOffs(78, 0).addBox(-5.0F, -2.5F, -1.25F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1875F, -4.1563F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.LeftFoot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.RightFoot.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}