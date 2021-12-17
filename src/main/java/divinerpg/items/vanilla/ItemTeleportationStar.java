package divinerpg.items.vanilla;

import divinerpg.util.*;
import divinerpg.util.teleport.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import javax.annotation.*;
import java.util.*;

public class ItemTeleportationStar extends ItemTeleportationCrystal {
    private final static String posKey = "BlockPos";
    private final static String dimKey = "Dim";

    public ItemTeleportationStar() {
        super("teleportation_star", 64);
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

        compound.putString(dimKey, player.level.dimension().location().toString());
        compound.putLong(posKey, player.blockPosition().asLong());

        return true;
    }




    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        CompoundNBT compound = getFromStack(player.getItemInHand(hand));
        boolean hasInfo = compound.contains(dimKey) && compound.contains(posKey);
        if (!world.isClientSide) {
            if(player.isCrouching()){
                trySetCords(compound, player, hasInfo);
                return ActionResult.success(player.getItemInHand(hand));
            }
            ServerWorld serverWorld = world.getServer().getLevel(RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(compound.getString(dimKey)))).getLevel();
            if (player instanceof ServerPlayerEntity) {
                player.changeDimension(serverWorld, new SecondaryTeleporter(serverWorld, BlockPos.of(compound.getLong(posKey))));
                if (!player.isCreative()) {
                    player.getUseItem().hurtAndBreak(1, player, (stage) -> {
                        stage.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                    });
                }
                return ActionResult.success(player.getItemInHand(hand));
            }
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }



    private CompoundNBT getFromStack(ItemStack stack) {
        if (!stack.hasTag()) {
            stack.setTag(new CompoundNBT());
        }

        return stack.getTag();
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
