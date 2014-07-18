package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityHiveQueen extends EntityDivineRPGBoss {
	
    private int spawnTick;
    private int deathTicks;

    public EntityHiveQueen(World var1) {
        super(var1);
        addAttackingAI();
        this.spawnTick = 80;
        this.setSize(1.5F, 4.0F); 
    }

    @Override
    public String mobName() {
        return "Hive Queen";
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.hiveQueenHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.hiveQueenDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.hiveQueenSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.hiveQueenFollowRange);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.spawnTick % 40 == 0 && !this.worldObj.isRemote) {
            EntityHoverStinger var2 = new EntityHoverStinger(this.worldObj);
            var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
            this.worldObj.spawnEntityInWorld(var2);
            this.worldObj.spawnParticle("reddust", var2.posX, var2.posY + 0.5D, var2.posZ, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D);
            spawnTick = 80;
        }

        if (this.spawnTick == 0 && !this.worldObj.isRemote) {
            EntityHiveSoldier var2 = new EntityHiveSoldier(this.worldObj);
            var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
            this.worldObj.spawnEntityInWorld(var2);
            this.worldObj.spawnParticle("reddust", var2.posX, var2.posY + 0.5D, var2.posZ, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D);
            this.spawnTick = 160;
        }

        this.spawnTick--;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.hiveQueen.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.hiveQueenHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.honeychunk, 10);
        if (this.rand.nextInt(5) != 0) {
            this.dropItem(VetheaItems.honeysuckle, 15);
        }
    }

    @Override
    protected void onDeathUpdate() {
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D);
        }
        int var4, var5;
        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                var4 = 1000;
                while (var4 > 0) {
                    var5 = EntityXPOrb.getXPSplit(var4);
                    var4 -= var5;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
                }
            }
            if (this.deathTicks == 1) {
                this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }

        this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
        this.renderYawOffset = this.rotationYaw += 20.0F;

        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            var4 = 2000;

            while (var4 > 0) {
                var5 = EntityXPOrb.getXPSplit(var4);
                var4 -= var5;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
            }
            this.setDead();
        }
    }

	@Override
	public String name() {
		return "Hive Queen";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}