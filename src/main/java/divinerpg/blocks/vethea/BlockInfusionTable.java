package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockMod;
import divinerpg.client.menu.InfusionTableMenu;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class BlockInfusionTable extends BlockMod {
    public BlockInfusionTable() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(-1, 3600000).instrument(NoteBlockInstrument.BASEDRUM));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult result) {
    	if (world.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable(BlockRegistry.infusionTable.get().getDescriptionId());
                }
                @Nullable @Override
                public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
                    return new InfusionTableMenu(windowId, inv, ContainerLevelAccess.create(player.level(), pos));
                }
            });
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inventory, player) -> {
            return new InfusionTableMenu(i, inventory, ContainerLevelAccess.create(level, pos));
        }, Component.translatable(BlockRegistry.infusionTable.get().getDescriptionId()));
    }

}