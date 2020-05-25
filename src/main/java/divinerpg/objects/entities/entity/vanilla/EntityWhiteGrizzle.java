package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineTameable;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWhiteGrizzle extends EntityDivineTameable {

    public EntityWhiteGrizzle(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 1.4F);
        this.setHealth(this.getMaxHealth());
    }

    public EntityWhiteGrizzle(World worldIn, EntityPlayer player) {
        this(worldIn);
        setTamedBy(player);
    }

    @Override
    public float getEyeHeight() {
        return 1.2F;
    }


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D * 1.3D);
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
            setTamedBy(player);
            this.playTameEffect(true);
        }

        return super.processInteract(player, hand);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GRIZZLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GRIZZLE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GRIZZLE_HURT;
    }
}
