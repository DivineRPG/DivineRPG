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
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelGrizzle<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("grizzle");
    public final ModelPart leg1;
    public final ModelPart leg2;
    public final ModelPart leg4;
    public final ModelPart leg3;
    public final ModelPart body;
    public final ModelPart head;

    public ModelGrizzle(ModelPart root) {
        super(root);
        body = root.getChild("body");
        head = root.getChild("head");
        leg1 = root.getChild("leg1");
        leg2 = root.getChild("leg2");
        leg3 = root.getChild("leg3");
        leg4 = root.getChild("leg4");
    }

    public ModelGrizzle(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6F, -12F, -9F, 16F, 13F, 13F, CubeDeformation.NONE)
                .texOffs(0, 26).addBox(-5F, -23F, -8F, 14F, 11F, 11F, CubeDeformation.NONE), PartPose.offsetAndRotation(-2F, 9F, 12F, 1.5708F, 0F, 0F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 48).addBox(-5F, -3F, -3F, 10F, 8F, 8F, CubeDeformation.NONE)
                .texOffs(50, 37).addBox(-3F, 1F, -7F, 6F, 4F, 4F, CubeDeformation.NONE)
                .texOffs(51, 45).addBox(3F, -5F, 0F, 3F, 4F, 1F, CubeDeformation.NONE)
                .texOffs(51, 45).mirror().addBox(-6F, -5F, 0F, 3F, 4F, 1F, CubeDeformation.NONE).mirror(false), PartPose.offset(0F, 10F, -16F));

        partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(50, 26).addBox(-3F, 2F, -2.5F, 5F, 6F, 5F, CubeDeformation.NONE), PartPose.offset(-4.5F, 16F, 10F));

        partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(50, 26).mirror().addBox(-2F, 2F, -2.5F, 5F, 6F, 5F, CubeDeformation.NONE).mirror(false), PartPose.offset(4.5F, 16F, 10F));

        partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(36, 48).addBox(-3F, 1F, -2.5F, 5F, 7F, 5F, CubeDeformation.NONE), PartPose.offset(-3.5F, 16F, -8F));

        partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(36, 48).mirror().addBox(-2F, 1F, -2.5F, 5F, 7F, 5F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.5F, 16F, -8F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        head.xRot = headPitch;
        head.yRot = netHeadYaw;

        leg1.xRot = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
        leg4.xRot = leg1.xRot;
        leg2.xRot = leg3.xRot = -leg1.xRot;
    }
}