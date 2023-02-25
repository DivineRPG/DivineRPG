package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemArcanaPotion extends ItemMod {

    protected int amountToAdd;

    public ItemArcanaPotion(int amountToAdd) {
        super(new Item.Properties().tab(DivineRPG.tabs.utilities));
        this.amountToAdd = amountToAdd;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaRegen(amountToAdd));
    }


    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        Player player = (Player) entityLiving;
        if (player != null) {
            if (!player.isCreative()) {
                stack.shrink(1);
            }
            player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                arcana.fill(player, amountToAdd);
            });
        }

        return stack;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack par1ItemStack) {
        return 10;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {

            InteractionResult result = arcana.getArcana() < arcana.getMaxArcana() ? InteractionResult.SUCCESS :
                    InteractionResult.FAIL;

        });
        return new InteractionResultHolder<>(InteractionResult.FAIL, player.getItemInHand(hand));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}