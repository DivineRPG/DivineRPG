package naturix.divinerpg.objects.items.arcana;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.events.Ticker;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityGeneralsStaff;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.objects.items.vethea.ItemStaff;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGeneralsStaff extends ItemMod {
	private Random rand = new Random();
	public ItemGeneralsStaff() {
		super("generals_staff");
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		ItemStaff.staffList.add(this);
	}
	
	@Override
	public @Nonnull ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull EntityPlayer player, @Nonnull EnumHand hand) {
		ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem());
		IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);	
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		
		if(Ticker.tick >= stack.getTagCompound().getLong("CanShootTime")) {
			if(!world.isRemote && arcana.getArcana()>=20) {
		        player.playSound(ModSounds.STARLIGHT, 1, 1);
				EntityThrowable entity = new EntityGeneralsStaff(world, player);
				world.spawnEntity(entity);
				arcana.consume(20);
				stack.getTagCompound().setLong("CanShootTime", Ticker.tick + 12);
			}
		}
		if (stack.getTagCompound().getLong("CanShootTime") >= 100000 || stack.getTagCompound().getLong("CanShootTime") > Ticker.tick + 141)stack.getTagCompound().setLong("CanShootTime", 0);
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItemMainhand());
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {	list.add(TooltipLocalizer.rangedDam(18));
		list.add(TooltipHelper.getInfoText("tooltip.generals_staff.split"));
		list.add(TooltipLocalizer.arcanaConsumed(20));
		list.add(TooltipLocalizer.infiniteUses());
	}
}