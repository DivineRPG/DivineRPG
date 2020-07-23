package divinerpg.client.render;

import divinerpg.objects.items.base.DivineShield;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelShield;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class ShieldsRender extends TileEntityItemStackRenderer {
    private ModelShield modelShield = new ModelShield();

    @Override
    public void renderByItem(ItemStack stack, float partialTicks) {
        Item item = stack.getItem();
        if (item instanceof DivineShield) {
            ResourceLocation texture = getShieldTexture((DivineShield) item);
            if (texture != null) {
                Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

                GlStateManager.pushMatrix();
                GlStateManager.scale(1.0F, -1.0F, -1.0F);
                this.modelShield.render();
                GlStateManager.popMatrix();

                return;
            }
        }

        super.renderByItem(stack, partialTicks);
    }

    @Nullable
    private ResourceLocation getShieldTexture(DivineShield item) {
        if (item == null)
            return null;

        ResourceLocation itemRegistryName = item.getRegistryName();
        if (itemRegistryName == null)
            return null;

        return new ResourceLocation(itemRegistryName.getResourceDomain(), "textures/shield/" + itemRegistryName.getResourcePath() + ".png");
    }
}
