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

public class ModelKarot<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("karot");

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart leg4;
    private final ModelPart ear1;
    private final ModelPart ear2;
    private final ModelPart tail;
    private final ModelPart shape1;
    private final ModelPart shape2;
    private final ModelPart shape3;
    private final ModelPart shape4;

    public ModelKarot(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelKarot(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("Head");
        this.body = rootPart.getChild("Body");
        this.leg1 = rootPart.getChild("Leg1");
        this.leg2 = rootPart.getChild("Leg2");
        this.leg3 = rootPart.getChild("Leg3");
        this.leg4 = rootPart.getChild("Leg4");
        this.ear1 = rootPart.getChild("Ear1");
        this.ear2 = rootPart.getChild("Ear2");
        this.tail = rootPart.getChild("Tail");
        this.shape1 = rootPart.getChild("Shape1");
        this.shape2 = rootPart.getChild("Shape2");
        this.shape3 = rootPart.getChild("Shape3");
        this.shape4 = rootPart.getChild("Shape4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, cubedef).mirror(false)
                .texOffs(16, 10).mirror().addBox(-5.0F, -2.5F, -6.0F, 2.0F, 2.0F, 6.0F, cubedef).mirror(false)
                .texOffs(16, 10).mirror().addBox(3.0F, -2.5F, -6.0F, 2.0F, 2.0F, 6.0F, cubedef).mirror(false), PartPose.offset(0.0F, 13.5F, -7.0F));

        PartDefinition body = root.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, -3.0F));
        body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-4.0F, -4.0F, -13.0F, 6.0F, 9.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(1.0F, 10.0F, 3.0F, -1.5708F, 0.0F, 0.0F));

        root.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-1.5F, 16.0F, 3.0F));

        root.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offset(1.5F, 16.0F, 3.0F));

        root.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-1.5F, 16.0F, -4.0F));

        root.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubedef).mirror(false), PartPose.offset(1.5F, 16.0F, -4.0F));

        root.addOrReplaceChild("Ear1", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(-3.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, cubedef).mirror(false), PartPose.offset(0.0F, 13.5F, -7.0F));

        root.addOrReplaceChild("Ear2", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(1.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, cubedef).mirror(false), PartPose.offset(0.0F, 13.5F, -7.0F));

        root.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, cubedef).mirror(false), PartPose.offset(-1.0F, 13.0F, 4.0F));

        root.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(1.0F, 9.0F, 0.0F));

        root.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 9.0F, 0.0F));

        root.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(1.0F, 9.0F, -4.0F));

        root.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(50, 18).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, cubedef).mirror(false), PartPose.offset(-3.0F, 9.0F, -4.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
        this.head.xRot = state.xRot * (float) (Math.PI / 180.0);

        float swing1 = Mth.cos(state.walkAnimationPos * 0.6662F) * 1.4F * state.walkAnimationSpeed;
        float swing2 = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 1.4F * state.walkAnimationSpeed;

        this.leg1.xRot = swing1;
        this.leg2.xRot = swing2;
        this.leg3.xRot = swing2;
        this.leg4.xRot = swing1;
    }
}