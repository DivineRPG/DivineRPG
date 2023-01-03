package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSeimer<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("seimer");
	private final ModelPart body;
	private final ModelPart headtop;
	private final ModelPart headbottom;
	private final ModelPart headright;
	private final ModelPart headleft;
	private final ModelPart hornright;
	private final ModelPart hornright2;
	private final ModelPart sensorright2;
	private final ModelPart sensorleft;
	private final ModelPart wingright;
	private final ModelPart wingleft;
	private final ModelPart wingleft1;
	private final ModelPart wingright2;
	private final ModelPart hornleft;
	private final ModelPart sensorright;
	private final ModelPart hornleft2;
	private final ModelPart sensorleft2;

	public ModelSeimer(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.headtop = root.getChild("headtop");
		this.headbottom = root.getChild("headbottom");
		this.headright = root.getChild("headright");
		this.headleft = root.getChild("headleft");
		this.hornright = root.getChild("hornright");
		this.hornright2 = root.getChild("hornright2");
		this.sensorright2 = root.getChild("sensorright2");
		this.sensorleft = root.getChild("sensorleft");
		this.wingright = root.getChild("wingright");
		this.wingleft = root.getChild("wingleft");
		this.wingleft1 = root.getChild("wingleft1");
		this.wingright2 = root.getChild("wingright2");
		this.hornleft = root.getChild("hornleft");
		this.sensorright = root.getChild("sensorright");
		this.hornleft2 = root.getChild("hornleft2");
		this.sensorleft2 = root.getChild("sensorleft2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 10.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("headtop", CubeListBuilder.create().texOffs(15, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 10.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("headbottom", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 16.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("headright", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 12.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("headleft", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(0.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("hornright", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("hornright2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("sensorright2", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 4.0F, -9.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("sensorleft", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 4.0F, -9.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("wingright", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 16.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("wingleft", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, 16.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("wingleft1", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, 12.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("wingright2", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 12.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("hornleft", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("sensorright", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 4.0F, -9.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("hornleft2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("sensorleft2", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, -9.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headtop.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headbottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornright2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		sensorright2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		sensorleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wingright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wingleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wingleft1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wingright2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		sensorright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornleft2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		sensorleft2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}