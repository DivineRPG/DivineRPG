package net.divinerpg.items.base;

import java.util.ArrayList;
import java.util.List;

import net.divinerpg.entities.twilight.EntityParticleBullet;
import net.divinerpg.entities.vanilla.projectile.EntityShooterBullet;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.Ticker;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemProjectileShooter extends ItemMod {
	
	private String soundName;
	protected float damage;
	protected Item ammo;
	private String projectileTex;
	protected int uses;
	private int delay;
	private boolean hasParticle;
	private String fx;
	public static List<Item> gunList = new ArrayList<Item>();
	public static List<Item> phaserList = new ArrayList<Item>();
	
	public ItemProjectileShooter(String name, float damage, String projectileTex, int uses, int counter) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		this.damage = damage;
		this.projectileTex = projectileTex;
		this.uses = uses;
		this.delay = counter;
		setMaxDamage(uses);
		if(!name.contains("Phaser") && !name.contains("frostclaw") && !name.contains("crabclawCannon") && !name.contains("bowheadCannon") && !name.contains("Anchor")) gunList.add(this);
		else if(name.contains("Phaser") || name.contains("frostclaw") || name.contains("crabclawCannon") || name.contains("bowheadCannon") || name.contains("Anchor")) phaserList.add(this);
	}
	
	public ItemProjectileShooter(String name, float damage, String soundName, String projectileTex, int uses, int counter) {
		this(name, damage, projectileTex, uses, counter);
		this.soundName = soundName;
	}
	
	public ItemProjectileShooter(String name, float damage, Item ammo, int uses, int counter) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		this.damage = damage;
		this.ammo = ammo;
		this.uses = uses;
		this.delay = counter;
		setMaxDamage(uses);
		if(!name.contains("Phaser") && !name.contains("frostclaw") && !name.contains("crabclawCannon") && !name.contains("bowheadCannon")) gunList.add(this);
		else if(name.contains("Phaser") || name.contains("frostclaw") || name.contains("crabclawCannon") || name.contains("bowheadCannon")) phaserList.add(this);
	}
	
	
	
	public ItemProjectileShooter(String name, float damage, String soundName, Item ammo, String projectileTex, int uses, int counter) {
		this(name, damage, ammo, projectileTex, uses, counter);
		this.soundName = soundName;
	}
	
	public ItemProjectileShooter(String name, float damage, Item ammo, String projectileTex, int uses, int counter) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		this.damage = damage;
		this.ammo = ammo;
		this.uses = uses;
		this.delay = counter;
		this.projectileTex = projectileTex;
		setMaxDamage(uses);
		if(!name.contains("Phaser") && !name.contains("frostclaw") && !name.contains("crabclawCannon") && !name.contains("bowheadCannon")) gunList.add(this);
		else if(name.contains("Phaser") || name.contains("frostclaw") || name.contains("crabclawCannon") || name.contains("bowheadCannon")) phaserList.add(this);
	}
	
	
	
	public ItemProjectileShooter(String name, float damage, String soundName, Item ammo, int uses, int counter) {
		this(name, damage, ammo, uses, counter);
		this.soundName = soundName;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		if(Ticker.tick >= stack.getTagCompound().getLong("CanShootTime")) {
			if(player.capabilities.isCreativeMode || this.ammo == null || player.inventory.hasItem(ammo)) {
				if(this.uses > -1 && !player.capabilities.isCreativeMode) stack.damageItem(1, player);
				if(this.ammo != null && !player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(ammo);
				if(!world.isRemote) {
					world.playSoundAtEntity(player, this.soundName != null ? this.soundName : "random.bow", 1, 1);
					EntityThrowable bullet = this.hasParticle ? (this.projectileTex != null ? new EntityParticleBullet(world, player, this.damage, this.projectileTex, this.fx) : new EntityParticleBullet(world, player, this.damage, this.ammo, this.fx)) : (this.projectileTex != null ? new EntityShooterBullet(world, player, this.damage, this.projectileTex) : new EntityShooterBullet(world, player, this.damage, this.ammo));
					world.spawnEntityInWorld(bullet);
					stack.getTagCompound().setLong("CanShootTime", Ticker.tick + delay*4);
				}
			}
		}
		if(player instanceof EntityPlayerMP)((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);
		if(stack.getTagCompound().getLong("CanShootTime") >= 100000 || stack.getTagCompound().getLong("CanShootTime")>Ticker.tick+delay*4+1)stack.getTagCompound().setLong("CanShootTime", 0);
		return stack;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.rangedDam(damage));
		list.add(this.ammo == null ? TooltipLocalizer.infiniteAmmo() : TooltipLocalizer.ammo(this.ammo));
		list.add(this.uses == -1 ? TooltipLocalizer.infiniteUses() : TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
	}
	
	public ItemProjectileShooter setHasParticle(String fx) {
		this.hasParticle = true;
		this.fx = fx;
		return this;
	}
}
