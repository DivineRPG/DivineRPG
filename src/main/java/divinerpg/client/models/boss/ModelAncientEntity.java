package divinerpg.client.models.boss;

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

public class ModelAncientEntity<T extends LivingEntityRenderState> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("ancient_entity");

    private final ModelPart head;
    private final ModelPart legr;
    private final ModelPart legl;
    private final ModelPart body;
    private final ModelPart legL2;
    private final ModelPart legR2;

    public ModelAncientEntity(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelAncientEntity(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.legr = root.getChild("legr");
        this.legl = root.getChild("legl");
        this.body = root.getChild("body");
        this.legL2 = root.getChild("legL2");
        this.legR2 = root.getChild("legR2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(33, 17).mirror().addBox(4.0F, -6.3F, -13.3F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(33, 17).mirror().addBox(-5.0F, -6.3F, -13.3F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -13.0F, -19.0F));

        head.addOrReplaceChild("hornbottomr_r1", CubeListBuilder.create().texOffs(33, 17).mirror().addBox(-5.0F, -6.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.9599F, 0.0F, 0.0F));
        head.addOrReplaceChild("hornbottoml_r1", CubeListBuilder.create().texOffs(33, 17).mirror().addBox(4.0F, -4.0F, -1.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.9599F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("legr", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 4.0F));
        partdefinition.addOrReplaceChild("legl", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 12.0F, 4.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(18, 4).mirror().addBox(-6.0F, -27.6F, -6.7F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, 0.7854F, 0.0F, 0.0F));

        body.addOrReplaceChild("Shape8_r1", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-3.0F, 4.0F, -2.5F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -29.0F, -2.0F, 1.3526F, 0.0F, 0.0F));
        body.addOrReplaceChild("Shape9_r1", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-3.0F, 4.0F, -4.0F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -27.0F, -2.0F, 1.3526F, 0.0F, 0.0F));
        body.addOrReplaceChild("Shape7_r1", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-3.0F, 1.0F, 9.0F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(34, 4).mirror().addBox(-3.0F, 1.0F, 2.0F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -10.0F, -2.0F, 1.3526F, 0.0F, 0.0F));
        body.addOrReplaceChild("Shape6_r1", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-3.0F, 1.0F, 4.5F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -11.0F, -2.0F, 1.3526F, 0.0F, 0.0F));
        body.addOrReplaceChild("Shape4_r1", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-3.0F, 6.0F, 6.0F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, -9.0F, 1.3526F, 0.0F, 0.0F));
        body.addOrReplaceChild("Shape3_r1", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-3.0F, -1.0F, 2.0F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, 1.3526F, 0.0F, 0.0F));
        body.addOrReplaceChild("Shape2_r1", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-3.0F, -1.0F, 1.0F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 1.3526F, 0.0F, 0.0F));
        body.addOrReplaceChild("Shape1_r1", CubeListBuilder.create().texOffs(34, 4).mirror().addBox(-3.0F, -6.5F, 17.0F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 19.0F, -2.0F, 1.3526F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("legL2", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-1.0F, 0.0F, -4.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 16).mirror().addBox(-1.0F, 12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 19).mirror().addBox(-1.0F, 24.0F, -2.0F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -9.0F, -16.0F));

        partdefinition.addOrReplaceChild("legR2", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-5.0F, 0.0F, -4.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 16).mirror().addBox(-3.0F, 12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 19).mirror().addBox(-2.0F, 24.0F, -2.0F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -9.0F, -16.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);

        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);

        this.legr.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.legl.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
    }
}