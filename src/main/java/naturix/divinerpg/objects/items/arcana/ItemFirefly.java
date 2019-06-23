package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
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

public class ItemFirefly extends ItemMod {

    private int arcana = 5;

    public ItemFirefly() {
        super("firefly", DivineRPGTabs.ranged);
        setMaxStackSize(1);
        setFull3D();
    }

    @Override
	  public @Nonnull ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull EntityPlayer player, @Nonnull EnumHand hand) {
	    //FIXME - must consume arcana
    	if(!world.isRemote) {
//    		&& ArcanaHelper.getProperties(player).useBar(arcana)){
            world.playSound(player, player.getPosition(), ModSounds.FIREFLY, SoundCategory.PLAYERS, 1, 1);
            //FIXME - needs firefly entity
//            EntityFirefly e = new EntityFirefly(world, player);
//            world.spawnEntity(e);
            
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItemMainhand());
		}
    
	    return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItemMainhand());
	}

    @Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {
    	list.add(TooltipLocalizer.homingShots());
        list.add(TooltipLocalizer.infiniteAmmo());
        list.add(TooltipLocalizer.arcanaConsumed(arcana));
        list.add(TooltipLocalizer.rangedDam(15));
        list.add(TooltipLocalizer.infiniteUses());
    }
}