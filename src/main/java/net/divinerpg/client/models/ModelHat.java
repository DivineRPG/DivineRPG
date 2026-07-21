package net.divinerpg.client.models;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.resources.Identifier;

import static net.divinerpg.DivineRPG.MODID;

public class ModelHat extends PlayerModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(MODID, "hat"), "main");

    public final ModelPart hat;

    public ModelHat(ModelPart root) {
        super(root, false);
        this.hat = this.head.getChild("hat");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = PlayerModel.createMesh(CubeDeformation.NONE, false);
        PartDefinition root = mesh.getRoot().clearRecursively();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        PartDefinition hatPart = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE), PartPose.ZERO);
        hatPart.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(32, 0).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 2.0F, 12.0F, CubeDeformation.NONE), PartPose.ZERO);

        return LayerDefinition.create(mesh, 80, 16);
    }

    @Override
    public void setupAnim(AvatarRenderState state) {
        super.setupAnim(state);
    }
}