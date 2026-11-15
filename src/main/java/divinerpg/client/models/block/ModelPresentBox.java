package divinerpg.client.models.block;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderTypes;

import static divinerpg.utils.Utils.createLocation;

public class ModelPresentBox extends Model<Float> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("present_box");
    public final ModelPart lid;
    public final ModelPart handle;

    public ModelPresentBox(ModelPart root) {
        super(root, RenderTypes::entityCutout);
        this.lid = root.getChild("lid");
        this.handle = root.getChild("handle");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("storage", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, 0.0F, 0.0F, 14.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.0F, 1.0F));

        partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, -14.0F, 14.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 7.0F, 15.0F));

        partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -15.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 7.0F, 15.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
    public void setupAnim(Float open) {
        super.setupAnim(open);
        this.lid.xRot = -(open * ((float)Math.PI / 2F));
        this.handle.xRot = this.lid.xRot;
    }
}