package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.registry.DRPGSoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Grizzle extends EntityDivineRPGTameable {

    public Grizzle(World worldIn, EntityPlayer player) {
        this(worldIn);
        setTamed(true);
        setOwnerId(player.getUniqueID());
    }

    public Grizzle(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 1.2F);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D * 1.3D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ItemFood) {
                    ItemFood food = (ItemFood) itemstack.getItem();
                    if (food.isWolfsFavoriteMeat() && this.getHealth() < this.getMaxHealth()) {
                        if (!player.capabilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }
                        this.heal(food.getHealAmount(itemstack));
                        return true;
                    }
                }
            }
        } else {
            this.setTamed(true);
            this.setOwnerId(player.getUniqueID());
        }

        return super.processInteract(player, hand);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 9.0F);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.GRIZZLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.GRIZZLE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.GRIZZLE_HURT;
    }
}
