package net.divinerpg.entity.vethea;

import net.divinerpg.Sounds;
import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.helper.items.VetheanItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityCymesoid extends EntityDivineRPGMob {
	
    private static final double spawnLayer = 1;

    public EntityCymesoid(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.cymesoidHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.cymesoidDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.cymesoidSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.cymesoidFollowRange);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

        if (var1 == null)
            return;
        else {
            Vec3 var3 = var1.getLook(1.0F).normalize();
            Vec3 var4 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX - var1.posX, this.boundingBox.minY + this.height / 2.0F - (var1.posY + var1.getEyeHeight()), this.posZ - var1.posZ);
            double var5 = var4.lengthVector();
            var4 = var4.normalize();
            double var7 = var3.dotProduct(var4);
            if( var7 > 1.0D - 0.025D / var5 && var1.canEntityBeSeen(this)) {
                this.addPotionEffect(new PotionEffect(Potion.invisibility.id, 200, 1));
            }
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.cymesoid.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.cymesoidHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheanItems.dirtyPearls, 1);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

	@Override
	public String mobName() {
		return "Crymesoid";
	}
}