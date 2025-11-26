package divinerpg.items.iceika;

import divinerpg.items.base.ItemModFoodEffect;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;

import static divinerpg.util.FoodList.EGG_NOG;
import static net.minecraft.sounds.SoundEvents.HONEY_DRINK;
import static net.minecraft.world.item.Items.BUCKET;

public class ItemEggNog extends ItemModFoodEffect {
    public ItemEggNog() {super(true, BUCKET, EGG_NOG);}
    @Override public UseAnim getUseAnimation(ItemStack stack) {return UseAnim.DRINK;}
    @Override public SoundEvent getEatingSound() {return HONEY_DRINK;}
}