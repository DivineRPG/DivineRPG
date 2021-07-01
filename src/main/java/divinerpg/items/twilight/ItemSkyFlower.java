package divinerpg.items.twilight;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemSkyFlower extends ItemModFood {
    public ItemSkyFlower(String name) {
        super(name, FoodList.SKY_FLOWER, DivineRPG.tabs.food, true);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.i18n("tooltip.sky_flower.breath"));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
        if(entity instanceof PlayerEntity) {
        PlayerEntity player = (PlayerEntity)entity;
            player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 600, 0, true, false));
            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 600, 0, true, false));
        }
        return super.finishUsingItem(stack, world, entity);
    }
}