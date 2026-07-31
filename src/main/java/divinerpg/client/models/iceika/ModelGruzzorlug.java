package divinerpg.client.models.iceika;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

import static divinerpg.utils.Utils.createLocation;


public class ModelGruzzorlug<S extends HumanoidRenderState> extends HumanoidModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("gruzzorlug");
    public final ModelPart eyebrow;

    public ModelGruzzorlug(ModelPart part) {
        super(part);
        this.eyebrow = this.head.getChild("eyebrow");
    }

    public ModelGruzzorlug(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;

        PartDefinition Head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, cubeDef)
                .texOffs(20, 0).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 3.0F, 1.0F, cubeDef)
                .texOffs(0, 0).addBox(-4.0F, -2.0F, -4.99F, 8.0F, 8.0F, 2.0F, cubeDef)
                .texOffs(0, 0).addBox(0.0F, -14.0F, -3.0F, 0.0F, 12.0F, 12.0F, cubeDef), PartPose.ZERO);

        Head.addOrReplaceChild("eyebrow", CubeListBuilder.create().texOffs(42, 0).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, cubeDef), PartPose.offset(0.0F, 0.0F, -3.99F));

        Head.addOrReplaceChild("moustache", CubeListBuilder.create().texOffs(44, 19).addBox(-5.0F, -2.5F, -1.25F, 10.0F, 3.0F, 2.0F, cubeDef), PartPose.offset(0.0F, 0.18F, -4.0F));

        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(24, 47).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.ZERO);

        PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 19).addBox(-5.0F, -10.0F, -3.0F, 10.0F, 11.0F, 5.0F, cubeDef), PartPose.offset(0.0F, 0.0F, 0.5F));

        Body.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(8, 35).addBox(-5.5F, 7.0F, -4.0F, 11.0F, 4.0F, 3.0F, cubeDef), PartPose.offset(0.0F, -10.5F, -1.01F));

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, cubeDef), PartPose.offset(-3.0F, 0.0F, -1.5F));

        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(43, 8).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, cubeDef), PartPose.offset(3.0F, 0.0F, -1.5F));

        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(44, 30).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 12.0F, 5.0F, cubeDef), PartPose.offset(0.0F, 0.0F, -0.5F));

        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(8, 42).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 12.0F, 5.0F, cubeDef), PartPose.offset(0.0F, 0.0F, -0.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        this.rightArm.y = 8.0F;
        this.leftArm.y = 8.0F;
        this.rightArm.x = -6.5F;
        this.leftArm.x = 6.5F;
        this.rightLeg.y = 18.0F;
        this.leftLeg.y = 18.0F;
        this.eyebrow.y = -4.0F;
        this.head.y = 7.01F;
        this.hat.y = 7.01F;
        this.body.y = 17.0F;
    }
}