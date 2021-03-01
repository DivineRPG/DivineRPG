package divinerpg.client.renders.layer;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.*;
import divinerpg.util.*;
import net.minecraft.client.entity.player.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

@OnlyIn(Dist.CLIENT)
public class PlayerHatRender <T extends PlayerEntity, M extends PlayerModel<T>> extends LayerRenderer<T, M> {
    private ModelHat modelHat;
    private IEntityRenderer<AbstractClientPlayerEntity, ModelHat<AbstractClientPlayerEntity>> renderManager;
    private ResourceLocation dev = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_red.png");
    private ResourceLocation tester = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_blue.png");
    private ResourceLocation artist = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_purple.png");
    private ResourceLocation patreon = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_yellow.png");
    private ResourceLocation friend = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_pink.png");

    public PlayerHatRender(IEntityRenderer<T, M> entityRendererIn) {
        super(entityRendererIn);
        modelHat=new ModelHat(getEntityModel());
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entitylivingbaseIn.isSneaking()) {
            matrixStackIn.translate(0.0F, 0.2F, 0.0F);
        }
        this.getEntityModel().copyModelAttributesTo(modelHat);
        this.modelHat.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        this.modelHat.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(getEntityTexture(entitylivingbaseIn)));
        this.modelHat.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

    }

    @Override
    public ResourceLocation getEntityTexture(T entity) {
        if (entity != null) {
        UUID id = entity.getUniqueID();

        if (Utils.isDeveloperName(id)) {
            return dev;
        }

        if (Utils.isPatreon(id)) {
            return patreon;
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

        return null;
    }

}
