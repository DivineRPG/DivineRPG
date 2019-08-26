package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoGreen extends Ayeraco {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/ayeraco_green");

    public AyeracoGreen(World worldIn) {
        super(worldIn);
    }

    public AyeracoGreen(World world, BlockPos beam) {
        super(world, beam, Color.GREEN, LOOT);
    }
}
