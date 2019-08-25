package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoRed extends Ayeraco {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/ayeraco_red");

    public AyeracoRed(World worldIn) {
        super(worldIn);
    }

    public AyeracoRed(World world, BlockPos beam) {
        super(world, beam, Color.RED, LOOT);
    }
}
