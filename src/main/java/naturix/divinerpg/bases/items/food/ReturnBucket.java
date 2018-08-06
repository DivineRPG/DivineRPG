package naturix.divinerpg.bases.items.food;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.FoodBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ReturnBucket extends FoodBase{
	
	private EntityPlayer entityplayer;

	public ReturnBucket(String name, int healAmount, boolean alwaysEdible) {
		super(name, healAmount, alwaysEdible);
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer && !((EntityPlayer)entityLiving).capabilities.isCreativeMode)
        {

            entityplayer.getFoodStats().addStats(this, stack);
            stack.shrink(1);
        }
				
		return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }

}
