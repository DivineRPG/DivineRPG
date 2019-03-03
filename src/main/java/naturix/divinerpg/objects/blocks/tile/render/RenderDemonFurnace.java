package naturix.divinerpg.objects.blocks.tile.render;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityDemonFurnace;
import naturix.divinerpg.objects.blocks.tile.model.ModelDemonFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDemonFurnace extends TileEntitySpecialRenderer<TileEntityDemonFurnace> {
    public static ResourceLocation FURNACE_ON = new ResourceLocation("divinerpg:textures/model/demon_furnace_on.png");
    public static ResourceLocation FURNACE_OFF = new ResourceLocation("divinerpg:textures/model/demon_furnace.png");

    private static ModelDemonFurnace model = new ModelDemonFurnace();

    public void render(TileEntityDemonFurnace te, double x, double y, double z, float partialTicks, int destroyStage,
            float alpha) {
        int rotation = 0;
        if (te.getWorld() != null)
            rotation = te.getBlockMetadata();
        if (rotation >= 8) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(FURNACE_ON);
            rotation = rotation - 8;
        } else {
            Minecraft.getMinecraft().getTextureManager().bindTexture(FURNACE_OFF);
        }
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
        GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
        model.render(0.0625F);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
