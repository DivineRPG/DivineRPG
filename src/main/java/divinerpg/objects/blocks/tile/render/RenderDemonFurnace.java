package divinerpg.objects.blocks.tile.render;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.entity.TileEntityDemonFurnace;
import divinerpg.objects.blocks.tile.model.ModelDemonFurnace;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderDemonFurnace extends TileEntitySpecialRenderer<TileEntityDemonFurnace> {
    public static final int[] facingToRotation = new int[]{180, 90, 0, 270};
    public static ResourceLocation FURNACE_ON = new ResourceLocation(DivineRPG.MODID, "textures/model/demon_furnace_on.png");
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static ResourceLocation FURNACE_OFF = new ResourceLocation(DivineRPG.MODID, "textures/model/demon_furnace.png");

    private static ModelDemonFurnace model = new ModelDemonFurnace();

    public void render(TileEntityDemonFurnace te, double x, double y, double z, float partialTicks, int destroyStage,
                       float alpha) {
        ResourceLocation texture = FURNACE_OFF;
        int rotation = 0;

        World world = te.getWorld();
        if (world != null) {
            IBlockState state = world.getBlockState(te.getPos());
            if (state.getBlock() == BlockRegistry.demonFurnaceOn) {
                texture = FURNACE_ON;
            }
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
