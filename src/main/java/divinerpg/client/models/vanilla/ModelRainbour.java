package divinerpg.client.models.vanilla;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelRainbour<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("rainbour");
    public final ModelPart body, tail1, tail2, head, lwing1, lwing2, lwing3, rwing1, rwing2, rwing3, lhip, rhip;

    public ModelRainbour(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.tail1 = root.getChild("tail1");
        this.tail2 = tail1.getChild("tail2");
        this.head = root.getChild("head");
        this.lwing1 = root.getChild("lwing1");
        this.lwing2 = lwing1.getChild("lwing2");
        this.lwing3 = lwing2.getChild("lwing3");
        this.rwing1 = root.getChild("rwing1");
        this.rwing2 = rwing1.getChild("rwing2");
        this.rwing3 = rwing2.getChild("rwing3");
        this.lhip = root.getChild("lhip");
        this.rhip = root.getChild("rhip");
    }

    public ModelRainbour(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-3.0F, 1.0F, 1.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, 0.0F, 8.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 14.0F, -5.0F));

        PartDefinition tail1 = partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(48, 50).mirror().addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(49, 40).mirror().addBox(-2.0F, -2.0F, 5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 13.0F, 5.5F));

        tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(68, 41).mirror().addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(73, 52).mirror().addBox(-5.5F, -1.0F, 4.0F, 11.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 9.5F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 41).mirror().addBox(-2.0F, -1.2F, -7.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 27).mirror().addBox(-3.0F, -2.0F, -5.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.5F, -5.0F));

        head.addOrReplaceChild("lhorn1_r1", CubeListBuilder.create().texOffs(24, 27).mirror().addBox(-0.5F, -4.0F, -3.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(25, 34).mirror().addBox(-0.5F, -6.0F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(30, 34).mirror().addBox(-6.5F, -6.0F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(30, 27).mirror().addBox(-6.5F, -4.0F, -3.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

        head.addOrReplaceChild("hornything_r1", CubeListBuilder.create().texOffs(49, 0).mirror().addBox(-1.0F, -8.9F, -19.8F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.0F, 5.0F, -0.8029F, 0.0F, 0.0F));

        PartDefinition lwing1 = partdefinition.addOrReplaceChild("lwing1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0.0F, 0.0F, -2.0F, 9.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 12.0F, -3.0F, 0.0F, -0.3665F, 0.0F));

        PartDefinition lwing2 = lwing1.addOrReplaceChild("lwing2", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.01F, 0.0F, 0.0F, 0.5585F, 0.0F));

        lwing2.addOrReplaceChild("lwing3", CubeListBuilder.create().texOffs(0, 50).mirror().addBox(11.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.44F, -0.01F, -0.5F, 0.0F, -0.4538F, 0.0F));

        PartDefinition rwing1 = partdefinition.addOrReplaceChild("rwing1", CubeListBuilder.create().texOffs(33, 18).mirror().addBox(-9.0F, 0.0F, -2.0F, 9.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 12.0F, -3.0F, 0.0F, 0.3665F, 0.0F));

        PartDefinition rwing2 = rwing1.addOrReplaceChild("rwing2", CubeListBuilder.create().texOffs(38, 28).mirror().addBox(-12.0F, 0.0F, 0.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.01F, 0.0F, 0.0F, -0.5585F, 0.0F));

        rwing2.addOrReplaceChild("rwing3", CubeListBuilder.create().texOffs(66, 15).mirror().addBox(-25.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.44F, -0.01F, -0.5F, 0.0F, 0.4538F, 0.0F));

        PartDefinition lhip = partdefinition.addOrReplaceChild("lhip", CubeListBuilder.create().texOffs(73, 28).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 15.0F, 2.0F));

        lhip.addOrReplaceChild("lfoot_r1", CubeListBuilder.create().texOffs(56, 12).mirror().addBox(2.5F, -10.5F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 15.0F, -2.0F, -0.1309F, 0.0F, 0.0F));

        lhip.addOrReplaceChild("lthigh", CubeListBuilder.create().texOffs(99, 29).mirror().addBox(-1.0F, 3.0F, -3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7679F, 0.0F, 0.0F));

        PartDefinition rhip = partdefinition.addOrReplaceChild("rhip", CubeListBuilder.create().texOffs(86, 28).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 15.0F, 2.0F));

        rhip.addOrReplaceChild("rfoot_r1", CubeListBuilder.create().texOffs(61, 12).mirror().addBox(-3.5F, -10.5F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 15.0F, -2.0F, -0.1309F, 0.0F, 0.0F));

        rhip.addOrReplaceChild("rthigh", CubeListBuilder.create().texOffs(39, 1).mirror().addBox(-1.0F, 3.0F, -3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7679F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        head.xRot = headPitch;
        head.yRot = netHeadYaw;

        boolean onGround = true;
        if (!onGround) {
            this.rhip.xRot = 0.3927F;
            this.lhip.xRot = 0.3927F;
        } else {
            this.lhip.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount) - 0.227F;
            this.rhip.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount) - 0.227F;
        }
        this.rwing1.zRot = (float) (Math.cos(ageInTicks * 0.3F) * Math.PI * 0.30F);
        this.lwing1.zRot = (float) (Math.cos(ageInTicks * 0.3F) * Math.PI * -0.30F);
        float t = (float) (Math.cos(limbSwing * 0.3F) * limbSwingAmount / 2);
        this.tail1.xRot = t;
        this.tail2.xRot = t * 2;
    }
}