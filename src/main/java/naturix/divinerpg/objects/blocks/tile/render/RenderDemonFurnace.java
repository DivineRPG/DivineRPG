package naturix.divinerpg.objects.blocks.tile.render;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityDemonFurnace;
import naturix.divinerpg.objects.blocks.tile.model.ModelDemonFurnace;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderDemonFurnace extends TileEntitySpecialRenderer<TileEntityDemonFurnace> {
    public static ResourceLocation FURNACE_ON = new ResourceLocation("divinerpg:textures/model/demon_furnace_on.png");
    public static ResourceLocation FURNACE_OFF = new ResourceLocation("divinerpg:textures/model/demon_furnace.png");
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final int[] facingToRotation = new int[] { 180, 90, 0, 270 };

    private static ModelDemonFurnace model = new ModelDemonFurnace();

    public void render(TileEntityDemonFurnace te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        ResourceLocation texture = FURNACE_OFF;
        int rotation = 0;

        World world = te.getWorld();
        if (world != null) {
            IBlockState state = world.getBlockState(te.getPos());
            //if (state.getBlock() == ModBlocks.demonFurnaceOn) {
            //    texture = FURNACE_ON;
            //}
            rotation = facingToRotation[state.getValue(FACING).getHorizontalIndex()];
        }

        this.bindTexture(texture);

        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.translate((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
        GlStateManager.rotate(rotation, 0.0F, 1.0F, 0.0F);
        model.render(0.0625F);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
    }
}
