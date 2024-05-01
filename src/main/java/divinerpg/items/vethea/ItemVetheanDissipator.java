package divinerpg.items.vethea;

import divinerpg.enums.BulletType;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import java.util.ArrayList;

public class ItemVetheanDissipator extends ItemVetheanDisk {
	public ItemVetheanDissipator(BulletType diskType) {super(diskType);}
	public ArrayList<BlockPos> getLocalDungeonAir(Level level, BlockPos pos) {
		int area = (int)(bulletType.getDamage() / 3);
		ArrayList<BlockPos> list = new ArrayList<>();
		for(int x = pos.getX() - area; x < pos.getX() + area; x++) for(int y = pos.getY() - area; y < pos.getY() + area; y++) for(int z = pos.getZ() - area; z < pos.getZ() + area; z++) {
			BlockPos position = new BlockPos(x, y, z);
			if(level.getBlockState(position).is(BlockRegistry.dungeonAir.get())) list.add(position);
		} return list;
	}
	@Override public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		ArrayList<BlockPos> list = getLocalDungeonAir(level, context.getClickedPos());
		if(list.isEmpty()) return InteractionResult.PASS;
		for(BlockPos pos : list) {
			level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
			level.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, .1, 0);
		} if(!context.getPlayer().isCreative()) context.getItemInHand().shrink(1);
		level.playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.BEE_LOOP, SoundSource.PLAYERS, 1, 1);
		return InteractionResult.SUCCESS;
	}
}