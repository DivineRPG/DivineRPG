package naturix.divinerpg.objects.blocks.tile.render;

import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixStatue;
import naturix.divinerpg.objects.blocks.tile.model.ModelDramixStatue;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDramixStatue extends TileEntitySpecialRenderer<TileEntityDramixStatue> {
    private static final ResourceLocation ENDER_CHEST_TEXTURE = new ResourceLocation(
            "divinerpg:textures/model/dramix_statue.png");
    private final ModelDramixStatue modelChest = new ModelDramixStatue();

    @Override
    public void render(TileEntityDramixStatue te, double x, double y, double z, float partialTicks, int destroyStage,
            float alpha) {
        int i = 0;

        if (te.hasWorld()) {
            i = te.getBlockMetadata();
        }

        if (destroyStage >= 0) {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        } else {
            this.bindTexture(ENDER_CHEST_TEXTURE);
        }

        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
        GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        GlStateManager.translate(0.5F, 0.5F, 0.5F);
        int j = 0;

        if (i == 2) {
            j = 180;
        }

        if (i == 3) {
            j = 0;
        }

        if (i == 4) {
            j = 90;
        }

        if (i == 5) {
            j = -90;
        }

        GlStateManager.rotate(j, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(-0.5F, -0.5F, -0.5F);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        if (destroyStage >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}