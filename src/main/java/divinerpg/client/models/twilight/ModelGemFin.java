package divinerpg.client.models.twilight;

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

public class ModelGemFin<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("gem_fin");
    private final ModelPart Body, Head, TailFin;

    public ModelGemFin(ModelPart root) {
        super(root);
        this.Body = root.getChild("Body");
        this.Head = root.getChild("Head");
        this.TailFin = root.getChild("TailFin");
    }

    public ModelGemFin(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(8, 15).addBox(0.0F, -6.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.5F, -4.0F, -2.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -1.0F));

        PartDefinition RightFin = Body.addOrReplaceChild("RightFin", CubeListBuilder.create(), PartPose.offset(-2.0F, -1.0F, 1.0F));

        RightFin.addOrReplaceChild("RightFin_r1", CubeListBuilder.create().texOffs(16, 16).addBox(0.5F, 0.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.3491F));

        PartDefinition LeftFin = Body.addOrReplaceChild("LeftFin", CubeListBuilder.create(), PartPose.offset(2.0F, -1.0F, 1.0F));

        LeftFin.addOrReplaceChild("LeftFin_r1", CubeListBuilder.create().texOffs(8, 18).addBox(-0.5F, 0.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.3491F));

        PartDefinition Hip = Body.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(16, 11).addBox(-1.0F, -6.0F, 1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 2.0F));

        partdefinition.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 4.0F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -3.0F, -3.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -3.0F));

        Head.addOrReplaceChild("LeftWhisker_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3682F, 0.2875F, -1.0513F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, -3.0F, 0.2942F, -0.1321F, -0.4202F));

        Head.addOrReplaceChild("RightWhisker_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.6567F, 0.361F, -1.0807F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, -3.0F, 0.3742F, 0.1574F, 0.3633F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
        float ageInTicks = state.ageInTicks;
        float f = 1.0F;
        if (!state.isInWater) {
            f = 1.5F;
        }

        this.TailFin.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
    }
}