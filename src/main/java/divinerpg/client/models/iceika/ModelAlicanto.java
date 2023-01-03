package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAlicanto<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("alicanto");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart spikebottom1;
	private final ModelPart spike2;
	private final ModelPart spike3;
	private final ModelPart spike4;
	private final ModelPart spike5;
	private final ModelPart spikebottom2;
	private final ModelPart headext1;
	private final ModelPart tail;
	private final ModelPart horngate1;
	private final ModelPart hornbottom1;
	private final ModelPart hornend;
	private final ModelPart horngate2;
	private final ModelPart horn;
	private final ModelPart hornbottom2;
	private final ModelPart hornbtm1;
	private final ModelPart hornbtm2;
	private final ModelPart headjoint;
	private final ModelPart headcap1;
	private final ModelPart headext2;
	private final ModelPart headcap2;
	private final ModelPart spikebottom3;
	private final ModelPart spike15;
	private final ModelPart spike14;
	private final ModelPart spike1;
	private final ModelPart spike6;
	private final ModelPart spike7;
	private final ModelPart wing1;
	private final ModelPart wing1slide1;
	private final ModelPart wing2;
	private final ModelPart wing1slide2;
	private final ModelPart wing1slide3;
	private final ModelPart wing2slide2;
	private final ModelPart wing2slide1;
	private final ModelPart wing2slide3;

	public ModelAlicanto(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.spikebottom1 = root.getChild("spikebottom1");
		this.spike2 = root.getChild("spike2");
		this.spike3 = root.getChild("spike3");
		this.spike4 = root.getChild("spike4");
		this.spike5 = root.getChild("spike5");
		this.spikebottom2 = root.getChild("spikebottom2");
		this.headext1 = root.getChild("headext1");
		this.tail = root.getChild("tail");
		this.horngate1 = root.getChild("horngate1");
		this.hornbottom1 = root.getChild("hornbottom1");
		this.hornend = root.getChild("hornend");
		this.horngate2 = root.getChild("horngate2");
		this.horn = root.getChild("horn");
		this.hornbottom2 = root.getChild("hornbottom2");
		this.hornbtm1 = root.getChild("hornbtm1");
		this.hornbtm2 = root.getChild("hornbtm2");
		this.headjoint = root.getChild("headjoint");
		this.headcap1 = root.getChild("headcap1");
		this.headext2 = root.getChild("headext2");
		this.headcap2 = root.getChild("headcap2");
		this.spikebottom3 = root.getChild("spikebottom3");
		this.spike15 = root.getChild("spike15");
		this.spike14 = root.getChild("spike14");
		this.spike1 = root.getChild("spike1");
		this.spike6 = root.getChild("spike6");
		this.spike7 = root.getChild("spike7");
		this.wing1 = root.getChild("wing1");
		this.wing1slide1 = root.getChild("wing1slide1");
		this.wing2 = root.getChild("wing2");
		this.wing1slide2 = root.getChild("wing1slide2");
		this.wing1slide3 = root.getChild("wing1slide3");
		this.wing2slide2 = root.getChild("wing2slide2");
		this.wing2slide1 = root.getChild("wing2slide1");
		this.wing2slide3 = root.getChild("wing2slide3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, -10.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 22.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 0.8644F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spikebottom1", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 7.0F, 13.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -4.0F, 0.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike3", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -1.0F, 5.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike4", CubeListBuilder.create().texOffs(40, 15).mirror().addBox(0.0F, -3.0F, 0.0F, 2.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -4.0F, 0.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike5", CubeListBuilder.create().texOffs(40, 15).mirror().addBox(0.0F, -3.0F, 0.0F, 2.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -1.0F, 5.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spikebottom2", CubeListBuilder.create().texOffs(40, 15).mirror().addBox(0.0F, -3.0F, 0.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 13.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("headext1", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 4.0F, -10.0F));

		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 18.0F, 8.0F));

		partdefinition.addOrReplaceChild("horngate1", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -6.0F, -15.0F));

		partdefinition.addOrReplaceChild("hornbottom1", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(-15.0F, 0.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 11.0F, -21.0F, 0.6109F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("hornend", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -6.0F, -24.0F));

		partdefinition.addOrReplaceChild("horngate2", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -6.0F, -18.0F));

		partdefinition.addOrReplaceChild("horn", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -5.0F, -23.0F));

		partdefinition.addOrReplaceChild("hornbottom2", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(-1.0F, 0.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 11.0F, -21.0F, 0.6109F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("hornbtm1", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(-14.0F, 0.0F, 2.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 12.0F, -21.0F, 0.6109F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("hornbtm2", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, 2.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 12.0F, -21.0F, 0.6109F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("headjoint", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -1.0F, -13.0F));

		partdefinition.addOrReplaceChild("headcap1", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(3.0F, 0.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, 3.0F, -11.0F));

		partdefinition.addOrReplaceChild("headext2", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 4.0F, -10.0F));

		partdefinition.addOrReplaceChild("headcap2", CubeListBuilder.create().texOffs(23, 14).mirror().addBox(3.0F, 0.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 3.0F, -11.0F));

		partdefinition.addOrReplaceChild("spikebottom3", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 7.0F, 13.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike15", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -1.0F, 5.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike14", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -4.0F, 0.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike1", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 4.0F, 10.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike6", CubeListBuilder.create().texOffs(40, 15).mirror().addBox(0.0F, -3.0F, 0.0F, 2.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, 10.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike7", CubeListBuilder.create().texOffs(13, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 4.0F, 10.0F, -0.2603F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, 0.0F, -5.0F, 20.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, 12.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing1slide1", CubeListBuilder.create().texOffs(26, 4).mirror().addBox(-12.0F, -1.0F, -6.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 12.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -5.0F, 20.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 12.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing1slide2", CubeListBuilder.create().texOffs(26, 4).mirror().addBox(-22.0F, -1.0F, -6.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 12.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing1slide3", CubeListBuilder.create().texOffs(26, 4).mirror().addBox(-2.0F, -1.0F, -6.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 12.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing2slide2", CubeListBuilder.create().texOffs(26, 4).mirror().addBox(10.0F, -1.0F, -6.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 12.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing2slide1", CubeListBuilder.create().texOffs(26, 4).mirror().addBox(0.0F, -1.0F, -6.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 12.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing2slide3", CubeListBuilder.create().texOffs(26, 4).mirror().addBox(20.0F, -1.0F, -6.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 12.0F, 0.0F, -0.733F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = ((float)(entity.getId() * 3) + ageInTicks) * 0.13F;

		wing1.zRot = Mth.cos(f) * 16.0F * ((float)Math.PI / 180F);
		wing1slide1.zRot = Mth.cos(f) * 16.0F * ((float)Math.PI / 180F);
		wing1slide2.zRot = Mth.cos(f) * 16.0F * ((float)Math.PI / 180F);
		wing1slide3.zRot = Mth.cos(f) * 16.0F * ((float)Math.PI / 180F);

		wing2.zRot = -wing1.zRot;
		wing2slide1.zRot = -wing1.zRot;
		wing2slide2.zRot = -wing1.zRot;
		wing2slide3.zRot = -wing1.zRot;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spikebottom1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spikebottom2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headext1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horngate1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornbottom1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornend.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horngate2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornbottom2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornbtm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hornbtm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headjoint.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headcap1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headext2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headcap2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spikebottom3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spike7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing1slide1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing1slide2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing1slide3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing2slide2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing2slide1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing2slide3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}