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
import net.minecraft.world.entity.player.*;
import net.minecraftforge.api.distmarker.*;

import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class PlayerHatRender<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private final ModelHat<T> modelHat;
    private final ResourceLocation
        dev = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_red.png"),
        tester = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_blue.png"),
        artist = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_purple.png"),
        special = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_yellow.png"),
        friend = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_pink.png");
    public PlayerHatRender(RenderLayerParent<T, M> parent, EntityModelSet set) {
        super(parent);
        modelHat = new ModelHat<>(set.bakeLayer(ModelHat.LAYER_LOCATION));
    }
    @Override public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        UUID id = entity.getUUID();
        if(entity.inventory.getArmor(3).isEmpty() && !entity.isInvisible() && entity.isModelPartShown(PlayerModelPart.HAT)) {
            if(Utils.isDeveloperName(id) || Utils.isTesterName(id) || Utils.isFriend(id) || Utils.isSpecial(id) || Utils.isArtist(id)) {
                modelHat.hat.copyFrom(getParentModel().head);
                VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
                modelHat.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
            }
        }
    }
    @Override public ResourceLocation getTextureLocation(T entity) {
        UUID id = entity.getUUID();
        if(Utils.isSpecial(id)) return special;
        if(Utils.isTesterName(id)) return tester;
        if(Utils.isArtist(id)) return artist;
        if(Utils.isFriend(id)) return friend;
        return dev;
    }
}