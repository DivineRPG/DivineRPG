package naturix.divinerpg.objects.blocks.tile.render;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.objects.blocks.tile.model.ParasectaAltarModel;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityParasectaAltarRender extends TileEntitySpecialRenderer<TileEntityParasectaAltar> {

    private ParasectaAltarModel model;
    public static TileEntityParasectaAltarRender instance;

    public TileEntityParasectaAltarRender() {

        model = new ParasectaAltarModel();
    }

    @Override
    public void render(TileEntityParasectaAltar te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(DivineRPG.modId + ":textures/model/altar_parasecta.png"));
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y - 0.6F, (float) z + 0.5F);
        model.render(0.0625F);
        GL11.glPopMatrix();
    }
}