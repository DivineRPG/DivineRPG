package divinerpg.items.vanilla;

import divinerpg.util.LocalizeUtils;
import divinerpg.util.teleport.SecondaryTeleporter;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

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
                    ItemStack stack = player.getItemInHand(hand);
                    stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                        p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
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
