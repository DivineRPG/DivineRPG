package net.divinerpg.items.iceika;

import net.divinerpg.items.base.ItemModFoodEffect;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;

import static net.divinerpg.utils.FoodList.EGG_NOG;
import static net.minecraft.sounds.SoundEvents.HONEY_DRINK;
import static net.minecraft.world.item.Items.BUCKET;

public class ItemEggNog extends ItemModFoodEffect {
    public ItemEggNog() {super(true, BUCKET, EGG_NOG, new Properties());}

    public ItemEggNog(Properties properties) {
        super(EGG_NOG, properties);
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {return ItemUseAnimation.DRINK;}
    //TODO - eat sound
//    @Override public SoundEvent getEatingSound() {return HONEY_DRINK;}
}