package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelJackOMan;
import divinerpg.objects.entities.entity.vanilla.EntityJackOMan;
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

public class RenderJackOMan extends RenderLiving<EntityJackOMan> {

    public static ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/jackoman.png");

    public RenderJackOMan(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelJackOMan(), 0.5F);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityJackOMan entity) {
        return TEXTURE;
    }

    private class MainHandLayer implements LayerRenderer<EntityJackOMan> {
        protected final RenderJackOMan renderJackOMan;

        public MainHandLayer(RenderJackOMan renderJackOManIn) {
            this.renderJackOMan = renderJackOManIn;
        }

        @Override
        public void doRenderLayer(EntityJackOMan entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelJackOMan) this.renderJackOMan.getMainModel()).bipedRightArm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(0, 0, -0.3);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(WeaponRegistry.scythe),
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