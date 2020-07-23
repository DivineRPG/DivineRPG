package divinerpg.objects.entities.entity.arcana;

import divinerpg.objects.entities.entity.EntityDivineTameable;
import divinerpg.objects.entities.entity.projectiles.EntityFyracryxFireball;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityFyracryx extends EntityDivineTameable implements IRangedAttackMob {

    public EntityFyracryx(World par1World) {
        super(par1World);
        this.setSize(1.0F, 1.2F);
        this.isImmuneToFire = true;
    }

    public EntityFyracryx(World world, EntityPlayer player) {
        this(world);
        setTamedBy(player);
    }

    @Override
    public float getEyeHeight() {
        return 0.85F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DEATHCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEATHCRYX;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ItemFood) {
                    ItemFood food = (ItemFood) itemstack.getItem();
                    if (food.isWolfsFavoriteMeat() && this.getHealth() < 20) {
                        if (!player.capabilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }
                        this.heal(food.getHealAmount(itemstack));
                        return true;
                    }
                }
            }
        } else {
            setTamedBy(player);
            this.playTameEffect(true);
        }

        return super.processInteract(player, hand);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getAttackTarget() != null && !this.world.isRemote && this.ticksExisted % 20 == 0)
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 0);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
        double tx = e.posX - this.posX;
        double ty = e.getEntityBoundingBox().minY - this.posY;
        double tz = e.posZ - this.posZ;
        float dist = MathHelper.sqrt(this.getDistance(this)) * 0.5F;
        this.world.playEvent(null, 1018, new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ),
                0);

        EntityFyracryxFireball shot = new EntityFyracryxFireball(this.world, this, tx + this.rand.nextGaussian() * dist,
                ty, tz + this.rand.nextGaussian() * dist);
        shot.posY = this.posY + this.height / 2.0F + 0.5D;
        this.world.spawnEntity(shot);
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}