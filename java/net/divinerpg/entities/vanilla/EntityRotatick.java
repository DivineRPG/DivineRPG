package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityRotatick extends EntityDivineRPGMob {
	
    public EntityRotatick(World par1World) {
        super(par1World);
        this.setSize(1.5F, 0.5F);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.rotatickHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.rotatickDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.rotatickSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.rotatickFollowRange);
    }
    
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.rotatick);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.rotatickHurt);
    }

    @Override
    protected String getDeathSound() {
    	return Sounds.getSoundName(Sounds.rotatickHurt);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        int var3;
        int var4;
        var3 = this.rand.nextInt(3 + par2);

        for (var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.diamond, 0);
        }

        var3 = this.rand.nextInt(3 + par2);

        for (var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.diamond, 1);
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 25.0D && super.getCanSpawnHere();
    }

	@Override
	public String mobName() {
		return "Rotatick";
	}
}