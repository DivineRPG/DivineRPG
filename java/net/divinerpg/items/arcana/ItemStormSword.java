package net.divinerpg.items.arcana;

import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.libs.DivineRPGAchievements;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemStormSword extends ItemModSword {

    public ItemStormSword(String name, ToolMaterial toolMaterial) {
        super(toolMaterial, name);
    }

    @Override
    protected boolean canUseSpecialEffect() {
        return ArcanaHelper.useBar(20);
    }

    @Override
    protected void useSpecialEffect(World world, EntityPlayer player) {
        for (int i = 2; i < 5; i += 2) {
            double angle = 0;
            while (angle < 2 * Math.PI) {
                int xOffset = (int) Math.round(Math.sin(angle) * i);
                int zOffset = (int) Math.round(Math.cos(angle) * i);
                world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + xOffset, player.posY, player.posZ + zOffset));
                angle += Math.PI / 8.0D;
            }
        }
        player.triggerAchievement(DivineRPGAchievements.allHellLoose);
    }
}
