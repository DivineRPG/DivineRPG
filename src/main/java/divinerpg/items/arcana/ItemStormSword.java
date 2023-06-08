package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemModSword;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

public class ItemStormSword extends ItemModSword {

    public ItemStormSword(Tier toolMaterial) {
        super(toolMaterial);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
        if (!world.isClientSide && arcana.getArcana() >= 75) {
            int blockReachDistance = 32;
            Vec3 vec3d = player.getEyePosition(1);
            Vec3 vec3d1 = player.getViewVector(1);
            Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
            BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

            if (arcana.getArcana() >= 20) {
                arcana.consume(player, 20);
                for (int i = 2; i < 5; i += 2) {
                    double angle = 0;
                    while (angle < 2 * Math.PI) {
                        LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
                        bolt.moveTo(pos.getLocation());
                        world.addFreshEntity(bolt);
                        angle += Math.PI / 8.0D;
                    }
                }
            }
        }
        });
        return super.use(world, player, hand);
    }
}
