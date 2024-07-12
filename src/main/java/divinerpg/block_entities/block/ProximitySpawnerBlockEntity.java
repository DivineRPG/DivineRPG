package divinerpg.block_entities.block;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class ProximitySpawnerBlockEntity extends BlockEntity {
	private static final String ENTITY_NAME_TAG = "drpgentityname";
	public String entityName;
	public ProximitySpawnerBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegistry.PROXIMITY_SPAWNER.get(), pos, state);
	}
	public static void serverTick(Level level, BlockPos pos, BlockState state, ProximitySpawnerBlockEntity entity) {
		if(level instanceof ServerLevel world && entity.entityName != null && world.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 25, EntitySelector.NO_CREATIVE_OR_SPECTATOR) != null) {
			world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
			ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, entity.entityName)).spawn(world, pos, MobSpawnType.SPAWNER);
		}
	}
	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		if(entityName != null) tag.putString(ENTITY_NAME_TAG, entityName);
	}
	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		if(tag.contains(ENTITY_NAME_TAG)) entityName = tag.getString(ENTITY_NAME_TAG);
	}
}