package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityLiopleurodon extends EntityDivineRPGMob {

    public EntityLiopleurodon(World var1) {
        super(var1);
        this.setSize(2F, 1F);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.liopleurodonHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.liopleurodonDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.liopleurodonSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.liopleurodonFollowRange);
    }
    
    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.liopleurodon);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.liopleurodonHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.liopleurodonHurt);
    }

    @Override
    protected float getSoundVolume() {
        return 0.05F;
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        if(rand.nextInt(7)==0)this.dropItem(VanillaItemsOther.liopleurodonSkull, 1);
        this.dropItem(VanillaItemsOther.liopleurodonTeeth, this.rand.nextInt(3+var2));
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextBoolean() && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isInWater();
    }

    @Override
    public void onEntityUpdate() {
        int i = this.getAir();
        super.onEntityUpdate();

        if (this.isEntityAlive() && !this.isInWater()) {
            if (!this.worldObj.isRemote) {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }
            --i;
            this.setAir(i);

            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0F);
            }
        }
        else {
            this.setAir(300);
        }   
    }

    @Override
    public boolean isInWater() {
        return this.worldObj.getBlock((int)this.posX, MathHelper.floor_double(this.posY), (int)this.posZ).getMaterial() == Material.water;
    }

    @Override
    protected void fall(float var1) {}
    
    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    public String mobName() {
        return "Liopleurodon";
    }
}