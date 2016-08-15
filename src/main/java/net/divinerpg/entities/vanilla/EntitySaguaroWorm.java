package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.vanilla.projectile.EntitySaguaroWormShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySaguaroWorm extends EntityDivineRPGMob {

    public EntitySaguaroWorm(World par1World) {
        super(par1World);
        this.setSize(0.5F, 3F);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.saguaroWormHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.saguaroWormDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.saguaroWormSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.saguaroWormFollowRange);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(17, 0);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.worldObj.isRemote) {
            this.entityToAttack = this.worldObj.getClosestVulnerablePlayerToEntity(this, 10);
            if(entityToAttack == null) this.dataWatcher.updateObject(17, 0);
            else {
                this.dataWatcher.updateObject(17, 1);
                if(this.ticksExisted%50==0) this.attack((EntityLivingBase)entityToAttack);
            }
        }
        if(this.dataWatcher.getWatchableObjectInt(17)==0)this.renderYawOffset=0;
    }

    @Override
    public void dropFewItems(boolean hit, int looting) {
        this.dropItem(VanillaItemsOther.terranShards, this.rand.nextInt(3+looting));
        this.dropItem(Item.getItemFromBlock(Blocks.cactus), this.rand.nextInt(3)+3);
    }

    public void attack(EntityLivingBase e) {
        double y = this.boundingBox.minY+2.7;
        double tx = e.posX - this.posX;
        double ty = e.boundingBox.minY - y;
        double tz = e.posZ - this.posZ;

        for(double h = -1.5; h<1.5; h+=0.3) {
            for (double r = 0; r < 1.5 - Math.abs(h); r += 0.3) {
                for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 8) {
                    EntitySaguaroWormShot shot = new EntitySaguaroWormShot(this.worldObj, this);
                    shot.posX = this.posX + r * Math.cos(theta);
                    shot.posY = this.posY + 5 + h;
                    shot.posZ = this.posZ + r * Math.sin(theta);
                    shot.setThrowableHeading(tx, ty, tz, 0.9f, 5);
                    worldObj.spawnEntityInWorld(shot);
                }
            }
        }
    }

    @Override
    protected String getLivingSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.saguaroWorm);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.saguaroWorm);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.getBlock((int)this.posX, MathHelper.floor_double(this.boundingBox.minY)-1, (int)this.posZ) == Blocks.sand && super.getCanSpawnHere();
    }

    @Override
    public String mobName() {
        return "Saguaro Worm";
    }

    @Override
    public boolean needsSpecialAI() {
        return true;
    }

}