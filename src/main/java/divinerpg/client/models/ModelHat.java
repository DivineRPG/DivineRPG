package divinerpg.client.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.*;

import static divinerpg.util.ClientUtils.createLocation;

@OnlyIn(Dist.CLIENT)
public class ModelHat<T extends Player> extends ListModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("hat");
    public ModelPart hat;
    public ModelHat(ModelPart root) {hat = root.getChild("hat");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -18, -4, 8, 8, 8, CubeDeformation.NONE), PartPose.ZERO);
        hat.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(32, 0).addBox(-6, -10, -6, 12, 2, 12, CubeDeformation.NONE), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 128, 128);
    }
    @Override public void setupAnim(Player entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	hat.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        hat.xRot = headPitch * Mth.DEG_TO_RAD;
    }
    @Override public Iterable<ModelPart> parts() {return ImmutableList.of(hat);}
}