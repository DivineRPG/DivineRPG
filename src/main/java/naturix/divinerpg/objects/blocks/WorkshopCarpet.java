package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * Created by LiteWolf101 on Jan
 * /28/2019
 */
public class WorkshopCarpet extends Block {
    protected String name;
    public WorkshopCarpet(String name) {
        super(Material.CARPET);
        setSoundType(SoundType.CLOTH);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DivineRPG.BlocksTab);
        this.setHardness(1.5f);
    }

    public void registerItemModel(Item itemBlock) {
        DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
