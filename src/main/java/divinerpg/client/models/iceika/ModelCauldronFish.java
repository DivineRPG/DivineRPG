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

public class ModelCauldronFish<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("cauldron_fish");
    private final ModelPart body;
    private final ModelPart rightFin;
    private final ModelPart leftFin;

    public ModelCauldronFish(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("Body");
        this.leftFin = rootPart.getChild("LeftFin");
        this.rightFin = rootPart.getChild("RightFin");
    }

    public ModelCauldronFish(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation zero = new CubeDeformation(0F);

        PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -13.0F, -4.5F, 9.0F, 6.0F, 9.0F, zero)
                .texOffs(0, 15).addBox(-3.5F, -7.0F, -3.5F, 7.0F, 2.0F, 7.0F, zero), PartPose.offset(0.0F, 24.0F, 0.0F));

        Body.addOrReplaceChild("Tendrils", CubeListBuilder.create().texOffs(21, 15).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 0.0F, zero)
                .texOffs(0, 17).addBox(0.0F, 0.0F, -3.5F, 0.0F, 5.0F, 7.0F, zero), PartPose.offset(0.0F, -5.0F, 0.0F));

        root.addOrReplaceChild("LeftFin", CubeListBuilder.create().texOffs(0, 4).addBox(-0.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, zero), PartPose.offset(4.5F, 14.0F, 0.0F));

        root.addOrReplaceChild("RightFin", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, zero), PartPose.offset(-4.5F, 14.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float ageInTicks = state.ageInTicks;

        if (state.isInWater) {
            this.body.xRot = 0.0F;
            this.leftFin.xRot = 0.0F;
            this.rightFin.xRot = 0.0F;

            this.leftFin.yRot = (float) Math.sin(ageInTicks);
            this.rightFin.yRot = -this.leftFin.yRot;

            this.leftFin.zRot = 0.0F;
            this.rightFin.zRot = 0.0F;

            this.leftFin.y = 14.0F;
            this.rightFin.y = 14.0F;
            this.body.z = 0.0F;
        } else {
            float rot = (float) Math.PI / 2F;
            this.body.xRot = rot;
            this.leftFin.xRot = rot;
            this.rightFin.xRot = rot;

            this.leftFin.zRot = (float) Math.sin(ageInTicks);
            this.rightFin.zRot = -this.leftFin.zRot;

            this.leftFin.yRot = 0.0F;
            this.rightFin.yRot = 0.0F;

            this.leftFin.y = 24.0F;
            this.rightFin.y = 24.0F;
            this.body.z = 10.0F;
        }
    }
}