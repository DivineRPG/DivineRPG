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

public class ModelWorkshopTinkerer<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("workshop_tinkerer");
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart arm;
    public final ModelPart leftLeg;
    public final ModelPart rightLeg;

    public ModelWorkshopTinkerer(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("Head");
        this.body = rootPart.getChild("Body");
        this.arm = this.body.getChild("Arm");
        this.leftLeg = rootPart.getChild("LeftLeg");
        this.rightLeg = rootPart.getChild("RightLeg");
    }

    public ModelWorkshopTinkerer(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.01F, 0.0F));

        PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(22, 50).addBox(-4.0F, -11.0F, 5.01F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        Body.addOrReplaceChild("Arm", CubeListBuilder.create().texOffs(0, 45).addBox(-9.0F, -2.5F, -4.1667F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(46, 18).addBox(4.0F, -2.5F, -4.1667F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-9.0F, -2.5F, -9.1657F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.1667F, 0.4363F, 0.0F, 0.0F));

        root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(32, 32).addBox(-1.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 12.01F, 0.0F));
        root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(40, 0).addBox(-5.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.01F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * ((float)Math.PI / 180F);
        this.head.xRot = state.xRot * ((float)Math.PI / 180F);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightLeg.yRot = 0.0F;
        this.leftLeg.yRot = 0.0F;
    }
}