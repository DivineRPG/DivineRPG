package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.*;
import divinerpg.DivineRPG;
import divinerpg.client.models.ModelHat;
import divinerpg.util.Utils;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.*;

import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class PlayerHatRender<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private ModelHat<T> modelHat;
    private ResourceLocation dev = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_red.png");
    private ResourceLocation tester = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_blue.png");
    private ResourceLocation artist = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_purple.png");
    private ResourceLocation special = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_yellow.png");
    private ResourceLocation friend = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_pink.png");

    public PlayerHatRender(RenderLayerParent<T, M> parent, EntityModelSet set) {
        super(parent);
        modelHat = new ModelHat<T>(set.bakeLayer(ModelHat.LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity != null) {
            UUID id = entity.getUUID();
            if (entity.inventory.getArmor(3).isEmpty()) {
                if (Utils.isDeveloperName(id) || Utils.isTesterName(id) || Utils.isFriend(id) || Utils.isSpecial(id) || Utils.isArtist(id)) {
                    modelHat.top.copyFrom(getParentModel().head);
                    modelHat.bottom.copyFrom(getParentModel().head);
                    VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
                    this.modelHat.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                }
            }
        }
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        if (entity != null) {
        UUID id = entity.getUUID();

        if (Utils.isDeveloperName(id)) {
            return dev;
        }

        if (Utils.isSpecial(id)) {
            return special;
        }

        if (Utils.isTesterName(id)) {
            return tester;
        }

        if (Utils.isArtist(id)) {
            return artist;
        }

        if (Utils.isFriend(id)) {
            return friend;
        }
    }

        return dev;
    }

}
