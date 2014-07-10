package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityHerbomancerMinion extends EntityDivineRPGMob {
	
    public float jumpHeight;
    public float height;
    public float height1;
    private int slimeJumpDelay = 0;

    public EntityHerbomancerMinion(World par1World) {
        super(par1World);
        this.yOffset = 0.0F;
        this.slimeJumpDelay = this.rand.nextInt(20) + 10;
        this.setSize(1.0F, 1.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.herbomancerMinionHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.herbomancerMinionDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.herbomancerMinionSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.herbomancerMinionFollowRange);
    }
    
    protected String getSlimeParticle() {
        return "slime";
    }

    protected String getJumpSound() {
        return "mob.slime.jump";
    }

    @Override
    public void onUpdate() {
        if (!this.worldObj.isRemote) {
            this.isDead = true;
        }

        this.height += (this.jumpHeight - this.height) * 0.5F;
        this.height1 = this.height;
        boolean var1 = this.onGround;
        super.onUpdate();
        int var2;

        if (this.onGround && !var1) {
            var2 = 1;

            for (int var3 = 0; var3 < var2 * 8; ++var3) {
                float var4 = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float var5 = this.rand.nextFloat() * 0.5F + 0.5F;
                float var6 = MathHelper.sin(var4) * var2 * 0.5F * var5;
                float var7 = MathHelper.cos(var4) * var2 * 0.5F * var5;
                this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX + var6, this.boundingBox.minY, this.posZ + var7, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);

            this.jumpHeight = -0.5F;
        }
        else if (!this.onGround && var1) {
            this.jumpHeight = 1.0F;
        }

        this.jumpHeight();

        if (this.worldObj.isRemote) {
            this.setSize(1.0F, 1.0F);
        }
    }

    @Override
    protected void updateEntityActionState() {
        this.despawnEntity();
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 32.0D);

        if (var1 != null) {
            this.faceEntity(var1, 10.0F, 20.0F);
        }

        if (this.onGround && this.slimeJumpDelay-- <= 0) {
            this.slimeJumpDelay = this.getJumpDelay();

            if (var1 != null) {
                this.slimeJumpDelay /= 3;
            }

            this.isJumping = true;

            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);

            this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
            this.moveForward = (1);
        } else {
            this.isJumping = false;

            if (this.onGround) {
                this.moveStrafing = this.moveForward = 0.0F;
            }
        }
    }

    protected void jumpHeight() {
        this.jumpHeight *= 0.6F;
    }

    protected int getJumpDelay() {
        return this.rand.nextInt(20) + 10;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)  {
        if (this.canEntityBeSeen(par1EntityPlayer) && this.getDistanceSqToEntity(par1EntityPlayer) < 1.0D && par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), 5)) {
            this.playSound("mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
        }
    }

	@Override
	public String mobName() {
		return "Herbomancer Minion";
	}
}