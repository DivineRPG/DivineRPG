package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityTheEye extends EntityDivineRPGMob {

    private boolean hasPotion = false;

    public EntityTheEye(World par1World) {
        super(par1World);
        addAttackingAI();
    }
    
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.theEye);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.theEyeHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.theEyeHurt);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.theEyeHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.theEyeDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.theEyeSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.theEyeFollowRange);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer p = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
        if(p != null) {
            Vec3 lookVec = p.getLook(1.0F).normalize();
            Vec3 lookAtMeVec = Vec3.createVectorHelper(this.posX - p.posX, this.boundingBox.minY + this.height - (p.posY + p.getEyeHeight()), this.posZ - p.posZ);
            double distMagnitude = lookAtMeVec.lengthVector();
            lookAtMeVec = lookAtMeVec.normalize();
            double var7 = lookVec.dotProduct(lookAtMeVec);
            if(var7 > 1.0D - 0.025D / distMagnitude && p.canEntityBeSeen(this)) {
                p.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0, true));
                p.triggerAchievement(DivineRPGAchievements.eyeOfEvil);
            }
        }
    }

    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.torch);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        int torchRand = this.rand.nextInt(2) + 1;
        this.dropItem(VanillaItemsOther.rupeeIngot, 1);
        this.dropItem(Item.getItemFromBlock(Blocks.torch), 16 * torchRand);
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
		return "The Eye";
	}
}