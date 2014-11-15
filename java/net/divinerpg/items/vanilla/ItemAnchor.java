package net.divinerpg.items.vanilla;

import java.util.List;

import com.google.common.collect.Multimap;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAnchor extends ItemMod {
	
	private Class<? extends EntityThrowable> entityClass;
	private int damage;
	
	public ItemAnchor(String name, Class<? extends EntityThrowable> entityClass, int damage) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		this.entityClass = entityClass;
		this.damage = damage;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote){
			var2.playSoundAtEntity(var3, Sounds.blitz.getPrefixedName(), 1.0F, 1.0F);
			EntityThrowable entity;
			
			try{
				entity = entityClass.getConstructor(World.class, EntityLivingBase.class).newInstance(var2, var3);
				var2.spawnEntityInWorld(entity);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return var1;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(this.damage + " Ranged damage");
		par3List.add("Infinite ammo and durability");
		par3List.add(ChatFormats.DIVINERPG);
	}
	
	@Override
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 8, 0));
        return multimap;
    }
}
