package divinerpg.data;

import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.function.BiConsumer;

import static divinerpg.DivineRPG.MODID;

public class ModEquipmentAssetProvider extends EquipmentAssetProvider {
    public ModEquipmentAssetProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(createKey("realmite"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "realmite")));
        output.accept(createKey("seng_fur"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "seng_fur")));
        output.accept(createKey("santa"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "santa")));
        output.accept(createKey("aquastrive"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "aquastrive")));
        output.accept(createKey("kraken"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "kraken")));
        output.accept(createKey("jack_o_man"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "jack_o_man")));
        output.accept(createKey("skeleman"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "skeleman")));
        output.accept(createKey("wither_reaper"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "wither_reaper")));
        output.accept(createKey("arlemite"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "arlemite")));
        output.accept(createKey("frozen"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "frozen")));
        output.accept(createKey("jungle"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "jungle")));
        output.accept(createKey("inferno"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "inferno")));
        output.accept(createKey("torridite"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "torridite")));
        output.accept(createKey("terran"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "terran")));
        output.accept(createKey("angelic"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "angelic")));
        output.accept(createKey("shadow"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "shadow")));
        output.accept(createKey("rupee"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "rupee")));
        output.accept(createKey("red_rupee"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "red_rupee")));
        output.accept(createKey("yellow_rupee"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "yellow_rupee")));
        output.accept(createKey("green_rupee"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "green_rupee")));
        output.accept(createKey("blue_rupee"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "blue_rupee")));
        output.accept(createKey("gray_rupee"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "gray_rupee")));
        output.accept(createKey("elite_realmite"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "elite_realmite")));
        output.accept(createKey("corrupted"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "corrupted")));
        output.accept(createKey("bedrock"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "bedrock")));
        output.accept(createKey("korma"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "korma")));
        output.accept(createKey("vemos"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "vemos")));
        output.accept(createKey("ender"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "ender")));
        output.accept(createKey("red_ender"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "red_ender")));
        output.accept(createKey("yellow_ender"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "yellow_ender")));
        output.accept(createKey("green_ender"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "green_ender")));
        output.accept(createKey("blue_ender"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "blue_ender")));
        output.accept(createKey("gray_ender"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "gray_ender")));
        output.accept(createKey("divine"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "divine")));
        output.accept(createKey("eden"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "eden")));
        output.accept(createKey("wildwood"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "wildwood")));
        output.accept(createKey("apalachia"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "apalachia")));
        output.accept(createKey("skythern"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "skythern")));
        output.accept(createKey("mortum"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "mortum")));
        output.accept(createKey("halite"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "halite")));
        output.accept(createKey("awakened_halite"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "awakened_halite")));
        output.accept(createKey("degraded_helmet"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "degraded_helmet")));
        output.accept(createKey("degraded_hood"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "degraded_hood")));
        output.accept(createKey("degraded_mask"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "degraded_mask")));
        output.accept(createKey("degraded"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "degraded")));
        output.accept(createKey("finished_helmet"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "finished_helmet")));
        output.accept(createKey("finished_hood"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "finished_hood")));
        output.accept(createKey("finished_mask"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "finished_mask")));
        output.accept(createKey("finished"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "finished")));
        output.accept(createKey("glistening_helmet"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "glistening_helmet")));
        output.accept(createKey("glistening_hood"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "glistening_hood")));
        output.accept(createKey("glistening_mask"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "glistening_mask")));
        output.accept(createKey("glistening"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "glistening")));
        output.accept(createKey("demonized_helmet"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "demonized_helmet")));
        output.accept(createKey("demonized_hood"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "demonized_hood")));
        output.accept(createKey("demonized_mask"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "demonized_mask")));
        output.accept(createKey("demonized"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "demonized")));
        output.accept(createKey("tormented_helmet"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "tormented_helmet")));
        output.accept(createKey("tormented_hood"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "tormented_hood")));
        output.accept(createKey("tormented_mask"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "tormented_mask")));
        output.accept(createKey("tormented"), createHumanoid(Identifier.fromNamespaceAndPath(MODID, "tormented")));
    }

    private ResourceKey<EquipmentAsset> createKey(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MODID, name));
    }

    public static EquipmentClientInfo createHumanoid(Identifier texturePath) {
        return EquipmentClientInfo.builder().addHumanoidLayers(texturePath).build();
    }
}