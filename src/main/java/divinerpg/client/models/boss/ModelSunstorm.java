package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.client.models.state.SunstormRenderState;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

import static divinerpg.utils.Utils.createLocation;

public class ModelSunstorm<S extends SunstormRenderState> extends HumanoidModel<S> implements ArmedModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("sunstorm");

    public final ModelPart rightSoul;
    public final ModelPart middleSoul;
    public final ModelPart leftSoul;
    public final ModelPart hip;

    public ModelSunstorm(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelSunstorm(ModelPart root) {
        super(root);
        this.rightSoul = this.body.getChild("right_soul");
        this.middleSoul = this.body.getChild("middle_soul");
        this.leftSoul = this.body.getChild("left_soul");
        this.hip = root.getChild("hip");
    }

    public static LayerDefinition createBodyLayer() {
        CubeDeformation cubeDef = CubeDeformation.NONE;
        MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDef, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 106).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 15.0F, 3.0F, cubeDef), PartPose.offset(0.0F, -21.0F, -5.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -23.0F, -6.0F, 24.0F, 22.0F, 18.0F, cubeDef), PartPose.offset(0.0F, -8.0F, 0.0F));
        body.addOrReplaceChild("middle_soul", CubeListBuilder.create().texOffs(61, 40).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 9.0F, 2.0F, cubeDef), PartPose.offsetAndRotation(0.0F, -28.0F, -8.0F, -Mth.PI / 7.2F, 0.0F, 0.0F));
        body.addOrReplaceChild("right_soul", CubeListBuilder.create().texOffs(45, 40).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 9.0F, 2.0F, cubeDef), PartPose.offsetAndRotation(-10.0F, -24.0F, -8.0F, -Mth.PI / 9.0F, 0.0F, -Mth.PI / 6.0F));
        body.addOrReplaceChild("left_soul", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 9.0F, 2.0F, cubeDef), PartPose.offsetAndRotation(10.0F, -24.0F, -8.0F, -Mth.PI / 9.0F, 0.0F, Mth.PI / 6.0F));

        PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(104, 103).addBox(-9.0F, 1.0F, -4.0F, 8.0F, 10.0F, 8.0F, cubeDef)
                .texOffs(30, 86).addBox(-12.0F, -7.0F, -6.0F, 12.0F, 8.0F, 12.0F, cubeDef), PartPose.offset(-12.0F, -23.0F, 2.0F));
        rightArm.addOrReplaceChild("right_cannon", CubeListBuilder.create().texOffs(0, 64).addBox(-5.0F, 0.0F, -4.0F, 10.0F, 22.0F, 11.0F, cubeDef), PartPose.offset(-5.0F, 10.0F, -1.0F));

        PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(84, 0).addBox(0.0F, -7.0F, -6.0F, 12.0F, 8.0F, 12.0F, cubeDef)
                .texOffs(89, 57).addBox(1.0F, 1.0F, -4.0F, 8.0F, 10.0F, 8.0F, cubeDef), PartPose.offset(12.0F, -23.0F, 2.0F));
        leftArm.addOrReplaceChild("left_cannon", CubeListBuilder.create().texOffs(47, 53).addBox(-5.0F, 0.0F, -4.0F, 10.0F, 22.0F, 11.0F, cubeDef), PartPose.offset(5.0F, 10.0F, -1.0F));

        partdefinition.addOrReplaceChild("hip", CubeListBuilder.create().texOffs(0, 40).addBox(-8.0F, -2.0F, -4.0F, 16.0F, 11.0F, 13.0F, cubeDef), PartPose.offset(0.0F, -9.0F, 0.0F));

        PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 98).addBox(-6.0F, 0.0F, -3.0F, 9.0F, 12.0F, 8.0F, cubeDef), PartPose.offset(-5.0F, -4.0F, 1.0F));
        rightLeg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(79, 76).addBox(-5.0F, 0.0F, -4.0F, 11.0F, 17.0F, 10.0F, cubeDef), PartPose.offset(-2.0F, 11.0F, 0.0F));

        PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(70, 103).addBox(-3.0F, 0.0F, -3.0F, 9.0F, 12.0F, 8.0F, cubeDef), PartPose.offset(5.0F, -4.0F, 1.0F));
        leftLeg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(78, 30).addBox(-6.0F, 0.0F, -4.0F, 11.0F, 17.0F, 10.0F, cubeDef), PartPose.offset(2.0F, 11.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.rightSoul.visible = state.hasRightSoul;
        this.leftSoul.visible = state.hasLeftSoul;
        this.middleSoul.visible = state.hasMiddleSoul;

        this.head.xRot = 0.0F;
        this.head.yRot = 0.0F;
        this.head.y = -21.0F;
        this.hat.y = -21.0F;
        this.body.y = -8.0F;

        this.rightArm.x = -12.0F;
        this.leftArm.x = -this.rightArm.x;
        this.rightArm.y = -23.0F;
        this.leftArm.y = -23.0F;
        this.rightArm.z = 2.0F;
        this.leftArm.z = 2.0F;

        this.rightLeg.y = -4.0F;
        this.leftLeg.y = -4.0F;
        this.rightLeg.z = 1.0F;
        this.leftLeg.z = 1.0F;
    }

    @Override
    public void translateToHand(S state, HumanoidArm arm, PoseStack poseStack) {
        this.getArm(arm).translateAndRotate(poseStack);
    }
}