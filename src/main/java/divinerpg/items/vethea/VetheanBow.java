package divinerpg.items.vethea;

import divinerpg.items.ranged.ItemBow;
import divinerpg.utils.ToolStats;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;

import java.util.List;
import java.util.function.Supplier;

import static divinerpg.registries.SoundRegistry.VETHEA_BOW;
import static net.minecraft.sounds.SoundSource.PLAYERS;
import static net.minecraft.stats.Stats.ITEM_USED;

public class VetheanBow extends ItemBow {
    public VetheanBow(Properties properties, ToolStats stats, Supplier<Item> infinityArrow, Integer nameColor) {
        super(stats, properties, infinityArrow, nameColor);
    }
    @Override public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if(entityLiving instanceof Player player) {
            ItemStack itemstack = player.getProjectile(stack);
            if(infinityArrow != null && (itemstack.isEmpty() || itemstack.is(infinityArrow.get()))) itemstack = new ItemStack(infinityArrow.get());
            if(itemstack.isEmpty()) return false;
            int i = EventHooks.onArrowLoose(stack, level, player, getUseDuration(stack, entityLiving) - timeLeft, true);
            if(i < 0) return false;
            float f = getPowerForTime(i);
            if(f >= .1F) {
                List<ItemStack> list = draw(stack, itemstack, player);
                if(level instanceof ServerLevel serverlevel && !list.isEmpty()) shoot(serverlevel, player, player.getUsedItemHand(), stack, list, f * 3 * speedScale, 1, f == 1, null);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), VETHEA_BOW, PLAYERS, 1, 1 / (level.getRandom().nextFloat() * .4F + 1.2F) + f * .5F);
                player.awardStat(ITEM_USED.get(this));
            }
            return true;
        }
        return false;
    }
}