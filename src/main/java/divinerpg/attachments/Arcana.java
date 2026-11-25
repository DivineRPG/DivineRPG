package divinerpg.attachments;

import divinerpg.registries.AttachmentRegistry;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public class Arcana {
    public static boolean hasArcana(@Nullable LivingEntity entity) {
        return entity != null && AttachmentRegistry.ARCANA.has(entity);
    }
    /**
     * Get current arcana
     * @return amount of arcana
     */
    public static float getAmount(@Nullable LivingEntity entity) {
        if(entity == null) return 0F;
        return AttachmentRegistry.ARCANA.get(entity);
    }
    /**
     * Gets arcana max
     * @return amount of max possible arcana
     */
    public static float getMaxArcana(@Nullable LivingEntity entity) {
        return entity == null ? 0F : AttachmentRegistry.MAX_ARCANA.get(entity);
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
        setAmount(entity, amount, getAmount(entity));
    }
    private static void setAmount(@Nullable LivingEntity entity, float amount, float previous) {
        amount = Math.clamp(amount, 0F, getMaxArcana(entity));
        if(previous != amount) AttachmentRegistry.ARCANA.set(entity, amount);
    }
    /**
     * Change the arcana amount of affected entity
     * @param entity - affected entity. if it is a server player and the amount changes, the new value gets sent to client
     * @param amount - the amount to modify the current arcana amount by
     */
    public static void modifyAmount(@Nullable LivingEntity entity, float amount) {
        if(amount != 0F && (amount > 0F || !(entity instanceof Player player && player.isCreative()))) {
            float previous = getAmount(entity);
            setAmount(entity, previous + amount, previous);
        }
    }
    /**
     * Called every tick. Adds single arcana and sends packet
     * @param entity - entity (usually the player)
     */
    public static void regen(@Nullable LivingEntity entity) {
        //TODO: if(entity != null && entity.level().getGameTime() % getRegenDelay() == 0) modifyAmount(entity, entity.hasEffect(MobEffectRegistry.KORMA_ARCANA) ? 4F : 1F);
    }
    /**
     * Sets max amount of arcana for player
     *
     * @param max - arcana max. Can't be less than zero
     */
    public static void setMaxArcana(@Nullable LivingEntity entity, float max) {
        if(entity == null) return;
        max = Math.max(max, 0F);
        if(getMaxArcana(entity) != max) AttachmentRegistry.MAX_ARCANA.set(entity, max);
    }
}