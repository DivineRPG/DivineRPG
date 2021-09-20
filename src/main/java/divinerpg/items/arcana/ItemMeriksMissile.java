package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.entities.projectile.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemMeriksMissile extends ItemMod {
    public static final int MAX_USE_DURATION = 72000;

    public ItemMeriksMissile(String name) {
        super(name, new Properties().tab(DivineRPG.tabs.ranged).stacksTo(1).durability(-1));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entityLiving) {
        if (stack.getItem() == ItemRegistry.meriksMissile && entityLiving instanceof PlayerEntity) {
            float charge = (float) (MAX_USE_DURATION) / 20.0F;
            PlayerEntity player = (PlayerEntity) entityLiving;
            Arcana arcana = player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);

            if (charge > 1.0) {
                charge = 1.0F;
            }
            float arcanaPoints = 50.0F * charge;

            if (arcana.getArcana() >= arcanaPoints && !world.isClientSide) {
                if (charge < 0.2F)
                    return super.finishUsingItem(stack, world, entityLiving);

                float damage = MathHelper.clamp(charge * 25F, 8F, 25F);

                world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundCategory.MASTER, 1, 1);

                EntityMerikMissile bullet = new EntityMerikMissile(EntityRegistry.MERIKS_MISSILE, world, player, damage);
                bullet.moveTo(player.blockPosition().getX(), player.blockPosition().getY(), player.blockPosition().getZ());
                bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
                world.addFreshEntity(bullet);
                arcana.consume(player, arcanaPoints);
            }
        }
        return super.finishUsingItem(stack, world, entityLiving);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return MAX_USE_DURATION;
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.meriks_missile"));
        tooltip.add(LocalizeUtils.bowDam("8-25"));
        tooltip.add(LocalizeUtils.arcanaConsumed("10-50"));
        tooltip.add(LocalizeUtils.infiniteUses());
    }
}