package divinerpg.items.vanilla;

import divinerpg.util.*;
import divinerpg.util.teleport.*;
import net.minecraft.*;
import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.server.command.*;

import javax.annotation.*;
import java.util.*;

public class ItemTeleportationStar extends ItemTeleportationCrystal {
    private final static String posKey = "BlockPos";
    private final static String dimKey = "Dim";

    public ItemTeleportationStar() {
        super(64);
    }

    /**
     * Tries to set current position
     *
     * @param compound - stack compund
     * @param player   - current player
     * @param hasInfo  - is value already set
     * @return
     */
    protected boolean trySetCords(CompoundTag compound, Player player, boolean hasInfo) {
        if (hasInfo)
            return false;

        compound.putString(dimKey, player.level.dimension().location().toString());
        compound.putLong(posKey, player.blockPosition().asLong());

        return true;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        CompoundTag compound = getFromStack(player.getItemInHand(hand));
        boolean hasInfo = compound.contains(dimKey) && compound.contains(posKey);
        if (!world.isClientSide) {
            if (player.isCrouching()) {
                if (!trySetCords(compound, player, hasInfo)) {
                    MutableComponent message = TextComponentHelper.createComponentTranslation(player, "message.teleportation_star_change_position");
                    message.withStyle(ChatFormatting.RED);
                    player.displayClientMessage(message, true);
                }
                return InteractionResultHolder.success(player.getItemInHand(hand));
            }
            if (!compound.contains(posKey) && !compound.contains(posKey)) {
                MutableComponent message = TextComponentHelper.createComponentTranslation(player, "message.teleportation_star_no_position");
                message.withStyle(ChatFormatting.RED);
                player.displayClientMessage(message, true);
                return InteractionResultHolder.fail(player.getItemInHand(hand));
            }
            ServerLevel serverWorld = world.getServer().getLevel(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(compound.getString(dimKey)))).getLevel();
            if (player instanceof ServerPlayer) {
                player.changeDimension(serverWorld, new SecondaryTeleporter(serverWorld, BlockPos.of(compound.getLong(posKey))));
                if (!player.isCreative()) {
                    ItemStack stack = player.getItemInHand(hand);
                    stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                        p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
                    });
                }
                return InteractionResultHolder.success(player.getItemInHand(hand));
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }


    private CompoundTag getFromStack(ItemStack stack) {
        if (!stack.hasTag()) {
            stack.setTag(new CompoundTag());
        }

        return stack.getTag();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        CompoundTag compound = getFromStack(stack);
        if (compound.contains(dimKey)) {
            tooltip.add(LocalizeUtils.i18n("tooltip.dimension", compound.getString(dimKey)));
        }

        if (compound.contains(posKey)) {
            BlockPos pos = BlockPos.of(compound.getLong(posKey));
            tooltip.add(LocalizeUtils.i18n("tooltip.block_position", pos.getX(), pos.getY(), pos.getZ()));
        }

        tooltip.add(Component.translatable(""));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }
}
