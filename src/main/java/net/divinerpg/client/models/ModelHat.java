package net.divinerpg.client.models;

import net.divinerpg.DivineRPG;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.*;

public class ModelHat extends EntityModel<AvatarRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "hat"), "main");
    public final ModelPart hat;

    public ModelHat(ModelPart root) {
        super(root);
        this.hat = root.getChild("hat");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition hat = root.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -18.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
        hat.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(32, 0).addBox(-6.0F, -10.0F, -6.0F, 12.0F, 2.0F, 12.0F), PartPose.ZERO);
        return LayerDefinition.create(mesh, 80, 16);
    }

    @Override
    public void setupAnim(AvatarRenderState state) {
        super.setupAnim(state);
        this.hat.yRot = state.yRot * ((float)Math.PI / 180F);
        this.hat.xRot = state.xRot * ((float)Math.PI / 180F);
    }
}