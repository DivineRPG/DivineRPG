package divinerpg.client.models.vanilla;

import divinerpg.entities.vanilla.overworld.EntitySaguaroWorm;
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

public class ModelSaguaroWorm<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("saguaro_worm");
    public final ModelPart base, active, inactive;

    public ModelSaguaroWorm(ModelPart root) {
        super(root);
        base = root.getChild("base");
        active = root.getChild("active");
        inactive = root.getChild("inactive");
    }

    public ModelSaguaroWorm(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 30).addBox(1, 0, 1, 14, 16, 14, cubeDef), PartPose.offset(-8, 8, -8));
        PartDefinition basePart = partdefinition.addOrReplaceChild("active", CubeListBuilder.create(), PartPose.ZERO);
        basePart.addOrReplaceChild("connector_bottom", CubeListBuilder.create().texOffs(56, 0).addBox(1, -2, 1, 10, 16, 10, cubeDef), PartPose.offsetAndRotation(-6, -1, -9, .288F, 0, 0));
        basePart.addOrReplaceChild("middle_active", CubeListBuilder.create().texOffs(0, 30).addBox(1, 0, 0, 14, 16, 14, cubeDef), PartPose.offsetAndRotation(-8, -13, -16, .4363F, 0, 0));
        basePart.addOrReplaceChild("connector_top", CubeListBuilder.create().texOffs(56, 0).addBox(1, 0, 1, 10, 16, 10, cubeDef), PartPose.offsetAndRotation(-6, -24, -22, .576F, 0, 0));
        basePart.addOrReplaceChild("head_active", CubeListBuilder.create().texOffs(0, 0).addBox(1, -42.5F, -14, 14, 16, 14, cubeDef), PartPose.offsetAndRotation(-8, -17, 11.5F, 1.0472F, 0, 0));
        partdefinition.addOrReplaceChild("inactive", CubeListBuilder.create()
                .texOffs(0, 0).addBox(1, -32, 1, 14, 16, 14, cubeDef) //Upper Cactus
                .texOffs(0, 30).addBox(1, -16, 1, 14, 16, 14, cubeDef), PartPose.offset(-8, 8, -8)); //Middle Cactus
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
    }
}