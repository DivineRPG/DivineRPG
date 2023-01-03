package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.capability.ArcanaProvider;
import divinerpg.entities.projectile.EntityMerikMissile;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMeriksMissile extends ItemMod {
    public static final int MAX_USE_DURATION = 72000;

    public ItemMeriksMissile() {
        super(new Properties().stacksTo(1).durability(-1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!player.abilities.mayBuild) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity livingEntity, int timeLeft) {
        if (stack.getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "meriks_missile")) && livingEntity instanceof Player) {
            Player player = (Player) livingEntity;

            float charge = (float) (MAX_USE_DURATION - timeLeft) / 20.0F;
            if (charge > 1.0) {
                charge = 1.0F;
            }
            float arcanaPoints = 50.0F * charge;
            float finalCharge = charge;
            player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                if (arcana.getArcana() >= arcanaPoints) {
                    if (finalCharge < 0.2F)
                        return;
                    float damage = Mth.clamp(finalCharge * 25F, 8F, 25F);
                    world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundSource.MASTER, 1, 1);
                    EntityMerikMissile bullet = new EntityMerikMissile(EntityRegistry.MERIKS_MISSILE.get(), world, player, damage);
                    bullet.moveTo(player.getX(), player.getY() + 1, player.getZ());
                    bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 3.0F, 1.0F);
                    world.addFreshEntity(bullet);
                    arcana.consume(player, arcanaPoints);
                }
            });

        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return MAX_USE_DURATION;
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.meriks_missile"));
        tooltip.add(LocalizeUtils.bowDam("8-25"));
        tooltip.add(LocalizeUtils.arcanaConsumed("10-50"));
        tooltip.add(LocalizeUtils.infiniteUses());
    }
}