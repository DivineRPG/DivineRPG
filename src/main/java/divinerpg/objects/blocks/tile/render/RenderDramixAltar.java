package divinerpg.objects.blocks.tile.render;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import divinerpg.objects.blocks.tile.model.ModelDramixAltar;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDramixAltar extends TileEntitySpecialRenderer<TileEntityDramixAltar> {
    private static ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/model/dramix_altar.png");
    private static ModelDramixAltar model = new ModelDramixAltar();

    public void render(TileEntityDramixAltar te, double x, double y, double z, float partialTicks, int destroyStage,
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
