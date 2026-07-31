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

public class ModelHellSpider<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("hell_spider");
    public final ModelPart Body;
    public final ModelPart Leg8;
    public final ModelPart Leg6;
    public final ModelPart Leg4;
    public final ModelPart Leg2;
    public final ModelPart Leg7;
    public final ModelPart Leg5;
    public final ModelPart Leg3;
    public final ModelPart Leg1;
    public final ModelPart Head;

    public ModelHellSpider(ModelPart root) {
        super(root);
        this.Body = root.getChild("Body");
        this.Leg8 = root.getChild("Leg8");
        this.Leg6 = root.getChild("Leg6");
        this.Leg4 = root.getChild("Leg4");
        this.Leg2 = root.getChild("Leg2");
        this.Leg7 = root.getChild("Leg7");
        this.Leg5 = root.getChild("Leg5");
        this.Leg3 = root.getChild("Leg3");
        this.Leg1 = root.getChild("Leg1");
        this.Head = root.getChild("Head");
    }

    public ModelHellSpider(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 12).mirror().addBox(-5.0F, -4.0F, 3.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, 0.0F));

        Body.addOrReplaceChild("Shape1_r1", CubeListBuilder.create().texOffs(15, 9).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, 14.0F, -0.4363F, 0.0F, 0.0F));

        Body.addOrReplaceChild("Shape4_r1", CubeListBuilder.create().texOffs(15, 9).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, 10.0F, -0.4363F, 0.0F, 0.0F));

        Body.addOrReplaceChild("Shape2_r1", CubeListBuilder.create().texOffs(15, 9).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, 2.0F, -0.4363F, 0.0F, 0.0F));

        Body.addOrReplaceChild("Shape3_r1", CubeListBuilder.create().texOffs(15, 9).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, 6.0F, -0.4363F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("Leg8", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 16.0F, -1.0F, 0.0F, 0.576F, 0.192F));

        partdefinition.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 16.0F, 0.0F, 0.0F, 0.2793F, 0.192F));

        partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 16.0F, 1.0F, 0.0F, -0.2793F, 0.192F));

        partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 16.0F, 2.0F, 0.0F, -0.576F, 0.192F));

        partdefinition.addOrReplaceChild("Leg7", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 16.0F, -1.0F, 0.0F, -0.576F, -0.192F));

        partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 16.0F, 0.0F, 0.0F, -0.2793F, -0.192F));

        partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 16.0F, 1.0F, 0.0F, 0.2793F, -0.192F));

        partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 16.0F, 2.0F, 0.0F, 0.576F, -0.192F));

        partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 16).mirror().addBox(4.0F, -6.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 16).mirror().addBox(-5.0F, -6.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 4).mirror().addBox(-5.0F, -8.0F, -8.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 4).mirror().addBox(4.0F, -8.0F, -8.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 4).mirror().addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, -3.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        this.Head.yRot = netHeadYaw;
        this.Head.xRot = headPitch;

        float var8 = ((float) Math.PI / 4F);
        this.Leg1.zRot = -var8;
        this.Leg2.zRot = var8;
        this.Leg3.zRot = -var8 * 0.74F;
        this.Leg4.zRot = var8 * 0.74F;
        this.Leg5.zRot = -var8 * 0.74F;
        this.Leg6.zRot = var8 * 0.74F;
        this.Leg7.zRot = -var8;
        this.Leg8.zRot = var8;
        float var9 = -0.0F;
        float var10 = 0.3926991F;
        this.Leg1.yRot = var10 * 2.0F + var9;
        this.Leg2.yRot = -var10 * 2.0F - var9;
        this.Leg3.yRot = var10 * 1.0F + var9;
        this.Leg4.yRot = -var10 * 1.0F - var9;
        this.Leg5.yRot = -var10 * 1.0F + var9;
        this.Leg6.yRot = var10 * 1.0F - var9;
        this.Leg7.yRot = -var10 * 2.0F + var9;
        this.Leg8.yRot = var10 * 2.0F - var9;
        float var11 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount);
        float var12 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + Math.PI) * 0.4F) * limbSwingAmount);
        float var13 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + (Math.PI / 2F)) * 0.4F) * limbSwingAmount);
        float var14 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + (Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount);
        float var15 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount);
        float var16 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + Math.PI) * 0.4F) * limbSwingAmount);
        float var17 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + (Math.PI / 2F)) * 0.4F) * limbSwingAmount);
        float var18 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + (Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount);
        this.Leg1.yRot += var11;
        this.Leg2.yRot += -var11;
        this.Leg3.yRot += var12;
        this.Leg4.yRot += -var12;
        this.Leg5.yRot += var13;
        this.Leg6.yRot += -var13;
        this.Leg7.yRot += var14;
        this.Leg8.yRot += -var14;
        this.Leg1.zRot += var15;
        this.Leg2.zRot += -var15;
        this.Leg3.zRot += var16;
        this.Leg4.zRot += -var16;
        this.Leg5.zRot += var17;
        this.Leg6.zRot += -var17;
        this.Leg7.zRot += var18;
        this.Leg8.zRot += -var18;
    }
}