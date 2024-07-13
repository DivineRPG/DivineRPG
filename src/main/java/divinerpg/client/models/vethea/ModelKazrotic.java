package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKazrotic<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("kazrotic");
	private final ModelPart head;
	private final ModelPart part1;
	private final ModelPart part2;
	private final ModelPart part3;
	private final ModelPart leg1p1;
	private final ModelPart leg1p2;
	private final ModelPart leg1p3;
	private final ModelPart leg1p4;
	private final ModelPart leg1p5;
	private final ModelPart leg1p6;
	private final ModelPart leg1p7;
	private final ModelPart leg1p8;
	private final ModelPart leg1p9;
	private final ModelPart part4;
	private final ModelPart part5;
	private final ModelPart part6;
	private final ModelPart part7;
	private final ModelPart part8;
	private final ModelPart part9;
	private final ModelPart part10;
	private final ModelPart part28;
	private final ModelPart part29;
	private final ModelPart part30;
	private final ModelPart part31;
	private final ModelPart part32;
	private final ModelPart part33;
	private final ModelPart part34;
	private final ModelPart part36;
	private final ModelPart part37;
	private final ModelPart part11;
	private final ModelPart part12;
	private final ModelPart part13;
	private final ModelPart part14;
	private final ModelPart part15;
	private final ModelPart part16;
	private final ModelPart part35;
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
	private final ModelPart leg1p10;
	private final ModelPart leg1p11;
	private final ModelPart leg1p12;
	private final ModelPart leg1p13;
	private final ModelPart leg1p14;
	private final ModelPart leg1p15;
	private final ModelPart leg2p1;
	private final ModelPart leg2p2;
	private final ModelPart leg2p3;
	private final ModelPart leg2p4;
	private final ModelPart leg2p5;
	private final ModelPart leg2p6;
	private final ModelPart leg2p7;
	private final ModelPart leg2p8;
	private final ModelPart leg2p9;
	private final ModelPart leg2p10;
	private final ModelPart leg2p11;
	private final ModelPart leg2p12;
	private final ModelPart leg2p13;
	private final ModelPart leg2p14;
	private final ModelPart leg2p15;
	private final ModelPart leg3p1;
	private final ModelPart leg3p2;
	private final ModelPart leg3p3;
	private final ModelPart leg3p4;
	private final ModelPart leg3p5;
	private final ModelPart leg3p6;
	private final ModelPart leg3p7;
	private final ModelPart leg3p8;
	private final ModelPart leg3p9;
	private final ModelPart leg3p10;
	private final ModelPart leg3p11;
	private final ModelPart leg3p12;
	private final ModelPart leg3p13;
	private final ModelPart leg3p14;
	private final ModelPart leg3p15;
	private final ModelPart leg4p1;
	private final ModelPart leg4p2;
	private final ModelPart leg4p3;
	private final ModelPart leg4p4;
	private final ModelPart leg4p15;
	private final ModelPart leg4p5;
	private final ModelPart leg4p6;
	private final ModelPart leg4p7;
	private final ModelPart leg4p8;
	private final ModelPart leg4p9;
	private final ModelPart leg4p10;
	private final ModelPart leg4p11;
	private final ModelPart leg4p12;
	private final ModelPart leg4p13;
	private final ModelPart leg4p14;

	public ModelKazrotic(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.part3 = root.getChild("part3");
		this.leg1p1 = root.getChild("leg1p1");
		this.leg1p2 = root.getChild("leg1p2");
		this.leg1p3 = root.getChild("leg1p3");
		this.leg1p4 = root.getChild("leg1p4");
		this.leg1p5 = root.getChild("leg1p5");
		this.leg1p6 = root.getChild("leg1p6");
		this.leg1p7 = root.getChild("leg1p7");
		this.leg1p8 = root.getChild("leg1p8");
		this.leg1p9 = root.getChild("leg1p9");
		this.part4 = root.getChild("part4");
		this.part5 = root.getChild("part5");
		this.part6 = root.getChild("part6");
		this.part7 = root.getChild("part7");
		this.part8 = root.getChild("part8");
		this.part9 = root.getChild("part9");
		this.part10 = root.getChild("part10");
		this.part28 = root.getChild("part28");
		this.part29 = root.getChild("part29");
		this.part30 = root.getChild("part30");
		this.part31 = root.getChild("part31");
		this.part32 = root.getChild("part32");
		this.part33 = root.getChild("part33");
		this.part34 = root.getChild("part34");
		this.part36 = root.getChild("part36");
		this.part37 = root.getChild("part37");
		this.part11 = root.getChild("part11");
		this.part12 = root.getChild("part12");
		this.part13 = root.getChild("part13");
		this.part14 = root.getChild("part14");
		this.part15 = root.getChild("part15");
		this.part16 = root.getChild("part16");
		this.part35 = root.getChild("part35");
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
		this.leg1p10 = root.getChild("leg1p10");
		this.leg1p11 = root.getChild("leg1p11");
		this.leg1p12 = root.getChild("leg1p12");
		this.leg1p13 = root.getChild("leg1p13");
		this.leg1p14 = root.getChild("leg1p14");
		this.leg1p15 = root.getChild("leg1p15");
		this.leg2p1 = root.getChild("leg2p1");
		this.leg2p2 = root.getChild("leg2p2");
		this.leg2p3 = root.getChild("leg2p3");
		this.leg2p4 = root.getChild("leg2p4");
		this.leg2p5 = root.getChild("leg2p5");
		this.leg2p6 = root.getChild("leg2p6");
		this.leg2p7 = root.getChild("leg2p7");
		this.leg2p8 = root.getChild("leg2p8");
		this.leg2p9 = root.getChild("leg2p9");
		this.leg2p10 = root.getChild("leg2p10");
		this.leg2p11 = root.getChild("leg2p11");
		this.leg2p12 = root.getChild("leg2p12");
		this.leg2p13 = root.getChild("leg2p13");
		this.leg2p14 = root.getChild("leg2p14");
		this.leg2p15 = root.getChild("leg2p15");
		this.leg3p1 = root.getChild("leg3p1");
		this.leg3p2 = root.getChild("leg3p2");
		this.leg3p3 = root.getChild("leg3p3");
		this.leg3p4 = root.getChild("leg3p4");
		this.leg3p5 = root.getChild("leg3p5");
		this.leg3p6 = root.getChild("leg3p6");
		this.leg3p7 = root.getChild("leg3p7");
		this.leg3p8 = root.getChild("leg3p8");
		this.leg3p9 = root.getChild("leg3p9");
		this.leg3p10 = root.getChild("leg3p10");
		this.leg3p11 = root.getChild("leg3p11");
		this.leg3p12 = root.getChild("leg3p12");
		this.leg3p13 = root.getChild("leg3p13");
		this.leg3p14 = root.getChild("leg3p14");
		this.leg3p15 = root.getChild("leg3p15");
		this.leg4p1 = root.getChild("leg4p1");
		this.leg4p2 = root.getChild("leg4p2");
		this.leg4p3 = root.getChild("leg4p3");
		this.leg4p4 = root.getChild("leg4p4");
		this.leg4p15 = root.getChild("leg4p15");
		this.leg4p5 = root.getChild("leg4p5");
		this.leg4p6 = root.getChild("leg4p6");
		this.leg4p7 = root.getChild("leg4p7");
		this.leg4p8 = root.getChild("leg4p8");
		this.leg4p9 = root.getChild("leg4p9");
		this.leg4p10 = root.getChild("leg4p10");
		this.leg4p11 = root.getChild("leg4p11");
		this.leg4p12 = root.getChild("leg4p12");
		this.leg4p13 = root.getChild("leg4p13");
		this.leg4p14 = root.getChild("leg4p14");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -15.0F, 0.0F));

		partdefinition.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -15.0F, 6.0F));

		partdefinition.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(15, 20).mirror().addBox(-10.0F, 7.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -11.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(15, 21).mirror().addBox(3.0F, 7.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -12.0F, 0.0F, -2.0071F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 13.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 15.0F, 3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 13.0F, 3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 13.0F, 3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p5", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 13.0F, 3.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p6", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 15.0F, 3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p7", CubeListBuilder.create().texOffs(23, 16).mirror().addBox(1.0F, 13.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p8", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -6.0F, 5.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, -0.4363F, -2.3562F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p9", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-5.0F, 0.0F, 5.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, -0.4363F, -2.3562F, 0.0F));

		partdefinition.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -15.0F, 6.0F));

		partdefinition.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -15.0F, -6.0F));

		partdefinition.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -15.0F, -6.0F));

		partdefinition.addOrReplaceChild("part7", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -15.0F, -2.0F));

		partdefinition.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -15.0F, -2.0F));

		partdefinition.addOrReplaceChild("part9", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -15.0F, 2.0F));

		partdefinition.addOrReplaceChild("part10", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -15.0F, 2.0F));

		partdefinition.addOrReplaceChild("part28", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -12.0F, 0.0F, -2.0071F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part29", CubeListBuilder.create().texOffs(19, 20).mirror().addBox(-1.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -12.0F, 0.0F, -1.7453F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part30", CubeListBuilder.create().texOffs(22, 22).mirror().addBox(-13.0F, 12.0F, 3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -11.0F, 0.0F, -1.7453F, -0.6109F, 0.0F));

		partdefinition.addOrReplaceChild("part31", CubeListBuilder.create().texOffs(19, 20).mirror().addBox(-5.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -11.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part32", CubeListBuilder.create().texOffs(15, 23).mirror().addBox(-10.0F, -4.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -11.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part33", CubeListBuilder.create().texOffs(15, 24).mirror().addBox(3.0F, -4.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -12.0F, 0.0F, -2.0071F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part34", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-9.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -11.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part36", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-17.0F, 2.0F, 2.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -12.0F, 0.0F, -1.5708F, -1.8675F, 0.0F));

		partdefinition.addOrReplaceChild("part37", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-12.0F, 0.0F, 4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -11.0F, 0.0F, -1.7453F, -0.6109F, 0.0F));

		partdefinition.addOrReplaceChild("part11", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -10.0F, -28.0F));

		partdefinition.addOrReplaceChild("part12", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -15.0F, -28.0F));

		partdefinition.addOrReplaceChild("part13", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -10.0F, -11.0F));

		partdefinition.addOrReplaceChild("part14", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -17.0F, -2.0F));

		partdefinition.addOrReplaceChild("part15", CubeListBuilder.create().texOffs(27, 2).mirror().addBox(1.0F, 2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, -15.0F, -25.0F));

		partdefinition.addOrReplaceChild("part16", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -10.0F, -20.0F));

		partdefinition.addOrReplaceChild("part35", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-18.0F, -6.0F, 1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -11.0F, 0.0F, -1.7453F, -1.8675F, 0.0F));

		partdefinition.addOrReplaceChild("part17", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -17.0F, -11.0F));

		partdefinition.addOrReplaceChild("part18", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -14.0F, -8.0F, 0.9599F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part19", CubeListBuilder.create().texOffs(27, 2).mirror().addBox(1.0F, 2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -15.0F, -25.0F));

		partdefinition.addOrReplaceChild("part20", CubeListBuilder.create().texOffs(27, 2).mirror().addBox(1.0F, 2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, -15.0F, -20.0F));

		partdefinition.addOrReplaceChild("part21", CubeListBuilder.create().texOffs(27, 2).mirror().addBox(1.0F, 2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -15.0F, -20.0F));

		partdefinition.addOrReplaceChild("part22", CubeListBuilder.create().texOffs(27, 2).mirror().addBox(1.0F, 2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, -15.0F, -15.0F));

		partdefinition.addOrReplaceChild("part23", CubeListBuilder.create().texOffs(27, 2).mirror().addBox(1.0F, 2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -15.0F, -15.0F));

		partdefinition.addOrReplaceChild("part24", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -16.0F, -20.0F));

		partdefinition.addOrReplaceChild("part25", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -14.0F, -12.0F, 0.9599F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part26", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -14.0F, -16.0F, 0.9599F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part27", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -14.0F, -20.0F, 0.9599F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p10", CubeListBuilder.create().texOffs(23, 16).mirror().addBox(-4.0F, 13.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p11", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 15.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p12", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 13.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p13", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 13.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p14", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 15.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, 0.0F, -3.1416F, 0.0F));

		partdefinition.addOrReplaceChild("leg1p15", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 5.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -3.0F, 11.0F, -0.4363F, -2.3562F, 0.0F));

		partdefinition.addOrReplaceChild("leg2p1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -6.0F, 5.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -3.0F, -10.0F, -0.4363F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("leg2p2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-5.0F, 0.0F, 5.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -3.0F, -10.0F, -0.4363F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("leg2p3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 5.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -3.0F, -10.0F, -0.4363F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("leg2p4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 15.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p5", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 13.0F, 3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p6", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 13.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p7", CubeListBuilder.create().texOffs(23, 16).mirror().addBox(-4.0F, 13.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p8", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 13.0F, 3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p9", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 13.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p10", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 13.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p11", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 13.0F, 3.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p12", CubeListBuilder.create().texOffs(23, 16).mirror().addBox(1.0F, 13.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p13", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 15.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p14", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 15.0F, 3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg2p15", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 15.0F, 3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -3.0F, -10.0F));

		partdefinition.addOrReplaceChild("leg3p1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 15.0F, 3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 15.0F, 3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 13.0F, 3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 13.0F, 3.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p5", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 13.0F, 3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p6", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-5.0F, 0.0F, 5.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, -0.4363F, 2.3562F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p7", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 5.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, -0.4363F, 2.3562F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p8", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -6.0F, 5.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, -0.4363F, 2.3562F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p9", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 15.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p10", CubeListBuilder.create().texOffs(23, 16).mirror().addBox(-4.0F, 13.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p11", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 13.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p12", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 15.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p13", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 13.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p14", CubeListBuilder.create().texOffs(23, 16).mirror().addBox(1.0F, 13.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg3p15", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 13.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 13.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 13.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 15.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 15.0F, 3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p15", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 13.0F, 3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p5", CubeListBuilder.create().texOffs(23, 16).mirror().addBox(-4.0F, 13.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p6", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, 13.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p7", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-5.0F, 0.0F, 5.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, -0.4363F, -0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p8", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -6.0F, 5.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, -0.4363F, -0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p9", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, 5.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, -0.4363F, -0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p10", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 13.0F, 3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p11", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 13.0F, 3.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p12", CubeListBuilder.create().texOffs(23, 16).mirror().addBox(1.0F, 13.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p13", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 15.0F, 3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("leg4p14", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(1.0F, 15.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -3.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1p1.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p2.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p3.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p4.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p5.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p6.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p7.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p8.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount-0.4363323F;
		this.leg1p9.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount-0.4363323F;
		this.leg1p10.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p11.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p12.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p13.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p14.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg1p15.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount-0.4363323F;

		this.leg2p1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount-0.4363323F;
		this.leg2p2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount-0.4363323F;
		this.leg2p3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount-0.4363323F;
		this.leg2p4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p7.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p8.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p9.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p10.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p11.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p12.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p13.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p14.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg2p15.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;

		this.leg3p1.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p2.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p3.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p4.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p5.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p6.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount-0.4363323F;
		this.leg3p7.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount-0.4363323F;
		this.leg3p8.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount-0.4363323F;
		this.leg3p9.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p10.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p11.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p12.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p13.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p14.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;
		this.leg3p15.xRot = Mth.cos(limbSwing * 0.6662F) *1.3F * limbSwingAmount;

		this.leg4p1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p7.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount-0.4363323F;
		this.leg4p8.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount-0.4363323F;
		this.leg4p9.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount-0.4363323F;
		this.leg4p10.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p11.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p12.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p13.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p14.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
		this.leg4p15.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) *1.3F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part28.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part29.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part30.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part31.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part32.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part33.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part34.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part36.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part37.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part16.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part35.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
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
		leg1p10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1p15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2p15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3p15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4p14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}