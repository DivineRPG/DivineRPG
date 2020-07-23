package divinerpg.objects.blocks.tile.render;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.entity.TileEntityArcaniumExtractor;
import divinerpg.objects.blocks.tile.model.ModelArcaniumExtractor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderArcaniumExtractor extends TileEntitySpecialRenderer<TileEntityArcaniumExtractor> {
    private static ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/model/arcanium_extractor.png");
    private static ModelArcaniumExtractor model = new ModelArcaniumExtractor();

    public void render(TileEntityArcaniumExtractor te, double x, double y, double z, float partialTicks,
            int destroyStage, float alpha) {
        this.bindTexture(TEXTURE);

        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.translate((float) x + 0.5F, (float) y, (float) z + 0.5F);
        model.render(0.0625F);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
    }
}
