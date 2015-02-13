package net.divinerpg.items.arcana;

import net.divinerpg.items.base.ItemModSword;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.events.ArcanaHelper;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemStormSword extends ItemModSword {

    public ItemStormSword(String name, ToolMaterial toolMaterial) {
        super(toolMaterial, name);
    }

    @Override
    protected boolean canUseSpecialEffect(EntityPlayer player) {
        return ArcanaHelper.getProperties(player).useBar(20);
    }

    @Override
    protected void useSpecialEffect(World world, EntityPlayer player) {
        for (int i = 2; i < 5; i += 2) {
            double angle = 0;
            while (angle < 2 * Math.PI) {
                int xOffset = (int) Math.round(Math.sin(angle) * i);
                int zOffset = (int) Math.round(Math.cos(angle) * i);
                if(Math.sqrt(xOffset*xOffset + zOffset*zOffset) > 3) world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + xOffset, player.posY, player.posZ + zOffset));
                angle += Math.PI / 8.0D;
            }
        }
        player.triggerAchievement(DivineRPGAchievements.allHellLoose);
    }
}
