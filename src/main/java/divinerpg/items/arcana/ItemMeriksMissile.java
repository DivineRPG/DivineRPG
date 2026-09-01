package divinerpg.items.arcana;

import divinerpg.entities.projectile.bullet.EntityMerikMissile;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import divinerpg.utils.ArcanaHelper;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;

public class ItemMeriksMissile extends ItemMod {
    public static final int MAX_USE_DURATION = 72000;

    public ItemMeriksMissile(Item.Properties properties) {
        super(properties.durability(1315));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(!player.getAbilities().mayBuild) return InteractionResult.FAIL;
        else {
            player.startUsingItem(hand);
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int remainingTime) {
        if (stack.getItem() == ItemRegistry.meriks_missile.get() && entity instanceof Player player) {
            float charge = (float)(MAX_USE_DURATION - remainingTime) / 20;
            if(charge > 1) charge = 1;
            float arcanaPoints = 50 * charge;
            float finalCharge = charge;
            float amount = ArcanaHelper.getArcana(player);
            if(amount >= arcanaPoints) {
                if(finalCharge < .2);
                float damage = Mth.clamp(finalCharge * 25, 2, 8);
                level.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1);
                EntityMerikMissile bullet = new EntityMerikMissile(EntityRegistry.MERIKS_MISSILE.get(), level, player, damage);
                bullet.moveOrInterpolateTo(new Vec3(player.getX(), player.getY() + 1, player.getZ()));
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 3, 1);
                level.addFreshEntity(bullet);
                if(!level.isClientSide()) ArcanaHelper.modifyAmount(player, -arcanaPoints);
            }
        }
        return false;
    }

    @Override public int getUseDuration(ItemStack itemStack, LivingEntity user) {return MAX_USE_DURATION;}

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.rangedDam("2-8"));
        builder.accept(LocalizeUtils.explosiveShots());
        builder.accept(LocalizeUtils.homingShots());
        builder.accept(LocalizeUtils.arcanaConsumed("10-50"));
    }
}