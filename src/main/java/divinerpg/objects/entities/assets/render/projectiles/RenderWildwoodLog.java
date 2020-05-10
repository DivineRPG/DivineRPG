package divinerpg.objects.entities.assets.render.projectiles;

import org.lwjgl.opengl.GL11;

import divinerpg.api.Reference;
import divinerpg.objects.entities.entity.projectiles.EntityWildwoodLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class RenderWildwoodLog extends RenderProjectile<EntityWildwoodLog> {
    private ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/blocks/wildwood_log_side.png");

    public RenderWildwoodLog(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.shadowSize = 0.5F;
    }
    
    @Override
    public void doRender(EntityWildwoodLog entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (entity.getBlock() != null)
        {
            IBlockState iblockstate = entity.getBlock().getDefaultState();
            GL11.glScaled(3, 3, 3);
            if (iblockstate.getRenderType() == EnumBlockRenderType.MODEL)
            {
                World world = entity.world;

                if (iblockstate != world.getBlockState(new BlockPos(entity)) && iblockstate.getRenderType() != EnumBlockRenderType.INVISIBLE)
                {
                    this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                    GlStateManager.pushMatrix();
                    GlStateManager.disableLighting();
                    Tessellator tessellator = Tessellator.getInstance();
                    BufferBuilder bufferbuilder = tessellator.getBuffer();

                    if (this.renderOutlines)
                    {
                        GlStateManager.enableColorMaterial();
                        GlStateManager.enableOutlineMode(this.getTeamColor(entity));
                    }

                    bufferbuilder.begin(7, DefaultVertexFormats.BLOCK);
                    BlockPos blockpos = new BlockPos(entity.posX, entity.getEntityBoundingBox().maxY, entity.posZ);
                    GlStateManager.translate((float)(x - (double)blockpos.getX() - 0.5D), (float)(y - (double)blockpos.getY()), (float)(z - (double)blockpos.getZ() - 0.5D));
                    BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
                    blockrendererdispatcher.getBlockModelRenderer().renderModel(world, blockrendererdispatcher.getModelForState(iblockstate), iblockstate, blockpos, bufferbuilder, false, MathHelper.getPositionRandom(entity.getPosition()));
                    tessellator.draw();

                    if (this.renderOutlines)
                    {
                        GlStateManager.disableOutlineMode();
                        GlStateManager.disableColorMaterial();
                    }

                    GlStateManager.enableLighting();
                    GlStateManager.popMatrix();
                    super.doRender(entity, x, y, z, entityYaw, partialTicks);
                }
            }
        }
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityWildwoodLog entity) {
        return TEXTURE;
    }
}