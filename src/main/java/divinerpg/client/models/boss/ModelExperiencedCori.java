package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntityExperiencedCori;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelExperiencedCori extends EntityModel<EntityExperiencedCori> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("experienced_cori");
	private final ModelPart Head;
	private final ModelPart Tentacle1;
	private final ModelPart Tentacle2;
	private final ModelPart Tentacle3;
	private final ModelPart Tentacle4;
	private final ModelPart Tentacle5;
	private final ModelPart Tentacle6;
	private final ModelPart Tentacle7;
	private final ModelPart Tentacle8;
	private final ModelPart Tentacle9;
	private final ModelPart Tentacle10;
	private final ModelPart Tentacle11;
	private final ModelPart Tentacle12;
	private final ModelPart Tentacle13;
	private final ModelPart Tentacle14;
	private final ModelPart Tentacle15;
	private final ModelPart Tentacle16;
	private final ModelPart Tentacle17;
	private final ModelPart Tentacle18;
	private final ModelPart Tentacle19;
	private final ModelPart Tentacle20;
	private final ModelPart Tentacle21;
	private final ModelPart Tentacle22;
	private final ModelPart Tentacle23;
	private final ModelPart Tentacle24;
	private final ModelPart Tentacle25;
	private final ModelPart Tentacle26;
	private final ModelPart Tentacle27;
	private final ModelPart Tentacle28;
	private final ModelPart Tentacle29;
	private final ModelPart Tentacle30;
	private final ModelPart Tentacle31;
	private final ModelPart Tentacle32;
	private final ModelPart Tentacle33;
	private final ModelPart Tentacle34;
	private final ModelPart Tentacle35;
	private final ModelPart Tentacle36;
	private final ModelPart Tentacle37;
	private final ModelPart Tentacle38;
	private final ModelPart Tentacle39;
	private final ModelPart Tentacle40;
	private final ModelPart Tentacle41;
	private final ModelPart Tentacle42;
	private final ModelPart Tentacle43;
	private final ModelPart Tentacle44;
	private final ModelPart Tentacle45;
	private final ModelPart Tentacle46;
	private final ModelPart Tentacle47;
	private final ModelPart Tentacle48;

	public ModelExperiencedCori(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Tentacle1 = root.getChild("Tentacle1");
		this.Tentacle2 = root.getChild("Tentacle2");
		this.Tentacle3 = root.getChild("Tentacle3");
		this.Tentacle4 = root.getChild("Tentacle4");
		this.Tentacle5 = root.getChild("Tentacle5");
		this.Tentacle6 = root.getChild("Tentacle6");
		this.Tentacle7 = root.getChild("Tentacle7");
		this.Tentacle8 = root.getChild("Tentacle8");
		this.Tentacle9 = root.getChild("Tentacle9");
		this.Tentacle10 = root.getChild("Tentacle10");
		this.Tentacle11 = root.getChild("Tentacle11");
		this.Tentacle12 = root.getChild("Tentacle12");
		this.Tentacle13 = root.getChild("Tentacle13");
		this.Tentacle14 = root.getChild("Tentacle14");
		this.Tentacle15 = root.getChild("Tentacle15");
		this.Tentacle16 = root.getChild("Tentacle16");
		this.Tentacle17 = root.getChild("Tentacle17");
		this.Tentacle18 = root.getChild("Tentacle18");
		this.Tentacle19 = root.getChild("Tentacle19");
		this.Tentacle20 = root.getChild("Tentacle20");
		this.Tentacle21 = root.getChild("Tentacle21");
		this.Tentacle22 = root.getChild("Tentacle22");
		this.Tentacle23 = root.getChild("Tentacle23");
		this.Tentacle24 = root.getChild("Tentacle24");
		this.Tentacle25 = root.getChild("Tentacle25");
		this.Tentacle26 = root.getChild("Tentacle26");
		this.Tentacle27 = root.getChild("Tentacle27");
		this.Tentacle28 = root.getChild("Tentacle28");
		this.Tentacle29 = root.getChild("Tentacle29");
		this.Tentacle30 = root.getChild("Tentacle30");
		this.Tentacle31 = root.getChild("Tentacle31");
		this.Tentacle32 = root.getChild("Tentacle32");
		this.Tentacle33 = root.getChild("Tentacle33");
		this.Tentacle34 = root.getChild("Tentacle34");
		this.Tentacle35 = root.getChild("Tentacle35");
		this.Tentacle36 = root.getChild("Tentacle36");
		this.Tentacle37 = root.getChild("Tentacle37");
		this.Tentacle38 = root.getChild("Tentacle38");
		this.Tentacle39 = root.getChild("Tentacle39");
		this.Tentacle40 = root.getChild("Tentacle40");
		this.Tentacle41 = root.getChild("Tentacle41");
		this.Tentacle42 = root.getChild("Tentacle42");
		this.Tentacle43 = root.getChild("Tentacle43");
		this.Tentacle44 = root.getChild("Tentacle44");
		this.Tentacle45 = root.getChild("Tentacle45");
		this.Tentacle46 = root.getChild("Tentacle46");
		this.Tentacle47 = root.getChild("Tentacle47");
		this.Tentacle48 = root.getChild("Tentacle48");
	}
	public ModelExperiencedCori(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Tentacle1 = root.getChild("Tentacle1");
		this.Tentacle2 = root.getChild("Tentacle2");
		this.Tentacle3 = root.getChild("Tentacle3");
		this.Tentacle4 = root.getChild("Tentacle4");
		this.Tentacle5 = root.getChild("Tentacle5");
		this.Tentacle6 = root.getChild("Tentacle6");
		this.Tentacle7 = root.getChild("Tentacle7");
		this.Tentacle8 = root.getChild("Tentacle8");
		this.Tentacle9 = root.getChild("Tentacle9");
		this.Tentacle10 = root.getChild("Tentacle10");
		this.Tentacle11 = root.getChild("Tentacle11");
		this.Tentacle12 = root.getChild("Tentacle12");
		this.Tentacle13 = root.getChild("Tentacle13");
		this.Tentacle14 = root.getChild("Tentacle14");
		this.Tentacle15 = root.getChild("Tentacle15");
		this.Tentacle16 = root.getChild("Tentacle16");
		this.Tentacle17 = root.getChild("Tentacle17");
		this.Tentacle18 = root.getChild("Tentacle18");
		this.Tentacle19 = root.getChild("Tentacle19");
		this.Tentacle20 = root.getChild("Tentacle20");
		this.Tentacle21 = root.getChild("Tentacle21");
		this.Tentacle22 = root.getChild("Tentacle22");
		this.Tentacle23 = root.getChild("Tentacle23");
		this.Tentacle24 = root.getChild("Tentacle24");
		this.Tentacle25 = root.getChild("Tentacle25");
		this.Tentacle26 = root.getChild("Tentacle26");
		this.Tentacle27 = root.getChild("Tentacle27");
		this.Tentacle28 = root.getChild("Tentacle28");
		this.Tentacle29 = root.getChild("Tentacle29");
		this.Tentacle30 = root.getChild("Tentacle30");
		this.Tentacle31 = root.getChild("Tentacle31");
		this.Tentacle32 = root.getChild("Tentacle32");
		this.Tentacle33 = root.getChild("Tentacle33");
		this.Tentacle34 = root.getChild("Tentacle34");
		this.Tentacle35 = root.getChild("Tentacle35");
		this.Tentacle36 = root.getChild("Tentacle36");
		this.Tentacle37 = root.getChild("Tentacle37");
		this.Tentacle38 = root.getChild("Tentacle38");
		this.Tentacle39 = root.getChild("Tentacle39");
		this.Tentacle40 = root.getChild("Tentacle40");
		this.Tentacle41 = root.getChild("Tentacle41");
		this.Tentacle42 = root.getChild("Tentacle42");
		this.Tentacle43 = root.getChild("Tentacle43");
		this.Tentacle44 = root.getChild("Tentacle44");
		this.Tentacle45 = root.getChild("Tentacle45");
		this.Tentacle46 = root.getChild("Tentacle46");
		this.Tentacle47 = root.getChild("Tentacle47");
		this.Tentacle48 = root.getChild("Tentacle48");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(7.0F, 7.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle2", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, cubedef).mirror(false), PartPose.offset(6.0F, 17.0F, 5.0F));

		partdefinition.addOrReplaceChild("Tentacle3", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(3.0F, 2.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle4", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(9.0F, 14.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle5", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-7.0F, 7.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle6", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(11.0F, 7.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle7", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(11.0F, 15.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle8", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 15.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle9", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 7.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle10", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 14.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle11", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-7.0F, 15.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle12", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(7.0F, 15.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle13", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, cubedef).mirror(false), PartPose.offset(3.0F, 6.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle14", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 17.0F, 5.0F));

		partdefinition.addOrReplaceChild("Tentacle15", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, cubedef).mirror(false), PartPose.offset(6.0F, 6.0F, 5.0F));

		partdefinition.addOrReplaceChild("Tentacle16", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-6.0F, 6.0F, 5.0F));

		partdefinition.addOrReplaceChild("Tentacle17", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle18", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, cubedef).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle19", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, 2.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle20", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 6.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle21", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(3.0F, 20.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle22", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, cubedef).mirror(false), PartPose.offset(3.0F, 19.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle23", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, 20.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle24", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 19.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle25", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle26", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, cubedef).mirror(false), PartPose.offset(0.0F, 19.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle27", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 14.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle28", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 14.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle29", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle30", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 2.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle31", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 20.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle32", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 20.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle33", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-6.0F, 2.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle34", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle35", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-6.0F, 20.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle36", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 20.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle37", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 11.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle38", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 11.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle39", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle40", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(9.0F, 11.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle41", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 8.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle42", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-5.0F, 8.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle43", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle44", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(9.0F, 8.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle45", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(9.0F, 2.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle46", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(9.0F, 20.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle47", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, 2.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		partdefinition.addOrReplaceChild("Tentacle48", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, 20.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityExperiencedCori entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle25.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle26.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle27.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle28.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle29.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle30.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle31.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle32.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle33.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle34.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle35.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle36.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle37.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle38.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle39.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle40.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle41.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle42.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle43.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle44.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle45.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle46.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle47.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tentacle48.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}