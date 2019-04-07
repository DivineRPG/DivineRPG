package naturix.divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMusicShooter extends ItemMod {

public ItemMusicShooter(String name) {
	super(name, DRPGCreativeTabs.ranged);
	setMaxStackSize(1);
	setMaxDamage(4000);
}

@Override
@SideOnly(Side.CLIENT)
public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
	if (this == ModItems.soundOfCarols) {
		list.add(TooltipLocalizer.rangedDam(16));
	} else {
		list.add(TooltipLocalizer.rangedDam(10));
	}
	list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
}

@Override
public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
	ItemStack stack = new ItemStack(this);
	if (!world.isRemote) {
		if (this == ModItems.soundOfCarols) {
			// world.spawnEntityInWorld(new EntityCarol(world, player));
			world.playSound(player, player.getPosition(), ModSounds.SOUND_OF_CAROLS, SoundCategory.MUSIC, 1, 1);
		} else {
			// world.spawnEntityInWorld(new EntityMusic(world, player));
			world.playSound(player, player.getPosition(), ModSounds.SOUND_OF_MUSIC, SoundCategory.MUSIC, 1, 1);
		}
		stack.damageItem(1, player);
	}
	return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(handIn));
}
}
