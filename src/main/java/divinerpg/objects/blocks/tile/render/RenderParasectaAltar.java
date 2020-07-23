package divinerpg.objects.blocks.tile.render;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import divinerpg.objects.blocks.tile.model.ModelParasectaAltar;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderParasectaAltar extends TileEntitySpecialRenderer<TileEntityParasectaAltar> {
    private static ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/model/parasecta_altar.png");
    private static ModelParasectaAltar model = new ModelParasectaAltar();

    public void render(TileEntityParasectaAltar te, double x, double y, double z, float partialTicks, int destroyStage,
            float alpha) {
        this.bindTexture(TEXTURE);

        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.translate((float) x + 0.5F, (float) y - 0.6F, (float) z + 0.5F);
        model.render(0.0625F);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
    }
}
