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

public class ModelRobbin<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("robbin");
    public final ModelPart body;
    public final ModelPart tail;
    public final ModelPart head;
    public final ModelPart leftWing;
    public final ModelPart rightWing;
    public final ModelPart leftLeg;
    public final ModelPart rightLeg;

    public ModelRobbin(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("head");
        this.body = rootPart.getChild("body");
        this.tail = rootPart.getChild("tail");
        this.leftWing = rootPart.getChild("left_wing");
        this.rightWing = rootPart.getChild("right_wing");
        this.leftLeg = rootPart.getChild("left_leg");
        this.rightLeg = rootPart.getChild("right_leg");
    }

    public ModelRobbin(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubeDef = CubeDeformation.NONE;

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F, cubeDef), PartPose.offset(0.0F, 22.0F, 1.0F));
        root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, cubeDef), PartPose.offset(0.0F, 18.3F, 1.6F));

        root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(11, 14).addBox(-1.5F, -2.5F, -2.0F, 3.0F, 3.0F, 3.0F, cubeDef) //Head
                .texOffs(8, 11).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 2.0F, cubeDef) //Beak
                .texOffs(0, 8).addBox(-2.0F, -3.49F, 0.0F, 1.0F, 1.0F, 2.0F, cubeDef) //Right Horn
                .texOffs(0, 11).addBox(1.0F, -3.49F, 0.0F, 1.0F, 1.0F, 2.0F, cubeDef), PartPose.offset(0.0F, 18.0F, -2.0F)); //Left Horn

        root.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 5.0F, cubeDef), PartPose.offset(-2.0F, 18.0F, -2.0F));
        root.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(20, 24).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 5.0F, cubeDef), PartPose.offset(2.0F, 18.0F, -2.0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F, cubeDef), PartPose.ZERO);
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(8, 20).addBox(0.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F, cubeDef), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.xRot = state.xRot * Mth.DEG_TO_RAD / 2.0F;
        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        float r = this.body.zRot = -Mth.PI / 12.0F;
        float f = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.tail.xRot = f * 0.35F - r;

        this.tail.yRot = f * 0.4F;
        this.rightWing.yRot = 0.0F;
        this.leftWing.yRot = 0.0F;
        this.rightLeg.xRot = f;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightLeg.y = 21.0F;
        this.leftLeg.y = 21.0F;
        this.rightLeg.z = 0.0F;
        this.leftLeg.z = 0.0F;
    }
}