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


public class ModelGroglin<S extends HumanoidRenderState> extends HumanoidModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("groglin");

    public ModelGroglin(ModelPart part) {
        super(part);
    }

    public ModelGroglin(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        CubeDeformation cubeDef = CubeDeformation.NONE;
        MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDef, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 34).addBox(4.0F, -9.0F, 0.0F, 1.0F, 5.0F, 5.0F, cubeDef)
                .texOffs(32, 24).addBox(-5.0F, -9.0F, 0.0F, 1.0F, 5.0F, 5.0F, cubeDef)
                .texOffs(0, 0).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 5.0F, 2.0F, cubeDef)
                .texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, cubeDef), PartPose.offset(0.0F, 0.0F, -1.0F));

        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(20, 44).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.ZERO);

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, -5.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubeDef), PartPose.offset(0.0F, 1.0F, 0.0F));

        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 14).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 11.0F, 4.0F, cubeDef)
                .texOffs(48, 16).addBox(-1.5F, 5.0F, -2.5F, 3.0F, 2.0F, 5.0F, cubeDef), PartPose.offset(-5.0F, 0.0F, -1.0F));

        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(48, 0).addBox(-1.5F, 5.0F, -2.5F, 3.0F, 2.0F, 5.0F, cubeDef)
                .texOffs(20, 29).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 11.0F, 4.0F, cubeDef), PartPose.offset(5.0F, 0.0F, -1.0F));

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 42).addBox(-2.0F, 3.0F, -2.5F, 4.0F, 2.0F, 5.0F, cubeDef)
                .texOffs(32, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, cubeDef), PartPose.offset(-2.5F, 0.0F, -1.0F));

        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 42).addBox(-2.0F, 3.0F, -2.5F, 4.0F, 2.0F, 5.0F, cubeDef)
                .texOffs(0, 30).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, cubeDef), PartPose.offset(2.5F, 0.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        this.rightArm.y = 6.0F;
        this.leftArm.y = 6.0F;
        this.rightLeg.y = 16.0F;
        this.leftLeg.y = 16.0F;
        this.head.y = 4.0F;
        this.hat.y = 4.0F;
        this.body.y = 8.0F;
    }
}