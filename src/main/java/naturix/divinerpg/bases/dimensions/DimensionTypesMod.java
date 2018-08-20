package naturix.divinerpg.bases.dimensions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.world.WorldProvider;

public enum DimensionTypesMod
{

	Eden(2, "_eden", "_eden", WorldProviderEden.class);

	private final int id;
    private final String name;
    private final String suffix;
    private final Class <? extends WorldProvider > clazz;
    private boolean shouldLoadSpawn = false;

    private DimensionTypesMod(int idIn, String nameIn, String suffixIn, Class <? extends WorldProvider > clazzIn)
    {
        this.id = idIn;
        this.name = nameIn;
        this.suffix = suffixIn;
        this.clazz = clazzIn;
        this.shouldLoadSpawn = idIn == 0;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getSuffix()
    {
        return this.suffix;
    }

    public WorldProvider createDimension()
    {
        try
        {
            Constructor <? extends WorldProvider > constructor = this.clazz.getConstructor();
            return constructor.newInstance();
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new Error("Could not create new dimension", nosuchmethodexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new Error("Could not create new dimension", invocationtargetexception);
        }
        catch (InstantiationException instantiationexception)
        {
            throw new Error("Could not create new dimension", instantiationexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new Error("Could not create new dimension", illegalaccessexception);
        }
    }

    public static DimensionTypesMod getById(int id)
    {
        for (DimensionTypesMod dimensiontype : values())
        {
            if (dimensiontype.getId() == id)
            {
                return dimensiontype;
            }
        }

        throw new IllegalArgumentException("Invalid dimension id " + id);
    }

    public boolean shouldLoadSpawn(){ return this.shouldLoadSpawn; }
    public DimensionTypesMod setLoadSpawn(boolean value) { this.shouldLoadSpawn = value; return this; }

    private static Class<?>[] ENUM_ARGS = {int.class, String.class, String.class, Class.class};
    static { net.minecraftforge.common.util.EnumHelper.testEnum(DimensionTypesMod.class, ENUM_ARGS); }
    public static DimensionTypesMod register(String name, String suffix, int id, Class<? extends WorldProvider> provider, boolean keepLoaded)
    {
        String enum_name = name.replace(" ", "_").toLowerCase();
        DimensionTypesMod ret = net.minecraftforge.common.util.EnumHelper.addEnum(DimensionTypesMod.class, enum_name, ENUM_ARGS,
                id, name, suffix, provider);
        return ret.setLoadSpawn(keepLoaded);
    }
    //TODO: Unregister? There is no way to really delete a enum value...

    public static DimensionTypesMod byName(String p_193417_0_)
    {
        for (DimensionTypesMod dimensiontype : values())
        {
            if (dimensiontype.getName().equals(p_193417_0_))
            {
                return dimensiontype;
            }
        }

        throw new IllegalArgumentException("Invalid dimension " + p_193417_0_);
    }
}
