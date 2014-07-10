package net.divinerpg.entities.arcana;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityDramix extends EntityDivineRPGBoss {

    private int firetick;
    private int firemax = 300;
    private int firemax2 = 200;

    private boolean isInvi;

    public EntityDramix(World var1) {
        super(var1);
        addAttackingAI();
        this.isImmuneToFire = true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.dramixHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.dramixDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.dramixSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.dramixFollowRange);
    }
    
    @Override
    public String mobName() {
        return "Dramix";
    }

    public boolean isInv() {
        return isInvi;
    }

    @Override
    public void onLivingUpdate() {

        if(firemax == firetick && firetick != 0) {
            this.isInvi = true;
            this.firetick = 0;
        } else {
            ++firetick;
        }

        if(firemax2 == firetick && firetick != 0) {
            this.isInvi = false;
            this.firetick = 0;
        } else {
            ++firetick;
        }

        super.onLivingUpdate();
    }

    @Override
    protected String getLivingSound() {
        return Sounds.dramix.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.dramixHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return Sounds.dramixHurt.getPrefixedName();
    }

    @Override
    public void dropFewItems(boolean par1, int par2) {
        this.dropItem(ArcanaItems.dungeonTokens, 5);
    }

	@Override
	public String name() {
		return mobName();
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}