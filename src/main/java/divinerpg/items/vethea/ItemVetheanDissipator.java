package divinerpg.items.vethea;

import divinerpg.items.ranged.ItemThrowable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import java.util.ArrayList;

import static divinerpg.registries.BlockRegistry.dungeonAir;
import static divinerpg.registries.EntityRegistry.DISSIPATOR;

public class ItemVetheanDissipator extends ItemThrowable {
	public ItemVetheanDissipator(float damage) {
		super(new Properties().stacksTo(1), DISSIPATOR::value, damage);
	}
	public static ArrayList<BlockPos> getLocalDungeonAir(Level level, BlockPos pos, float damage) {
		int area = (int)(damage / 3);
		ArrayList<BlockPos> list = new ArrayList<>();
		for(int x = pos.getX() - area; x < pos.getX() + area; x++) for(int y = pos.getY() - area; y < pos.getY() + area; y++) for(int z = pos.getZ() - area; z < pos.getZ() + area; z++) {
			BlockPos position = new BlockPos(x, y, z);
			if(level.getBlockState(position).is(dungeonAir.get())) list.add(position);
		} return list;
	}
	@Override public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		ArrayList<BlockPos> list = getLocalDungeonAir(level, context.getClickedPos(), damage);
		if(list.isEmpty()) return InteractionResult.PASS;
		for(BlockPos pos : list) {
			level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
			level.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, .1, 0);
			if(context.getPlayer().getRandom().nextInt(3) == 0) level.playSound(context.getPlayer(), pos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS);
		} if(!context.getPlayer().isCreative()) context.getItemInHand().hurtAndBreak(getDurabilityUse(context.getItemInHand()), context.getPlayer(), LivingEntity.getSlotForHand(context.getHand()));
		level.playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.BEE_LOOP, SoundSource.PLAYERS, 1, 1);
		return InteractionResult.SUCCESS;
	}
}