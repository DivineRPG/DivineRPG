package naturix.divinerpg.objects.items.clock;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.ItemBase;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

			public class MysteriousClock extends ItemBase{

				public MysteriousClock(String name) {
					super(name);
					setMaxStackSize(1);
				}
				@Override
				public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
			    {
			        pos = pos.offset(facing);
			        ItemStack itemstack = player.getHeldItem(hand);

			        if (!player.canPlayerEdit(pos, facing, itemstack))
			        {
			            return EnumActionResult.FAIL;
			        }
			        else
			        {
			            if (worldIn.isAirBlock(pos))
			            {
			                worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			                worldIn.setBlockState(pos, ModBlocks.blueFire.getDefaultState(), 11);
			                if(Config.debug==true) {
			                DivineRPG.logger.info("portal spawned at " + pos);
			            }
			            }

			            if (player instanceof EntityPlayerMP)
			            {
			                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos, itemstack);
			            }

			            itemstack.splitStack(1);
			            return EnumActionResult.SUCCESS;
			        }
			    }
			}