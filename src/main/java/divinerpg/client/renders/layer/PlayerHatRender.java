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
import net.neoforged.api.distmarker.*;

import java.time.*;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class PlayerHatRender<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private final ModelHat<T> modelHat;
    private final ResourceLocation
        hat = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/devhats/hat.png"),
        pumpkin_hat = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/devhats/pumpkin_hat.png");
    public PlayerHatRender(RenderLayerParent<T, M> parent, EntityModelSet set) {
        super(parent);
        modelHat = new ModelHat<>(set.bakeLayer(ModelHat.LAYER_LOCATION));
    }
    @Override public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        UUID id = entity.getUUID();
        if(entity.getInventory().getArmor(3).isEmpty() && !entity.isInvisible() && entity.isModelPartShown(PlayerModelPart.HAT)) {
            if(Utils.isDeveloperName(id) || Utils.isTesterName(id) || Utils.isFriend(id) || Utils.isSpecial(id) || Utils.isArtist(id)) {
                modelHat.hat.copyFrom(getParentModel().head);
                modelHat.colorband.copyFrom(getParentModel().head);
                VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
                modelHat.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, getColor(entity));
            }
        }
    }
    public int getColor(T entity) {
        UUID id = entity.getUUID();
        if(Utils.isSpecial(id)) return 0xfed93f;
        if(Utils.isTesterName(id)) return 0x159295;
        if(Utils.isArtist(id)) return 0x9743cd;
        if(Utils.isFriend(id)) return 0xf4a7c0;
        return 0xa82a23;
    }
    @Override public ResourceLocation getTextureLocation(T entity) {
        LocalDate now = LocalDate.now();
        return now.getMonth() == Month.OCTOBER && now.getDayOfMonth() == 31 ? pumpkin_hat : hat;
    }
}