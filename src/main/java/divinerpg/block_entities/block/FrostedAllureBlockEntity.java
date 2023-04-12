package divinerpg.block_entities.block;

import divinerpg.blocks.iceika.BlockFrostedAllure;
import divinerpg.config.CommonConfig;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class FrostedAllureBlockEntity extends BlockEntity {

    public FrostedAllureBlockEntity(BlockPos p_155077_, BlockState p_155078_) {
        super(BlockEntityRegistry.FROSTED_ALLURE.get(), p_155077_, p_155078_);
    }

    @Override @Nullable
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, FrostedAllureBlockEntity block) {
        if (level instanceof ServerLevel && level.random.nextInt(5000) == 0 && ((ServerLevel) level).getAllEntities().spliterator().estimateSize() <= CommonConfig.allureMaxMobs.get()) {
            switch(state.getValue(BlockFrostedAllure.CATEGORY)) {
                case 1:
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.MONSTER, (ServerLevel) level, pos.above());
                    break;
                case 2:
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.CREATURE, (ServerLevel) level, pos.above());
                    break;
                case 3:
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.AMBIENT, (ServerLevel) level, pos.above());
                    break;
                case 4:
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.AXOLOTLS, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.UNDERGROUND_WATER_CREATURE, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.WATER_CREATURE, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.WATER_AMBIENT, (ServerLevel) level, pos.above());
                    break;
                case 5:
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.MISC, (ServerLevel) level, pos.above());
                    break;
                default:
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.MONSTER, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.CREATURE, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.AMBIENT, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.AXOLOTLS, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.UNDERGROUND_WATER_CREATURE, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.WATER_CREATURE, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.WATER_AMBIENT, (ServerLevel) level, pos.above());
                    NaturalSpawner.spawnCategoryForPosition(MobCategory.MISC, (ServerLevel) level, pos.above());
                    break;

            }
        }
    }
}
