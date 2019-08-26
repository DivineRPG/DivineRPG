package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelEnchantedArcher;
import divinerpg.objects.entities.entity.twilight.SkythernArcher;
import divinerpg.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSkythernArcher extends RenderLiving<SkythernArcher> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/skythern_archer.png");

    public RenderSkythernArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnchantedArcher(), shadowsizeIn);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(SkythernArcher entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<SkythernArcher> {
        @Override
        public Render<? super SkythernArcher> createRenderFor(RenderManager manager) {
            return new RenderSkythernArcher(manager, new ModelEnchantedArcher(), 0);
        }
    }

    private class MainHandLayer implements LayerRenderer<SkythernArcher> {
        protected final RenderSkythernArcher renderSkythernArcher;

        public MainHandLayer(RenderSkythernArcher renderSkythernArcherIn) {
            this.renderSkythernArcher = renderSkythernArcherIn;
        }

        @Override
        public void doRenderLayer(SkythernArcher entity, float limbSwing, float limbSwingAmount, float partialTicks,
                float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelEnchantedArcher) this.renderSkythernArcher.getMainModel()).rightarm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(-0.45F, 0.35F, -0.05F);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(ModItems.skythernBow),
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