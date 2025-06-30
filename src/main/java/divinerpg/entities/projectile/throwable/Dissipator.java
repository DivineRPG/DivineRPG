package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.items.ranged.ItemThrowable;
import divinerpg.items.vethea.ItemVetheanDissipator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;

import static divinerpg.registries.ItemRegistry.teaker_dissipator;
import static net.minecraft.sounds.SoundEvents.CANDLE_EXTINGUISH;

public class Dissipator extends EntityDisk {
    public Dissipator(EntityType<? extends DivineThrownItem> type, Level world) {
        super(type, world);
    }
    @Override protected void onHit(HitResult result) {
        super.onHit(result);
        Level level = level();
        ItemStack item = getItem();
        float damage = item.isEmpty() || !(item.getItem() instanceof ItemThrowable t) ? 3 : t.damage;
        ArrayList<BlockPos> list = ItemVetheanDissipator.getLocalDungeonAir(level(), blockPosition(), damage);
        if(!list.isEmpty()) {
            for(BlockPos pos : list) {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                level.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, .1, 0);
                if(getRandom().nextInt(3) == 0) playSound(CANDLE_EXTINGUISH);
            } if(level instanceof ServerLevel l && getOwner() instanceof Player p && !p.isCreative()) item.hurtAndBreak(1, l, p, (i) -> {});
            drop();
        }
    }
    @Override protected Item getDefaultItem() {return teaker_dissipator.get();}
}