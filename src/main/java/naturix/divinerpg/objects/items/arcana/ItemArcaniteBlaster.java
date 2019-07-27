package naturix.divinerpg.objects.items.arcana;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.client.EntityResourceLocation;
import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.events.Ticker;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArcaniteBlaster extends ItemMod {
	private Random rand = new Random();
	public ItemArcaniteBlaster() {
		super("arcanite_blaster");
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(6500);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
     {
       	IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
		ItemStack stack = new ItemStack(this);
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		
		if(Ticker.tick >= stack.getTagCompound().getLong("CanShootTime")) {
			if(arcana.getArcana() >= 80) {
			if(!world.isRemote)world.playSound(player, player.getPosition(), ModSounds.GHAST_CANNON, SoundCategory.PLAYERS, 1, 1);
				for(int i = 0; i < 30; i++) {
					EntityThrowable entity = new EntityShooterBullet(world, player, BulletType.ARCANITE_BLASTER);
					entity.posX += (this.rand.nextDouble()-this.rand.nextDouble())*1.5;
					entity.posY += (this.rand.nextDouble()-this.rand.nextDouble())*1.5;
					entity.posZ += (this.rand.nextDouble()-this.rand.nextDouble())*1.5;
					entity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
	                
					if(!world.isRemote) {
						world.spawnEntity(entity);
						stack.getTagCompound().setLong("CanShootTime", Ticker.tick + 7);
					}
				}
				arcana.consume(20);
				stack.damageItem(1, player);
			}
		}
		if(player instanceof EntityPlayerMP)((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);
		if (stack.getTagCompound().getLong("CanShootTime") >= 100000 || stack.getTagCompound().getLong("CanShootTime") > Ticker.tick + 141)stack.getTagCompound().setLong("CanShootTime", 0);

        return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {	list.add(TooltipLocalizer.bowDam("30x23"));
		list.add(TooltipLocalizer.arcanaConsumed(20));
		list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
	}
}