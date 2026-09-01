package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.ParticleRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class ItemDivineAccumulator extends ItemMod {

    public ItemDivineAccumulator(Properties properties) {
        super(properties.stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
        arcanaConsumedUse = 80;
        cooldown = 10;
    }

    @Override
    protected InteractionResult arcanicUse(Level level, Player player, InteractionHand hand) {
        double x = player.getX(), y = player.getY(), z = player.getZ();
        for(double r = 0; r < 4; r+= 0.1) for(double theta = 0; theta < 2 * Math.PI; theta += (Math.PI / 24)) {
            level.addParticle(ParticleRegistry.EDEN_PORTAL.get(), x + r * Math.cos(theta), y, z + (r * Math.sin(theta)), Math.random(), Math.random(), Math.random());
            }
            player.setJumping(false);
            player.setOnGround(false);
            player.setDeltaMovement(player.getDeltaMovement().x, player.getDeltaMovement().y + 2, player.getDeltaMovement().z);
            player.playSound(SoundRegistry.DIVINE_ACCUMULATOR.get(), 1, 1);
            return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.i18n("divine_accumulator.launch"));
        builder.accept(LocalizeUtils.i18n("divine_accumulator.fall"));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
}
