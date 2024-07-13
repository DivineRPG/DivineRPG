package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.boss.EntityAyeraco;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAyeraco extends EntityModel<EntityAyeraco> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("ayeraco");
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart WingLB;
	private final ModelPart Tail2;
	private final ModelPart Tail3;
	private final ModelPart WingRB;
	private final ModelPart WingRF;
	private final ModelPart WingLF;
	private final ModelPart WingRM;
	private final ModelPart WingLM;
	private final ModelPart Head2;
	private final ModelPart Body;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape5;
	private final ModelPart Shape7;
	private final ModelPart Shape9;
	private final ModelPart Shape11;
	private final ModelPart Shape13;

	public ModelAyeraco(Context context) {
		this(context.bakeLayer(LAYER_LOCATION));
	}

	public ModelAyeraco(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Tail = root.getChild("Tail");
		this.WingLB = root.getChild("WingLB");
		this.Tail2 = root.getChild("Tail2");
		this.Tail3 = root.getChild("Tail3");
		this.WingRB = root.getChild("WingRB");
		this.WingRF = root.getChild("WingRF");
		this.WingLF = root.getChild("WingLF");
		this.WingRM = root.getChild("WingRM");
		this.WingLM = root.getChild("WingLM");
		this.Head2 = root.getChild("Head2");
		this.Body = root.getChild("Body");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape5 = root.getChild("Shape5");
		this.Shape7 = root.getChild("Shape7");
		this.Shape9 = root.getChild("Shape9");
		this.Shape11 = root.getChild("Shape11");
		this.Shape13 = root.getChild("Shape13");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, -1.0F, 0.0F, 6.0F, 6.0F, 7.0F, cubedef).mirror(false), PartPose.offset(3.0F, 12.0F, -17.0F));

		Head.addOrReplaceChild("Mouth1_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-3.0F, 0.0F, -7.0F, 6.0F, 1.0F, 7.0F, cubedef).mirror(false), PartPose.offsetAndRotation(3.0F, 5.0F, 7.0F, 0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 10.0F, cubedef).mirror(false), PartPose.offset(3.0F, 14.0F, 14.0F));

		partdefinition.addOrReplaceChild("WingLB", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(0.0F, 0.0F, 2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(28, 27).mirror().addBox(8.0F, 0.0F, 3.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(5.0F, 13.0F, 1.0F));

		partdefinition.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 10.0F, cubedef).mirror(false), PartPose.offset(0.0F, 14.0F, 14.0F));

		partdefinition.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 10.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 14.0F, 14.0F));

		partdefinition.addOrReplaceChild("WingRB", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(-7.0F, 0.0F, 2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(28, 27).mirror().addBox(-15.0F, 0.0F, 3.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 13.0F, 1.0F));

		partdefinition.addOrReplaceChild("WingRF", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(-7.0F, 0.0F, -2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(28, 27).mirror().addBox(-15.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("WingLF", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(0.0F, 0.0F, -2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(28, 27).mirror().addBox(8.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(5.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("WingRM", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(-7.0F, 0.0F, 2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(28, 27).mirror().addBox(-15.0F, 0.0F, 3.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("WingLM", CubeListBuilder.create().texOffs(28, 27).mirror().addBox(0.0F, 0.0F, 2.0F, 8.0F, 1.0F, 4.0F, cubedef).mirror(false)
		.texOffs(28, 27).mirror().addBox(8.0F, 0.0F, 3.0F, 8.0F, 1.0F, 2.0F, cubedef).mirror(false), PartPose.offset(5.0F, 13.0F, -3.0F));

		PartDefinition Head2 = partdefinition.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, -1.0F, 0.0F, 6.0F, 6.0F, 7.0F, cubedef).mirror(false), PartPose.offset(-9.0F, 12.0F, -17.0F));

		Head2.addOrReplaceChild("Mouth2_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-3.0F, 0.0F, -7.0F, 6.0F, 1.0F, 7.0F, cubedef).mirror(false), PartPose.offsetAndRotation(3.0F, 5.0F, 7.0F, 0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.0F, 0.0F, 10.0F, 6.0F, 16.0F, cubedef).mirror(false)
		.texOffs(0, 0).mirror().addBox(0.0F, 5.0F, 2.0F, 10.0F, 1.0F, 12.0F, cubedef).mirror(false)
		.texOffs(13, 16).mirror().addBox(-1.0F, 0.0F, -2.0F, 12.0F, 4.0F, 2.0F, cubedef).mirror(false)
		.texOffs(10, 12).mirror().addBox(0.0F, 0.0F, 16.0F, 10.0F, 4.0F, 6.0F, cubedef).mirror(false), PartPose.offset(-5.0F, 12.0F, -8.0F));

		PartDefinition Shape2 = partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 13.0F, 10.0F, 0.7808F, 0.0F, 0.0F));

		Shape2.addOrReplaceChild("Shape1_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -7.0F, 5.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 4.0F, -1.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Shape3 = partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(46, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 12.0F, -16.0F, 0.7808F, 0.0F, 0.0F));

		Shape3.addOrReplaceChild("Shape4_r1", CubeListBuilder.create().texOffs(46, 20).mirror().addBox(5.0F, -5.0F, -1.0F, 2.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 4.0F, 5.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Shape5 = partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, -2.0F, 0.7808F, 0.0F, 0.0F));

		Shape5.addOrReplaceChild("Shape6_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -5.0F, 2.5F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 3.0F, 2.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Shape7 = partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 12.0F, 3.0F, 0.7808F, 0.0F, 0.0F));

		Shape7.addOrReplaceChild("Shape8_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -15.3F, 4.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, -3.0F, -0.3054F, 0.0F, 0.0F));

		Shape7.addOrReplaceChild("Shape7_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -13.0F, 3.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, -3.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Shape9 = partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 7.0F, 0.7808F, 0.0F, 0.0F));

		Shape9.addOrReplaceChild("Shape10_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -9.3F, 6.4F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 6.0F, -3.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Shape11 = partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, -7.0F, 0.7808F, 0.0F, 0.0F));

		Shape11.addOrReplaceChild("Shape12_r1", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.0F, -7.0F, -1.0F, 4.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 6.0F, 5.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Shape13 = partdefinition.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(46, 20).mirror().addBox(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-7.0F, 12.0F, -16.0F, 0.7808F, 0.0F, 0.0F));

		Shape13.addOrReplaceChild("Shape14_r1", CubeListBuilder.create().texOffs(46, 20).mirror().addBox(-7.0F, -8.2F, -14.1F, 2.0F, 1.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(7.0F, 12.0F, 16.0F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityAyeraco entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.WingRF.zRot = this.WingRM.zRot = this.WingRB.zRot = (float) (Math.cos(ageInTicks * 0.1F) * Math.PI * 0.15F);

        this.WingLF.zRot = -this.WingRF.zRot;
        this.WingLM.zRot = -this.WingRF.zRot;
        this.WingLB.zRot = -this.WingRF.zRot;

        this.Tail.xRot = Tail3.xRot = (float) (-Math.cos(ageInTicks * 0.1F) * Math.PI * 0.15F);
        this.Tail2.xRot = (float) (Math.sin(ageInTicks * 0.1F) * Math.PI * 0.15F);
        
        this.Shape2.yRot = (float) (Math.cos(ageInTicks * 0.1F) * Math.PI * 0.05F);
        this.Shape5.yRot = this.Shape2.yRot;
        this.Shape7.yRot = this.Shape2.yRot;
        this.Shape9.yRot = this.Shape2.yRot;
        this.Shape11.yRot = this.Shape2.yRot;
        this.Shape3.yRot = this.Head.yRot + this.Shape2.yRot;
        this.Shape3.xRot = this.Head.xRot;
        this.Shape13.xRot = this.Head.xRot;
        this.Shape13.yRot = this.Head.yRot + this.Shape2.yRot;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		Head.render(poseStack, buffer, packedLight, packedOverlay, color);
		Tail.render(poseStack, buffer, packedLight, packedOverlay, color);
		WingLB.render(poseStack, buffer, packedLight, packedOverlay, color);
		Tail2.render(poseStack, buffer, packedLight, packedOverlay, color);
		Tail3.render(poseStack, buffer, packedLight, packedOverlay, color);
		WingRB.render(poseStack, buffer, packedLight, packedOverlay, color);
		WingRF.render(poseStack, buffer, packedLight, packedOverlay, color);
		WingLF.render(poseStack, buffer, packedLight, packedOverlay, color);
		WingRM.render(poseStack, buffer, packedLight, packedOverlay, color);
		WingLM.render(poseStack, buffer, packedLight, packedOverlay, color);
		Head2.render(poseStack, buffer, packedLight, packedOverlay, color);
		Body.render(poseStack, buffer, packedLight, packedOverlay, color);
		Shape2.render(poseStack, buffer, packedLight, packedOverlay, color);
		Shape3.render(poseStack, buffer, packedLight, packedOverlay, color);
		Shape5.render(poseStack, buffer, packedLight, packedOverlay, color);
		Shape7.render(poseStack, buffer, packedLight, packedOverlay, color);
		Shape9.render(poseStack, buffer, packedLight, packedOverlay, color);
		Shape11.render(poseStack, buffer, packedLight, packedOverlay, color);
		Shape13.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}