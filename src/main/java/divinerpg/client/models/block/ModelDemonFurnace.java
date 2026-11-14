package divinerpg.client.models.block;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.world.entity.Entity;

import static divinerpg.utils.Utils.createLocation;

public class ModelDemonFurnace extends Model.Simple {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("demon_furnace");
    public ModelDemonFurnace(ModelPart root) {
        super(root, RenderTypes::entityCutout);
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("Box", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 8.0F, -8.0F, 0.0F, 0.0F, 3.1416F));

        partdefinition.addOrReplaceChild("Arm1", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -8.0F, 3.0F, 0.0F, 0.0F, 1.2566F));

        partdefinition.addOrReplaceChild("Arm2", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 24.0F, 3.0F, 0.0F, 0.0F, 3.1416F));

        partdefinition.addOrReplaceChild("Arm3", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 24.0F, 3.0F, 0.0F, 0.0F, 3.1416F));

        partdefinition.addOrReplaceChild("Arm4", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, -3.0F, 3.0F, 0.0F, 0.0F, 0.6632F));

        partdefinition.addOrReplaceChild("Arm5", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F,  -8.0F, 3.0F, 0.0F, 0.0F, -1.2566F));

        partdefinition.addOrReplaceChild("Arm6", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -3.0F, 3.0F, 0.0F, 0.0F, -0.6632F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}