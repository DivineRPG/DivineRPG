package divinerpg.objects.blocks.iceika;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.BlockMod;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFrostedAllure extends BlockMod{

    public BlockFrostedAllure(String name) {
        super(name, 0.8f);
        this.setTickRandomly(true);
    }
    
    @Override
    public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
    	super.randomTick(worldIn, pos, state, random);

    	performWorldGenSpawning(worldIn, worldIn.getBiome(pos), pos.getX() + 8, pos.getZ() + 8, 16, 16, random);

    }
    

    public static boolean canCreatureTypeSpawnAtLocation(EntityLiving.SpawnPlacementType spawnPlacementTypeIn, World worldIn, BlockPos pos)
    {
        if (!worldIn.getWorldBorder().contains(pos))
        {
            return false;
        }
        else
        {
            return spawnPlacementTypeIn.canSpawnAt(worldIn, pos);
        }
    }

    public static void performWorldGenSpawning(World worldIn, Biome biomeIn, int centerX, int centerZ, int diameterX, int diameterZ, Random randomIn)
    {
        List<Biome.SpawnListEntry> list = biomeIn.getSpawnableList(EnumCreatureType.MONSTER);

        if (!list.isEmpty())
        {
            while (randomIn.nextFloat() < biomeIn.getSpawningChance())
            {
                Biome.SpawnListEntry biome$spawnlistentry = (Biome.SpawnListEntry)WeightedRandom.getRandomItem(worldIn.rand, list);
                int i = biome$spawnlistentry.minGroupCount + randomIn.nextInt(1 + biome$spawnlistentry.maxGroupCount - biome$spawnlistentry.minGroupCount);
                IEntityLivingData ientitylivingdata = null;
                int j = centerX + randomIn.nextInt(diameterX);
                int k = centerZ + randomIn.nextInt(diameterZ);
                int l = j;
                int i1 = k;

                for (int j1 = 0; j1 < i; ++j1)
                {
                    boolean flag = false;

                    for (int k1 = 0; !flag && k1 < 4; ++k1)
                    {
                        BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(j, 0, k));

                        if (canCreatureTypeSpawnAtLocation(EntityLiving.SpawnPlacementType.ON_GROUND, worldIn, blockpos))
                        {
                            EntityLiving entityliving;

                            try
                            {
                                entityliving = biome$spawnlistentry.newInstance(worldIn);
                            }
                            catch (Exception exception)
                            {
                                exception.printStackTrace();
                                continue;
                            }

                            if (net.minecraftforge.event.ForgeEventFactory.canEntitySpawn(entityliving, worldIn, j + 0.5f, (float) blockpos.getY(), k +0.5f, false) == net.minecraftforge.fml.common.eventhandler.Event.Result.DENY) continue;
                            entityliving.setLocationAndAngles((double)((float)j + 0.5F), (double)blockpos.getY(), (double)((float)k + 0.5F), randomIn.nextFloat() * 360.0F, 0.0F);
                            
                            AxisAlignedBB bb = new AxisAlignedBB(blockpos).grow(7, 4, 7);
                        	int numCreaturesNearby = worldIn.getEntitiesWithinAABB(EntityLiving.class, bb, input -> input != null && input.isCreatureType(EnumCreatureType.MONSTER, false)).size();
                    		if (numCreaturesNearby < 8) {
                            worldIn.spawnEntity(entityliving);
                    		}
                            ientitylivingdata = entityliving.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), ientitylivingdata);
                            flag = true;
                        }

                        j += randomIn.nextInt(5) - randomIn.nextInt(5);

                        for (k += randomIn.nextInt(5) - randomIn.nextInt(5); j < centerX || j >= centerX + diameterX || k < centerZ || k >= centerZ + diameterX; k = i1 + randomIn.nextInt(5) - randomIn.nextInt(5))
                        {
                            j = l + randomIn.nextInt(5) - randomIn.nextInt(5);
                        }
                    }
                }
            }
        }
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> list, ITooltipFlag advanced)
    {
    	list.add(new TextComponentTranslation("tooltip.frosted_allure").getFormattedText());
    }
}