package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelHastreus<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("hastreus");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart plate1;
	private final ModelPart plate2;
	private final ModelPart plate3;
	private final ModelPart plate4;
	private final ModelPart horn1;
	private final ModelPart horn2;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;
	private final ModelPart head2;
	private final ModelPart horn3;
	private final ModelPart horn4;
	private final ModelPart connector1;
	private final ModelPart connector2;
	private final ModelPart connector3;
	private final ModelPart connector4;
	private final ModelPart horn5;
	private final ModelPart horn6;
	private final ModelPart horn7;
	private final ModelPart horn8;
	private final ModelPart leg4;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg1;
	private final ModelPart leg3cap;
	private final ModelPart leg1cap;
	private final ModelPart leg4cap;
	private final ModelPart leg2cap;
	private final ModelPart body5;
	private final ModelPart body6;
	private final ModelPart body7;
	private final ModelPart body8;
	private final ModelPart body9;
	private final ModelPart body10;
	private final ModelPart body11;
	private final ModelPart body12;
	private final ModelPart body13;
	private final ModelPart body14;
	private final ModelPart body15;
	private final ModelPart body16;
	private final ModelPart body17;
	private final ModelPart body18;
	private final ModelPart body19;
	private final ModelPart body20;
	private final ModelPart body21;
	private final ModelPart body22;
	private final ModelPart body31;
	private final ModelPart body23;
	private final ModelPart body24;
	private final ModelPart body25;
	private final ModelPart body26;
	private final ModelPart body27;
	private final ModelPart body28;
	private final ModelPart body29;
	private final ModelPart body30;

	public ModelHastreus(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.plate1 = root.getChild("plate1");
		this.plate2 = root.getChild("plate2");
		this.plate3 = root.getChild("plate3");
		this.plate4 = root.getChild("plate4");
		this.horn1 = root.getChild("horn1");
		this.horn2 = root.getChild("horn2");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.body4 = root.getChild("body4");
		this.head2 = root.getChild("head2");
		this.horn3 = root.getChild("horn3");
		this.horn4 = root.getChild("horn4");
		this.connector1 = root.getChild("connector1");
		this.connector2 = root.getChild("connector2");
		this.connector3 = root.getChild("connector3");
		this.connector4 = root.getChild("connector4");
		this.horn5 = root.getChild("horn5");
		this.horn6 = root.getChild("horn6");
		this.horn7 = root.getChild("horn7");
		this.horn8 = root.getChild("horn8");
		this.leg4 = root.getChild("leg4");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg1 = root.getChild("leg1");
		this.leg3cap = root.getChild("leg3cap");
		this.leg1cap = root.getChild("leg1cap");
		this.leg4cap = root.getChild("leg4cap");
		this.leg2cap = root.getChild("leg2cap");
		this.body5 = root.getChild("body5");
		this.body6 = root.getChild("body6");
		this.body7 = root.getChild("body7");
		this.body8 = root.getChild("body8");
		this.body9 = root.getChild("body9");
		this.body10 = root.getChild("body10");
		this.body11 = root.getChild("body11");
		this.body12 = root.getChild("body12");
		this.body13 = root.getChild("body13");
		this.body14 = root.getChild("body14");
		this.body15 = root.getChild("body15");
		this.body16 = root.getChild("body16");
		this.body17 = root.getChild("body17");
		this.body18 = root.getChild("body18");
		this.body19 = root.getChild("body19");
		this.body20 = root.getChild("body20");
		this.body21 = root.getChild("body21");
		this.body22 = root.getChild("body22");
		this.body31 = root.getChild("body31");
		this.body23 = root.getChild("body23");
		this.body24 = root.getChild("body24");
		this.body25 = root.getChild("body25");
		this.body26 = root.getChild("body26");
		this.body27 = root.getChild("body27");
		this.body28 = root.getChild("body28");
		this.body29 = root.getChild("body29");
		this.body30 = root.getChild("body30");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 4.0F, -8.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 5.0F, 20.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("plate1", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(3.0F, -4.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.0F, 12.0F, 24.0F));

		partdefinition.addOrReplaceChild("plate2", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(-4.0F, -4.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(17.0F, 12.0F, 24.0F));

		partdefinition.addOrReplaceChild("plate3", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(3.0F, -4.0F, -4.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.0F, 12.0F, -5.0F));

		partdefinition.addOrReplaceChild("plate4", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(-4.0F, -4.0F, -4.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(17.0F, 12.0F, -5.0F));

		partdefinition.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 2.0F, -9.0F));

		partdefinition.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(3.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 2.0F, -9.0F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 5.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 5.0F, 20.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(30, 9).mirror().addBox(-4.0F, -8.0F, 0.0F, 2.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, 8.0F, 24.0F, -2.5307F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 4.0F, -8.0F));

		partdefinition.addOrReplaceChild("horn3", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 2.0F, -9.0F));

		partdefinition.addOrReplaceChild("horn4", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(3.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 2.0F, -9.0F));

		partdefinition.addOrReplaceChild("connector1", CubeListBuilder.create().texOffs(28, 17).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 9.0F, 22.0F));

		partdefinition.addOrReplaceChild("connector2", CubeListBuilder.create().texOffs(28, 17).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 9.0F, -8.0F));

		partdefinition.addOrReplaceChild("connector3", CubeListBuilder.create().texOffs(28, 17).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-20.0F, 9.0F, 22.0F));

		partdefinition.addOrReplaceChild("connector4", CubeListBuilder.create().texOffs(28, 17).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-20.0F, 9.0F, -8.0F));

		partdefinition.addOrReplaceChild("horn5", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(3.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 2.0F, -7.0F));

		partdefinition.addOrReplaceChild("horn6", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 2.0F, -7.0F));

		partdefinition.addOrReplaceChild("horn7", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 2.0F, -7.0F));

		partdefinition.addOrReplaceChild("horn8", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(3.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 2.0F, -7.0F));

		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(17.0F, 12.0F, -5.0F));

		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(17.0F, 12.0F, 24.0F));

		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.0F, 12.0F, -5.0F));

		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.0F, 12.0F, 24.0F));

		partdefinition.addOrReplaceChild("leg3cap", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(-4.0F, -4.0F, -4.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.0F, 12.0F, -5.0F));

		partdefinition.addOrReplaceChild("leg1cap", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(-4.0F, -4.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.0F, 12.0F, 24.0F));

		partdefinition.addOrReplaceChild("leg4cap", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(-2.0F, -4.0F, -4.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(17.0F, 12.0F, -5.0F));

		partdefinition.addOrReplaceChild("leg2cap", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(-2.0F, -4.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(17.0F, 12.0F, 24.0F));

		partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 5.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-13.0F, -10.0F, -2.0F, 4.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -2.0F, 24.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(30, 9).mirror().addBox(-4.0F, -8.0F, 0.0F, 2.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, 8.0F, 13.0F, -2.5307F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -2.0F, 24.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -2.0F, 2.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -2.0F, 13.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(30, 9).mirror().addBox(-4.0F, -8.0F, 0.0F, 2.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, 8.0F, 2.0F, -2.5307F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-13.0F, -10.0F, -2.0F, 4.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -2.0F, 2.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-13.0F, -10.0F, -2.0F, 4.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -2.0F, 13.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -2.0F, 2.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body15", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -2.0F, 13.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body16", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -2.0F, 24.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-13.0F, -10.0F, -2.0F, 3.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -2.0F, 2.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body18", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-13.0F, -10.0F, -2.0F, 3.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -2.0F, 13.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body19", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-13.0F, -10.0F, -2.0F, 3.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -2.0F, 24.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body20", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -2.0F, 13.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body21", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-4.0F, -9.0F, -2.0F, 1.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -3.0F, 20.0F, 2.5307F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("body22", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -2.0F, 24.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body31", CubeListBuilder.create().texOffs(30, 9).mirror().addBox(-4.0F, -8.0F, 0.0F, 2.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 8.0F, 13.0F, 2.5307F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("body23", CubeListBuilder.create().texOffs(30, 9).mirror().addBox(-4.0F, -8.0F, 0.0F, 2.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 8.0F, 24.0F, 2.5307F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("body24", CubeListBuilder.create().texOffs(30, 9).mirror().addBox(-4.0F, -8.0F, 0.0F, 2.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 8.0F, 2.0F, 2.5307F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("body25", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -10.0F, -2.0F, 3.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -2.0F, 2.0F, 2.5307F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body26", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-4.0F, -9.0F, -2.0F, 1.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -3.0F, -2.0F, 2.5307F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("body27", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-4.0F, -9.0F, -2.0F, 1.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -3.0F, 9.0F, 2.5307F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("body28", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-4.0F, -9.0F, -2.0F, 1.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, -3.0F, 5.0F, 2.5307F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("body29", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-4.0F, -9.0F, -2.0F, 1.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, -3.0F, 16.0F, 2.5307F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("body30", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-4.0F, -9.0F, -2.0F, 1.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, -3.0F, 27.0F, 2.5307F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.leg1cap.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2cap.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg3cap.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg4cap.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		plate1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		plate2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		plate3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		plate4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		connector1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		connector2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		connector3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		connector4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		horn8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3cap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1cap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4cap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2cap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body31.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body25.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body26.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body27.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body28.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body29.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body30.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}