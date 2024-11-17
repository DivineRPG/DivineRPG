package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityBiphron extends VetheaMob {
	
    private boolean gravMove;

    public EntityBiphron(World var1) {
        super(var1);
        addAttackingAI();
        this.setSize(0.4F, 2.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.biphronHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.biphronDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.biphronSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.biphronFollowRange);
    }

    @Override
    protected void fall(float par1) { }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.rand.nextInt(50) == 0) {
            if (!this.gravMove) {
                this.gravMove = true;
            } else {
                this.gravMove = false;
            }
        }

        if (this.gravMove) {
            this.motionY = 0.4;
        }
    }
 
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }
 
    @Override
    protected String getLivingSound() {
        return Sounds.biphron.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.biphronHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.cleanPearls, 1);
    }
 
    @Override
    public int getSpawnLayer() {
    	return 2;
    }

	@Override
	public String mobName() {
		return "Biphron";
	}
}