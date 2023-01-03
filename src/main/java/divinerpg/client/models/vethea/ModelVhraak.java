package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelVhraak<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("vhraak");
	private final ModelPart part1;
	private final ModelPart part2;
	private final ModelPart Leg1p1;
	private final ModelPart Leg2p1;
	private final ModelPart Tail6;
	private final ModelPart part3;
	private final ModelPart part4;
	private final ModelPart Leg1p2;
	private final ModelPart Leg2p2;
	private final ModelPart Leg1p3;
	private final ModelPart Leg2p3;
	private final ModelPart Leg1p4;
	private final ModelPart Leg2p4;
	private final ModelPart Leg1p5;
	private final ModelPart Leg2p5;
	private final ModelPart Leg1p6;
	private final ModelPart Leg2p6;
	private final ModelPart part5;
	private final ModelPart part6;
	private final ModelPart Leg3p1;
	private final ModelPart Leg3p2;
	private final ModelPart Leg3p3;
	private final ModelPart Leg4p1;
	private final ModelPart Leg4p2;
	private final ModelPart Leg4p3;
	private final ModelPart Leg3p4;
	private final ModelPart Leg4p4;
	private final ModelPart Leg3p5;
	private final ModelPart Leg3p6;
	private final ModelPart Leg4p5;
	private final ModelPart Leg4p6;
	private final ModelPart part7;
	private final ModelPart part8;
	private final ModelPart part9;
	private final ModelPart part10;
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
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Tail3;
	private final ModelPart Tail4;
	private final ModelPart Tail5;
	private final ModelPart part41;
	private final ModelPart part42;
	private final ModelPart part43;
	private final ModelPart part44;
	private final ModelPart part45;
	private final ModelPart part46;

	public ModelVhraak(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.Leg1p1 = root.getChild("Leg1p1");
		this.Leg2p1 = root.getChild("Leg2p1");
		this.Tail6 = root.getChild("Tail6");
		this.part3 = root.getChild("part3");
		this.part4 = root.getChild("part4");
		this.Leg1p2 = root.getChild("Leg1p2");
		this.Leg2p2 = root.getChild("Leg2p2");
		this.Leg1p3 = root.getChild("Leg1p3");
		this.Leg2p3 = root.getChild("Leg2p3");
		this.Leg1p4 = root.getChild("Leg1p4");
		this.Leg2p4 = root.getChild("Leg2p4");
		this.Leg1p5 = root.getChild("Leg1p5");
		this.Leg2p5 = root.getChild("Leg2p5");
		this.Leg1p6 = root.getChild("Leg1p6");
		this.Leg2p6 = root.getChild("Leg2p6");
		this.part5 = root.getChild("part5");
		this.part6 = root.getChild("part6");
		this.Leg3p1 = root.getChild("Leg3p1");
		this.Leg3p2 = root.getChild("Leg3p2");
		this.Leg3p3 = root.getChild("Leg3p3");
		this.Leg4p1 = root.getChild("Leg4p1");
		this.Leg4p2 = root.getChild("Leg4p2");
		this.Leg4p3 = root.getChild("Leg4p3");
		this.Leg3p4 = root.getChild("Leg3p4");
		this.Leg4p4 = root.getChild("Leg4p4");
		this.Leg3p5 = root.getChild("Leg3p5");
		this.Leg3p6 = root.getChild("Leg3p6");
		this.Leg4p5 = root.getChild("Leg4p5");
		this.Leg4p6 = root.getChild("Leg4p6");
		this.part7 = root.getChild("part7");
		this.part8 = root.getChild("part8");
		this.part9 = root.getChild("part9");
		this.part10 = root.getChild("part10");
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
		this.Tail1 = root.getChild("Tail1");
		this.Tail2 = root.getChild("Tail2");
		this.Tail3 = root.getChild("Tail3");
		this.Tail4 = root.getChild("Tail4");
		this.Tail5 = root.getChild("Tail5");
		this.part41 = root.getChild("part41");
		this.part42 = root.getChild("part42");
		this.part43 = root.getChild("part43");
		this.part44 = root.getChild("part44");
		this.part45 = root.getChild("part45");
		this.part46 = root.getChild("part46");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 11.5F, -7.0F));

		partdefinition.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 12.0F, 15.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg1p1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-4.0F, -1.0F, -2.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.5F, 12.0F, 18.0F));

		partdefinition.addOrReplaceChild("Leg2p1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, -1.0F, -2.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.5F, 12.0F, 18.0F));

		partdefinition.addOrReplaceChild("Tail6", CubeListBuilder.create().texOffs(9, 18).mirror().addBox(-2.0F, 21.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 12.0F, 21.0F, 1.1301F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 12.0F, 15.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 4.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 6.0F, 18.0F, 1.7567F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg1p2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(2.0F, 9.0F, 9.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, 18.0F, -1.5708F, 0.4363F, 0.0F));

		partdefinition.addOrReplaceChild("Leg2p2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(4.0F, 7.0F, 9.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, 18.0F, -1.5708F, 0.4363F, 0.0F));

		partdefinition.addOrReplaceChild("Leg1p3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, 18.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg2p3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, 18.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg1p4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-3.0F, -7.0F, 8.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, 18.0F, -2.3562F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg2p4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0.0F, -7.0F, 8.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, 18.0F, -2.3562F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg1p5", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-2.0F, 2.0F, 10.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, 18.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg2p5", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(1.0F, 2.0F, 10.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, 18.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg1p6", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-5.0F, 8.0F, 9.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, 18.0F, -1.5708F, -0.4363F, 0.0F));

		partdefinition.addOrReplaceChild("Leg2p6", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-2.0F, 8.0F, 9.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, 18.0F, -1.5708F, -0.4363F, 0.0F));

		partdefinition.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 12.0F, 6.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 12.0F, 6.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg3p1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0.0F, -7.0F, 8.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, -1.0F, -2.3562F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg3p2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, -1.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg3p3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, -1.0F, -2.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.5F, 12.0F, -1.0F));

		partdefinition.addOrReplaceChild("Leg4p1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-3.0F, -7.0F, 8.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, -1.0F, -2.3562F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg4p2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, -1.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg4p3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-4.0F, -1.0F, -2.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.5F, 12.0F, -1.0F));

		partdefinition.addOrReplaceChild("Leg3p4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(1.0F, 2.0F, 10.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg4p4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-2.0F, 2.0F, 10.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leg3p5", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(4.0F, 7.0F, 9.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, -1.0F, -1.5708F, 0.4363F, 0.0F));

		partdefinition.addOrReplaceChild("Leg3p6", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-2.0F, 8.0F, 9.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 12.0F, -1.0F, -1.5708F, -0.4363F, 0.0F));

		partdefinition.addOrReplaceChild("Leg4p5", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(2.0F, 9.0F, 9.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, -1.0F, -1.5708F, 0.4363F, 0.0F));

		partdefinition.addOrReplaceChild("Leg4p6", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-5.0F, 8.0F, 9.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 12.0F, -1.0F, -1.5708F, -0.4363F, 0.0F));

		partdefinition.addOrReplaceChild("part7", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 12.0F, -3.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(2.0F, 6.0F, -3.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 9.0F, 1.8326F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("part9", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(2.0F, -3.0F, -1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 9.0F, 1.8326F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("part10", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-5.0F, -3.0F, -1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 8.0F, 9.0F, 1.8326F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("part11", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-5.0F, 6.0F, -3.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 8.0F, 9.0F, 1.8326F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("part12", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(5.0F, 6.0F, -3.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("part13", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(5.0F, -3.0F, -1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("part14", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(5.0F, -12.0F, 1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("part15", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-3.0F, 6.0F, -3.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 9.0F, 1.8326F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("part16", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-3.0F, -3.0F, -1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 9.0F, 1.8326F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("part17", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(6.0F, 6.0F, -3.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part18", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(6.0F, -3.0F, -1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part19", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(6.0F, -12.0F, 1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part20", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(4.0F, 6.0F, -3.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 8.0F, 9.0F, 1.8326F, 0.0F, -0.3491F));

		partdefinition.addOrReplaceChild("part21", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(4.0F, -3.0F, -1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 8.0F, 9.0F, 1.8326F, 0.0F, -0.3491F));

		partdefinition.addOrReplaceChild("part22", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(5.0F, -12.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 6.0F, 9.0F, 2.0557F, 0.1859F, -0.0145F));

		partdefinition.addOrReplaceChild("part23", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-7.0F, -12.0F, 1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part24", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-7.0F, -3.0F, -1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part25", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-7.0F, 6.0F, -3.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part26", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-6.0F, -3.0F, -1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("part27", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-6.0F, 6.0F, -3.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("part28", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-6.0F, -12.0F, 1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 9.0F, 1.8326F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("part29", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-5.0F, -12.0F, 1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 8.0F, 9.0F, 1.8326F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("part30", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-3.0F, -12.0F, 1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 9.0F, 1.8326F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("part31", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(2.0F, -12.0F, 1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 9.0F, 1.8326F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("part32", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(4.0F, -12.0F, 1.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 8.0F, 9.0F, 1.8326F, 0.0F, -0.3491F));

		partdefinition.addOrReplaceChild("part33", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-6.0F, -12.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 9.0F, 2.0944F, -0.1745F, 0.1374F));

		partdefinition.addOrReplaceChild("part34", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(2.0F, -12.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 5.0F, 9.0F, 2.0557F, 0.1859F, -0.5236F));

		partdefinition.addOrReplaceChild("part35", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(4.0F, -12.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 6.0F, 9.0F, 2.0557F, 0.1859F, -0.3491F));

		partdefinition.addOrReplaceChild("part36", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-3.0F, -12.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 5.0F, 9.0F, 2.0944F, -0.1745F, 0.4864F));

		partdefinition.addOrReplaceChild("part37", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-5.0F, -12.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 6.0F, 9.0F, 2.0944F, -0.1745F, 0.3119F));

		partdefinition.addOrReplaceChild("part38", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 12.0F, -3.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part39", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 4.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 6.0F, -3.0F, 1.9426F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part40", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -2.0F, -3.0F, 4.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 6.0F, 14.0F, 1.9426F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(9, 18).mirror().addBox(-2.0F, 5.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 12.0F, 21.0F, 1.1301F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(9, 18).mirror().addBox(-2.0F, 13.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 12.0F, 21.0F, 1.1301F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(9, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 12.0F, 21.0F, 1.1301F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail4", CubeListBuilder.create().texOffs(9, 18).mirror().addBox(-1.0F, 8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 12.0F, 21.0F, 1.1301F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail5", CubeListBuilder.create().texOffs(9, 18).mirror().addBox(-1.0F, 16.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 12.0F, 21.0F, 1.1301F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part41", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(-5.0F, -7.0F, -3.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 11.5F, -7.0F));

		partdefinition.addOrReplaceChild("part42", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(3.0F, -7.0F, -3.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 11.5F, -7.0F));

		partdefinition.addOrReplaceChild("part43", CubeListBuilder.create().texOffs(2, 12).mirror().addBox(-6.0F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 11.5F, -7.0F));

		partdefinition.addOrReplaceChild("part44", CubeListBuilder.create().texOffs(2, 12).addBox(3.0F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 11.5F, -7.0F));

		partdefinition.addOrReplaceChild("part45", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(-5.0F, -5.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 11.5F, -7.0F));

		partdefinition.addOrReplaceChild("part46", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(3.0F, -5.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 11.5F, -7.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Leg1p1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Leg1p2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-1.570796F;
		this.Leg1p3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-0.7853982F;
		this.Leg1p4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-2.356194F;
		this.Leg1p5.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-1.570796F;
		this.Leg1p6.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-1.570796F;

		this.Leg2p1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Leg2p2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-1.570796F;
		this.Leg2p3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-0.7853982F;
		this.Leg2p4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-2.356194F;
		this.Leg2p5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-1.570796F;
		this.Leg2p6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-1.570796F;

		this.Leg3p1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-2.356194F;
		this.Leg3p2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-0.7853982F;
		this.Leg3p3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Leg3p4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-1.570796F;
		this.Leg3p5.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-1.570796F;
		this.Leg3p6.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount-1.570796F;

		this.Leg4p1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-2.356194F;
		this.Leg4p2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-0.7853982F;
		this.Leg4p3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Leg4p4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-1.570796F;
		this.Leg4p5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-1.570796F;
		this.Leg4p6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount-1.570796F;

		this.Tail1.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI * 0.15F + 1.130069F;
		this.Tail2.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI * 0.15F + 1.130069F;
		this.Tail3.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI * 0.15F + 1.130069F;
		this.Tail4.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI * 0.15F + 1.130069F;
		this.Tail5.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI * 0.15F + 1.130069F;
		this.Tail6.xRot = Mth.cos(ageInTicks * 0.1F) * (float)Math.PI * 0.15F + 1.130069F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1p1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2p1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1p2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2p2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1p3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2p3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1p4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2p4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1p5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2p5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1p6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2p6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3p1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3p2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3p3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4p1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4p2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4p3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3p4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4p4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3p5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3p6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4p5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4p6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part25.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part26.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part27.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part28.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part29.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part30.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part31.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part32.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part33.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part34.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part35.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part36.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part37.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part38.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part39.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part40.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part41.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part42.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part43.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part44.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part45.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		part46.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}