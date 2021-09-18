package divinerpg.blocks.base;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

import java.util.function.*;

public class BlockModDoor extends DoorBlock {
	
    public BlockModDoor(String name, Material material, float hardness, float resistance, ToolType tool) {
        super(Block.Properties
                .of(material)
                .strength(hardness, resistance)
                .harvestTool(tool)
                .noOcclusion()
                .requiresCorrectToolForDrops());
        setRegistryName(DivineRPG.MODID, name);
    }

    public BlockModDoor(String name, Material material, float hardness, Supplier<Item> doorItem) {
        super(Block.Properties
                .of(material)
                .strength(hardness, 2)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
        setRegistryName(DivineRPG.MODID, name);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
            state = state.cycle(OPEN);
            world.setBlock(pos, state, 10);
            world.levelEvent(player, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), pos, 0);
            return ActionResultType.sidedSuccess(world.isClientSide);
    }

    private int getCloseSound() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.material == Material.METAL ? 1005 : 1006;
    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return new ItemStack(state.getBlock());
    }

}