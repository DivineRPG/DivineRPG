package net.divinerpg.items.twilight;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.twilight.projectile.EntityPhaserApalachia;
import net.divinerpg.entities.twilight.projectile.EntityPhaserEden;
import net.divinerpg.entities.twilight.projectile.EntityPhaserHalite;
import net.divinerpg.entities.twilight.projectile.EntityPhaserMortum;
import net.divinerpg.entities.twilight.projectile.EntityPhaserSkythern;
import net.divinerpg.entities.twilight.projectile.EntityPhaserWildWood;
import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTwilightPhaser extends ItemMod {
	private int damage;
	private int firetick;
	private int firemax;
	private String firesound;
	private String name;

	public ItemTwilightPhaser(int dam, String name) {
		super(name, DivineRPGTabs.ranged);
		this.damage = dam;
        this.firemax = 0;
        this.firetick = this.firemax;
        this.firesound = Sounds.phaser.getPrefixedName();
        this.setMaxStackSize(1);
        this.setMaxDamage(3000);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote) {
			if (this.firetick == this.firemax && this.firemax != 0) {
				if(var1.getItem() == TwilightItemsWeapons.skythernPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserSkythern(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.halitePhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserHalite(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.wildwoodPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserWildWood(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.edenPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserEden(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.mortumPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserMortum(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.apalachiaPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserApalachia(var2, var3));
					var1.damageItem(1, var3);
				}
                this.firetick = 0;
			} else {
				++this.firetick;
			}

			if (this.firemax == 0) {
				if(var1.getItem() == TwilightItemsWeapons.skythernPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserSkythern(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.halitePhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserHalite(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.wildwoodPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserWildWood(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.edenPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserEden(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.mortumPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserMortum(var2, var3));
					var1.damageItem(1, var3);
				}

				if(var1.getItem() == TwilightItemsWeapons.apalachiaPhaser) {
					var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
					var2.spawnEntityInWorld(new EntityPhaserApalachia(var2, var3));
					var1.damageItem(1, var3);
				}
			}

		}
		return var1;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4) {
		this.firetick = this.firemax;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean par4) {
		if(item.getItem() == TwilightItemsWeapons.halitePhaser) {
			list.add("51 Ranged Damage");
			list.add(item.getMaxDamage() - item.getItemDamage() + " Uses");
		}

		if(item.getItem() == TwilightItemsWeapons.wildwoodPhaser) {
			list.add("30 Ranged Damage");
			list.add(item.getMaxDamage() - item.getItemDamage() + " Uses");
		}

		if(item.getItem() == TwilightItemsWeapons.skythernPhaser) {
			list.add("41 Ranged Damage");
			list.add(item.getMaxDamage() - item.getItemDamage() + " Uses");
		}

		if(item.getItem() == TwilightItemsWeapons.edenPhaser) {
			list.add("24 Ranged Damage");
			list.add(item.getMaxDamage() - item.getItemDamage() + " Uses");
		}

		if(item.getItem() == TwilightItemsWeapons.mortumPhaser) {
			list.add("46 Ranged Damage");
			list.add(item.getMaxDamage() - item.getItemDamage() + " Uses");
		}

		if(item.getItem() == TwilightItemsWeapons.apalachiaPhaser) {
			list.add("35 Ranged Damage");
			list.add(item.getMaxDamage() - item.getItemDamage() + " Uses");
		}
	}
}
