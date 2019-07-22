package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class GolemOfRejuvination extends EntityDivineRPGTameable {
    private int healTimer;

    public GolemOfRejuvination(World world) {
        super(world);
        this.setSize(1F, 2.2F);
        this.healTimer = 0;
    }

    public GolemOfRejuvination(World par1World, EntityPlayer p) {
        this(par1World);
        this.setOwnerId(p.getUniqueID());
        setTamed(true);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
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
        return ModSounds.GOLEM;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}