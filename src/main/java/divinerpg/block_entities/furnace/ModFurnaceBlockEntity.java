package divinerpg.block_entities.furnace;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

public abstract class ModFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public final String containerName;
    final float speed;
    protected ModFurnaceBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, String containerName, float speed)  {
        super(type, pos, state, RecipeType.SMELTING);
        this.containerName = containerName;
        this.speed = speed;
    }
    @Override
    protected float getSpeedMultiplier(ServerLevel level, ItemStack fuelItem) {
        return super.getSpeedMultiplier(level, fuelItem) * speed;
    }
    @Override
    protected Component getDefaultName() {
        return Component.translatable(containerName);
    }
}