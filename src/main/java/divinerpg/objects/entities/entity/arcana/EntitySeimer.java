package divinerpg.objects.entities.entity.arcana;

import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.objects.entities.entity.EntityDivineTameable;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntitySeimer extends EntityDivineTameable {

    public EntitySeimer(World par1World) {
        super(par1World);
        this.setSize(1.0F, 1.0F);
    }

    public EntitySeimer(World par1World, EntityPlayer player) {
        this(par1World);
        setTamedBy(player);
    }

    @Override
    public float getEyeHeight() {
        return 0.6F;
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
        if (this.getOwner() != null && this.getOwner() instanceof EntityPlayer) {
            IArcana arcana = DivineAPI.getArcana(this.getOwner());
            arcana.fill((EntityPlayer) this.getOwner(), 1);
        }
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}