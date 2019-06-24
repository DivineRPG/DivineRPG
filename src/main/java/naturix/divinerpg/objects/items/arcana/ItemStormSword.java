package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.items.base.ItemModSword;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class ItemStormSword extends ItemModSword {

    public ItemStormSword(String name, ToolMaterial toolMaterial) {
        super(toolMaterial, name);
    }

    @Override
    protected boolean canUseSpecialEffect(EntityPlayer player) {
    	//FIXME - needs to consume arcana
//        return ArcanaHelper.getProperties(player).useBar(20);
    	return true;
    }

    @Override
    protected void useSpecialEffect(World world, EntityPlayer player) {
        for (int i = 2; i < 5; i += 2) {
            double angle = 0;
            while (angle < 2 * Math.PI) {
                int xOffset = (int) Math.round(Math.sin(angle) * i);
                int zOffset = (int) Math.round(Math.cos(angle) * i);
                if(Math.sqrt(xOffset*xOffset + zOffset*zOffset) > 3) world.spawnEntity(new EntityLightningBolt(world, player.posX + xOffset, player.posY, player.posZ + zOffset, false));
                angle += Math.PI / 8.0D;
            }
        }
        //FIXME - Probably wanna make the achievement trigger at some point
//        player.triggerAchievement(DivineRPGAchievements.allHellLoose);
    }
}