package naturix.divinerpg.bases.items.book;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.entities.entity.arcana.Parasecta;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
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
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {	
		if(healAmount != 0){
			if(playerIn.getHealth() < playerIn.getMaxHealth()){
				playerIn.heal(healAmount);
				playerIn.inventory.currentItem--;
			}
		}
    	BlockPos pos = new BlockPos(playerIn.getLookVec().x, playerIn.getLookVec().y, playerIn.getLookVec().z);
		Parasecta parasecta = new Parasecta(worldIn);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		//ItemStack stack;
		Block block = worldIn.getBlockState(pos).getBlock();

		if(!worldIn.isRemote){
			if(block == ModBlocks.altarParasecta){
				parasecta.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				if(worldIn.getCollisionBoxes(parasecta, parasecta.getCollisionBoundingBox()).isEmpty()) { 
				    worldIn.spawnEntity(parasecta);
				    if(!playerIn.capabilities.isCreativeMode) {
				    int item3 = playerIn.inventory.currentItem;
				    item3--;}
				}
				return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
				
			} 
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
		
	}
}