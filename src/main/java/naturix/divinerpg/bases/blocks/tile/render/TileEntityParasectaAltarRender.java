package naturix.divinerpg.bases.blocks.tile.render;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.bases.blocks.tile.model.ParasectaAltarModel;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TileEntityParasectaAltarRender extends TileEntitySpecialRenderer<TileEntityParasectaAltar> {

	private ParasectaAltarModel model;
	public static TileEntityParasectaAltarRender instance;
	private RenderManager renderManager;
	private final RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	
	public TileEntityParasectaAltarRender() {
		model = new ParasectaAltarModel();
	}

	@Override
	public void render(TileEntityParasectaAltar te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {	
		
		if(te == null || !te.hasWorld()) {
			//renderTileAsItem(x, y, z);
			ItemStack stack = new ItemStack(ModBlocks.altarParasecta);
			//this.renderItem.renderItem(stack, TransformType.FIXED);
			return;
		}
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(DivineRPG.modId + ":textures/model/altar_parasecta.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y - 0.6F, (float)z + 0.5F);
		model.render(0.0625F);
		
		GL11.glPopMatrix();
	}
	
	private final ParasectaAltarModel modelBasic = new ParasectaAltarModel();
	private static final ResourceLocation[] TEXTURE = new ResourceLocation[] { new ResourceLocation(DivineRPG.modId + ":textures/model/altar_parasecta.png") };

	
	private void renderTileAsItem(double x, double y, double z) {
		GlStateManager.pushMatrix();
		bindTexture(TEXTURE[0]);
		GlStateManager.translate((float) x + 0.5F, (float) y + 0.75F, (float) z + 0.5F);
		GlStateManager.pushMatrix();
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
		modelBasic.render(0.125F);
		GlStateManager.popMatrix();
	}
}