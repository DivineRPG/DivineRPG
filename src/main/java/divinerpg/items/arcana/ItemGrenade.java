package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.sounds.*;
import net.minecraft.stats.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemGrenade extends ItemMod {

    private final int counter = 0;

    public ItemGrenade() {
        super(DivineRPG.tabs.ranged);

    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        RandomSource random = world.getRandom();
        world.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.TRIDENT_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        player.getCooldowns().addCooldown(this, 20);
        if (!world.isClientSide) {
            EntityGrenade grenade = new EntityGrenade(EntityRegistry.GRENADE.get(), world);
            grenade.moveTo(player.getX(), player.getY(), player.getZ());
//            grenade.setItem(itemstack);
            grenade.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(grenade);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.explosiveShots());
    }
}
