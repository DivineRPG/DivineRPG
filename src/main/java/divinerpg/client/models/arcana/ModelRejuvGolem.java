package divinerpg.client.models.arcana;

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

public class ModelRejuvGolem<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("rejuv_golem");
    private final ModelPart head;
    private final ModelPart rightshoulder;
    private final ModelPart leftshoulder;
    private final ModelPart middle;
    private final ModelPart body;
    private final ModelPart rightarm;
    private final ModelPart leftarm;

    public ModelRejuvGolem(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelRejuvGolem(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("head");
        this.rightshoulder = rootPart.getChild("rightshoulder");
        this.leftshoulder = rootPart.getChild("leftshoulder");
        this.middle = rootPart.getChild("middle");
        this.body = rootPart.getChild("body");
        this.rightarm = rootPart.getChild("rightarm");
        this.leftarm = rootPart.getChild("leftarm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 7.0F, 0.0F));

        root.addOrReplaceChild("rightshoulder", CubeListBuilder.create().texOffs(73, 3).mirror().addBox(-4.0F, -6.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 11.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

        root.addOrReplaceChild("leftshoulder", CubeListBuilder.create().texOffs(73, 3).mirror().addBox(-2.0F, -6.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 11.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

        root.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(68, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 7.0F, -2.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(25, 10).mirror().addBox(-4.0F, 0.0F, -2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 12.0F, -3.0F));

        root.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 11.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

        root.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 11.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.rightarm.xRot = this.rightshoulder.xRot = Mth.cos(limbSwing) * limbSwingAmount * 0.75F - 0.6981317F;
        this.leftarm.xRot = this.leftshoulder.xRot = Mth.cos(limbSwing + (float) Math.PI) * limbSwingAmount * 0.75F - 0.6981317F;
    }
}