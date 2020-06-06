package divinerpg.objects.entities.assets.render;

import divinerpg.DivineRPG;
import divinerpg.config.GeneralConfig;
import divinerpg.objects.entities.assets.model.ModelHat;
import divinerpg.utils.Utils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.UUID;

public class PlayerHatRender implements LayerRenderer<EntityPlayer> {
    private ModelHat modelHat;
    private RenderPlayer renderManager;
    private ResourceLocation dev = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_red.png");
    private ResourceLocation tester = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_blue.png");
    private ResourceLocation artist = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_purple.png");
    private ResourceLocation patreon = new ResourceLocation(DivineRPG.MODID, "textures/model/devhats/hat_yellow.png");

    public PlayerHatRender(RenderPlayer renderManager) {
        this.renderManager = renderManager;
        modelHat = new ModelHat(renderManager.getMainModel());
    }

    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(GeneralConfig.generalOptions.enablePlayerHats == false) {
            return;
        }

        ResourceLocation texture = getTexture(player);
        if (texture == null) {
            return;
        }

        GlStateManager.pushMatrix();

        if (player.isSneaking()) {
            GlStateManager.translate(0.0F, 0.2F, 0.0F);
        }

        renderManager.bindTexture(texture);
        modelHat.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.popMatrix();
    }

    @Nullable
    private ResourceLocation getTexture(EntityPlayer entity) {
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
        }

        return null;
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
