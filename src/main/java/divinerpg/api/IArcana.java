package divinerpg.api;

import net.minecraft.entity.player.EntityPlayer;

public interface IArcana {
    /**
     * Consumes arcana and sends packet
     * @param player - player
     * @param points - consuming amount
     */
    public void consume(EntityPlayer player, float points);

    /**
     * Adds arcana and send packet
     * @param player - player
     * @param points - adding amount
     */
    public void fill(EntityPlayer player, float points);

    /**
     * Called every tick. Adds single arcana and sends packet
      * @param player - player
     */
    public void regen(EntityPlayer player);

    /**
     * Set arcana amount
     * @param points - count. Final amount can't be less 0 or more getMaxArcana()
     */
    public void set(float points);

    /**
     * Get current arcana
     * @return amount of arcana
     */
    public float getArcana();

    /**
     * Gets arcana max
     * @return amount of max possible arcana
     */
    public float getMaxArcana();

    /**
     * Gets delay in ticks
     * @return - ticks count in which player can regen one arcana
     */
    public int getRegenDelay();

    /**
     * Managing with arcana regen delay
     * @param delay - ticks count in which player can regen one arcana
     */
    public void setRegenDelay(int delay);
}