package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockModUnbreakable;
import divinerpg.client.menu.InfusionTableMenu;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

import static net.minecraft.world.inventory.ContainerLevelAccess.create;
import static net.minecraft.world.level.material.MapColor.FIRE;

public class BlockInfusionTable extends BlockModUnbreakable {
    public BlockInfusionTable() {super(FIRE);}
    @Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
    @Override public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult result) {
    	if(world.isClientSide) return InteractionResult.SUCCESS;
        else {
            player.openMenu(new MenuProvider() {
                @Override public Component getDisplayName() {
                    return Component.translatable(BlockRegistry.infusionTable.get().getDescriptionId());
                }
                @Override public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
                    return new InfusionTableMenu(windowId, inv, create(player.level(), pos));
                }
            });
            return InteractionResult.CONSUME;
        }
    }
    @Nullable
    @Override public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inventory, player) -> new InfusionTableMenu(i, inventory, create(level, pos)), Component.translatable(BlockRegistry.infusionTable.get().getDescriptionId()));
    }
}