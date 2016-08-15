package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTheGrue extends EntityDivineRPGMob {

    public EntityTheGrue(World par1World) {
        super(par1World);
        this.setSize(0.8F, 2.0F);
        addAttackingAI();
        this.tasks.addTask(0, new EntityAILeapAtTarget(this, 0.6f));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.theGrueHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.theGrueDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.theGrueSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.theGrueFollowRange);
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.deathcryx);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.deathcryxHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.deathcryxHurt);
    }

    @Override
    public void dropFewItems(boolean beenHit, int lootingLevel) {
        this.dropItem(VanillaItemsOther.arlemiteIngot, 1);
        if(this.rand.nextBoolean())this.dropItem(VanillaItemsOther.corruptedShards, 3);
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
        return "The Grue";
    }
}