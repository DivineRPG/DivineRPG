package divinerpg.blocks.vethea;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import divinerpg.tiles.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockInfusionTable extends Block {

    public BlockInfusionTable(String name) {
        super(AbstractBlock.Properties.of(Material.STONE).strength(-1, 6000000F));
        setRegistryName(name);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.MODEL;
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityInfusionTable();
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (player instanceof ServerPlayerEntity) {
            player.openMenu(state.getMenuProvider(world, pos));
            return ActionResultType.CONSUME;
        }
        return ActionResultType.SUCCESS;
    }

    @Nullable
    @Override
    public INamedContainerProvider getMenuProvider(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedContainerProvider((i, inventory, player) -> {
            return new InfusionTableContainer<>(i, inventory, IWorldPosCallable.create(world, pos));
        }, new TranslationTextComponent(BlockRegistry.infusionTable.getDescriptionId()));
    }

}
