package divinerpg.client.models.twilight;

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

public class ModelWeakCori<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("weak_cori");

    public final ModelPart Head;
    public final ModelPart Tendrils;
    public final ModelPart FrontRightTendril;
    public final ModelPart FrontMiddleTendril;
    public final ModelPart FrontLeftTendril;
    public final ModelPart BackRightTendril;
    public final ModelPart BackMiddleTendril;
    public final ModelPart BackLeftTendril;
    public final ModelPart RightTendril;
    public final ModelPart LeftTendril;

    public ModelWeakCori(ModelPart root) {
        super(root);
        Head = root.getChild("Head");
        Tendrils = root.getChild("Tendrils");
        FrontRightTendril = Tendrils.getChild("FrontRightTendril");
        FrontMiddleTendril = Tendrils.getChild("FrontMiddleTendril");
        FrontLeftTendril = Tendrils.getChild("FrontLeftTendril");
        BackRightTendril = Tendrils.getChild("BackRightTendril");
        BackMiddleTendril = Tendrils.getChild("BackMiddleTendril");
        BackLeftTendril = Tendrils.getChild("BackLeftTendril");
        RightTendril = Tendrils.getChild("RightTendril");
        LeftTendril = Tendrils.getChild("LeftTendril");
    }

    public ModelWeakCori(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(40, 55).addBox(-4, -6, -1, 8, 8, 1, cubeDef)
                .texOffs(13, 54).addBox(-5, -7, -.5F, 10, 10, 0, cubeDef), PartPose.offset(0, 12, 1));

        Head.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -6, -8, 7, 5, 8, cubeDef)
                .texOffs(0, 22).addBox(-3.5F, -1, -8, 7, 1, 8, cubeDef), PartPose.offset(0, 0, -1));

        Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 13).addBox(-3.5F, -1, -9, 7, 1, 8, cubeDef)
                .texOffs(22, 5).addBox(-3.5F, 0, -9, 7, 1, 8, cubeDef), PartPose.offset(0, 1, 0));

        PartDefinition Tendrils = partdefinition.addOrReplaceChild("Tendrils", CubeListBuilder.create().texOffs(24, 16).addBox(-2.5F, 1.5F, -1.5F, 5, 3, 6, cubeDef), PartPose.offset(0, 12.49F, -1.5F));

        Tendrils.addOrReplaceChild("FrontRightTendril", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F, .5F, -3, 3, 9, 3, cubeDef), PartPose.offset(-2, 4, -.5F));
        Tendrils.addOrReplaceChild("FrontMiddleTendril", CubeListBuilder.create().texOffs(44, 0).addBox(-1.5F, .5F, -3, 3, 9, 3, cubeDef), PartPose.offset(0, 4, -.5F));
        Tendrils.addOrReplaceChild("FrontLeftTendril", CubeListBuilder.create().texOffs(21, 40).addBox(0, .5F, -3, 3, 9, 3, cubeDef), PartPose.offset(1.5F, 4, -.5F));
        Tendrils.addOrReplaceChild("BackRightTendril", CubeListBuilder.create().texOffs(36, 37).addBox(-3, .5F, 0, 3, 9, 3, cubeDef), PartPose.offset(-1.5F, 4, 3.5F));
        Tendrils.addOrReplaceChild("BackMiddleTendril", CubeListBuilder.create().texOffs(12, 31).addBox(-1.5F, .5F, 0, 3, 9, 3, cubeDef), PartPose.offset(0, 4, 3.5F));
        Tendrils.addOrReplaceChild("BackLeftTendril", CubeListBuilder.create().texOffs(39, 25).addBox(0, .5F, 0, 3, 9, 3, cubeDef), PartPose.offset(1.5F, 4, 3.5F));
        Tendrils.addOrReplaceChild("RightTendril", CubeListBuilder.create().texOffs(27, 28).addBox(-3, .5F, -1.5F, 3, 9, 3, cubeDef), PartPose.offset(-1.5F, 4, 1.5F));
        Tendrils.addOrReplaceChild("LeftTendril", CubeListBuilder.create().texOffs(0, 31).addBox(0, .5F, -1.5F, 3, 9, 3, cubeDef), PartPose.offset(1.5F, 4, 1.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float ageInTicks = state.ageInTicks;

        Head.yRot = netHeadYaw;
        Head.xRot = headPitch;

        float f = Mth.cos(ageInTicks * 15F * Mth.DEG_TO_RAD) * Mth.HALF_PI * .25F;
        BackMiddleTendril.xRot = RightTendril.zRot = f + .5672F;
        FrontMiddleTendril.xRot = LeftTendril.zRot = -f - .5672F;
        FrontRightTendril.xRot = FrontLeftTendril.zRot = FrontLeftTendril.xRot = BackLeftTendril.zRot = f - .3491F;
        FrontRightTendril.zRot = BackLeftTendril.xRot = BackRightTendril.xRot = BackRightTendril.zRot = -f + .3491F;
    }
}