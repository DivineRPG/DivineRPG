package divinerpg.client.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.*;

import static divinerpg.util.ClientUtils.createLocation;

@OnlyIn(Dist.CLIENT)
public class ModelHat<T extends Player> extends ListModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("hat");
    public ModelPart top, bottom;


    public ModelHat(EntityRendererProvider.Context context) {
        ModelPart root = context.bakeLayer(LAYER_LOCATION);
        this.top = root.getChild("top");
        this.bottom = root.getChild("bottom");
    }

    public ModelHat(ModelPart root) {
        this.top = root.getChild("top");
        this.bottom = root.getChild("bottom");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition top = partdefinition.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4, -18, -4, 8, 8, 8, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-6, -10, -6, 12, 2, 12, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        top.getChild("bottom");
        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.top.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.top.xRot = headPitch / (180F / (float) Math.PI);
        this.bottom.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.bottom.xRot = headPitch / (180F / (float) Math.PI);
    }

    @Override
    public Iterable<ModelPart> parts() {
        return ImmutableList.of(top, bottom);
    }

}