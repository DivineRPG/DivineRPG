package divinerpg.client.models.block;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderTypes;

import static divinerpg.utils.Utils.createLocation;

public class ModelEdenChest extends Model<Float> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("eden_chest");
    public final ModelPart lid, chestKnobLeft, chestKnobMiddle, chestKnobRight;
    public ModelEdenChest(ModelPart root) {
        super(root, RenderTypes::entityCutout);
        this.lid = root.getChild("lid");
        this.chestKnobLeft = root.getChild("chestKnobLeft");
        this.chestKnobMiddle = root.getChild("chestKnobMiddle");
        this.chestKnobRight = root.getChild("chestKnobRight");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, -14.0F, 14.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 7.0F, 15.0F));

        partdefinition.addOrReplaceChild("storage", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, 0.0F, 0.0F, 14.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.0F, 1.0F));

        partdefinition.addOrReplaceChild("chestKnobLeft", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -15.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 7.0F, 15.0F));

        partdefinition.addOrReplaceChild("chestKnobMiddle", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -15.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 7.0F, 15.0F));

        partdefinition.addOrReplaceChild("chestKnobRight", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -15.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, 7.0F, 15.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
    public void setupAnim(Float open) {
        super.setupAnim(open);
        chestKnobRight.xRot = chestKnobMiddle.xRot = chestKnobLeft.xRot = lid.xRot = -(open * ((float)Math.PI / 2F));
    }
}
