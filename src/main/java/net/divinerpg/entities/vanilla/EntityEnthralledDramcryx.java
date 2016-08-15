package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityEnthralledDramcryx extends EntityDivineRPGMob {
	
    public EntityEnthralledDramcryx(World par1World) {
        super(par1World);
        addAttackingAI();
        setSize(1.25F, 1.25F);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.corruptedDramcryxHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.corruptedDramcryxDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.corruptedDramcryxSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.corruptedDramcryxFollowRange);
    }
    
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.dramcryx);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.dramcryxHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.dramcryxHurt);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        int var3;
        int var4;
        var3 = this.rand.nextInt(3 + par2);

        for (var4 = 0; var4 < var3; ++var4) {
            this.dropItem(VanillaItemsOther.corruptedShards, 1);
        }

        var3 = this.rand.nextInt(3 + par2);

        for (var4 = 0; var4 < var3; ++var4) {
            this.dropItem(VanillaItemsOther.corruptedShards, 2);
        }
        
        if(this.rand.nextInt(40) == 0) this.dropItem(VanillaItemsOther.arlemiteIngot, 5);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.posY <= 16.0D && super.getCanSpawnHere();
    }

	@Override
	public String mobName() {
		return "Enthralled Dramcryx";
	}
}