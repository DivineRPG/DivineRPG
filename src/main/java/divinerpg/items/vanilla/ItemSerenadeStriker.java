package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import java.util.function.Consumer;

public class ItemSerenadeStriker extends ItemMod {
    public ItemSerenadeStriker(Properties properties) {
        super(properties.stacksTo(1).durability(100));
        cooldown = 80;
    }
    @Override public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        int blockReachDistance = 32;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        double angle = 0;
        while(angle < 1 * Math.PI) {
            LightningBolt bolt = new LightningBolt(EntityTypes.LIGHTNING_BOLT, level);
            bolt.moveOrInterpolateTo(pos.getLocation());
            level.addFreshEntity(bolt);
            angle += Math.PI / 8;
        } if(!player.isCreative()) stack.hurtAndBreak(1, player, hand);
        player.getCooldowns().addCooldown(stack, cooldown);
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.lightningShots());
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }

}