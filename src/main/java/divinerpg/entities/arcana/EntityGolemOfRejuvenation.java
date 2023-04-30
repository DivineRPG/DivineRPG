package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

public class EntityGolemOfRejuvenation extends EntityDivineTameable {

    private int healTimer;

    public EntityGolemOfRejuvenation(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
        this.healTimer = 0;
    }

    public EntityGolemOfRejuvenation(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setHealth(getMaxHealth());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.375F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GOLEM.get();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level.isClientSide) {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (this.isTame()) {
                if (item.getFoodProperties(itemstack, null) != null) {
                    if (item.getFoodProperties(itemstack, null).isMeat() && this.getHealth() < this.getMaxHealth()) {
                        if (!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        this.heal((float) item.getFoodProperties(itemstack, null).getNutrition());
                        return InteractionResult.PASS;
                    } else {
                        tame(player);
                        this.setTame(true);
                    }
                }
            }
            return super.mobInteract(player, hand);
        }
        return InteractionResult.PASS;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getOwner() != null) {
            if (this.healTimer == 16) {
                this.getOwner().heal(1);
                this.healTimer = 0;
            } else {
                this.healTimer++;
            }
        }
    }
}
