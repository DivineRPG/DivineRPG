package divinerpg.objects.items.twilight;

import divinerpg.objects.items.base.ItemFastFood;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemForbiddenFruit extends ItemFastFood {
	public ItemForbiddenFruit() {
		super(2, 1, false, "forbidden_fruit");
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
        	EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
            
            entityplayer.addExperience(2);
            
            
            try {
                Thread.sleep(5000); // 1 second
                stack.shrink(stack.getCount());
                entityplayer.inventory.dropAllItems();
            } catch (InterruptedException ex) {
                System.out.print("forbidden fruit failed");
            }
            if (entityplayer instanceof EntityPlayerMP)
            {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
                
               
            }
        }
        entityLiving.heal(4);
        
        
        stack.shrink(1);
        return stack;
    }

}
