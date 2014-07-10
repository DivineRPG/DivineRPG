package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDensos extends EntityDivineRPGBoss {
	
    private static final ItemStack defaultHeldItem = new ItemStack(TwilightItemsWeapons.haliteBlade, 1);

    public EntityDensos(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.densosHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.densosDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.densosSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.densosFollowRange);
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }
 
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.densos);
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.densosHurt);
    }

    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    @Override
    public void dropFewItems(boolean var1, int var2) {
        int var3 = this.rand.nextInt(2 + var2);
        int var4;

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(TwilightItemsArmor.haliteHelmet, 1);
            this.dropItem(TwilightItemsArmor.haliteBody, 1);
            this.dropItem(TwilightItemsArmor.haliteLegs, 1);
            this.dropItem(TwilightItemsArmor.haliteBoots, 1);
        }
    }

	@Override
	public String mobName() {
		return "Densos";
	}

	@Override
	public String name() {
		return "Densos";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}
