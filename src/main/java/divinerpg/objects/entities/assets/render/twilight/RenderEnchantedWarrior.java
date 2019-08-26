package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelEnchantedWarrior;
import divinerpg.objects.entities.entity.twilight.EnchantedWarrior;
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

public class RenderEnchantedWarrior extends RenderLiving<EnchantedWarrior> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/enchanted_warrior.png");

    public RenderEnchantedWarrior(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnchantedWarrior(), shadowsizeIn);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EnchantedWarrior entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EnchantedWarrior> {
        @Override
        public Render<? super EnchantedWarrior> createRenderFor(RenderManager manager) {
            return new RenderEnchantedWarrior(manager, new ModelEnchantedWarrior(), 0);
        }
    }

    private class MainHandLayer implements LayerRenderer<EnchantedWarrior> {
        protected final RenderEnchantedWarrior renderEnchantedWarrior;

        public MainHandLayer(RenderEnchantedWarrior renderEnchantedWarriorIn) {
            this.renderEnchantedWarrior = renderEnchantedWarriorIn;
        }

        @Override
        public void doRenderLayer(EnchantedWarrior entity, float limbSwing, float limbSwingAmount, float partialTicks,
                float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelEnchantedWarrior) this.renderEnchantedWarrior.getMainModel()).bipedRightArm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(0, 0, -0.55f);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(ModItems.apalachiaBlade),
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