package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.entities.projectile.EntityMerikMissile;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.*;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemMeriksMissile extends ItemMod {
    public static final int MAX_USE_DURATION = 72000;
    public ItemMeriksMissile() {super(new Properties().durability(1315));}
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(!player.abilities.mayBuild) return InteractionResultHolder.fail(itemstack);
        else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }
    @Override public void releaseUsing(ItemStack stack, Level world, LivingEntity livingEntity, int timeLeft) {
        if (stack.getItem() == ItemRegistry.meriks_missile.get() && livingEntity instanceof Player player) {
            float charge = (float)(MAX_USE_DURATION - timeLeft) / 20;
            if(charge > 1) charge = 1;
            float arcanaPoints = 50 * charge;
            float finalCharge = charge;
            player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                if(arcana.getAmount(world.isClientSide()) >= arcanaPoints) {
                    if(finalCharge < .2) return;
                    float damage = Mth.clamp(finalCharge * 25, 2, 8);
                    world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1);
                    EntityMerikMissile bullet = new EntityMerikMissile(EntityRegistry.MERIKS_MISSILE.get(), world, player, damage);
                    bullet.moveTo(player.getX(), player.getY() + 1, player.getZ());
                    bullet.shootFromRotation(player, player.xRot, player.yRot, 0, 3, 1);
                    world.addFreshEntity(bullet);
                    arcana.modifyAmount(player, -arcanaPoints);
                }
            });
        }
    }
    @Override public int getUseDuration(ItemStack stack) {return MAX_USE_DURATION;}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam("2-8"));
        tooltip.add(LocalizeUtils.explosiveShots());
        tooltip.add(LocalizeUtils.homingShots());
        tooltip.add(LocalizeUtils.arcanaConsumed("10-50"));
    }
}