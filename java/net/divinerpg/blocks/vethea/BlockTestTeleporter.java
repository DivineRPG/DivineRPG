package net.divinerpg.blocks.vethea;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockTestTeleporter extends BlockMod{

    public BlockTestTeleporter(String name) {
        super(name, 0.4F, DivineRPGTabs.vethea);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if(player.isSneaking()) return false;
        player.travelToDimension(ConfigurationHelper.vethea);
        return true;
    }

}
