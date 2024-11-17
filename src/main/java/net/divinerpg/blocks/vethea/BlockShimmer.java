package net.divinerpg.blocks.vethea;

public class BlockShimmer extends BlockVetheaPlant{

	public BlockShimmer(String name) {
		super(name);
		setBlockBounds(0, 0, 0, 1, 0.1f, 1);
	}
	
	@Override
	public int getRenderType() {
		return 23;
	}

}
