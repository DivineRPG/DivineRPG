package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.*;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EntitySnapper extends EntityDivineTameable {
    public EntitySnapper(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setHealth(getMaxHealth());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.4F;
    }

    protected EntitySnapper(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (this.isTame()) {
                if (itemstack.is(ItemTags.FISHES) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.isCreative()) itemstack.shrink(1);
                    if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                        this.tame(player);
                        this.navigation.recomputePath();
                        this.setTarget((LivingEntity) null);
                        this.level().broadcastEntityEvent(this, (byte) 7);
                        this.heal(item.getFoodProperties(itemstack, player).getNutrition());
                    } else {
                        this.level().broadcastEntityEvent(this, (byte) 6);
                        this.heal(item.getFoodProperties(itemstack, player).getNutrition());
                    }
                } else {
                    tame(player);
                    this.setTame(true);
                }
            }
            return super.mobInteract(player, hand);
        }
        return InteractionResult.PASS;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getOwner() != null && this.getOwner() instanceof Player) if (this.random.nextInt(3000) == 0) this.getOwner().addEffect(new MobEffectInstance(MobEffects.SATURATION, 5));
    }
}
