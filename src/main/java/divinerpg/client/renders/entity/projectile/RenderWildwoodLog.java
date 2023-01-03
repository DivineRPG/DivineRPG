package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityWildwoodLog;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class RenderWildwoodLog extends EntityRenderer<EntityWildwoodLog> {
    private final BlockRenderDispatcher dispatcher;
    public RenderWildwoodLog(Context context) {
        super(context);
        this.shadowRadius = 0.5F;
        this.dispatcher = context.getBlockRenderDispatcher();
    }

    @Override
    public ResourceLocation getTextureLocation(EntityWildwoodLog p_110775_1_) {
        return new ResourceLocation(DivineRPG.MODID, "textures/block/wildwood_log_side.png");
    }

    public void render(EntityWildwoodLog entity, float p_114635_, float p_114636_, PoseStack p_114637_, MultiBufferSource p_114638_, int p_114639_) {
        BlockState blockstate = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_log")).defaultBlockState();
        if (blockstate.getRenderShape() == RenderShape.MODEL) {
            Level level = entity.getLevel();
            if (blockstate != level.getBlockState(entity.blockPosition()) && blockstate.getRenderShape() != RenderShape.INVISIBLE) {
                p_114637_.pushPose();
                BlockPos blockpos = new BlockPos(entity.getX(), entity.getBoundingBox().maxY, entity.getZ());
                p_114637_.translate(-0.5D, 0.0D, -0.5D);
                var model = this.dispatcher.getBlockModel(blockstate);
                for (var renderType : model.getRenderTypes(blockstate, RandomSource.create(blockstate.getSeed(entity.blockPosition())), net.minecraftforge.client.model.data.ModelData.EMPTY))
                    this.dispatcher.getModelRenderer().tesselateBlock(level, model, blockstate, blockpos, p_114637_, p_114638_.getBuffer(renderType), false, RandomSource.create(), blockstate.getSeed(entity.blockPosition()), OverlayTexture.NO_OVERLAY, net.minecraftforge.client.model.data.ModelData.EMPTY, renderType);
                p_114637_.popPose();
                super.render(entity, p_114635_, p_114636_, p_114637_, p_114638_, p_114639_);
            }
        }
    }
}