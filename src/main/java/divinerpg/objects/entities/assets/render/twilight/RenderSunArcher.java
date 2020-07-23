package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSunArcher;
import divinerpg.objects.entities.entity.eden.EntitySunArcher;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSunArcher extends RenderLiving<EntitySunArcher> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/sun_archer.png");

    public RenderSunArcher(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSunArcher(), 1F);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySunArcher entity) {
        return texture;
    }


    private class MainHandLayer implements LayerRenderer<EntitySunArcher> {
        protected final RenderSunArcher renderSunArcher;

        public MainHandLayer(RenderSunArcher renderSunArcherIn) {
            this.renderSunArcher = renderSunArcherIn;
        }

        @Override
        public void doRenderLayer(EntitySunArcher entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelSunArcher) this.renderSunArcher.getMainModel()).armRight.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(0.075f, 0.05f, -0.1);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(WeaponRegistry.edenBow),
                    ItemCameraTransforms.TransformType.NONE);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }

        @Override
        public boolean shouldCombineTextures() {
            return false;
        }
    }
}