package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.*;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAquamarine extends ItemMod {

    public ItemAquamarine() {
        super(new Item.Properties().durability(10));
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        this.place(new BlockPlaceContext(context));
        return InteractionResult.FAIL;
    }


    public InteractionResult place(BlockPlaceContext p_40577_) {
        if (!this.getBlock().isEnabled(p_40577_.getLevel().enabledFeatures())) {
            return InteractionResult.FAIL;
        } else if (!p_40577_.canPlace()) {
            return InteractionResult.FAIL;
        } else {
            BlockPlaceContext blockplacecontext = this.updatePlacementContext(p_40577_);
            if (blockplacecontext == null) {
                return InteractionResult.FAIL;
            } else {
                BlockState blockstate = this.getPlacementState(blockplacecontext);
                if (blockstate == null) {
                    return InteractionResult.FAIL;
                } else if (!this.placeBlock(blockplacecontext)) {
                    return InteractionResult.FAIL;
                } else {
                    BlockPos blockpos = blockplacecontext.getClickedPos();
                    Level level = blockplacecontext.getLevel();
                    Player player = blockplacecontext.getPlayer();
                    ItemStack itemstack = blockplacecontext.getItemInHand();
                    BlockState blockstate1 = level.getBlockState(blockpos);
                    if (blockstate1.is(blockstate.getBlock())) {
                        blockstate1 = this.updateBlockStateFromTag(blockpos, level, itemstack, blockstate1);
                        blockstate1.getBlock().setPlacedBy(level, blockpos, blockstate1, player, itemstack);
                        if (player instanceof ServerPlayer) {
                            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                        }
                    }

                    level.gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of(player, blockstate1));
                    SoundType soundtype = blockstate1.getSoundType(level, blockpos, p_40577_.getPlayer());
                    level.playSound(player, blockpos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                    if (player == null || !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }
    }

    @Nullable
    public BlockPlaceContext updatePlacementContext(BlockPlaceContext p_40609_) {
        return p_40609_;
    }

    @Nullable
    protected BlockState getPlacementState(BlockPlaceContext p_40613_) {
        BlockState blockstate = this.getBlock().getStateForPlacement(p_40613_);
        return blockstate != null && this.canPlace(p_40613_, blockstate) ? blockstate : null;
    }

    private BlockState updateBlockStateFromTag(BlockPos p_40603_, Level p_40604_, ItemStack p_40605_, BlockState p_40606_) {
        BlockState blockstate = p_40606_;
        CompoundTag compoundtag = p_40605_.getTag();
        if (compoundtag != null) {
            CompoundTag compoundtag1 = compoundtag.getCompound("BlockStateTag");
            StateDefinition<Block, BlockState> statedefinition = p_40606_.getBlock().getStateDefinition();

            for(String s : compoundtag1.getAllKeys()) {
                Property<?> property = statedefinition.getProperty(s);
                if (property != null) {
                    String s1 = compoundtag1.get(s).getAsString();
                    blockstate = updateState(blockstate, property, s1);
                }
            }
        }

        if (blockstate != p_40606_) {
            p_40604_.setBlock(p_40603_, blockstate, 2);
        }

        return blockstate;
    }

    private static <T extends Comparable<T>> BlockState updateState(BlockState p_40594_, Property<T> p_40595_, String p_40596_) {
        return p_40595_.getValue(p_40596_).map((p_40592_) -> {
            return p_40594_.setValue(p_40595_, p_40592_);
        }).orElse(p_40594_);
    }

    protected boolean canPlace(BlockPlaceContext p_40611_, BlockState p_40612_) {
        Player player = p_40611_.getPlayer();
        CollisionContext collisioncontext = player == null ? CollisionContext.empty() : CollisionContext.of(player);
        return (!this.mustSurvive() || p_40612_.canSurvive(p_40611_.getLevel(), p_40611_.getClickedPos())) && p_40611_.getLevel().isUnobstructed(p_40612_, p_40611_.getClickedPos(), collisioncontext);
    }

    protected boolean mustSurvive() {
        return true;
    }

    protected boolean placeBlock(BlockPlaceContext context) {
        context.getLevel().setBlock(context.getClickedPos(), Fluids.WATER.defaultFluidState().createLegacyBlock(), 11);
        context.getLevel().scheduleTick(context.getClickedPos(), Fluids.WATER, Fluids.WATER.getTickDelay(context.getLevel()));
        return true;
    }




    public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
        super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
        this.getBlock().appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
    }

    public Block getBlock() {
        return Fluids.WATER.defaultFluidState().createLegacyBlock().getBlock();
    }
}