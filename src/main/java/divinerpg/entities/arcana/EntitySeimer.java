package divinerpg.entities.arcana;

import divinerpg.capability.*;
import divinerpg.entities.base.*;
import net.minecraft.world.*;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EntitySeimer extends EntityDivineTameable {

    public EntitySeimer(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }

    public EntitySeimer(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setHealth(getMaxHealth());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.6F;
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
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
        if (this.getOwner() != null && this.getOwner() instanceof Player) {
            getOwner().getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                arcana.fill((Player) this.getOwner(), 1);
            });
        }
    }
}