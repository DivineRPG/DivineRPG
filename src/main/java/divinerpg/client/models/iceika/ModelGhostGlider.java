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

import static divinerpg.utils.Utils.createLocation;

public class ModelGhostGlider<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("ghost_glider");
    private final ModelPart body;
    private final ModelPart rightWing;
    private final ModelPart leftWing;

    public ModelGhostGlider(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("Body");
        this.rightWing = rootPart.getChild("RightWing");
        this.leftWing = rootPart.getChild("LeftWing");
    }

    public ModelGhostGlider(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -9.0F, -3.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition MiddleTendril = Body.addOrReplaceChild("MiddleTendril", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        MiddleTendril.addOrReplaceChild("MiddleTendril_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -2.5F, -0.0436F, 0.0F, 0.0F));

        PartDefinition LeftTendril = Body.addOrReplaceChild("LeftTendril", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        LeftTendril.addOrReplaceChild("LeftTendril_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, -3.5F, -0.0436F, 0.0F, -0.1309F));

        PartDefinition RightTendril = Body.addOrReplaceChild("RightTendril", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        RightTendril.addOrReplaceChild("RightTendril_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.0F, -3.5F, -0.0436F, 0.0F, 0.1309F));

        PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 1.5F));

        Tail.addOrReplaceChild("BackTailSegment", CubeListBuilder.create().texOffs(39, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.5F));

        Tail.addOrReplaceChild("MiddleTailSegment", CubeListBuilder.create().texOffs(31, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.5F));

        Tail.addOrReplaceChild("FrontTailSegment", CubeListBuilder.create().texOffs(21, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        root.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(15, 6).addBox(-4.5F, -0.5F, -1.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 14.5F, 0.5F));

        root.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(15, 14).addBox(-0.5F, -0.5F, -1.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 14.5F, 0.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float ageInTicks = state.ageInTicks;
        this.rightWing.zRot = (float) Math.sin(10D * ageInTicks / (180D / Math.PI)) * 0.3F;
        this.leftWing.zRot = -this.rightWing.zRot;
    }
}