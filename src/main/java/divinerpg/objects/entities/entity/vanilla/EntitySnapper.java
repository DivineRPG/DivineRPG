package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineTameable;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntitySnapper extends EntityDivineTameable {

    public EntitySnapper(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 0.5F);
    }

    public EntitySnapper(World worldIn, EntityPlayer player) {
        this(worldIn);
        setTamedBy(player);
    }

    @Override
    public float getEyeHeight() {
        return 0.4F;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getOwner() != null && this.getOwner() instanceof EntityPlayer) {
            if (this.rand.nextInt(3000) == 0)
                this.getOwner().addPotionEffect(new PotionEffect(MobEffects.SATURATION, 5));
        }
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ItemFood) {
                    ItemFood food = (ItemFood) itemstack.getItem();
                    if (food == Items.FISH && this.getHealth() < this.getMaxHealth()) {
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
}
