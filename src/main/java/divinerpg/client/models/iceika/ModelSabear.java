package divinerpg.client.models.iceika;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelSabear<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("sabear");
    public final ModelPart rearLeftLeg;
    public final ModelPart frontLeftLeg;
    public final ModelPart rearRightLeg;
    public final ModelPart frontRightLeg;
    public final ModelPart head;
    public final ModelPart body;

    public ModelSabear(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.rearLeftLeg = rootPart.getChild("RearLeftLeg");
        this.frontLeftLeg = rootPart.getChild("FrontLeftLeg");
        this.rearRightLeg = rootPart.getChild("RearRightLeg");
        this.frontRightLeg = rootPart.getChild("FrontRightLeg");
        this.head = rootPart.getChild("Head");
        this.body = rootPart.getChild("body");
    }

    public ModelSabear(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(22, 49).addBox(-2.0F, -1.0F, -4.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 14.0F, -4.0F));

        root.addOrReplaceChild("RearLeftLeg", CubeListBuilder.create().texOffs(48, 18).addBox(-2.5F, 0.5F, -4.0F, 5.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 12.5F, 12.0F));

        root.addOrReplaceChild("RearRightLeg", CubeListBuilder.create().texOffs(44, 41).addBox(-2.5F, 0.5F, -4.0F, 5.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 12.5F, 12.0F));

        root.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 49).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 14.5F, -5.0F));

        PartDefinition Head = root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 67).addBox(-3.0F, 3.25F, -10.8333F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 67).addBox(2.0F, 3.25F, -10.8333F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 60).addBox(-3.0F, -1.75F, -10.8333F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(42, 0).addBox(-5.0F, -4.75F, -6.8333F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(-6.0F, -5.75F, -4.8333F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 9).addBox(4.0F, -5.75F, -4.8333F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.75F, -7.1667F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 26).addBox(-7.0F, -22.0F, -8.0F, 14.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.0F, -23.0F, 4.0F, 14.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * ((float)Math.PI / 180F);
        this.head.xRot = state.xRot * ((float)Math.PI / 180F);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.frontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rearLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.frontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rearRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}