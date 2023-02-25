package divinerpg.items.twilight;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemSkyFlower extends ItemModFood {
    public ItemSkyFlower() {
        super(FoodList.SKY_FLOWER, DivineRPG.tabs.food, true);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.i18n("tooltip.sky_flower.breath"));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0, true, false));
        }
        return super.finishUsingItem(stack, world, entity);
    }
}