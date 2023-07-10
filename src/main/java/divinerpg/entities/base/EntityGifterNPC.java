package divinerpg.entities.base;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;

import java.util.ArrayList;
import java.util.Objects;

public abstract class EntityGifterNPC extends PathfinderMob {

    public EntityGifterNPC(EntityType<? extends PathfinderMob> type, Level worldIn) {
    	super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }
    @Override
    public boolean checkSpawnRules(LevelAccessor p_21686_, MobSpawnType p_21687_) {
        return super.checkSpawnRules(p_21686_, p_21687_) &&
                !p_21686_.getBiome(this.blockPosition()).is(Objects.requireNonNull(ResourceLocation.tryParse("minecraft:mushroom_fields")));
    }
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(this.isAlive()) {
            if(!this.level().isClientSide) {
                player.inventory.add(this.getGift());
                sendRandomChatMessage(player);
                this.kill();
            }
            return InteractionResult.PASS;
        } else {
        	return super.mobInteract(player, hand);
        }
    }

    protected void sendRandomChatMessage(Player player) {
        ArrayList<String> messages = getMessages();
        String name = Component.translatable(getTranslationName()).getString();
        String messageToTranslate = Component.translatable(messages.get(random.nextInt(messages.size()))).getString();
        Component message = Component.translatable(name + ": " + messageToTranslate);
        player.displayClientMessage(message, true);
    }

    protected abstract ItemStack getGift();
    protected abstract ArrayList<String> getMessages();
    protected abstract String getTranslationName();
}