package naturix.divinerpg.objects.items;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.events.Ticker;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemProjectileShooter extends ItemBase {

	public static List<Item> gunList = new ArrayList<Item>();
	public static List<Item> phaserList = new ArrayList<Item>();
	protected float damage;
	protected Item ammo;
	protected int uses;
	private int delay;

	public ItemProjectileShooter(String name, float damage, Item ammo, int uses, int counter) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		setMaxStackSize(1);
		this.damage = damage;
		this.ammo = ammo;
		this.uses = uses;
		this.delay = counter;
		setMaxDamage(uses);
		if (!name.contains("Phaser") && !name.contains("frostclaw") && !name.contains("crabclawCannon")
		        && !name.contains("bowheadCannon")) {
			gunList.add(this);
		} else if (name.contains("Phaser") || name.contains("frostclaw") || name.contains("crabclawCannon")
		        || name.contains("bowheadCannon")) {
			phaserList.add(this);
		}
	}

	public ItemProjectileShooter(String name, float damage, Item ammo, String projectileTex, int uses, int counter) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		setMaxStackSize(1);
		this.damage = damage;
		this.ammo = ammo;
		this.uses = uses;
		this.delay = counter;
		setMaxDamage(uses);
		if (!name.contains("Phaser") && !name.contains("frostclaw") && !name.contains("crabclawCannon")
		        && !name.contains("bowheadCannon")) {
			gunList.add(this);
		} else if (name.contains("Phaser") || name.contains("frostclaw") || name.contains("crabclawCannon")
		        || name.contains("bowheadCannon")) {
			phaserList.add(this);
		}
	}

	public ItemProjectileShooter(String name, float damage, String projectileTex, int uses, int counter) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		setMaxStackSize(1);
		this.damage = damage;
		this.uses = uses;
		this.delay = counter;
		this.setMaxDamage(uses);
		if (!name.contains("Phaser") && !name.contains("frostclaw") && !name.contains("crabclawCannon")
		        && !name.contains("bowheadCannon") && !name.contains("Anchor")) {
			gunList.add(this);
		} else if (name.contains("Phaser") || name.contains("frostclaw") || name.contains("crabclawCannon")
		        || name.contains("bowheadCannon") || name.contains("Anchor")) {
			phaserList.add(this);
		}
	}

	public ItemProjectileShooter(String name, float damage, String soundName, Item ammo, int uses, int counter) {
		this(name, damage, ammo, uses, counter);
	}

	public ItemProjectileShooter(String name, float damage, String soundName, Item ammo, String projectileTex, int uses,
	        int counter) {
		this(name, damage, ammo, projectileTex, uses, counter);
	}

	public ItemProjectileShooter(String name, float damage, String soundName, String projectileTex, int uses,
	        int counter) {
		this(name, damage, projectileTex, uses, counter);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add(TooltipLocalizer.rangedDam(damage));
		list.add(this.ammo == null ? TooltipLocalizer.infiniteAmmo() : TooltipLocalizer.ammo(this.ammo));
		list.add(this.uses == -1 ? TooltipLocalizer.infiniteUses()
		        : TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		ItemStack stack = new ItemStack(this);

		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}
		if (Ticker.tick >= stack.getTagCompound().getLong("CanShootTime")) {
			if (player.capabilities.isCreativeMode || this.ammo == null
			        || player.inventory.hasItemStack(new ItemStack(ammo))) {
				if (this.uses > -1 && !player.capabilities.isCreativeMode) {
					stack.damageItem(1, player);
				}
				if (this.ammo != null && !player.capabilities.isCreativeMode) {
					// player.inventory.mainInventory.remove(ammo);
				}
				if (!world.isRemote) {
					// worldgen.playSoundAtEntity(player, this.soundName != null ? this.soundName :
					// "random.bow", 1, 1);
					// EntityThrowable bullet = this.hasParticle
					// ? (this.projectileTex != null
					// ? new EntityParticleBullet(worldgen, player, this.damage, this.projectileTex,
					// this.fx)
					// : new EntityParticleBullet(worldgen, player, this.damage, this.ammo, this.fx))
					// : (this.projectileTex != null
					// ? new EntityShooterBullet(worldgen, player, this.damage, this.projectileTex)
					// : new EntityShooterBullet(worldgen, player, this.damage, this.ammo));
					// worldgen.spawnEntity(bullet);
					stack.getTagCompound().setLong("CanShootTime", Ticker.tick + delay * 4);
				}
			}
		}
		if (player instanceof EntityPlayerMP) {
			((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
		}
		if (stack.getTagCompound().getLong("CanShootTime") >= 100000
		        || stack.getTagCompound().getLong("CanShootTime") > Ticker.tick + delay * 4 + 1) {
			stack.getTagCompound().setLong("CanShootTime", 0);
		}

		return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(handIn));
	}

	public ItemProjectileShooter setHasParticle(String fx) {
		return this;
	}
}