package naturix.divinerpg.objects.blocks.iceika;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * Created by LiteWolf101 on Feb
 * /20/2019
 */
public class XMasLights extends BlockLadder {
    protected String name;
    public XMasLights(String name) {
        super();
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(3f);
        setResistance(5f);
        setCreativeTab(DivineRPG.BlocksTab);
        setLightLevel(1);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return false;
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    public void registerItemModel() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, name);
    }
}
