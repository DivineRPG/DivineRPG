package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGalroid<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("galroid");
	private final ModelPart horn1;
	private final ModelPart body1;
	private final ModelPart rightleg1;
	private final ModelPart leftleg1;
	private final ModelPart rightleg2;
	private final ModelPart leftleg2;
	private final ModelPart rightleg3;
	private final ModelPart leftleg3;
	private final ModelPart rightleg4;
	private final ModelPart rightleg5;
	private final ModelPart leftleg4;
	private final ModelPart leftleg5;
	private final ModelPart leftarm1;
	private final ModelPart rightarm1;
	private final ModelPart leftarm2;
	private final ModelPart leftarm3;
	private final ModelPart leftarm4;
	private final ModelPart rightarm2;
	private final ModelPart rightarm3;
	private final ModelPart rightarm4;
	private final ModelPart rightarm5;
	private final ModelPart leftarm5;
	private final ModelPart rightarm6;
	private final ModelPart leftarm6;
	private final ModelPart rightarm7;
	private final ModelPart rightarm8;
	private final ModelPart rightarm9;
	private final ModelPart leftarm7;
	private final ModelPart leftarm8;
	private final ModelPart leftarm9;
	private final ModelPart rightarm10;
	private final ModelPart rightarm11;
	private final ModelPart rightarm12;
	private final ModelPart rightarm13;
	private final ModelPart rightarm14;
	private final ModelPart rightarm15;
	private final ModelPart rightarm16;
	private final ModelPart rightarm17;
	private final ModelPart rightarm18;
	private final ModelPart leftarm10;
	private final ModelPart leftarm11;
	private final ModelPart leftarm12;
	private final ModelPart leftarm13;
	private final ModelPart leftarm14;
	private final ModelPart leftarm15;
	private final ModelPart leftarm16;
	private final ModelPart leftarm17;
	private final ModelPart leftarm18;
	private final ModelPart rightarm19;
	private final ModelPart rightarm20;
	private final ModelPart rightarm21;
	private final ModelPart rightarm22;
	private final ModelPart rightarm23;
	private final ModelPart rightarm24;
	private final ModelPart rightarm25;
	private final ModelPart rightarm26;
	private final ModelPart leftarm19;
	private final ModelPart leftarm20;
	private final ModelPart leftarm22;
	private final ModelPart leftarm21;
	private final ModelPart leftarm23;
	private final ModelPart leftarm24;
	private final ModelPart leftarm25;
	private final ModelPart leftarm26;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;
	private final ModelPart body5;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart body6;
	private final ModelPart body7;
	private final ModelPart body8;
	private final ModelPart body9;
	private final ModelPart body10;
	private final ModelPart body11;
	private final ModelPart body12;
	private final ModelPart body13;
	private final ModelPart body14;
	private final ModelPart head;
	private final ModelPart horn2;
	private final ModelPart horn3;
	private final ModelPart horn4;
	private final ModelPart leftarm27;
	private final ModelPart rightarm27;

	public ModelGalroid(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.horn1 = root.getChild("horn1");
		this.body1 = root.getChild("body1");
		this.rightleg1 = root.getChild("rightleg1");
		this.leftleg1 = root.getChild("leftleg1");
		this.rightleg2 = root.getChild("rightleg2");
		this.leftleg2 = root.getChild("leftleg2");
		this.rightleg3 = root.getChild("rightleg3");
		this.leftleg3 = root.getChild("leftleg3");
		this.rightleg4 = root.getChild("rightleg4");
		this.rightleg5 = root.getChild("rightleg5");
		this.leftleg4 = root.getChild("leftleg4");
		this.leftleg5 = root.getChild("leftleg5");
		this.leftarm1 = root.getChild("leftarm1");
		this.rightarm1 = root.getChild("rightarm1");
		this.leftarm2 = root.getChild("leftarm2");
		this.leftarm3 = root.getChild("leftarm3");
		this.leftarm4 = root.getChild("leftarm4");
		this.rightarm2 = root.getChild("rightarm2");
		this.rightarm3 = root.getChild("rightarm3");
		this.rightarm4 = root.getChild("rightarm4");
		this.rightarm5 = root.getChild("rightarm5");
		this.leftarm5 = root.getChild("leftarm5");
		this.rightarm6 = root.getChild("rightarm6");
		this.leftarm6 = root.getChild("leftarm6");
		this.rightarm7 = root.getChild("rightarm7");
		this.rightarm8 = root.getChild("rightarm8");
		this.rightarm9 = root.getChild("rightarm9");
		this.leftarm7 = root.getChild("leftarm7");
		this.leftarm8 = root.getChild("leftarm8");
		this.leftarm9 = root.getChild("leftarm9");
		this.rightarm10 = root.getChild("rightarm10");
		this.rightarm11 = root.getChild("rightarm11");
		this.rightarm12 = root.getChild("rightarm12");
		this.rightarm13 = root.getChild("rightarm13");
		this.rightarm14 = root.getChild("rightarm14");
		this.rightarm15 = root.getChild("rightarm15");
		this.rightarm16 = root.getChild("rightarm16");
		this.rightarm17 = root.getChild("rightarm17");
		this.rightarm18 = root.getChild("rightarm18");
		this.leftarm10 = root.getChild("leftarm10");
		this.leftarm11 = root.getChild("leftarm11");
		this.leftarm12 = root.getChild("leftarm12");
		this.leftarm13 = root.getChild("leftarm13");
		this.leftarm14 = root.getChild("leftarm14");
		this.leftarm15 = root.getChild("leftarm15");
		this.leftarm16 = root.getChild("leftarm16");
		this.leftarm17 = root.getChild("leftarm17");
		this.leftarm18 = root.getChild("leftarm18");
		this.rightarm19 = root.getChild("rightarm19");
		this.rightarm20 = root.getChild("rightarm20");
		this.rightarm21 = root.getChild("rightarm21");
		this.rightarm22 = root.getChild("rightarm22");
		this.rightarm23 = root.getChild("rightarm23");
		this.rightarm24 = root.getChild("rightarm24");
		this.rightarm25 = root.getChild("rightarm25");
		this.rightarm26 = root.getChild("rightarm26");
		this.leftarm19 = root.getChild("leftarm19");
		this.leftarm20 = root.getChild("leftarm20");
		this.leftarm22 = root.getChild("leftarm22");
		this.leftarm21 = root.getChild("leftarm21");
		this.leftarm23 = root.getChild("leftarm23");
		this.leftarm24 = root.getChild("leftarm24");
		this.leftarm25 = root.getChild("leftarm25");
		this.leftarm26 = root.getChild("leftarm26");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.body4 = root.getChild("body4");
		this.body5 = root.getChild("body5");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.body6 = root.getChild("body6");
		this.body7 = root.getChild("body7");
		this.body8 = root.getChild("body8");
		this.body9 = root.getChild("body9");
		this.body10 = root.getChild("body10");
		this.body11 = root.getChild("body11");
		this.body12 = root.getChild("body12");
		this.body13 = root.getChild("body13");
		this.body14 = root.getChild("body14");
		this.head = root.getChild("head");
		this.horn2 = root.getChild("horn2");
		this.horn3 = root.getChild("horn3");
		this.horn4 = root.getChild("horn4");
		this.leftarm27 = root.getChild("leftarm27");
		this.rightarm27 = root.getChild("rightarm27");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(0.0F, -15.0F, 1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(60, 21).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -6.0F, 2.0F));

		partdefinition.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(54, 25).mirror().addBox(2.0F, 7.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(54, 25).mirror().addBox(2.0F, 7.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(54, 25).mirror().addBox(-3.0F, 7.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(55, 25).mirror().addBox(-3.0F, 7.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg4", CubeListBuilder.create().texOffs(72, 13).mirror().addBox(-3.0F, 9.0F, -3.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg5", CubeListBuilder.create().texOffs(72, 13).mirror().addBox(1.0F, 9.0F, -3.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg4", CubeListBuilder.create().texOffs(72, 13).mirror().addBox(-3.0F, 9.0F, -3.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg5", CubeListBuilder.create().texOffs(72, 13).mirror().addBox(1.0F, 9.0F, -3.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(0.0F, 0.0F, 14.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, -1.2217F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(-2.0F, 0.0F, 14.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, -1.2217F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(0.0F, -2.0F, -3.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, 0.0F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("leftarm3", CubeListBuilder.create().texOffs(119, 10).mirror().addBox(-2.0F, 4.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, 0.0F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("leftarm4", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(0.0F, -2.0F, 2.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, 0.0F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(-2.0F, -2.0F, -3.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, 0.0F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("rightarm3", CubeListBuilder.create().texOffs(121, 10).mirror().addBox(1.0F, 6.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, 0.0F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("rightarm4", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(-2.0F, -2.0F, 2.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, 0.0F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("rightarm5", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, 0.0F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("leftarm5", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, 0.0F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("rightarm6", CubeListBuilder.create().texOffs(121, 10).mirror().addBox(-4.0F, 6.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, 0.0F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("leftarm6", CubeListBuilder.create().texOffs(119, 10).mirror().addBox(3.0F, 4.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, 0.0F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("rightarm7", CubeListBuilder.create().texOffs(103, 20).mirror().addBox(-4.0F, 12.0F, 9.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, -1.2217F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("rightarm8", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-3.0F, 0.0F, 10.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, -1.2217F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("rightarm9", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(-2.0F, 0.0F, 9.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, -1.2217F, 0.0F, 2.2689F));

		partdefinition.addOrReplaceChild("leftarm7", CubeListBuilder.create().texOffs(103, 20).mirror().addBox(-2.0F, 12.0F, 9.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, -1.2217F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("leftarm8", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-1.0F, 0.0F, 10.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, -1.2217F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("leftarm9", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(0.0F, 0.0F, 9.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 0.0F, -1.2217F, 0.0F, -2.2689F));

		partdefinition.addOrReplaceChild("rightarm10", CubeListBuilder.create().texOffs(103, 20).mirror().addBox(-4.0F, 12.0F, 9.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, -1.2217F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("rightarm11", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-3.0F, 0.0F, 10.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, -1.2217F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("rightarm12", CubeListBuilder.create().texOffs(121, 10).mirror().addBox(1.0F, 6.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("rightarm13", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(-2.0F, 0.0F, 9.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, -1.2217F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("rightarm14", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(-2.0F, -2.0F, -3.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("rightarm15", CubeListBuilder.create().texOffs(121, 10).mirror().addBox(-4.0F, 6.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("rightarm16", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("rightarm17", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(-2.0F, 0.0F, 14.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, -1.2217F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("rightarm18", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(-2.0F, -2.0F, 2.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("leftarm10", CubeListBuilder.create().texOffs(103, 20).mirror().addBox(-2.0F, 12.0F, 9.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, -1.2217F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm11", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(0.0F, 0.0F, 9.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, -1.2217F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm12", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-1.0F, 0.0F, 10.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, -1.2217F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm13", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(0.0F, -2.0F, -3.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm14", CubeListBuilder.create().texOffs(87, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm15", CubeListBuilder.create().texOffs(119, 10).mirror().addBox(3.0F, 4.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm16", CubeListBuilder.create().texOffs(119, 10).mirror().addBox(-2.0F, 4.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm17", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(0.0F, -2.0F, 2.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm18", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(0.0F, 0.0F, 14.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, -1.2217F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("rightarm19", CubeListBuilder.create().texOffs(103, 20).mirror().addBox(-4.0F, 12.0F, 9.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, -1.2217F, 0.0F, 1.3963F));

		partdefinition.addOrReplaceChild("rightarm20", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(-2.0F, 0.0F, 9.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, -1.2217F, 0.0F, 1.3963F));

		partdefinition.addOrReplaceChild("rightarm21", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.3963F));

		partdefinition.addOrReplaceChild("rightarm22", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-3.0F, 0.0F, 10.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, -1.2217F, 0.0F, 1.3963F));

		partdefinition.addOrReplaceChild("rightarm23", CubeListBuilder.create().texOffs(121, 10).mirror().addBox(-4.0F, 6.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.3963F));

		partdefinition.addOrReplaceChild("rightarm24", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(-2.0F, -2.0F, -3.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.3963F));

		partdefinition.addOrReplaceChild("rightarm25", CubeListBuilder.create().texOffs(121, 10).mirror().addBox(1.0F, 6.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.3963F));

		partdefinition.addOrReplaceChild("rightarm26", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(-2.0F, -2.0F, 2.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.3963F));

		partdefinition.addOrReplaceChild("leftarm19", CubeListBuilder.create().texOffs(103, 20).mirror().addBox(-2.0F, 12.0F, 9.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, -1.2217F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("leftarm20", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("leftarm22", CubeListBuilder.create().texOffs(119, 10).mirror().addBox(3.0F, 4.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("leftarm21", CubeListBuilder.create().texOffs(86, 16).mirror().addBox(-1.0F, 0.0F, 10.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, -1.2217F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("leftarm23", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(0.0F, 0.0F, 14.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, -1.2217F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("leftarm24", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(0.0F, 0.0F, 9.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, -1.2217F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("leftarm25", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(0.0F, -2.0F, 2.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("leftarm26", CubeListBuilder.create().texOffs(119, 10).mirror().addBox(-2.0F, 4.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(72, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, 2.0F));

		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(60, 21).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -6.0F, 2.0F));

		partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -9.0F, 0.0F));

		partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(60, 21).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -6.0F, -2.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(72, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 5.0F, 2.0F));

		partdefinition.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(72, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, -1.0F));

		partdefinition.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(72, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 5.0F, -1.0F));

		partdefinition.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(72, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 1.0F, 2.0F));

		partdefinition.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(72, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 1.0F, 2.0F));

		partdefinition.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(72, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 1.0F, -1.0F));

		partdefinition.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(72, 2).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 1.0F, -1.0F));

		partdefinition.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(60, 21).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -6.0F, -2.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(38, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -8.0F, 0.0F));

		partdefinition.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(0.0F, -15.0F, -3.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("horn3", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-2.0F, -15.0F, 1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		partdefinition.addOrReplaceChild("horn4", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-2.0F, -15.0F, -3.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		partdefinition.addOrReplaceChild("leftarm27", CubeListBuilder.create().texOffs(110, 5).mirror().addBox(0.0F, -2.0F, -3.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.3963F));

		partdefinition.addOrReplaceChild("rightarm27", CubeListBuilder.create().texOffs(95, 2).mirror().addBox(-2.0F, 0.0F, 14.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 0.0F, -1.2217F, 0.0F, 1.3963F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg5.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightleg1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.rightarm1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm7.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm8.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm9.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm10.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm11.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm12.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm13.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm14.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm15.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm16.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm17.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm18.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm19.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm20.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm21.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm22.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.rightarm23.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm24.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm25.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm26.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm27.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;

		this.leftarm1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm3.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm4.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm5.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm6.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm7.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm8.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm9.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm10.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm11.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm12.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm13.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm14.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm15.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm16.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm17.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm18.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm19.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm20.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm21.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm22.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm23.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm24.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - 1.22173F;
		this.leftarm25.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm26.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm27.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		horn1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm25.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm26.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm25.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm26.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm27.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm27.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}