package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.capability.Arcana;
import divinerpg.capability.ArcanaCapability;
import divinerpg.items.base.ItemModSword;
import divinerpg.util.RarityList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ItemStormSword extends ItemModSword {

    public ItemStormSword(String name, IItemTier toolMaterial) {
        super(name, RarityList.COMMON, toolMaterial, DivineRPG.tabs.melee);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        Arcana arcana = player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);
        if (!world.isClientSide && arcana.getArcana() >= 75) {
            Vector3d start  = player.getEyePosition(1);
            Vector3d vec31 = player.getViewVector(1);
            Vector3d end = start.add(vec31.x * 32, vec31.y * 32, vec31.z * 32);
            RayTraceContext pos = new RayTraceContext(start, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, player);

            if (arcana.getArcana() >= 20) {
                arcana.consume(player, 20);
                for (int i = 2; i < 5; i += 2) {
                    double angle = 0;
                    while (angle < 2 * Math.PI) {
                            LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
                            bolt.moveTo(pos.getTo());
                            world.addFreshEntity(bolt);
                            angle += Math.PI / 8.0D;
                    }
                }
            }
            return super.use(world, player, hand);
        }
        return super.use(world, player, hand);
    }
}
