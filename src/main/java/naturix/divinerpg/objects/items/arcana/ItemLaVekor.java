package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityGrenade;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLaVekor extends ItemMod {

	private int arcana = 5;

	public ItemLaVekor() {
		super("la_vekor", DRPGCreativeTabs.ranged);
		setMaxStackSize(1);
		setFull3D();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
	    		if((player.inventory.hasItemStack(new ItemStack(ModItems.grenade)) || player.capabilities.isCreativeMode)) {
    	//FIXME - Needs to consume arcana
    	//    		&& ArcanaHelper.getProperties(player).useBar(arcana)) {
				
				if(!world.isRemote){
				    player.playSound(ModSounds.LA_VEKOR, 1, 1);
				    EntityThrowable projectile = new EntityGrenade(world, player);
				    projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
	                world.spawnEntity(projectile);
	                if(!player.capabilities.isCreativeMode)
					{
						
	                ItemStack stack = new ItemStack(ModItems.grenade);
					stack.shrink(1);
				}
			    }

		        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
			}
	            return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {	list.add(TooltipLocalizer.explosiveShots());
		list.add(TooltipLocalizer.ammo(ModItems.grenade));
		list.add(TooltipLocalizer.arcanaConsumed(arcana));
		list.add(TooltipLocalizer.infiniteUses());
	}
}