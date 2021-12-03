package divinerpg.world.vethea;

import com.mojang.serialization.*;
import divinerpg.registries.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

import java.util.*;

public class FireCrystalFeature extends Feature<NoFeatureConfig> {

    public FireCrystalFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
        List<Integer> list = new ArrayList<>();
        list.add(16);
        list.add(64);
        list.add(112);
        if(random.nextInt(10) == 0) {
            for (float i = 0; i < 5; i += 0.5) {
                for (float j = 0; j < 2 * Math.PI * i; j += 0.5) {
                    BlockPos position = pos.offset(Math.sin(j) * i, list.get(random.nextInt(list.size())), Math.cos(j) * i);
                    reader.setBlock(position, BlockRegistry.fireCrystal.defaultBlockState(), 0);
                }
            }
        }
        return false;
    }
}
