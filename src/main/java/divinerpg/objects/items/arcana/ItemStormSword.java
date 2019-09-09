package divinerpg.objects.items.arcana;

import divinerpg.capabilities.ArcanaProvider;
import divinerpg.api.IArcana;
import divinerpg.objects.items.base.ItemModSword;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemStormSword extends ItemModSword {

    public ItemStormSword(String name, ToolMaterial toolMaterial) {
        super(toolMaterial, name);
    }

    @Override
    protected boolean canUseSpecialEffect(EntityPlayer player) {
		IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
		if(arcana.getArcana()>=20) {
		arcana.consume(player, 20);
    	return true;
		}else {
			return false;
		}
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
    }
}