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
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelEnthralledDramcryx<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("enthralled_dramcryx");
    public final ModelPart Body;
    public final ModelPart Tail;
    public final ModelPart Head;
    public final ModelPart BackRightLeg;
    public final ModelPart FrontLeftLeg;
    public final ModelPart FrontRightLeg;
    public final ModelPart BackLeftLeg;

    public ModelEnthralledDramcryx(ModelPart root) {
        super(root);
        Body = root.getChild("Body");
        Tail = Body.getChild("Tail");
        Head = Body.getChild("Head");
        BackRightLeg = root.getChild("BackRightLeg");
        FrontLeftLeg = root.getChild("FrontLeftLeg");
        FrontRightLeg = root.getChild("FrontRightLeg");
        BackLeftLeg = root.getChild("BackLeftLeg");
    }

    public ModelEnthralledDramcryx(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0, 15, 2));
        Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7, -7, -19, 14, 8, 20, cubeDef), PartPose.offsetAndRotation(0, 2, 8, -.2618F, 0, 0));

        PartDefinition Spines = Body.addOrReplaceChild("Spines", CubeListBuilder.create().texOffs(40, 28).addBox(-1, -17, -6.5F, 5, 16, 6, cubeDef), PartPose.offset(-1.5F, -4, .5F));
        Spines.addOrReplaceChild("BackSpine_r1", CubeListBuilder.create().texOffs(66, 43).addBox(-1, -18.03F, -6.94F, 3, 10, 3, cubeDef), PartPose.offsetAndRotation(1, 7, -3.5F, -1.0908F, 0, 0));
        Spines.addOrReplaceChild("MiddleSpine_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.01F, -22.54F, -2.29F, 5, 14, 4, cubeDef), PartPose.offsetAndRotation(1, 7, -3.5F, -.3927F, 0, 0));

        Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(62, 28).addBox(-4, -8, -2.5F, 8, 10, 5, cubeDef), PartPose.offsetAndRotation(0, 1, 11.5F, -.3491F, 0, 0));

        Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(4, 28).addBox(4.99F, -1, -10.5F, 1, 5, 1, cubeDef)
                .texOffs(0, 28).addBox(-5.99F, -1, -10.5F, 1, 5, 1, cubeDef)
                .texOffs(0, 28).addBox(-6, -5, -8, 12, 10, 8, cubeDef)
                .texOffs(0, 65).addBox(-5, -2, -10, 10, 7, 2, cubeDef)
                .texOffs(32, 28).addBox(1, -8F, -4.2F, 4, 3, 3, cubeDef)
                .texOffs(66, 0).addBox(-5, -8F, -4.2F, 4, 3, 3, cubeDef), PartPose.offset(0, -6, -9));

        partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 46).addBox(-4, -3, -3, 6, 13, 6, cubeDef), PartPose.offset(-5, 14, 7));
        partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(48, 50).addBox(-2, -3, -3, 6, 13, 6, cubeDef), PartPose.offset(4, 14, -5));
        partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(24, 50).addBox(-4, -3, -3, 6, 13, 6, cubeDef), PartPose.offset(-4, 14, -5));
        partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(48, 0).addBox(-2, -3, -3, 6, 13, 6, cubeDef), PartPose.offset(5, 14, 7));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);

        Head.yRot = netHeadYaw;
        Head.xRot = headPitch;

        float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
        float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;

        Body.zRot = f * .05F;
        Tail.yRot = f * .25F;
        FrontRightLeg.xRot = BackLeftLeg.xRot = f1;
        FrontLeftLeg.xRot = BackRightLeg.xRot = f;
    }
}