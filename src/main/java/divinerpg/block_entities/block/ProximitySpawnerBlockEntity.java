package divinerpg.block_entities.block;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.*;

public class ProximitySpawnerBlockEntity extends BlockEntity {
    private static final String ENTITY_NAME_TAG = "drpgentityname";
    public String entityName;
    public ProximitySpawnerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.PROXIMITY_SPAWNER.get(), pos, state);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, ProximitySpawnerBlockEntity entity) {
        if(level instanceof ServerLevel world && entity.entityName != null && world.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 25, EntitySelector.NO_CREATIVE_OR_SPECTATOR) != null) {
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            BuiltInRegistries.ENTITY_TYPE.getValue(entity.entityName.indexOf(':') == -1 ? Identifier.fromNamespaceAndPath(DivineRPG.MODID, entity.entityName) : Identifier.parse(entity.entityName)).spawn(world, pos, EntitySpawnReason.SPAWNER);
        }
    }
    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if(entityName != null) output.putString(ENTITY_NAME_TAG, entityName);
    }
    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        entityName = input.getStringOr(ENTITY_NAME_TAG, null);
    }
}