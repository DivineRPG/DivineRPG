package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDivineAccumulator extends ItemMod {
    public ItemDivineAccumulator() {
        super(new Properties().stacksTo(1));
        arcanaConsumedUse = 80;
        cooldown = 10;
    }
    @Override
    protected InteractionResultHolder<ItemStack> arcanicUse(Level level, Player player, InteractionHand hand) {
        double x = player.getX(), y = player.getY(), z = player.getZ();
        for(double r = 0; r < 4; r += 0.1) for(double theta = 0; theta < 2 * Math.PI; theta += (Math.PI / 24)) {
        	level.addParticle(ParticleRegistry.EDEN_PORTAL.get(),
    			x + (r * Math.cos(theta)),
                y,
                z + (r * Math.sin(theta)),
                Math.random(),
                Math.random(),
                Math.random());
        }
        player.setJumping(false);
        player.setOnGround(false);
	    player.setDeltaMovement(player.getDeltaMovement().x, player.getDeltaMovement().y + 2, player.getDeltaMovement().z);
	    player.playSound(SoundRegistry.DIVINE_ACCUMULATOR.get(), 1, 1);
    	return InteractionResultHolder.success(player.getItemInHand(hand));
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("divine_accumulator.launch"));
        list.add(LocalizeUtils.i18n("divine_accumulator.fall"));
        super.appendHoverText(stack, worldIn, list, flagIn);
        stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
}