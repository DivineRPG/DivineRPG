package net.divinerpg.blocks.vethea;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.api.worldgen.DivineTeleporter;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class BlockTestTeleporter extends BlockMod{

    public BlockTestTeleporter(String name) {
        super(name, 0.4F, DivineRPGTabs.vethea);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if(player.isSneaking()) return false;
        EntityPlayerMP MPPlayer = (EntityPlayerMP)player; 
        MPPlayer.mcServer.getConfigurationManager().transferPlayerToDimension(MPPlayer, ConfigurationHelper.vethea); //Crashes. Need to find correct way to get EntityPlayerMP I think.
        return true;
    }
}
