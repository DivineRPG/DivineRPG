package naturix.divinerpg.utils.predicate;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
public class StonePredicate implements Predicate<IBlockState> {

	/**
	 * Says that it will only replace netherrack
	 */
	@Override
	public boolean apply(IBlockState input) {
		return input != null && input.getBlock() == Blocks.STONE;
	}

}