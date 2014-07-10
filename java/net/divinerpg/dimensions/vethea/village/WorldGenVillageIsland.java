package net.divinerpg.dimensions.vethea.village;

import java.util.ArrayList;
import java.util.Random;

import net.divinerpg.dimensions.vethea.all.WorldGenConeUp;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenVillageIsland extends WorldGenerator
{
	public final WorldGenConeUp spike = new WorldGenConeUp();
	public final ArrayList<WorldGenerator> housesDown;
	public final ArrayList<WorldGenerator> housesUp;
	public final ArrayList<WorldGenerator> lampsDown;
	public final ArrayList<WorldGenerator> lampsUp;
    public WorldGenVillageIsland()
    {
        super();
        housesDown = new ArrayList(3);
        housesDown.add(new HouseDown1());
        housesDown.add(new HouseDown2());
        housesDown.add(new HouseDown3());
        
        housesUp = new ArrayList(5);
        housesUp.add(new HouseUp1());
        housesUp.add(new HouseUp2());
        housesUp.add(new HouseUp3());
        housesUp.add(new HouseUp4());
        housesUp.add(new HouseUp5());
        
        lampsDown = new ArrayList(4);
        lampsDown.add(new LightDown1());
        lampsDown.add(new LightDown2());
        lampsDown.add(new LightDown3());
        lampsDown.add(new LightDown4());
        
        lampsUp = new ArrayList(5);
        lampsUp.add(new LightUp1());
        lampsUp.add(new LightUp2());
        lampsUp.add(new LightUp3());
        lampsUp.add(new LightUp4());
        lampsUp.add(new LightUp5());
        
    }

	@Override
	public boolean generate(World par1, Random par2, int par3, int par4, int par5) {
		int var2 = par2.nextInt(15) + 25;
		
		this.placeSpikeIteration(par1, par2, par3, par4, par5, var2);
		return true;
	}
	
	void placeSpikeIteration (World par1World, Random par2, int x, int y, int z, int radius)
	{
		for (float i = 0; i < radius; i += 5)
		{
			for (float j = 0; j < 2*Math.PI*i; j += 4)
			{
				spike.generate(par1World, par2, (int)Math.round(x + Math.sin(j) * (i - par2.nextInt(2))), y - (int)(i/10), (int)Math.round(z + Math.cos(j) * (i - par2.nextInt(2))), (int)(radius - i)/2);
				
				if (j % 8 == 0)
				{
					int var1 = par2.nextInt(5);
					if (var1 == 0)
					{
						lampsDown.get(par2.nextInt(4)).generate(par1World, par2, (int)Math.round(x + Math.sin(j) * (i - par2.nextInt(2))), y - (int)(i/10) - 5, (int)Math.round(z + Math.cos(j) * (i - par2.nextInt(2))));
					}
					else if (var1 == 1)
					{
						housesDown.get(par2.nextInt(3)).generate(par1World, par2, (int)Math.round(x + Math.sin(j) * (i - par2.nextInt(2))), y - (int)(i/10) - 5, (int)Math.round(z + Math.cos(j) * (i - par2.nextInt(2))));
					}
				}
				else if (par2.nextInt(5) == 0 && j % 8 == 4)
				{
					int var1 = par2.nextInt(5);
					int var2 = y + (int)(radius - i)/2 + 1;
					while (!par1World.isAirBlock((int)Math.round(x + Math.sin(j) * (i - par2.nextInt(2))), var2, (int)Math.round(z + Math.cos(j) * (i - par2.nextInt(2)))))
					{
						var2++;
					}
					if (var1 == 0)
					{
						lampsUp.get(par2.nextInt(4)).generate(par1World, par2, (int)Math.round(x + Math.sin(j) * (i - par2.nextInt(2))), var2, (int)Math.round(z + Math.cos(j) * (i - par2.nextInt(2))));
					}
					else if (var1 == 1)
					{
						housesUp.get(par2.nextInt(5)).generate(par1World, par2, (int)Math.round(x + Math.sin(j) * (i - par2.nextInt(2))), var2, (int)Math.round(z + Math.cos(j) * (i - par2.nextInt(2))));
					}
				}
			}
		}
	}
	
}