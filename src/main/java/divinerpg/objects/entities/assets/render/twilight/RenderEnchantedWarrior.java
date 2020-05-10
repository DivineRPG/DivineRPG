package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.api.Reference;
import divinerpg.objects.entities.assets.model.twilight.ModelEnchantedWarrior;
import divinerpg.objects.entities.entity.twilight.EntityEnchantedWarrior;
import divinerpg.registry.ModWeapons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEnchantedWarrior extends RenderLiving<EntityEnchantedWarrior> {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/enchanted_warrior.png");

    public RenderEnchantedWarrior(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEnchantedWarrior(), 0);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnchantedWarrior entity) {
        return texture;
    }

    private class MainHandLayer implements LayerRenderer<EntityEnchantedWarrior> {
        protected final RenderEnchantedWarrior renderEnchantedWarrior;

        public MainHandLayer(RenderEnchantedWarrior renderEnchantedWarriorIn) {
            this.renderEnchantedWarrior = renderEnchantedWarriorIn;
        }

        @Override
        public void doRenderLayer(EntityEnchantedWarrior entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelEnchantedWarrior) this.renderEnchantedWarrior.getMainModel()).bipedRightArm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(0, 0, -0.55f);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(ModWeapons.apalachiaBlade),
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