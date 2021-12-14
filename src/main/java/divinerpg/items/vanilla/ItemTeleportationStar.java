package divinerpg.items.vanilla;

import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemTeleportationStar extends ItemTeleportationCrystal {
    private final static String posKey = "BlockPos";
    private final static String dimKey = "Dim";

    public ItemTeleportationStar() {
        super("teleportation_star", 64);
    }

    private CompoundNBT getFromStack(ItemStack stack) {
        if (!stack.hasTag()) {
            stack.setTag(new CompoundNBT());
        }

        return stack.getTag();
    }

    @Nullable
    @Override
    protected BlockPos getSavedPos(PlayerEntity player, ItemStack stack) {
        CompoundNBT tag = getFromStack(stack);
        if (!tag.contains(posKey))
            return null;

        return BlockPos.of(tag.getLong(posKey));
    }

    @Override
    protected RegistryKey<World> getSavedDimType(PlayerEntity player, ItemStack stack) {
        CompoundNBT tag = getFromStack(stack);
        if (!tag.contains(dimKey))
            return null;

        String dimName = tag.getString(dimKey);
        ;
        try {
            return World.OVERWORLD;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Tries to set current position
     *
     * @param compound - stack compund
     * @param player   - current player
     * @param hasInfo  - is value already set
     * @return
     */
    protected boolean trySetCords(CompoundNBT compound, PlayerEntity player, boolean hasInfo) {
        if (hasInfo)
            return false;

        compound.putString(dimKey, player.level.dimension().getRegistryName().getPath());
        compound.putLong(posKey, player.blockPosition().asLong());

        return true;
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        CompoundNBT compound = getFromStack(stack);

        boolean hasInfo = compound.contains(dimKey) && compound.contains(posKey);


        if (player.isCrouching()) {
            if (trySetCords(compound, player, hasInfo)) {
                return new ActionResult<>(ActionResultType.SUCCESS, stack);
            }

            // only on client side
            if (player.level.isClientSide) {
                ITextComponent message = new TranslationTextComponent("messaage.teleportation_star");
                message.getStyle().withColor(TextFormatting.RED);
                player.sendMessage(message, player.getUUID());
            }

            // failed during change position
            hasInfo = false;
        }

        return hasInfo
                ? super.use(worldIn, player, hand)
                : ActionResult.fail(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        CompoundNBT compound = getFromStack(stack);

        if (compound.contains(dimKey)) {
            tooltip.add(LocalizeUtils.i18n("tooltip.dimension", compound.getString(dimKey)));
        }

        if (compound.contains(posKey)) {
            BlockPos pos = BlockPos.of(compound.getLong(posKey));
            tooltip.add(LocalizeUtils.i18n("tooltip.block_position", pos.getX(), pos.getY(), pos.getZ()));
        }

        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }
}
