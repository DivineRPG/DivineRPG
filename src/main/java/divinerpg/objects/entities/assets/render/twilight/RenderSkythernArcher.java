package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelEnchantedArcher;
import divinerpg.objects.entities.entity.twilight.EntitySkythernArcher;
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

public class RenderSkythernArcher extends RenderLiving<EntitySkythernArcher> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_archer.png");

    public RenderSkythernArcher(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEnchantedArcher(), 1F);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySkythernArcher entity) {
        return texture;
    }

    private class MainHandLayer implements LayerRenderer<EntitySkythernArcher> {
        protected final RenderSkythernArcher renderSkythernArcher;

        public MainHandLayer(RenderSkythernArcher renderSkythernArcherIn) {
            this.renderSkythernArcher = renderSkythernArcherIn;
        }

        @Override
        public void doRenderLayer(EntitySkythernArcher entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelEnchantedArcher) this.renderSkythernArcher.getMainModel()).rightarm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(-0.45F, 0.35F, -0.05F);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(WeaponRegistry.skythernBow),
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