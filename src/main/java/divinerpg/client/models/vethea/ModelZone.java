package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelZone<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("zone");
	private final ModelPart part1;
	private final ModelPart part2;
	private final ModelPart rightleg1;
	private final ModelPart leftleg1;
	private final ModelPart part3;
	private final ModelPart part4;
	private final ModelPart part5;
	private final ModelPart part6;
	private final ModelPart part8;
	private final ModelPart part9;
	private final ModelPart part11;
	private final ModelPart part12;
	private final ModelPart part13;
	private final ModelPart part14;
	private final ModelPart part15;
	private final ModelPart part16;
	private final ModelPart part17;
	private final ModelPart part18;
	private final ModelPart part19;
	private final ModelPart part20;
	private final ModelPart part21;
	private final ModelPart part22;
	private final ModelPart part23;
	private final ModelPart part24;
	private final ModelPart part25;
	private final ModelPart part26;
	private final ModelPart part27;
	private final ModelPart part28;
	private final ModelPart part29;
	private final ModelPart part30;
	private final ModelPart part31;
	private final ModelPart part32;
	private final ModelPart part33;
	private final ModelPart part34;
	private final ModelPart part35;
	private final ModelPart part36;
	private final ModelPart part37;
	private final ModelPart part38;
	private final ModelPart part39;
	private final ModelPart part40;
	private final ModelPart part41;
	private final ModelPart part42;
	private final ModelPart part43;
	private final ModelPart part44;
	private final ModelPart part45;
	private final ModelPart part46;
	private final ModelPart part47;
	private final ModelPart part48;
	private final ModelPart part49;
	private final ModelPart part50;
	private final ModelPart part51;
	private final ModelPart leftleg6;
	private final ModelPart rightleg2;
	private final ModelPart leftleg2;
	private final ModelPart rightleg3;
	private final ModelPart leftleg3;
	private final ModelPart rightleg4;
	private final ModelPart leftleg4;
	private final ModelPart rightleg5;
	private final ModelPart rightleg6;
	private final ModelPart leftleg5;

	public ModelZone(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.rightleg1 = root.getChild("rightleg1");
		this.leftleg1 = root.getChild("leftleg1");
		this.part3 = root.getChild("part3");
		this.part4 = root.getChild("part4");
		this.part5 = root.getChild("part5");
		this.part6 = root.getChild("part6");
		this.part8 = root.getChild("part8");
		this.part9 = root.getChild("part9");
		this.part11 = root.getChild("part11");
		this.part12 = root.getChild("part12");
		this.part13 = root.getChild("part13");
		this.part14 = root.getChild("part14");
		this.part15 = root.getChild("part15");
		this.part16 = root.getChild("part16");
		this.part17 = root.getChild("part17");
		this.part18 = root.getChild("part18");
		this.part19 = root.getChild("part19");
		this.part20 = root.getChild("part20");
		this.part21 = root.getChild("part21");
		this.part22 = root.getChild("part22");
		this.part23 = root.getChild("part23");
		this.part24 = root.getChild("part24");
		this.part25 = root.getChild("part25");
		this.part26 = root.getChild("part26");
		this.part27 = root.getChild("part27");
		this.part28 = root.getChild("part28");
		this.part29 = root.getChild("part29");
		this.part30 = root.getChild("part30");
		this.part31 = root.getChild("part31");
		this.part32 = root.getChild("part32");
		this.part33 = root.getChild("part33");
		this.part34 = root.getChild("part34");
		this.part35 = root.getChild("part35");
		this.part36 = root.getChild("part36");
		this.part37 = root.getChild("part37");
		this.part38 = root.getChild("part38");
		this.part39 = root.getChild("part39");
		this.part40 = root.getChild("part40");
		this.part41 = root.getChild("part41");
		this.part42 = root.getChild("part42");
		this.part43 = root.getChild("part43");
		this.part44 = root.getChild("part44");
		this.part45 = root.getChild("part45");
		this.part46 = root.getChild("part46");
		this.part47 = root.getChild("part47");
		this.part48 = root.getChild("part48");
		this.part49 = root.getChild("part49");
		this.part50 = root.getChild("part50");
		this.part51 = root.getChild("part51");
		this.leftleg6 = root.getChild("leftleg6");
		this.rightleg2 = root.getChild("rightleg2");
		this.leftleg2 = root.getChild("leftleg2");
		this.rightleg3 = root.getChild("rightleg3");
		this.leftleg3 = root.getChild("leftleg3");
		this.rightleg4 = root.getChild("rightleg4");
		this.leftleg4 = root.getChild("leftleg4");
		this.rightleg5 = root.getChild("rightleg5");
		this.rightleg6 = root.getChild("rightleg6");
		this.leftleg5 = root.getChild("leftleg5");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 13.0F, -1.0F));

		partdefinition.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 6.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 6.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(43, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 9.0F, -1.0F));

		partdefinition.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(18, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 9.0F, -1.0F));

		partdefinition.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 13.0F, -1.0F));

		partdefinition.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(100, 7).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(52, 9).mirror().addBox(-7.0F, -2.0F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 9.0F, -2.0F, 0.0F, 0.0F, -0.6981F));

		partdefinition.addOrReplaceChild("part9", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 10.0F, -1.0F));

		partdefinition.addOrReplaceChild("part11", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 10.0F, -1.0F));

		partdefinition.addOrReplaceChild("part12", CubeListBuilder.create().texOffs(52, 9).mirror().addBox(-5.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 9.0F, -2.0F, 0.0F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("part13", CubeListBuilder.create().texOffs(111, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(14.0F, 14.0F, -8.0F));

		partdefinition.addOrReplaceChild("part14", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 14.0F, 2.0F));

		partdefinition.addOrReplaceChild("part15", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 14.0F, 2.0F));

		partdefinition.addOrReplaceChild("part16", CubeListBuilder.create().texOffs(95, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 17.0F, -8.0F));

		partdefinition.addOrReplaceChild("part17", CubeListBuilder.create().texOffs(95, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 17.0F, -8.0F));

		partdefinition.addOrReplaceChild("part18", CubeListBuilder.create().texOffs(111, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 14.0F, -8.0F));

		partdefinition.addOrReplaceChild("part19", CubeListBuilder.create().texOffs(111, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 14.0F, -8.0F));

		partdefinition.addOrReplaceChild("part20", CubeListBuilder.create().texOffs(95, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 14.0F, -8.0F));

		partdefinition.addOrReplaceChild("part21", CubeListBuilder.create().texOffs(95, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 14.0F, -8.0F));

		partdefinition.addOrReplaceChild("part22", CubeListBuilder.create().texOffs(110, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 14.0F, -3.0F));

		partdefinition.addOrReplaceChild("part23", CubeListBuilder.create().texOffs(110, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 14.0F, -3.0F));

		partdefinition.addOrReplaceChild("part24", CubeListBuilder.create().texOffs(50, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 14.0F, -3.0F));

		partdefinition.addOrReplaceChild("part25", CubeListBuilder.create().texOffs(50, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 17.0F, -3.0F));

		partdefinition.addOrReplaceChild("part26", CubeListBuilder.create().texOffs(110, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(14.0F, 14.0F, -3.0F));

		partdefinition.addOrReplaceChild("part27", CubeListBuilder.create().texOffs(50, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 17.0F, -3.0F));

		partdefinition.addOrReplaceChild("part28", CubeListBuilder.create().texOffs(110, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 14.0F, -3.0F));

		partdefinition.addOrReplaceChild("part29", CubeListBuilder.create().texOffs(50, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 14.0F, -3.0F));

		partdefinition.addOrReplaceChild("part30", CubeListBuilder.create().texOffs(111, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 14.0F, -8.0F));

		partdefinition.addOrReplaceChild("part31", CubeListBuilder.create().texOffs(114, 11).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 18.0F, -3.0F));

		partdefinition.addOrReplaceChild("part32", CubeListBuilder.create().texOffs(100, 7).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(15.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("part33", CubeListBuilder.create().texOffs(112, 11).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("part34", CubeListBuilder.create().texOffs(114, 11).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 18.0F, -3.0F));

		partdefinition.addOrReplaceChild("part35", CubeListBuilder.create().texOffs(112, 11).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("part36", CubeListBuilder.create().texOffs(100, 7).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("part37", CubeListBuilder.create().texOffs(100, 7).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 13.0F, -3.0F));

		partdefinition.addOrReplaceChild("part38", CubeListBuilder.create().texOffs(100, 7).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 13.0F, -6.0F));

		partdefinition.addOrReplaceChild("part39", CubeListBuilder.create().texOffs(100, 7).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(15.0F, 13.0F, -6.0F));

		partdefinition.addOrReplaceChild("part40", CubeListBuilder.create().texOffs(100, 7).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 13.0F, -6.0F));

		partdefinition.addOrReplaceChild("part41", CubeListBuilder.create().texOffs(112, 11).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 13.0F, -6.0F));

		partdefinition.addOrReplaceChild("part42", CubeListBuilder.create().texOffs(114, 11).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, 18.0F, -6.0F));

		partdefinition.addOrReplaceChild("part43", CubeListBuilder.create().texOffs(114, 11).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 18.0F, -6.0F));

		partdefinition.addOrReplaceChild("part44", CubeListBuilder.create().texOffs(102, 7).mirror().addBox(-4.0F, 0.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 13.0F, -6.0F));

		partdefinition.addOrReplaceChild("part45", CubeListBuilder.create().texOffs(112, 11).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 13.0F, -6.0F));

		partdefinition.addOrReplaceChild("part46", CubeListBuilder.create().texOffs(2, 24).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part47", CubeListBuilder.create().texOffs(2, 24).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part48", CubeListBuilder.create().texOffs(52, 9).mirror().addBox(-7.0F, -2.0F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 9.0F, 4.0F, 0.0F, 0.0F, -0.6981F));

		partdefinition.addOrReplaceChild("part49", CubeListBuilder.create().texOffs(52, 9).mirror().addBox(-5.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("part50", CubeListBuilder.create().texOffs(52, 9).mirror().addBox(-7.0F, -2.0F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 9.0F, 1.0F, 0.0F, 0.0F, -0.6981F));

		partdefinition.addOrReplaceChild("part51", CubeListBuilder.create().texOffs(52, 9).mirror().addBox(-5.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 9.0F, 1.0F, 0.0F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("leftleg6", CubeListBuilder.create().texOffs(74, 3).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(74, 3).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(70, 16).mirror().addBox(-2.0F, 7.0F, -8.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(70, 16).mirror().addBox(-2.0F, 7.0F, -8.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(94, 24).mirror().addBox(-1.0F, 1.0F, -8.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 16.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg4", CubeListBuilder.create().texOffs(94, 24).mirror().addBox(-1.0F, 1.0F, -8.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 16.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 6.0F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg5", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 6.0F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg6", CubeListBuilder.create().texOffs(70, 24).mirror().addBox(-2.0F, 5.0F, -8.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg5", CubeListBuilder.create().texOffs(70, 24).mirror().addBox(-2.0F, 5.0F, -8.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 16.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.5235988F;
		this.leftleg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg5.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg6.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightleg1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + 0.5235988F;
		this.rightleg5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part16.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part17.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part18.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part19.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part20.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part21.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part22.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part23.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part24.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part25.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part26.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part27.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part28.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part29.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part30.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part31.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part32.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part33.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part34.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part35.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part36.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part37.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part38.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part39.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part40.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part41.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part42.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part43.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part44.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part45.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part46.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part47.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part48.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part49.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part50.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part51.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}