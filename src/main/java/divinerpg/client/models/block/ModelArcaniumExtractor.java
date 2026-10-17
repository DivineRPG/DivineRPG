package divinerpg.client.models.block;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.util.Unit;

import static divinerpg.utils.Utils.createLocation;

public class ModelArcaniumExtractor extends Model.Simple {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("arcanium_extractor");

    public ModelArcaniumExtractor(ModelPart root) {
        super(root, RenderTypes::entityCutoutCull);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubeDef = CubeDeformation.NONE;
        PartPose zPose = PartPose.ZERO;

        partdefinition.addOrReplaceChild("plate_lower", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-7, 0, -7, 14, 2, 14, cubeDef), zPose);
        partdefinition.addOrReplaceChild("plate_middle", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-7, 10, -7, 14, 2, 14, cubeDef), PartPose.rotation(0, 1.571F, 0));
        partdefinition.addOrReplaceChild("plate_upper", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-7, 20, -7, 14, 2, 14, cubeDef), PartPose.rotation(0, 4.7124F, 0));
        partdefinition.addOrReplaceChild("S1", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(3, 12, 3, 2, 8, 2, cubeDef), zPose);
        partdefinition.addOrReplaceChild("S2", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(3, 12, 3, 2, 8, 2, cubeDef), PartPose.rotation(0, 1.571F, 0));
        partdefinition.addOrReplaceChild("S4", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(3, 12, 3, 2, 8, 2, cubeDef), PartPose.rotation(0, 3.1416F, 0));
        partdefinition.addOrReplaceChild("S3", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(3, 12, 3, 2, 8, 2, cubeDef), PartPose.rotation(0, 4.7124F, 0));
        partdefinition.addOrReplaceChild("S5", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(2, 2, 2, 2, 8, 2, cubeDef), zPose);
        partdefinition.addOrReplaceChild("S6", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(2, 2, 2, 2, 8, 2, cubeDef), PartPose.rotation(0, 1.571F, 0));
        partdefinition.addOrReplaceChild("S7", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(2, 2, 2, 2, 8, 2, cubeDef), PartPose.rotation(0, 3.1416F, 0));
        partdefinition.addOrReplaceChild("S8", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(2, 2, 2, 2, 8, 2, cubeDef), PartPose.rotation(0, 4.7124F, 0));
        partdefinition.addOrReplaceChild("r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1, 22, 0, 1, 4, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3, 22, 4, 1, 4, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(4, 22, -6, 1, 4, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5, 22, -4, 1, 4, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(4, 22, -1, 1, 2, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5, 22, 2, 1, 2, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1, 22, -5, 1, 2, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(5, 22, 5, 1, 2, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(2, 22, 3, 1, 2, 1, cubeDef), zPose);
        partdefinition.addOrReplaceChild("r10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3, 22, -2, 1, 2, 1, cubeDef), zPose);

        return LayerDefinition.create(meshdefinition, 64, 32);
    }
}