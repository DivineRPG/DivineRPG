package divinerpg.items.vethea;

import divinerpg.DivineRPG;
import divinerpg.enums.DiskType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class ItemVetheanDissipator extends ItemVetheanDisk {
	public ItemVetheanDissipator(DiskType type) {
		super(type);
	}
	public ArrayList<BlockPos> getLocalDungeonAir(Level level, BlockPos pos) {
		int area = (int) (diskType.getDamage() / 3);
		ArrayList<BlockPos> list = new ArrayList<>();
		for(int x = pos.getX() - area; x < pos.getX() + area; x++) for(int y = pos.getY() - area; y < pos.getY() + area; y++) for(int z = pos.getZ() - area; z < pos.getZ() + area; z++) {
			BlockPos position = new BlockPos(x, y, z);
			if(level.getBlockState(position).is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dungeon_air")))) list.add(position);
		}
		return list;
	}
	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		ArrayList<BlockPos> list = getLocalDungeonAir(level, context.getClickedPos());
		if(list.isEmpty()) return InteractionResult.SUCCESS;
		for(BlockPos pos : list) {
			level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
			level.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, 0.1, 0);
		}
		if(!context.getPlayer().isCreative()) context.getItemInHand().shrink(1);
		level.playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.BEE_LOOP, SoundSource.PLAYERS, 1F, 1F);
		return InteractionResult.CONSUME;
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ArrayList<BlockPos> list = getLocalDungeonAir(level, player.blockPosition());
		if(list.isEmpty()) return super.use(level, player, hand);
		for(BlockPos pos : list) {
			level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
			level.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, 0.1, 0);
		}
		ItemStack itemstack = player.getItemInHand(hand);
		if(!player.isCreative()) itemstack.shrink(1);
		level.playSound(player, player.blockPosition(), SoundEvents.BEE_LOOP, SoundSource.PLAYERS, 1F, 1F);
		return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, itemstack);
	}
}