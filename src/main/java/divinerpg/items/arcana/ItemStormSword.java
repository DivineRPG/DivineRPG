package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.enums.ToolStats;
import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemStormSword extends ItemModSword {
    public ItemStormSword() {
        super(ToolStats.STORM_SWORD);
        arcanaConsumedUse = 60;
        cooldown = 20;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        int blockReachDistance = 32;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedUse) {
                for(int i = 2; i < 5; i += 2) {
                    double angle = 0;
                    while (angle < 2 * Math.PI) {
                        LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
                        bolt.moveTo(pos.getLocation());
                        level.addFreshEntity(bolt);
                        angle += Math.PI / 8;
                    }
                }
            }
        }); return super.use(level, player, hand);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.lightningShots());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}