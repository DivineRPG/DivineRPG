package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.teleport.SecondaryTeleporter;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemTeleportationStar extends ItemMod {
    private final static String posKey = "BlockPos";
    private final static String dimKey = "Dim";
    public ItemTeleportationStar() {super(new Properties().durability(64));}
    /**
     * Tries to set current position.
     *
     * @param compound - stack compound
     * @param player - current player
     * @param hasInfo - is value already set
     */
    protected boolean trySetCords(CompoundTag compound, Player player, boolean hasInfo) {
        if(hasInfo) return false;
        compound.putString(dimKey, player.level().dimension().location().toString());
        compound.putLong(posKey, player.blockPosition().asLong());
        return true;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        CompoundTag compound = getFromStack(stack);
        boolean hasInfo = compound.contains(dimKey) && compound.contains(posKey);
        Component message;
        if(!world.isClientSide) {
            if(player.isShiftKeyDown()) {
                if(!trySetCords(compound, player, hasInfo)) {
                    message = LocalizeUtils.clientMessage(ChatFormatting.RED, "teleport.change_position");
                    player.displayClientMessage(message, true);
                } return InteractionResultHolder.success(stack);
            } if(!compound.contains(posKey) && !compound.contains(posKey)) {
                message = LocalizeUtils.clientMessage(ChatFormatting.RED, "teleport.no_position");
                player.displayClientMessage(message, true);
                return InteractionResultHolder.fail(stack);
            } ServerLevel serverWorld = world.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation(compound.getString(dimKey)))).getLevel();
            if(player instanceof ServerPlayer) {
                player.changeDimension(serverWorld, new SecondaryTeleporter(serverWorld, BlockPos.of(compound.getLong(posKey))));
                if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(player.getUsedItemHand()));
                player.getCooldowns().addCooldown(this, 160);
                player.awardStat(Stats.ITEM_USED.get(this));
                return InteractionResultHolder.success(stack);
            }
        } return super.use(world, player, hand);
    }
    private CompoundTag getFromStack(ItemStack stack) {
        if(!stack.hasTag()) stack.setTag(new CompoundTag());
        return stack.getTag();
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        CompoundTag compound = getFromStack(stack);
        if(compound.contains(dimKey)) tooltip.add(LocalizeUtils.i18n(ChatFormatting.WHITE, "teleport.dimension", compound.getString(dimKey)));
        if(compound.contains(posKey)) {
            BlockPos pos = BlockPos.of(compound.getLong(posKey));
            tooltip.add(LocalizeUtils.i18n(ChatFormatting.WHITE, "teleport.block_position", pos.getX(), pos.getY(), pos.getZ()));
        } super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}