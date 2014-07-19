package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
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
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityTheEye extends EntityDivineRPGMob {
     
    private int teleportDelay = 0;
    private int stare = 0;

    private boolean hasPotion = false;

    public EntityTheEye(World par1World) {
        super(par1World);
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.theEyeHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.theEyeDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.theEyeSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.theEyeFollowRange);
    }

    protected Entity findPlayerToAttack() {
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

        if (var1 != null) {
            if (this.shouldAttackPlayer(var1)) {
                if (this.stare == 0) {
                    this.worldObj.playSoundAtEntity(var1, "mob.endermen.stare", 1.0F, 1.0F);
                }

                if (this.stare++ == 5) {
                    this.stare = 0;
                    return var1;
                }
            } else {
                this.stare = 0;
            }
        }
        return null;
    }

    private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.armorInventory[3];

        if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
            return false;
        } else {
            Vec3 var3 = par1EntityPlayer.getLook(1.0F).normalize();
            Vec3 var4 = Vec3.createVectorHelper(this.posX - par1EntityPlayer.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (par1EntityPlayer.posY + (double)par1EntityPlayer.getEyeHeight()), this.posZ - par1EntityPlayer.posZ);
            double var5 = var4.lengthVector();
            var4 = var4.normalize();
            double var7 = var3.dotProduct(var4);
            return var7 > 1.0D - 0.025D / var5 ? par1EntityPlayer.canEntityBeSeen(this) : false;
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.entityToAttack instanceof EntityPlayerMP) {
            ((EntityPlayerMP)entityToAttack).addPotionEffect(new PotionEffect(Potion.blindness.id, 2 * 40, 2));
            ((EntityPlayer) entityToAttack).triggerAchievement(DivineRPGAchievements.eyeOfEvil);
        }
    }

    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.torch);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        int var4;
        int var3 = this.rand.nextInt(2 + par2) + 1;
        this.dropItem(VanillaItemsOther.rupeeIngot, 1);
        this.dropItem(Item.getItemFromBlock(Blocks.torch), 16 * var3);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 15.0D && super.getCanSpawnHere();
    }

	@Override
	public String mobName() {
		return "The Eye";
	}
}