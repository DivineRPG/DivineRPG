package naturix.divinerpg.bases.items.book;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BookBase extends ItemBase {

	protected int healAmount = 0;
	public BookBase(String name) {
		super(name, DivineRPG.ItemsTab);
		setMaxStackSize(1);
	}
	public ItemBase setHealAmount(int healAmount){
		this.healAmount = healAmount;
		return this;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
    	if(healAmount != 0){
			if(playerIn.getHealth() < playerIn.getMaxHealth()){
				playerIn.heal(healAmount);
				//playerIn.inventory.consumeInventoryItem(this);
			}
		}
    	return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	//EntityParasecta parasecta = new EntityParasecta(worldIn);
		EntityZombie parasecta = new EntityZombie(worldIn);
		//EntityDramix dramix = new EntityDramix(worldIn);
		EntityCreeper dramix = new EntityCreeper(worldIn);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		//ItemStack stack;
		Block block = worldIn.getBlockState(pos).getBlock();

		if(!worldIn.isRemote){
			if(block == ModBlocks.altarParasecta){
				//parasecta.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				if(worldIn.getCollisionBoxes(parasecta, parasecta.getCollisionBoundingBox()).isEmpty()) { 
				    worldIn.spawnEntity(parasecta);
				    //if(!player.capabilities.isCreativeMode) stack.stackSize--;
				}
				return EnumActionResult.PASS;
			} 

			if(block == ModBlocks.altarDramix){
				//dramix.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				if(worldIn.getCollisionBoxes(dramix, dramix.getCollisionBoundingBox()).isEmpty()) { 
				    worldIn.spawnEntity(dramix);
				    //if(!player.capabilities.isCreativeMode) stack.stackSize--;
				}
				return EnumActionResult.PASS;
			}
		}
		return EnumActionResult.FAIL;
	}
}