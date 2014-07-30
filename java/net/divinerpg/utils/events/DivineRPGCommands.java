package net.divinerpg.utils.events;

import java.util.List;

import net.divinerpg.api.worldgen.DivineTeleporter;
import net.divinerpg.dimensions.arcana.TeleporterArcana;
import net.divinerpg.dimensions.vethea.TeleporterVethea;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.world.Teleporter;

public class DivineRPGCommands extends CommandBase {

	@Override
	public String getCommandName() {
		return "divinerpg";
	}

	@Override
	public String getCommandUsage(ICommandSender cmdSender) {
		return "/divinerpg <var1> <dimension>";
	}

	@Override
	public void processCommand(ICommandSender cmdSender, String[] args) {
		EntityPlayerMP playerMP = (EntityPlayerMP) cmdSender;
		if(!playerMP.worldObj.isRemote) {

			if (args[0].equalsIgnoreCase("Overworld")) {
				if (playerMP.dimension != 0) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, new Teleporter(playerMP.mcServer.worldServerForDimension(playerMP.dimension)));
				}
			}
			
			if (args[0].equalsIgnoreCase("Nether")) {
				if (playerMP.dimension != -1) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, -1, new Teleporter(playerMP.mcServer.worldServerForDimension(playerMP.dimension)));
				}
			}

			if (args[0].equalsIgnoreCase("End")) {
				if (playerMP.dimension != 1) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 1, new Teleporter(playerMP.mcServer.worldServerForDimension(playerMP.dimension)));
				}
			}

			if (args[0].equalsIgnoreCase("Eden")) {
				if (playerMP.dimension != ConfigurationHelper.eden) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ConfigurationHelper.eden,
							new DivineTeleporter(playerMP.mcServer.worldServerForDimension(ConfigurationHelper.eden), ConfigurationHelper.eden,
									TwilightBlocks.edenPortal, VanillaBlocks.divineRock));
				}
			}

			if (args[0].equalsIgnoreCase("Iceika")) {
				if (playerMP.dimension != ConfigurationHelper.iceika) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ConfigurationHelper.iceika,
							new DivineTeleporter(playerMP.mcServer.worldServerForDimension(ConfigurationHelper.iceika), ConfigurationHelper.iceika,
									IceikaBlocks.portal, Blocks.snow));
				}
			}

			if (args[0].equalsIgnoreCase("WildWoods")) {
				if (playerMP.dimension != ConfigurationHelper.wildwood) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ConfigurationHelper.wildwood,
							new DivineTeleporter(playerMP.mcServer.worldServerForDimension(ConfigurationHelper.wildwood), ConfigurationHelper.wildwood,
									TwilightBlocks.wildwoodPortal, TwilightBlocks.edenBlock));
				}
			}
			
			if (args[0].equalsIgnoreCase("Apalachia")) {
				if (playerMP.dimension != ConfigurationHelper.apalachia) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ConfigurationHelper.apalachia,
							new DivineTeleporter(playerMP.mcServer.worldServerForDimension(ConfigurationHelper.apalachia), ConfigurationHelper.apalachia,
									TwilightBlocks.apalachiaPortal, TwilightBlocks.wildwoodBlock));
				}
			}
			
			if (args[0].equalsIgnoreCase("Skythern")) {
				if (playerMP.dimension != ConfigurationHelper.skythern) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ConfigurationHelper.skythern,
							new DivineTeleporter(playerMP.mcServer.worldServerForDimension(ConfigurationHelper.skythern), ConfigurationHelper.skythern,
									TwilightBlocks.skythernPortal, TwilightBlocks.apalachiaBlock));
				}
			}
			
			if (args[0].equalsIgnoreCase("Mortum")) {
				if (playerMP.dimension != ConfigurationHelper.mortum) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ConfigurationHelper.mortum,
							new DivineTeleporter(playerMP.mcServer.worldServerForDimension(ConfigurationHelper.mortum), ConfigurationHelper.mortum,
									TwilightBlocks.mortumPortal, TwilightBlocks.skythernBlock));
				}
			}

			if (args[0].equalsIgnoreCase("Arcana")) {
				if (playerMP.dimension != ConfigurationHelper.arcana) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ConfigurationHelper.arcana,
							new TeleporterArcana(playerMP.mcServer.worldServerForDimension(ConfigurationHelper.arcana)));
				}
			}

			if (args[0].equalsIgnoreCase("Vethea")) {
				if (playerMP.dimension != ConfigurationHelper.vethea) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ConfigurationHelper.vethea, 
							new TeleporterVethea(playerMP.mcServer.worldServerForDimension(ConfigurationHelper.vethea)));
				}
			}

			if(playerMP.dimension == ConfigurationHelper.iceika)
				playerMP.triggerAchievement(DivineRPGAchievements.frozenLand);

			if(playerMP.dimension == ConfigurationHelper.mortum)
				playerMP.triggerAchievement(DivineRPGAchievements.darkAnotherDay);
			
			if(playerMP.dimension == ConfigurationHelper.eden)
				playerMP.triggerAchievement(DivineRPGAchievements.possibilities);

		}
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 1;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2) {
		return par2.length == 1 ? getListOfStringsMatchingLastWord(par2, new String[] { "Overworld", "Nether", "End", "Iceika", "Eden", "WildWoods", "Apalachia", "Skythern", "Mortum", "Arcana", "Vethea" }) : null;
	}
}
