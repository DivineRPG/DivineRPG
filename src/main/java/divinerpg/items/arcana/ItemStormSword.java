package divinerpg.items.arcana;

import divinerpg.items.base.ItemModSword;
import divinerpg.utils.ToolStats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class ItemStormSword extends ItemModSword {
    public ItemStormSword(Properties properties) {
        super(ToolStats.STORM_SWORD, properties);
    arcanaConsumedUse = 60;
    cooldown = 20;
    }

    @Override
    protected InteractionResult arcanicUse(Level level, Player player, InteractionHand hand) {
        int blockReachDistance = 32;
        Vec3 eyePosition = player.getEyePosition(1);
        Vec3 viewVector = player.getViewVector(1);
        Vec3 vec3 = eyePosition.add(viewVector.x * blockReachDistance, viewVector.y * blockReachDistance, viewVector.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(eyePosition, vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        for(int i = 2; i < 5; i += 2) {
            double angle = 0;
            while(angle < 2 * Math.PI) {
                LightningBolt bolt = new LightningBolt(EntityTypes.LIGHTNING_BOLT, level);
                bolt.moveOrInterpolateTo(pos.getLocation().offsetRandom(RandomSource.create(), 8));
                level.addFreshEntity(bolt);
                angle += Math.PI / 8;
            }
        } return InteractionResult.SUCCESS;
    }
}
