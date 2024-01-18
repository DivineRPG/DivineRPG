package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.shapes.*;

public class BlockModDungeonAir extends BlockMod {
    /**
     * remove the {@code .air()} property for better managing when building with this block
     */
    public BlockModDungeonAir() {
        super(BlockBehaviour.Properties.of().noLootTable().noOcclusion().noCollission().air());
    }
    @Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if(entity instanceof ServerPlayer && !((ServerPlayer) entity).hasEffect(MobEffectRegistry.HEAVY_AIR.get()) && ((ServerPlayer) entity).gameMode.getGameModeForPlayer() == GameType.SURVIVAL)
			((ServerPlayer) entity).addEffect(new MobEffectInstance(MobEffectRegistry.HEAVY_AIR.get(), 20, 1, true, false, false));
	}
    @Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
    	return context.isHoldingItem(BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "dungeon_air")).asItem()) ? Shapes.block() : Shapes.empty();
	}
    @Override
	public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
		return 1.0F;
    }
    @Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.INVISIBLE;
    }
    @Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
		return true;
    }
}