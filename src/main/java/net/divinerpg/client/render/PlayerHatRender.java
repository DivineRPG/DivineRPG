package net.divinerpg.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.divinerpg.client.models.ModelHat;
import net.divinerpg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

import java.util.UUID;

import static net.divinerpg.DivineRPG.MODID;

public class PlayerHatRender extends RenderLayer<AvatarRenderState, PlayerModel> {
    private static final Identifier DEV_HAT_TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/model/devhats/hat_red.png");
    private static final Identifier TESTER_HAT_TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/model/devhats/hat_blue.png");
    private static final Identifier ARTIST_HAT_TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/model/devhats/hat_purple.png");
    private static final Identifier SPECIAL_HAT_TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/model/devhats/hat_yellow.png");
    private static final Identifier FRIEND_HAT_TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/model/devhats/hat_pink.png");

    private final ModelHat hatModel;

    public PlayerHatRender(RenderLayerParent<AvatarRenderState, PlayerModel> parent, EntityModelSet modelSet) {
        super(parent);
        this.hatModel = new ModelHat(modelSet.bakeLayer(ModelHat.LAYER_LOCATION));
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, AvatarRenderState state, float yRot, float xRot) {
        Minecraft mc = Minecraft.getInstance();
        UUID playerUuid = mc.player != null ? mc.player.getUUID() : null;
        boolean hasRole = playerUuid != null && (Utils.isDeveloperName(playerUuid) || Utils.isTesterName(playerUuid) || Utils.isSpecial(playerUuid) || Utils.isArtist(playerUuid) || Utils.isFriend(playerUuid));
        if (hasRole && !state.isInvisible && state.showHat) {
            Identifier texture = DEV_HAT_TEXTURE;
            if (Utils.isSpecial(playerUuid)) {
                texture = SPECIAL_HAT_TEXTURE;
            } else if (Utils.isTesterName(playerUuid)) {
                texture = TESTER_HAT_TEXTURE;
            } else if (Utils.isArtist(playerUuid)) {
                texture = ARTIST_HAT_TEXTURE;
            } else if (Utils.isFriend(playerUuid)) {
                texture = FRIEND_HAT_TEXTURE;
            }
            poseStack.pushPose();
            this.hatModel.setupAnim(state);
            this.hatModel.head.loadPose(this.getParentModel().head.storePose());
            submitNodeCollector.submitModel(this.hatModel, state, poseStack, RenderTypes.entityCutout(texture), lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor, null);
            poseStack.popPose();
        }
    }
}