package naturix.divinerpg.objects.items.arcana;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemReflector extends ItemMod {
	private Random rand = new Random();
	public ItemReflector() {
		super("arcanium_reflector");
		setCreativeTab(DivineRPGTabs.utility);
		setMaxStackSize(1);
		setFull3D();
	}
	
	@Override
	  public @Nonnull ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull EntityPlayer player, @Nonnull EnumHand hand) {
			if(!world.isRemote) {
				//FIXME - needs to consume arcana
//					&& ArcanaHelper.getProperties(player).useBar(20)) {

				player.playSound(ModSounds.REFLECTOR, 1, 1);
				//FIXME - needs entity
//			EntityThrowable entity = new EntityReflector(world, player);
//			world.spawnEntityInWorld(entity);
				return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItemMainhand());
				
		}
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItemMainhand());
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {	list.add(TooltipHelper.getInfoText("tooltip.refector.push"));
		list.add(TooltipLocalizer.arcanaConsumed(20));
		list.add(TooltipLocalizer.infiniteUses());
	}
}