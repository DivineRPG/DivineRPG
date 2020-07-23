package divinerpg.objects.items.twilight;

import divinerpg.objects.items.base.ItemFastFood;
import divinerpg.objects.items.base.ItemModFood;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemForbiddenFruit extends ItemModFood {

	public ItemForbiddenFruit() {
	    super(3, 0.5F, false, "forbidden_fruit");
	}

	@Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 0));

            switch(itemRand.nextInt(3)) {
                case 0:
                    player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 120, 1));
                    break;
                case 1:
                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, 120, 1));
                    break;
                default:
                    player.setFire(6);
                    break;
            }
        }
    }

}
