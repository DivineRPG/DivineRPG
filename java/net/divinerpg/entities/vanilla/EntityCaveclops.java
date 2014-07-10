package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.divinerpg.entities.vanilla.projectile.EntityCaveRock;
import net.divinerpg.libs.Sounds;

public class EntityCaveclops extends EntityDivineRPGMob implements IRangedAttackMob {
	
    public EntityCaveclops(World par1World) {
        super(par1World);
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.25F, 30, 10.0F));
        addAttackingAI();
        this.setSize(1.0F, 2.9F);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.caveclopsHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.caveclopsDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.caveclopsSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.caveclopsFollowRange);
    }

	@Override
	protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.cyclops);
    }

	@Override 
	protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.cyclopsHurt);
    }
 
	@Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.cyclopsHurt);
    }
 
	@Override
    protected void dropFewItems(boolean par1, int par2) {
        int var3;
        int var4;
        var3 = this.rand.nextInt(3 + par2);

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(VanillaItemsOther.realmiteIngot, 3);
        }

        var3 = this.rand.nextInt(3 + par2);

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.golden_pickaxe, 1);
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 20.0D && super.getCanSpawnHere();
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase var1, float f) {
        EntityCaveRock var2 = new EntityCaveRock(this.worldObj, this);
        double var3 = var1.posX - this.posX;
        double var5 = var1.posY + (double)var1.getEyeHeight() - 1.100000023841858D - var2.posY;
        double var7 = var1.posZ - this.posZ;
        float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
        var2.setThrowableHeading(var3, var5 + (double)var9, var7, 1.6F, 12.0F);
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var2);
    }

	@Override
	public String mobName() {
		return "Caveclops";
	}
}