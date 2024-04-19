package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemModSword;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

public class ItemStormSword extends ItemModSword {
    public ItemStormSword(Tier toolMaterial) {
        super(toolMaterial);
        arcanaConsumed = 40;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        int blockReachDistance = 32;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        return player.getCapability(ArcanaProvider.ARCANA).map(arcana -> {
            if(arcana.getArcana() >= arcanaConsumed) {
                for(int i = 2; i < 5; i += 2) {
                    double angle = 0;
                    while (angle < 2 * Math.PI) {
                        LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
                        bolt.moveTo(pos.getLocation());
                        level.addFreshEntity(bolt);
                        angle += Math.PI / 8;
                    }
                }
                arcana.consume(player, arcanaConsumed);
                player.getCooldowns().addCooldown(this, 10);
                player.awardStat(Stats.ITEM_USED.get(this));
                return InteractionResultHolder.success(player.getItemInHand(hand));
            } return super.use(level, player, hand);
        }).orElse(null);
    }
}