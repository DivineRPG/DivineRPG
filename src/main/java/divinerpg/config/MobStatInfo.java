package divinerpg.config;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.config.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Contains default values of entity attrubutes
 */
public class MobStatInfo {
    /**
     * Known map of configurable attrutes
     */
    private final static Map<IAttribute, String> knownAttributesPostfix;

    /**
     * Comments to every attribute
     */
    private final static Map<IAttribute, String> knownAttributesComments;

    /**
     * Init known and configurable attribute
     *
     * @param attr    - entity ettribute
     * @param postfix - string postifix. Used to search row from config like "<ENTITY_NAME>_<postfix>"
     * @param comment - attribute comment
     */
    private static void initAttr(IAttribute attr, String postfix, String comment) {
        knownAttributesPostfix.put(attr, postfix);
        knownAttributesComments.put(attr, comment);
    }

    /**
     * Define here what attrubutes will be used
     */
    static {
        knownAttributesPostfix = new HashMap<>();
        knownAttributesComments = new HashMap<>();

        initAttr(SharedMonsterAttributes.ARMOR, "armor", "Armor value");
        initAttr(SharedMonsterAttributes.MAX_HEALTH, "health", "Max mob health");
        initAttr(SharedMonsterAttributes.ATTACK_DAMAGE, "attack", "Attack value");
    }

    /**
     * List of attribute values
     */
    public final Map<IAttribute, Float> values = new HashMap<>();

    /**
     * Init stat from entity. Using for testing
     *
     * @param e - entity
     * @return
     */
    public static MobStatInfo fromEntity(EntityLivingBase e) {
        MobStatInfo result = new MobStatInfo(0, 0, 0);

        knownAttributesPostfix.entrySet().stream()
                .collect(Collectors.toMap(x -> x, x -> {
                    if (e.getEntityAttribute(x.getKey()) != null) {
                        return (float) e.getEntityAttribute(x.getKey()).getAttributeValue();
                    }

                    return 0F;
                }))
                .forEach((iAttributeStringEntry, aFloat) -> result.values.put(iAttributeStringEntry.getKey(), aFloat));

        return result;
    }

    public MobStatInfo(double health, double attack, double armor) {
        values.put(SharedMonsterAttributes.ATTACK_DAMAGE, (float) attack);
        values.put(SharedMonsterAttributes.MAX_HEALTH, (float) health);
        values.put(SharedMonsterAttributes.ARMOR, (float) armor);
    }

    /**
     * Init config rows
     *
     * @param cfg
     * @param id
     */
    public void initConfig(Configuration cfg, ResourceLocation id) {
        String entityName = id.getResourcePath();

        String comment = new TextComponentTranslation(String.format("entity.%s.%s.name", id.getResourceDomain(), entityName)).getUnformattedComponentText();
        cfg.addCustomCategoryComment(entityName, comment);

        for (Map.Entry<IAttribute, String> entry : knownAttributesPostfix.entrySet()) {
            IAttribute attr = entry.getKey();
            float value = cfg.getFloat(entityName + "_" + entry.getValue(), entityName, values.getOrDefault(attr, 0F), Float.MIN_NORMAL, Float.MAX_VALUE, knownAttributesComments.get(attr));

            values.put(attr, value);
        }
    }

    /**
     * Initialize entity attruibutes
     *
     * @param e
     */
    public void initEntity(EntityLivingBase e) {
        values.forEach((attribute, aFloat) -> {
            getOrRegister(e, attribute).setBaseValue(aFloat);
        });
    }

    /**
     * Gets ettribute from entity. Register it if needed
     *
     * @param e    - current entity
     * @param attr - attribute
     * @return
     */
    private IAttributeInstance getOrRegister(EntityLivingBase e, IAttribute attr) {
        AbstractAttributeMap map = e.getAttributeMap();
        IAttributeInstance instance = map.getAttributeInstance(attr);

        if (instance == null) {
            map.registerAttribute(attr);
            instance = map.getAttributeInstance(attr);
        }

        return instance;
    }
}
