package divinerpg.items.iceika;

import divinerpg.items.base.ItemModFood;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;

import static divinerpg.util.FoodList.EGG_NOG;
import static net.minecraft.sounds.SoundEvents.HONEY_DRINK;

public class ItemEggNog extends ItemModFood {
    public ItemEggNog() {super(true, EGG_NOG);}
    @Override public UseAnim getUseAnimation(ItemStack stack) {return UseAnim.DRINK;}
    @Override public SoundEvent getEatingSound() {return HONEY_DRINK;}
}