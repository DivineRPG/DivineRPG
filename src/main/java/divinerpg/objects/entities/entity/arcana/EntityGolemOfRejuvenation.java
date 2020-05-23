package divinerpg.objects.entities.entity.arcana;

import divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGolemOfRejuvenation extends EntityDivineRPGTameable {
    private int healTimer;

    public EntityGolemOfRejuvenation(World world) {
        super(world);
        this.setSize(1F, 2.35F);
        this.healTimer = 0;
    }

    public EntityGolemOfRejuvenation(World world, EntityPlayer player) {
        this(world);
        setTamedBy(player);
    }

    @Override
    public float getEyeHeight() {
        return 2.0F;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ItemFood) {
                    ItemFood food = (ItemFood) itemstack.getItem();
                    if (food.isWolfsFavoriteMeat() && this.getHealth() < 30) {
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
        if (this.getOwner() != null) {
            if (this.healTimer == 16) {
                this.getOwner().heal(1);
                this.healTimer = 0;
            } else {
                this.healTimer++;
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GOLEM;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}