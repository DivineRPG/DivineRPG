package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelTwilightArcher<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("twilight_archer");
	private final ModelPart head;
	private final ModelPart body1;
	private final ModelPart rightarmext;
	private final ModelPart leftfoot;
	private final ModelPart bodymain;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;
	private final ModelPart body6;
	private final ModelPart body5;
	public final ModelPart rightarm;
	private final ModelPart rightarmcap;
	private final ModelPart leftarm;
	private final ModelPart leftarmext;
	private final ModelPart leftarmcap;
	private final ModelPart leftleg;
	private final ModelPart leftlegcap;
	private final ModelPart rightfoot;
	private final ModelPart rightleg;
	private final ModelPart rightlegcap;
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;
	private final ModelPart Shape5;
	private final ModelPart Shape6;
	private final ModelPart Shape7;
	private final ModelPart Shape8;
	private final ModelPart Shape9;
	private final ModelPart Shape10;
	private final ModelPart Shape11;
	private final ModelPart Shape12;
	private final ModelPart Shape13;
	private final ModelPart Shape14;
	private final ModelPart Shape15;
	private final ModelPart Shape16;
	private final ModelPart Shape17;
	private final ModelPart Shape18;
	private final ModelPart Shape19;
	private final ModelPart Shape20;
	private final ModelPart body12;
	private final ModelPart body7;
	private final ModelPart body8;
	private final ModelPart body9;
	private final ModelPart body10;
	private final ModelPart body11;
	private final ModelPart head2;
	private final ModelPart Shape21;
	private final ModelPart Shape22;
	private final ModelPart Shape23;
	private final ModelPart Shape24;
	private final ModelPart Shape25;
	private final ModelPart Shape26;
	private final ModelPart Shape27;
	private final ModelPart Shape28;
	private final ModelPart Shape29;
	private final ModelPart Shape30;
	private final ModelPart Shape31;
	private final ModelPart Shape32;
	private final ModelPart Shape33;
	private final ModelPart Shape34;
	private final ModelPart Shape35;
	private final ModelPart Shape36;
	private final ModelPart Shape37;
	private final ModelPart Shape38;
	private final ModelPart Shape39;
	private final ModelPart Shape40;

	public ModelTwilightArcher(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body1 = root.getChild("body1");
		this.rightarmext = root.getChild("rightarmext");
		this.leftfoot = root.getChild("leftfoot");
		this.bodymain = root.getChild("bodymain");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.body4 = root.getChild("body4");
		this.body6 = root.getChild("body6");
		this.body5 = root.getChild("body5");
		this.rightarm = root.getChild("rightarm");
		this.rightarmcap = root.getChild("rightarmcap");
		this.leftarm = root.getChild("leftarm");
		this.leftarmext = root.getChild("leftarmext");
		this.leftarmcap = root.getChild("leftarmcap");
		this.leftleg = root.getChild("leftleg");
		this.leftlegcap = root.getChild("leftlegcap");
		this.rightfoot = root.getChild("rightfoot");
		this.rightleg = root.getChild("rightleg");
		this.rightlegcap = root.getChild("rightlegcap");
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape6 = root.getChild("Shape6");
		this.Shape7 = root.getChild("Shape7");
		this.Shape8 = root.getChild("Shape8");
		this.Shape9 = root.getChild("Shape9");
		this.Shape10 = root.getChild("Shape10");
		this.Shape11 = root.getChild("Shape11");
		this.Shape12 = root.getChild("Shape12");
		this.Shape13 = root.getChild("Shape13");
		this.Shape14 = root.getChild("Shape14");
		this.Shape15 = root.getChild("Shape15");
		this.Shape16 = root.getChild("Shape16");
		this.Shape17 = root.getChild("Shape17");
		this.Shape18 = root.getChild("Shape18");
		this.Shape19 = root.getChild("Shape19");
		this.Shape20 = root.getChild("Shape20");
		this.body12 = root.getChild("body12");
		this.body7 = root.getChild("body7");
		this.body8 = root.getChild("body8");
		this.body9 = root.getChild("body9");
		this.body10 = root.getChild("body10");
		this.body11 = root.getChild("body11");
		this.head2 = root.getChild("head2");
		this.Shape21 = root.getChild("Shape21");
		this.Shape22 = root.getChild("Shape22");
		this.Shape23 = root.getChild("Shape23");
		this.Shape24 = root.getChild("Shape24");
		this.Shape25 = root.getChild("Shape25");
		this.Shape26 = root.getChild("Shape26");
		this.Shape27 = root.getChild("Shape27");
		this.Shape28 = root.getChild("Shape28");
		this.Shape29 = root.getChild("Shape29");
		this.Shape30 = root.getChild("Shape30");
		this.Shape31 = root.getChild("Shape31");
		this.Shape32 = root.getChild("Shape32");
		this.Shape33 = root.getChild("Shape33");
		this.Shape34 = root.getChild("Shape34");
		this.Shape35 = root.getChild("Shape35");
		this.Shape36 = root.getChild("Shape36");
		this.Shape37 = root.getChild("Shape37");
		this.Shape38 = root.getChild("Shape38");
		this.Shape39 = root.getChild("Shape39");
		this.Shape40 = root.getChild("Shape40");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -16.0F, -19.0F));

		partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -12.0F, -2.0F));

		partdefinition.addOrReplaceChild("rightarmext", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(-7.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, -16.0F, -6.0F));

		partdefinition.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(28, 15).mirror().addBox(-3.0F, 17.0F, -9.0F, 6.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodymain", CubeListBuilder.create().texOffs(28, 10).mirror().addBox(-4.0F, 0.0F, -2.0F, 14.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -21.0F, -14.0F));

		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -21.0F, -16.0F));

		partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -14.0F, -3.0F));

		partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -18.0F, -7.0F));

		partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -19.0F, -9.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(-11.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, -16.0F, -6.0F));

		partdefinition.addOrReplaceChild("rightarmcap", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(-12.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, -16.0F, -6.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(7.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, -16.0F, -7.0F));

		partdefinition.addOrReplaceChild("leftarmext", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(-1.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, -16.0F, -7.0F));

		partdefinition.addOrReplaceChild("leftarmcap", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(6.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, -16.0F, -7.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegcap", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(28, 15).mirror().addBox(-3.0F, 17.0F, -9.0F, 6.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegcap", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -31.0F, -13.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -29.0F, -11.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -27.0F, -9.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -8.0F, 8.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -5.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(5.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, -24.0F, -2.0F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(5.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, -25.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(6.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, -20.0F, 3.0F));

		partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -12.0F, 7.0F));

		partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -15.0F, 6.0F));

		partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -18.0F, 5.0F));

		partdefinition.addOrReplaceChild("Shape12", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 10.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 8.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape14", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 6.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape15", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 4.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape16", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape17", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 0.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape18", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -2.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape19", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -26.0F, -6.0F));

		partdefinition.addOrReplaceChild("Shape20", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(6.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, -22.0F, 1.0F));

		partdefinition.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -21.0F, -14.0F));

		partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -19.0F, -9.0F));

		partdefinition.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -18.0F, -7.0F));

		partdefinition.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -14.0F, -3.0F));

		partdefinition.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -12.0F, -2.0F));

		partdefinition.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -21.0F, -16.0F));

		partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -16.0F, -19.0F));

		partdefinition.addOrReplaceChild("Shape21", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -31.0F, -13.0F));

		partdefinition.addOrReplaceChild("Shape22", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -29.0F, -11.0F));

		partdefinition.addOrReplaceChild("Shape23", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -27.0F, -9.0F));

		partdefinition.addOrReplaceChild("Shape24", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -26.0F, -6.0F));

		partdefinition.addOrReplaceChild("Shape25", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(5.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -25.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape26", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(5.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -24.0F, -2.0F));

		partdefinition.addOrReplaceChild("Shape27", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(6.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -22.0F, 1.0F));

		partdefinition.addOrReplaceChild("Shape28", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(6.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -20.0F, 3.0F));

		partdefinition.addOrReplaceChild("Shape29", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -18.0F, 5.0F));

		partdefinition.addOrReplaceChild("Shape30", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -15.0F, 6.0F));

		partdefinition.addOrReplaceChild("Shape31", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 7.0F));

		partdefinition.addOrReplaceChild("Shape32", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -8.0F, 8.0F));

		partdefinition.addOrReplaceChild("Shape33", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -5.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape34", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -2.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape35", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape36", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 2.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape37", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 4.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape38", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 6.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape39", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 8.0F, 10.0F));

		partdefinition.addOrReplaceChild("Shape40", CubeListBuilder.create().texOffs(35, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 10.0F, 10.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = (netHeadYaw / 57.295776F);
		this.head.xRot = (headPitch / 57.295776F);
		this.head2.yRot = (netHeadYaw / 57.295776F);
		this.head2.xRot = (headPitch / 57.295776F);

		this.rightarm.xRot = (Mth.cos(limbSwing * 0.6662F + 3.141593F) * 2.0F * limbSwingAmount * 0.5F);
		this.rightarmcap.xRot = (Mth.cos(limbSwing * 0.6662F + 3.141593F) * 2.0F * limbSwingAmount * 0.5F);
		this.rightarmext.xRot = (Mth.cos(limbSwing * 0.6662F + 3.141593F) * 2.0F * limbSwingAmount * 0.5F);

		this.leftarm.xRot = (Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
		this.leftarmcap.xRot = (Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
		this.leftarmext.xRot = (Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);

		this.rightarm.zRot = 0.0F;
		this.rightarmcap.zRot = 0.0F;
		this.rightarmext.zRot = 0.0F;

		this.leftarm.zRot = 0.0F;
		this.leftarmcap.zRot = 0.0F;
		this.leftarmext.zRot = 0.0F;

		this.rightleg.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.rightlegcap.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.rightfoot.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);

		this.leftleg.xRot = (Mth.cos((float) (limbSwing * 0.6662F + 3.141592653589793D)) * 1.4F * limbSwingAmount);
		this.leftlegcap.xRot = (Mth.cos((float) (limbSwing * 0.6662F + 3.141592653589793D)) * 1.4F * limbSwingAmount);
		this.leftfoot.xRot = (Mth.cos((float) (limbSwing * 0.6662F + 3.141592653589793D)) * 1.4F * limbSwingAmount);

		this.rightleg.yRot = 0.0F;
		this.rightlegcap.yRot = 0.0F;
		this.rightfoot.yRot = 0.0F;

		this.leftleg.yRot = 0.0F;
		this.leftlegcap.yRot = 0.0F;
		this.leftfoot.yRot = 0.0F;

		this.rightarm.yRot = 0.0F;
		this.rightarmcap.yRot = 0.0F;
		this.rightarmext.yRot = 0.0F;

		this.leftarm.yRot = 0.0F;
		this.leftarmcap.yRot = 0.0F;
		this.leftarmext.yRot = 0.0F;

		this.rightarm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightarmcap.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightarmext.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;

		this.leftarm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftarmcap.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftarmext.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;

		this.rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.rightarmcap.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.rightarmext.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;

		this.leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftarmcap.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftarmext.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmext.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftfoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bodymain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmcap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmext.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmcap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegcap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightfoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegcap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape25.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape26.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape27.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape28.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape29.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape30.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape31.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape32.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape33.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape34.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape35.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape36.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape37.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape38.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape39.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape40.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}