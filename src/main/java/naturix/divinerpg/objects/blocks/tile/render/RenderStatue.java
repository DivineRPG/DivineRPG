package naturix.divinerpg.objects.blocks.tile.render;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityStatue;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.world.World;

public class RenderStatue extends TileEntitySpecialRenderer<TileEntityStatue> {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final int[] facingToRotation = new int[] { 0, 270, 180, 90 };

    public void render(TileEntityStatue te, double x, double y, double z, float partialTicks, int destroyStage,
            float alpha) {
        int rotation = 0;
        World world = te.getWorld();
        if (world != null) {
            IBlockState state = world.getBlockState(te.getPos());
            rotation = facingToRotation[state.getValue(FACING).getHorizontalIndex()];
        }
        Minecraft.getMinecraft().getTextureManager().bindTexture(te.statueType.getTexture());
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.7F, (float) z + 0.5F);
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
        te.statueType.getModel().render(0.0625F);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}