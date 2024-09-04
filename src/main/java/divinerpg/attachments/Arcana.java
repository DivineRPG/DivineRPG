package divinerpg.attachments;

import javax.annotation.Nullable;

import divinerpg.network.payload.*;
import divinerpg.registries.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;

public class Arcana {
    /**
     * Get current arcana
     * @return amount of arcana
     */
    public static float getAmount(@Nullable LivingEntity entity) {
        return entity == null ? 0 : entity.getData(AttachmentRegistry.ARCANA);
    }
    /**
     * Gets arcana max
     * @return amount of max possible arcana
     */
    public static float getMaxArcana(@Nullable LivingEntity entity) {
        return entity == null ? 0 : entity.getData(AttachmentRegistry.MAX_ARCANA);
    }
    /**
     * Gets delay in ticks
     * @return - amount of ticks that pass between arcana regeneration
     */
    public static int getRegenDelay() {
        return 4;
    }
    /**
     * Set arcana amount
     * @param entity - affected entity. if it is a server player and the amount changes, the new value gets sent to client
     * @param amount - count. will be clamped to 0 - max.
     */
    public static void setAmount(@Nullable LivingEntity entity, float amount) {
    	if(entity == null) return;
    	float previous = getAmount(entity);
    	setAmount(entity, amount, previous);
    }
    private static void setAmount(@Nullable LivingEntity entity, float amount, float previous) {
    	float max = getMaxArcana(entity);
    	amount = amount > max ? max : (amount < 0F ? 0F : amount);
    	entity.setData(AttachmentRegistry.ARCANA, amount);
    	if(previous != amount && entity instanceof ServerPlayer player) PacketDistributor.sendToPlayer(player, new ArcanaAmount(amount));
    }
    /**
     * Change the arcana amount of affected entity
     * @param entity - affected entity. if it is a server player and the amount changes, the new value gets sent to client
     * @param amount - the amount to modify the current arcana amount by
     */
    public static void modifyAmount(@Nullable LivingEntity entity, float amount) {
    	if(amount != 0F && (amount > 0F || !(entity != null && entity instanceof Player player && player.isCreative()))) {
    		float previous = getAmount(entity);
    		setAmount(entity, previous + amount, previous);
    	}
    }
    /**
     * Called every tick. Adds single arcana and sends packet
     * @param entity - entity (usually the player)
     */
    public static void regen(@Nullable LivingEntity entity) {
        if(entity != null && entity.level().getGameTime() % getRegenDelay() == 0) modifyAmount(entity, entity.hasEffect(MobEffectRegistry.KORMA_ARCANA) ? 4F : 1F);
    }
    /**
     * Sets max amount of arcana for player
     *
     * @param max - arcana max. Can't be less than zero
     */
    public static void setMaxArcana(@Nullable LivingEntity entity, float max) {
    	if(entity == null) return;
    	float previous = getMaxArcana(entity);
        max = max < 0F ? 0F : max;
        entity.setData(AttachmentRegistry.MAX_ARCANA, max);
        if(previous != max && entity instanceof ServerPlayer player) PacketDistributor.sendToPlayer(player, new MaxArcana(max));
    }
}