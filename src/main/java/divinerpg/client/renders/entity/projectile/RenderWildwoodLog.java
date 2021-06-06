package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.matrix.*;
import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class RenderWildwoodLog extends EntityRenderer<EntityWildwoodLog> {
    public RenderWildwoodLog(EntityRendererManager p_i46177_1_) {
        super(p_i46177_1_);
        this.shadowRadius = 0.5F;
    }

    @Override
    public ResourceLocation getTextureLocation(EntityWildwoodLog p_110775_1_) {
        return new ResourceLocation(DivineRPG.MODID, "textures/blocks/wildwood_log_side.png");
    }

    public void render(EntityWildwoodLog p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        BlockState blockstate = BlockRegistry.wildwoodLog.defaultBlockState();
        if (blockstate.getRenderShape() == BlockRenderType.MODEL) {
            World world = p_225623_1_.level;
            if (blockstate != world.getBlockState(p_225623_1_.blockPosition()) && blockstate.getRenderShape() != BlockRenderType.INVISIBLE) {
                p_225623_4_.pushPose();
                BlockPos blockpos = new BlockPos(p_225623_1_.getX(), p_225623_1_.getBoundingBox().maxY, p_225623_1_.getZ());
                p_225623_4_.translate(-0.5D, 0.0D, -0.5D);
                BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
                for (net.minecraft.client.renderer.RenderType type : net.minecraft.client.renderer.RenderType.chunkBufferLayers()) {
                    if (RenderTypeLookup.canRenderInLayer(blockstate, type)) {
                        net.minecraftforge.client.ForgeHooksClient.setRenderLayer(type);
                        blockrendererdispatcher.getModelRenderer().tesselateBlock(world, blockrendererdispatcher.getBlockModel(blockstate), blockstate, blockpos, p_225623_4_, p_225623_5_.getBuffer(type), false, new Random(), blockstate.getSeed(p_225623_1_.blockPosition()), OverlayTexture.NO_OVERLAY);
                    }
                }
                net.minecraftforge.client.ForgeHooksClient.setRenderLayer(null);
                p_225623_4_.popPose();
                super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
            }
        }
    }
}