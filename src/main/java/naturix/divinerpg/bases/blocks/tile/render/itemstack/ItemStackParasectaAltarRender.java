package naturix.divinerpg.bases.blocks.tile.render.itemstack;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.tile.model.ParasectaAltarModel;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemStackParasectaAltarRender extends TileEntityItemStackRenderer {
    public final TileEntityItemStackRenderer PARENT;
    private final ParasectaAltarModel MODEL_ALTAR = new ParasectaAltarModel();
    private final ResourceLocation ALTAR_PARTS_TEXTURE = new ResourceLocation(DivineRPG.modId + ":textures/model/altar_parasecta.png");

    public ItemStackParasectaAltarRender(TileEntityItemStackRenderer previous) {
    	PARENT = previous;
    }

    @Override
    public void renderByItem(ItemStack stack) {
    	this.renderByItem(stack, 1.0F);
    }

    @Override
	public void renderByItem(ItemStack stack, float partialTicks) {
        if ((!stack.isEmpty())) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(ALTAR_PARTS_TEXTURE);
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0, -1.0, -1.0);
            MODEL_ALTAR.render(1);
            GlStateManager.popMatrix();
            renderItem(Item.getItemFromBlock(ModBlocks.altarParasecta));
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.25, 1.25, 1.25);
            GlStateManager.translate(0, 0, 0.08125);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            
            GlStateManager.popMatrix();
        }
        else
            PARENT.renderByItem(stack);
    }

    private void renderItem(Item blockIn){
        ItemStack stack = new ItemStack(blockIn);
        stack.getItem().getTileEntityItemStackRenderer().renderByItem(stack);
    }
}