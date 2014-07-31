package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityVerek extends EntityDivineRPGMob {
	
    public EntityVerek(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.verekHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.verekDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.verekSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.verekFollowRange);
    }

    @Override
    public int getTotalArmorValue() {
        return 6;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.verek);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.verekHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.verekHurt);
    }

    @Override
    protected Item getDropItem() {
        return TwilightItemsOther.wildwoodSoul;
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        int var3 = this.rand.nextInt(2 + var2);

        for (int var4 = 0; var4 < var3; ++var4) {
            this.dropItem(TwilightItemsOther.wildwoodSoul, 2);
        }
    }

	@Override
	public String mobName() {
		return "Verek";
	}
}