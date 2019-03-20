package naturix.divinerpg.objects.blocks.tile.render;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.objects.blocks.tile.model.ParasectaAltarModel;
import naturix.divinerpg.utils.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class TileEntityParasectaAltarRender extends TileEntitySpecialRenderer<TileEntityParasectaAltar> {

    private ParasectaAltarModel model;
    public static TileEntityParasectaAltarRender instance;

    public TileEntityParasectaAltarRender() {

        model = new ParasectaAltarModel();
    }

    @Override
    public void render(TileEntityParasectaAltar te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MODID + ":textures/model/altar_parasecta.png"));
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y - 0.6F, (float) z + 0.5F);
        model.render(0.0625F);
        GL11.glPopMatrix();
    }
}