package naturix.divinerpg.objects.blocks;

import java.util.ArrayList;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireBase extends BlockFire implements IHasModel {

    protected ArrayList<PortalBase> portals = new ArrayList<PortalBase>();
    protected String name;

    public FireBase(String name) { // TODO
        super();
        this.name = name;
        setLightLevel(1.0F);
        setCreativeTab(null);
        setUnlocalizedName(name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public void addPortal(PortalBase portal) {
        portals.add(portal);
    }

    protected boolean canNeighborBurn(World world, BlockPos pos) {
        return this.canCatchFire(world, pos.west()) || this.canCatchFire(world, pos.east()) || this.canCatchFire(world, pos.up()) || this.canCatchFire(world, pos.down()) || this.canCatchFire(world, pos.south()) || this.canCatchFire(world, pos.north());
    }

    protected void lightPortal(World world, BlockPos pos, IBlockState state) {
        ModBlocks.edenPortal.makePortal(world, pos);
        ModBlocks.wildwoodPortal.makePortal(world, pos);
        ModBlocks.apalachiaPortal.makePortal(world, pos);
        ModBlocks.skythernPortal.makePortal(world, pos);
        ModBlocks.mortumPortal.makePortal(world, pos);
        ModBlocks.iceikaPortal.makePortal(world, pos);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        lightPortal(world, pos, state);
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}