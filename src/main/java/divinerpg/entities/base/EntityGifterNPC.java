package divinerpg.entities.base;


import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public abstract class EntityGifterNPC extends PathfinderMob {
    public EntityGifterNPC(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new PanicGoal(this, .5));
        goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, .35));
        goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, .35));
        goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8));
        goalSelector.addGoal(11, new RandomLookAroundGoal(this));
    }
    @Override public boolean checkSpawnRules(LevelAccessor level, EntitySpawnReason type) {return true;}
    @Override public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(isAlive()) {
            if(!level().isClientSide()) {
                player.getInventory().add(getGift());
                if(getChatMessages().length != 0 && random.nextInt(5) == 1) player.sendSystemMessage(Component.literal(getName().getString() + ": ")
                        .append(Component.translatable(getChatMessages()[random.nextInt(getChatMessages().length)])));
                remove(Entity.RemovalReason.DISCARDED);
            } return InteractionResult.PASS;
        } else return super.mobInteract(player, hand);
    }
    protected abstract ItemStack getGift();
    public abstract String[] getChatMessages();
}