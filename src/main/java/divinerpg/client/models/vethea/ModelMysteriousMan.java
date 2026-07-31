package divinerpg.client.models.vethea;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelMysteriousMan<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("mysterious_man");
    private final ModelPart head;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart facemask1;
    private final ModelPart facemask2;
    private final ModelPart facemask3;
    private final ModelPart facemask4;

    public ModelMysteriousMan(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.rightleg = root.getChild("rightleg");
        this.leftleg = root.getChild("leftleg");
        this.body = root.getChild("body");
        this.neck = root.getChild("neck");
        this.facemask1 = root.getChild("facemask1");
        this.facemask2 = root.getChild("facemask2");
        this.facemask3 = root.getChild("facemask3");
        this.facemask4 = root.getChild("facemask4");
    }

    public ModelMysteriousMan(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(20, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -2.0F, 0.0F));

        partdefinition.addOrReplaceChild("facemask1", CubeListBuilder.create().texOffs(37, 3).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, -2.0F));

        partdefinition.addOrReplaceChild("facemask2", CubeListBuilder.create().texOffs(37, 3).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 6.0F));

        partdefinition.addOrReplaceChild("facemask3", CubeListBuilder.create().texOffs(37, 3).mirror().addBox(4.0F, 0.0F, -2.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, -2.0F));

        partdefinition.addOrReplaceChild("facemask4", CubeListBuilder.create().texOffs(37, 3).mirror().addBox(-4.0F, 0.0F, -2.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, -2.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
    }
}