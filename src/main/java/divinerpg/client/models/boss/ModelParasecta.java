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
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelParasecta<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("parasecta");
    private final ModelPart foot6;
    private final ModelPart wing2;
    private final ModelPart wing1;
    private final ModelPart body;
    private final ModelPart leg6;
    private final ModelPart foot4;
    private final ModelPart leg4;
    private final ModelPart foot5;
    private final ModelPart leg5;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart foot1;
    private final ModelPart foot2;
    private final ModelPart foot3;
    private final ModelPart head;

    public ModelParasecta(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelParasecta(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.foot6 = rootPart.getChild("foot6");
        this.wing2 = rootPart.getChild("wing2");
        this.wing1 = rootPart.getChild("wing1");
        this.body = rootPart.getChild("body");
        this.leg6 = rootPart.getChild("leg6");
        this.foot4 = rootPart.getChild("foot4");
        this.leg4 = rootPart.getChild("leg4");
        this.foot5 = rootPart.getChild("foot5");
        this.leg5 = rootPart.getChild("leg5");
        this.leg1 = rootPart.getChild("leg1");
        this.leg2 = rootPart.getChild("leg2");
        this.leg3 = rootPart.getChild("leg3");
        this.foot1 = rootPart.getChild("foot1");
        this.foot2 = rootPart.getChild("foot2");
        this.foot3 = rootPart.getChild("foot3");
        this.head = rootPart.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("foot6", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, 13.0F, 11.0F, 0.0F, 0.0F, -0.4363F));

        root.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, -0.733F, 0.0F, 0.0F));

        root.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -5.0F, 14.0F, 1.0F, 10.0F, cubedef).mirror(false), PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, -0.733F, 0.0F, 0.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-6.0F, -10.0F, -7.0F, 20.0F, 22.0F, 5.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, -3.0F, 2.0F, 0.8644F, 0.0F, 0.0F));

        root.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 15.0F, 10.0F));

        root.addOrReplaceChild("foot4", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, 6.0F, 1.0F, 0.0F, 0.0F, -0.4363F));

        root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 8.0F, 0.0F));

        root.addOrReplaceChild("foot5", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, 10.0F, 6.0F, 0.0F, 0.0F, -0.4363F));

        root.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 12.0F, 5.0F));

        root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, cubedef).mirror(false), PartPose.offset(11.0F, 8.0F, 0.0F));

        root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, cubedef).mirror(false), PartPose.offset(11.0F, 12.0F, 5.0F));

        root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-6.0F, -10.0F, -7.0F, 4.0F, 12.0F, 3.0F, cubedef).mirror(false), PartPose.offset(11.0F, 15.0F, 10.0F));

        root.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(11.0F, 9.0F, 1.0F, 0.0F, 0.0F, 0.4363F));

        root.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(11.0F, 13.0F, 6.0F, 0.0F, 0.0F, 0.4363F));

        root.addOrReplaceChild("foot3", CubeListBuilder.create().texOffs(15, 17).mirror().addBox(-5.0F, -1.0F, -7.0F, 2.0F, 9.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(11.0F, 16.0F, 11.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-4.0F, -4.0F, -5.0F, 8.0F, 8.0F, 6.0F, cubedef).mirror(false), PartPose.offset(0.0F, -3.0F, -8.0F));

        head.addOrReplaceChild("tusk1_r1", CubeListBuilder.create().texOffs(47, 16).mirror().addBox(-1.0F, -0.4667F, 0.0F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(3.0F, 4.0F, -4.0F, 0.0F, 0.0F, 0.2618F));

        head.addOrReplaceChild("tusk2_r1", CubeListBuilder.create().texOffs(47, 16).mirror().addBox(0.0F, -0.4667F, 0.0F, 1.0F, 3.0F, 1.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-3.0F, 4.0F, -4.0F, 0.0F, 0.0F, -0.2618F));

        return LayerDefinition.create(meshdefinition, 128, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.wing1.yRot = Mth.cos(state.ageInTicks * 1.3F) * Mth.PI * 0.25F;
        this.wing2.yRot = -this.wing1.yRot;
        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        this.head.xRot = state.xRot * Mth.DEG_TO_RAD;
    }
}