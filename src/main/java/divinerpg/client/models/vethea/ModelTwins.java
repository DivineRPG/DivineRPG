package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.vethea.EntityTwins;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelTwins extends EntityModel<EntityTwins> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("twins");
	private final ModelPart rightlegt;
	private final ModelPart leftlegt;
	private final ModelPart rotated1;
	private final ModelPart rotated2;
	private final ModelPart rotated3;
	private final ModelPart rotated4;
	private final ModelPart rotated5;
	private final ModelPart rotated6;
	private final ModelPart rotated7;
	private final ModelPart rotated8;
	private final ModelPart rotated9;
	private final ModelPart rotated10;
	private final ModelPart rotated11;
	private final ModelPart rotated12;
	private final ModelPart rotated13;
	private final ModelPart rotated14;
	private final ModelPart rotated15;
	private final ModelPart rotated16;
	private final ModelPart rotated17;
	private final ModelPart rotated18;
	private final ModelPart righttoe1;
	private final ModelPart lefttoe1;
	private final ModelPart leftleg;
	private final ModelPart rightleg;
	private final ModelPart lefttoe2;
	private final ModelPart righttoe2;
	private final ModelPart rotated19;
	private final ModelPart rotated20;
	private final ModelPart rotated21;
	private final ModelPart rotated22;
	private final ModelPart rotated23;
	private final ModelPart rotated24;
	private final ModelPart rotated25;
	private final ModelPart rotated26;
	private final ModelPart rotated27;
	private final ModelPart rotated28;
	private final ModelPart rotated29;
	private final ModelPart rotated30;
	private final ModelPart rotated31;
	private final ModelPart rotated32;
	private final ModelPart rotated33;
	private final ModelPart rotated34;
	private final ModelPart rotated35;
	private final ModelPart rotated36;

	public ModelTwins(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.rightlegt = root.getChild("rightlegt");
		this.leftlegt = root.getChild("leftlegt");
		this.rotated1 = root.getChild("rotated1");
		this.rotated2 = root.getChild("rotated2");
		this.rotated3 = root.getChild("rotated3");
		this.rotated4 = root.getChild("rotated4");
		this.rotated5 = root.getChild("rotated5");
		this.rotated6 = root.getChild("rotated6");
		this.rotated7 = root.getChild("rotated7");
		this.rotated8 = root.getChild("rotated8");
		this.rotated9 = root.getChild("rotated9");
		this.rotated10 = root.getChild("rotated10");
		this.rotated11 = root.getChild("rotated11");
		this.rotated12 = root.getChild("rotated12");
		this.rotated13 = root.getChild("rotated13");
		this.rotated14 = root.getChild("rotated14");
		this.rotated15 = root.getChild("rotated15");
		this.rotated16 = root.getChild("rotated16");
		this.rotated17 = root.getChild("rotated17");
		this.rotated18 = root.getChild("rotated18");
		this.righttoe1 = root.getChild("righttoe1");
		this.lefttoe1 = root.getChild("lefttoe1");
		this.leftleg = root.getChild("leftleg");
		this.rightleg = root.getChild("rightleg");
		this.lefttoe2 = root.getChild("lefttoe2");
		this.righttoe2 = root.getChild("righttoe2");
		this.rotated19 = root.getChild("rotated19");
		this.rotated20 = root.getChild("rotated20");
		this.rotated21 = root.getChild("rotated21");
		this.rotated22 = root.getChild("rotated22");
		this.rotated23 = root.getChild("rotated23");
		this.rotated24 = root.getChild("rotated24");
		this.rotated25 = root.getChild("rotated25");
		this.rotated26 = root.getChild("rotated26");
		this.rotated27 = root.getChild("rotated27");
		this.rotated28 = root.getChild("rotated28");
		this.rotated29 = root.getChild("rotated29");
		this.rotated30 = root.getChild("rotated30");
		this.rotated31 = root.getChild("rotated31");
		this.rotated32 = root.getChild("rotated32");
		this.rotated33 = root.getChild("rotated33");
		this.rotated34 = root.getChild("rotated34");
		this.rotated35 = root.getChild("rotated35");
		this.rotated36 = root.getChild("rotated36");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("rightlegt", CubeListBuilder.create().texOffs(101, 16).mirror().addBox(-4.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegt", CubeListBuilder.create().texOffs(101, 16).mirror().addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated1", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(4.0F, -16.0F, -12.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, -0.1745F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated2", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(-8.0F, -15.0F, -12.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated3", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-3.0F, -18.0F, -6.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated4", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-6.0F, -15.0F, -9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 12.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated5", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(2.0F, -16.0F, -9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated6", CubeListBuilder.create().texOffs(56, 1).mirror().addBox(-4.0F, -10.0F, -7.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -25.0F, -9.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -25.0F, -10.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated9", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(4.0F, -16.0F, -13.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated10", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-6.0F, -15.0F, -10.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 13.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated11", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(2.0F, -16.0F, -10.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 14.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated12", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(5.0F, -7.0F, -19.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, -0.1745F, 3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated13", CubeListBuilder.create().texOffs(59, 26).mirror().addBox(-18.0F, -9.0F, -3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated14", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -4.0F, 0.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated15", CubeListBuilder.create().texOffs(82, 16).mirror().addBox(-8.0F, -15.0F, -13.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated16", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-3.0F, -18.0F, -7.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated17", CubeListBuilder.create().texOffs(56, 1).mirror().addBox(-4.0F, -10.0F, -8.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated18", CubeListBuilder.create().texOffs(86, 2).mirror().addBox(-5.0F, -4.0F, -8.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("righttoe1", CubeListBuilder.create().texOffs(19, 17).mirror().addBox(1.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("lefttoe1", CubeListBuilder.create().texOffs(19, 17).mirror().addBox(2.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("lefttoe2", CubeListBuilder.create().texOffs(19, 17).mirror().addBox(-4.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("righttoe2", CubeListBuilder.create().texOffs(19, 17).mirror().addBox(-5.0F, 9.0F, -10.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated19", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(-7.0F, -6.0F, -19.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, 3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("rotated20", CubeListBuilder.create().texOffs(59, 26).mirror().addBox(-18.0F, -9.0F, 1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated21", CubeListBuilder.create().texOffs(58, 24).mirror().addBox(-19.0F, -9.0F, -7.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated22", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-22.0F, -11.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated23", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(5.0F, -7.0F, -21.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated24", CubeListBuilder.create().texOffs(55, 22).mirror().addBox(-7.0F, -6.0F, -21.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rotated25", CubeListBuilder.create().texOffs(58, 24).mirror().addBox(-19.0F, -9.0F, -1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated26", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-22.0F, -11.0F, 1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated27", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-23.0F, -11.0F, -7.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated28", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-23.0F, -11.0F, 2.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated29", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-22.0F, -13.0F, 1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated30", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-22.0F, -13.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated31", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-23.0F, -7.0F, -7.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated32", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-23.0F, -7.0F, 2.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated33", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-22.0F, -7.0F, 1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated34", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-22.0F, -7.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated35", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-22.0F, -5.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rotated36", CubeListBuilder.create().texOffs(61, 28).mirror().addBox(-22.0F, -5.0F, 1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(EntityTwins entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftlegt.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.lefttoe1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.lefttoe2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.righttoe1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.righttoe2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		
		if(entity.abilityCoolDown < 11) {
			float f = (float)((entity.isFast ? 1 : -1) * (Math.PI / 20.));
			this.rotated1.yRot += f;
			this.rotated2.yRot += f;
			this.rotated3.yRot += f;
			this.rotated4.yRot += f;
			this.rotated5.yRot += f;
			this.rotated6.yRot += f;
			this.rotated7.yRot += f;
			this.rotated8.yRot += f;
			this.rotated9.yRot += f;
			this.rotated10.yRot += f;
			this.rotated11.yRot += f;
			this.rotated12.yRot += f;
			this.rotated13.yRot += f;
			this.rotated14.yRot += f;
			this.rotated15.yRot += f;
			this.rotated16.yRot += f;
			this.rotated17.yRot += f;
			this.rotated18.yRot += f;
			this.rotated19.yRot += f;
			this.rotated20.yRot += f;
			this.rotated21.yRot += f;
			this.rotated22.yRot += f;
			this.rotated23.yRot += f;
			this.rotated24.yRot += f;
			this.rotated25.yRot += f;
			this.rotated26.yRot += f;
			this.rotated27.yRot += f;
			this.rotated28.yRot += f;
			this.rotated29.yRot += f;
			this.rotated30.yRot += f;
			this.rotated31.yRot += f;
			this.rotated32.yRot += f;
			this.rotated33.yRot += f;
			this.rotated34.yRot += f;
			this.rotated35.yRot += f;
			this.rotated36.yRot += f;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		rightlegt.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegt.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated16.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated17.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated18.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		righttoe1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		lefttoe1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		lefttoe2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		righttoe2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated19.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated20.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated21.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated22.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated23.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated24.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated25.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated26.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated27.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated28.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated29.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated30.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated31.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated32.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated33.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated34.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated35.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rotated36.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}