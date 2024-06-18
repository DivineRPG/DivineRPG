package divinerpg.capability;

import javax.annotation.Nullable;

import divinerpg.config.CommonConfig;
import divinerpg.registries.MobEffectRegistry;
import divinerpg.util.DivineRPGPacketHandler;
import divinerpg.util.packets.PacketArcanaBar;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.network.PacketDistributor;

public class Arcana implements INBTSerializable<CompoundTag> {
	
	public static float clientMax, clientAmount;
	
    private int tickDelay = 4;
    private float max = CommonConfig.maxArcana.get();
    private float arcana = max;
    /**
     * Get current arcana
     * @return amount of arcana
     */
    public float getAmount(boolean clientSide) {
        return clientSide ? clientAmount : arcana;
    }
    /**
     * Gets arcana max
     * @return amount of max possible arcana
     */
    public float getMaxArcana(boolean clientSide) {
        return clientSide ? clientMax : max;
    }
    /**
     * Gets delay in ticks
     * @return - amount of ticks that pass between arcana regeneration
     */
    public int getRegenDelay() {
        return tickDelay;
    }
    private void sendDataToClient(@Nullable LivingEntity entity) {
    	if(entity != null && entity instanceof ServerPlayer player) DivineRPGPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new PacketArcanaBar(this));
    }
    /**
     * Set arcana amount
     * @param entity - affected entity. if it is a server player and the amount changes, the new value gets sent to client
     * @param amount - count. will be clamped to 0 - max.
     */
    public void setAmount(@Nullable LivingEntity entity, float amount) {
    	float previous = arcana;
    	arcana = amount > max ? max : (amount < 0F ? 0F : amount);
    	if(previous != arcana) sendDataToClient(entity);
    }
    /**
     * Change the arcana amount of affected entity
     * @param entity - affected entity. if it is a server player and the amount changes, the new value gets sent to client
     * @param amount - the amount to modify the current arcana amount by
     */
    public void modifyAmount(@Nullable LivingEntity entity, float amount) {
    	if(amount != 0F && (amount > 0F || !(entity != null && entity instanceof Player player && player.isCreative()))) setAmount(entity, arcana + amount);
    }
    /**
     * Called every tick. Adds single arcana and sends packet
     * @param entity - entity (usually the player)
     */
    public void regen(@Nullable LivingEntity entity) {
        if(entity != null && entity.level().getGameTime() % tickDelay == 0) modifyAmount(entity, entity.hasEffect(MobEffectRegistry.KORMA_ARCANA.get()) ? 4F : 1F);
    }
    /**
     * Sets max amount of arcana for player
     *
     * @param max - arcana max. Can't be less than zero
     */
    public void setMaxArcana(float max) {
        this.max = max < 0F ? 0F : max;
    }
    /**
     * Managing with arcana regen delay
     * @param delay - ticks count in which player can regen one arcana
     */
    public void setRegenDelay(int delay) {
        tickDelay = delay < 1 ? 1 : delay;
    }
    @Override
    public CompoundTag serializeNBT() {
    	CompoundTag tag = new CompoundTag();
    	tag.putFloat("arcana", arcana);
        return tag;
    }
    @Override
    public void deserializeNBT(CompoundTag tag) {
    	arcana = tag.getFloat("arcana");
    }
}