package divinerpg.client.renders;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.client.models.ModelHat;
import divinerpg.utils.Utils;
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

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static divinerpg.DivineRPG.MODID;

public class PlayerHatRender extends RenderLayer<AvatarRenderState, PlayerModel> {
    private final ModelHat hatModel;

    public PlayerHatRender(RenderLayerParent<AvatarRenderState, PlayerModel> parent, EntityModelSet modelSet) {
        super(parent);
        this.hatModel = new ModelHat(modelSet.bakeLayer(ModelHat.LAYER_LOCATION));
    }

    private static Identifier getHatTexture(String baseName) {
        LocalDate today = LocalDate.now();
        boolean oct31 = today.getMonth() == Month.OCTOBER && today.getDayOfMonth() == 31;
        String path = "textures/model/devhats/" + baseName + (oct31 ? "_alt" : "") + ".png";
        return Identifier.fromNamespaceAndPath(MODID, path);
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, AvatarRenderState state, float yRot, float xRot) {
        Minecraft mc = Minecraft.getInstance();
        UUID playerUuid = mc.player != null ? mc.player.getUUID() : null;
        boolean hasRole = playerUuid != null && (Utils.isDeveloperName(playerUuid) || Utils.isTesterName(playerUuid) || Utils.isSpecial(playerUuid) || Utils.isArtist(playerUuid) || Utils.isFriend(playerUuid));

        if (hasRole && !state.isInvisible && state.showHat) {
            String baseTexture = "hat_red";
            if (Utils.isSpecial(playerUuid)) {
                baseTexture = "hat_yellow";
            } else if (Utils.isTesterName(playerUuid)) {
                baseTexture = "hat_blue";
            } else if (Utils.isArtist(playerUuid)) {
                baseTexture = "hat_purple";
            } else if (Utils.isFriend(playerUuid)) {
                baseTexture = "hat_pink";
            }

            Identifier texture = getHatTexture(baseTexture);

            poseStack.pushPose();
            this.hatModel.setupAnim(state);
            this.hatModel.head.loadPose(this.getParentModel().head.storePose());
            submitNodeCollector.submitModel(this.hatModel, state, poseStack, RenderTypes.entityCutout(texture), lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);
            poseStack.popPose();
        }
    }
}