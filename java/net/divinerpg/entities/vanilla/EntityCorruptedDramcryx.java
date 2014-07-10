package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityCorruptedDramcryx extends EntityDivineRPGMob {
	
    public EntityCorruptedDramcryx(World par1World) {
        super(par1World);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.corruptedDramcryxHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.corruptedDramcryxDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.corruptedDramcryxSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.corruptedDramcryxFollowRange);
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
    }

    protected void dropRareDrop(int par1) {
        switch(this.rand.nextInt(1)) {
            case 0:
                this.dropItem(VanillaItemsOther.arlemiteIngot, 5);
                break;
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 15.0D && super.getCanSpawnHere();
    }

	@Override
	public String mobName() {
		return "Corrupted Dramcryx";
	}
}